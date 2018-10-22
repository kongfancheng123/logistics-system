package com.agioe.tool.data.controller;

import com.agioe.tool.data.Qo.*;
import com.agioe.tool.data.entity.WebResponse;
import com.agioe.tool.data.service.ParentNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ParentNode")
public class ParentNodeController {
    @Autowired
    private ParentNodeService parentNodeService;

    /**
     * 展示所有上层节点
     *
     * @return
     */
    @RequestMapping(value = "/showAllParentNode", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse showAllParentNode() {
        return parentNodeService.showAllParentNode();
    }

    /**
     * 分页展示上层节点
     *
     * @return
     */
    @RequestMapping(value = "/showPageParentNode", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse showPageParentNode(@RequestBody PageQo pageQo) {
        return parentNodeService.showPageParentNode(pageQo);
    }

    /**
     * 添加上层节点
     *
     * @param addParentNode1Qo
     * @return
     */
    @RequestMapping(value = "/addParentNode1", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse addParentNode1(@RequestBody AddParentNode1Qo addParentNode1Qo) {
        return parentNodeService.addParentNode1(addParentNode1Qo);
    }

    /**
     * 更新上层节点
     *
     * @param updateParentNode1Qo
     * @return
     */
    @RequestMapping(value = "/updateParentNode1", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse updateParentNode1(@RequestBody UpdateParentNode1Qo updateParentNode1Qo) {
        return parentNodeService.updateParentNode1(updateParentNode1Qo);
    }

    /**
     * 删除上层节点
     *
     * @param deleteParentNode1Qo
     * @return
     */
    @RequestMapping(value = "/deleteParentNode1", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse deleteParentNode1(@RequestBody DeleteParentNode1Qo deleteParentNode1Qo) {
        return parentNodeService.deleteParentNode1(deleteParentNode1Qo);
    }

    /**
     * 导出上层节点表
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/exportExcelParentNode", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse exportExcelParentNode() throws Exception {
        return parentNodeService.exportExcelParentNode();
    }

    /**
     * 导入上层节点表
     *
     * @param importExcelParentNodeQo
     * @return
     */
    @RequestMapping(value = "/importExcelParentNode", method = RequestMethod.POST)
    @ResponseBody
    public WebResponse importExcelParentNode(@RequestBody ImportExcelParentNodeQo importExcelParentNodeQo) throws Exception {
        return parentNodeService.importExcelParentNode(importExcelParentNodeQo);
    }


}
