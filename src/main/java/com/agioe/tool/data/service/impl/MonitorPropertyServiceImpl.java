package com.agioe.tool.data.service.impl;

import com.agioe.tool.data.Qo.AddMonitorProperty1Qo;
import com.agioe.tool.data.Qo.DeleteMonitorProperty1Qo;
import com.agioe.tool.data.Qo.UpdateMonitorProperty1Qo;
import com.agioe.tool.data.Vo.ShowAllMonitorPropertyVo;
import com.agioe.tool.data.dao.MonitorPropertyDao;
import com.agioe.tool.data.entity.EquipmentInfo;
import com.agioe.tool.data.entity.MonitorProperty;
import com.agioe.tool.data.entity.MonitorPropertyTemplateBind;
import com.agioe.tool.data.entity.WebResponse;
import com.agioe.tool.data.service.EquipmentInfoService;
import com.agioe.tool.data.service.MonitorPropertyService;
import com.agioe.tool.data.service.MonitorPropertyTemplateBindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonitorPropertyServiceImpl implements MonitorPropertyService {
    @Autowired
    private MonitorPropertyDao monitorPropertyDao;

    @Autowired
    private MonitorPropertyTemplateBindService monitorPropertyTemplateBindService;

    @Autowired
    private EquipmentInfoService equipmentInfoService;

    @Override
    public Integer insertMonitorProperty(MonitorProperty monitorProperty) {
        return monitorPropertyDao.insertMonitorProperty(monitorProperty);
    }

    @Override
    public Integer deleteMonitorProperty(String equipmentPropertyCode) {
        return monitorPropertyDao.deleteMonitorProperty(equipmentPropertyCode);
    }

    @Override
    public List<MonitorProperty> selectByMonitorProperty(MonitorProperty monitorProperty) {
        return monitorPropertyDao.selectByMonitorProperty(monitorProperty);
    }

    @Override
    public Integer updateMonitorProperty(MonitorProperty monitorProperty) {
        return monitorPropertyDao.updateMonitorProperty(monitorProperty);
    }

    @Override
    public List<MonitorProperty> selectAll() {
        return monitorPropertyDao.selectAll();
    }

    @Override
    public MonitorProperty selectByid(Integer id) {
        return monitorPropertyDao.selectByid(id);
    }

    @Override
    public WebResponse showAllMonitorProperty() {
        List<ShowAllMonitorPropertyVo> showAllMonitorPropertyVos = new ArrayList<>();
        List<MonitorProperty> monitorProperties = monitorPropertyDao.selectAll();
        if (monitorProperties.size() > 0) {
            for (MonitorProperty monitorProperty : monitorProperties) {
                ShowAllMonitorPropertyVo showAllMonitorPropertyVo = new ShowAllMonitorPropertyVo();
                showAllMonitorPropertyVo.setEquipmentPropertyCode(monitorProperty.getEquipmentPropertyCode());
                showAllMonitorPropertyVo.setEquipmentPropertyName(monitorProperty.getEquipmentPropertyName());
                showAllMonitorPropertyVo.setEquipmentPropertyType(monitorProperty.getEquipmentPropertyType());
                showAllMonitorPropertyVos.add(showAllMonitorPropertyVo);
            }
        }
        return WebResponse.success(showAllMonitorPropertyVos);
    }

    @Override
    public WebResponse addMonitorProperty1(AddMonitorProperty1Qo addMonitorProperty1Qo) {
        String equipmentPropertyCode = addMonitorProperty1Qo.getEquipmentPropertyCode();
        String equipmentPropertyName = addMonitorProperty1Qo.getEquipmentPropertyName();
        Integer equipmentPropertyType = addMonitorProperty1Qo.getEquipmentPropertyType();
        //编码判重
        MonitorProperty monitorProperty = new MonitorProperty();
        monitorProperty.setEquipmentPropertyCode(equipmentPropertyCode);
        List<MonitorProperty> monitorProperties = monitorPropertyDao.selectByMonitorProperty(monitorProperty);
        if (monitorProperties.size() > 0) {
            return WebResponse.error(400, "编码已存在");
        }
        //名称判重
        MonitorProperty monitorProperty1 = new MonitorProperty();
        monitorProperty1.setEquipmentPropertyName(equipmentPropertyName);
        List<MonitorProperty> monitorProperties1 = monitorPropertyDao.selectByMonitorProperty(monitorProperty1);
        if (monitorProperties1.size() > 0) {
            return WebResponse.error(400, "监控信息名已存在");
        }
        //添加
        MonitorProperty monitorProperty2 = new MonitorProperty();
        monitorProperty2.setEquipmentPropertyName(equipmentPropertyName);
        monitorProperty2.setEquipmentPropertyCode(equipmentPropertyCode);
        monitorProperty2.setEquipmentPropertyType(equipmentPropertyType);
        monitorPropertyDao.insertMonitorProperty(monitorProperty2);
        return WebResponse.success();
    }

    @Override
    public WebResponse updateMonitorProperty1(UpdateMonitorProperty1Qo updateMonitorProperty1Qo) {
        String equipmentPropertyCode = updateMonitorProperty1Qo.getEquipmentPropertyCode();
        String equipmentPropertyName = updateMonitorProperty1Qo.getEquipmentPropertyName();
        Integer equipmentPropertyType = updateMonitorProperty1Qo.getEquipmentPropertyType();
        MonitorProperty monitorProperty = new MonitorProperty();
        monitorProperty.setEquipmentPropertyCode(equipmentPropertyCode);
        List<MonitorProperty> monitorProperties = monitorPropertyDao.selectByMonitorProperty(monitorProperty);
        if (monitorProperties.size() > 0) {
            MonitorProperty monitorProperty1 = monitorProperties.get(0);
            monitorProperty1.setEquipmentPropertyType(equipmentPropertyType);
            monitorProperty1.setEquipmentPropertyName(equipmentPropertyName);
            monitorPropertyDao.updateMonitorProperty(monitorProperty1);
        }
        return WebResponse.success();
    }

    @Override
    public WebResponse deleteMonitorProperty1(DeleteMonitorProperty1Qo deleteMonitorProperty1Qo) {
        String equipmentPropertyCode = deleteMonitorProperty1Qo.getEquipmentPropertyCode();
        //判断与设备有无绑定关系
        EquipmentInfo equipmentInfo = new EquipmentInfo();
        equipmentInfo.setEquipmentPropertyCode(equipmentPropertyCode);
        List<EquipmentInfo> equipmentInfos = equipmentInfoService.selectByEquipmentInfo(equipmentInfo);
        if (equipmentInfos.size() > 0) {
            return WebResponse.error(400, "与设备信息有绑定关系,删除失败");
        }
        //判断与属性模板是否有绑定关系
        MonitorPropertyTemplateBind monitorPropertyTemplateBind = new MonitorPropertyTemplateBind();
        monitorPropertyTemplateBind.setEquipmentPropertyCode(equipmentPropertyCode);
        List<MonitorPropertyTemplateBind> monitorPropertyTemplateBinds = monitorPropertyTemplateBindService.selectByMonitorPropertyTemplateBind(monitorPropertyTemplateBind);
        if (monitorPropertyTemplateBinds.size() > 0) {
            return WebResponse.error(400, "与属性模板有绑定关系,删除失败");
        }
        //删除
        monitorPropertyDao.deleteMonitorProperty(equipmentPropertyCode);
        return WebResponse.success();
    }
}