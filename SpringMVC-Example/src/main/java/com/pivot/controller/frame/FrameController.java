package com.pivot.controller.frame;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/***************************************************************************
 * @className: FrameController
 * @date     : 2019/9/12 11:31
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
@Controller
public class FrameController {
    @GetMapping(path = "/success")
    public String success() {
        return "frame/index";
    }
}
