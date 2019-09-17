package com.pivot.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/***************************************************************************
 * @className: ResponseVO
 * @date     : 2019/9/6 15:00
 * @author   : 张琰培 (zhangyanpei@vvise.com)
 * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
 * @desc     : [功能简介]
 * ------------------------------------------------------------
 * 修改历史
 * 序号             日期                      修改人                  修改原因
 * 1
 * 2
 ***********************************************************************/
@Data
@NoArgsConstructor
public class ResponseVO {
    private int status;
    private String msg;
    public ResponseVO(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{\"status\":" + status + ", \"msg\":\"" + msg + "\"}";
    }
}
