package com.agioe.tool.data.controller;

import com.agioe.tool.data.Qo.*;
import com.agioe.tool.data.entity.WebResponse;
import com.agioe.tool.data.service.EquipmentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/EquipmentInfo")
public class EquipmentInfoController {
    @Autowired
    private EquipmentInfoService equipmentInfoService;

    /**
     * 展示所有设备
     *
     * @return
     */
    @RequestMapping(value = "/showAllEquipmentInfo", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse showAllEquipmentInfo() {
        return equipmentInfoService.showAllEquipmentInfo();
    }

//    /**
//     * 添加设备
//     *
//     * @param addEquipmentInfo1Qo
//     * @return
//     */
//    @RequestMapping(value = "/addEquipmentInfo1", method = RequestMethod.POST)
//    @ResponseBody
//    public WebResponse addEquipmentInfo1(@RequestBody AddEquipmentInfo1Qo addEquipmentInfo1Qo) {
//        return equipmentInfoService.addEquipmentInfo1(addEquipmentInfo1Qo);
//    }

    /**
     * 更新设备
     *
     * @param updateEquipmentInfo1Qo
     * @return
     */
    @RequestMapping(value = "/updateEquipmentInfo1", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse updateEquipmentInfo1(@RequestBody UpdateEquipmentInfo1Qo updateEquipmentInfo1Qo) {
        return equipmentInfoService.updateEquipmentInfo1(updateEquipmentInfo1Qo);
    }

    /**
     * 删除设备
     *
     * @param deleteEquipmentInfo1Qo
     * @return
     */
    @RequestMapping(value = "/deleteEquipmentInfo1", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse deleteEquipmentInfo1(@RequestBody DeleteEquipmentInfo1Qo deleteEquipmentInfo1Qo) {
        return equipmentInfoService.deleteEquipmentInfo1(deleteEquipmentInfo1Qo);
    }


    /**
     * 条件查询设备
     *
     * @return
     */
    @RequestMapping(value = "/showEquipmentInfoByCondition", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse showEquipmentInfoByCondition(@RequestBody ShowEquipmentInfoByConditionQo showEquipmentInfoByConditionQo) {
        return equipmentInfoService.showEquipmentInfoByCondition(showEquipmentInfoByConditionQo);
    }


    /**
     * 发送实时数据
     *
     * @return
     */
    @RequestMapping(value = "/sendEquipmentRealtimeData", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse sendEquipmentRealtimeData(@RequestBody SendEquipmentRealtimeDataQo sendEquipmentRealtimeDataQo) {
        return equipmentInfoService.sendEquipmentRealtimeData(sendEquipmentRealtimeDataQo);
    }

    /**
     * 发送事件
     *
     * @return
     */
    @RequestMapping(value = "/sendEventHistory", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse sendEventHistory(@RequestBody SendEventHistoryQo sendEventHistoryQo) {
        return equipmentInfoService.sendEventHistory(sendEventHistoryQo);
    }

    /**
     * 解除事件
     */
    @RequestMapping(value = "/dealEventHistory", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse dealEventHistory(@RequestBody DealEventHistoryQo dealEventHistoryQo) {
        return equipmentInfoService.dealEventHistory(dealEventHistoryQo);
    }

}