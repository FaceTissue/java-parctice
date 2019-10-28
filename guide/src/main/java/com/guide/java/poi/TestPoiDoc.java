//package com.guide.java.poi;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
///***************************************************************************
// * @className: TestPoiDoc
// * @date     : 2019/10/16 14:15
// * @author   : 成建侠 (chengjianxia@vvise.com)
// * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
// * @desc     : [功能简介]
// * ------------------------------------------------------------
// * 修改历史
// * 序号             日期                      修改人                  修改原因
// * 1
// * 2
// ***********************************************************************/
//public class TestPoiDoc {
//
//    public static void main(String[] args) throws Exception {
//        //需要进行文本替换的信息
//        Map<String, Object> data = new HashMap<String, Object>();
//        data.put("date", "2018-03-06");
//        data.put("name", "东方明珠");
//        data.put("addr", "上海黄浦江附近");
//        data.put("code", "东方社区");
//        //data.put("picture","1111");
//
//
//        //图片，如果是多个图片，就新建多个map
//        Map<String,Object> picture1 = new HashMap<String, Object>();
//        picture1.put("width", 50);
//        picture1.put("height", 50);
//        picture1.put("type", "jpg");
//        picture1.put("content", "E:\\1.jpg");
//        data.put("picture",picture1);
//
//        Map<String,Object> picture2 = new HashMap<String, Object>();
//        picture2.put("width", 50);
//        picture2.put("height", 50);
//        picture2.put("type", "jpg");
//        picture2.put("content", "E:\\1.jpg");
//        data.put("picture1",picture2);
//
//        //模板文件地址
//        String inputUrl = "E:\\1.docx";
//        //新生产的模板文件
//        String outputUrl = "E:\\2.docx";
//        WorderToNewWordUtils.changWord(inputUrl, outputUrl, data, new ArrayList<>());
//    }
//
//}
