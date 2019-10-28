//package com.guide.java.poi;
//
//import org.apache.poi.ooxml.POIXMLDocument;
//import org.apache.poi.xwpf.usermodel.*;
//
//import java.io.*;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
///***************************************************************************
// * @className: WorderToNewWordUtils
// * @date     : 2019/10/16 20:22
// * @author   : 成建侠 (chengjianxia@vvise.com)
// * @module   : [项目]-[一级菜单]-[二级菜单]-[三级菜单]
// * @desc     : [功能简介]
// * ------------------------------------------------------------
// * 修改历史
// * 序号             日期                      修改人                  修改原因
// * 1
// * 2
// ***********************************************************************/
//public class WorderToNewWordUtils {
//    /**
//     * 根据模板生成新word文档
//     * 判断表格是需要替换还是需要插入，判断逻辑有$为替换，表格无$为插入
//     * @param inputUrl 模板存放地址
//     * @param outputUrl 新文档存放地址
//     * @param textMap 需要替换的信息集合
//     * @param tableList 需要插入的表格信息集合
//     * @return 成功返回true,失败返回false
//     */
//    public static boolean changWord(String inputUrl, String outputUrl,
//                                    Map<String, Object> textMap, List<String[]> tableList) {
//
//        //模板转换默认成功
//        boolean changeFlag = true;
//        try {
//            //获取docx解析对象
//            CustomXWPFDocument document = new CustomXWPFDocument(POIXMLDocument.openPackage(inputUrl));
//            //解析替换文本段落对象
//            WorderToNewWordUtils.changeText(document, textMap);
//            //解析替换表格对象
//            WorderToNewWordUtils.changeTable(document, textMap, tableList);
//
//            //生成新的word
//            File file = new File(outputUrl);
//            FileOutputStream stream = new FileOutputStream(file);
//            document.write(stream);
//            stream.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            changeFlag = false;
//        }
//
//        return changeFlag;
//
//    }
//
//    /**
//     * 替换段落文本
//     * @param document docx解析对象
//     * @param textMap 需要替换的信息集合
//     */
//    public static void changeText(CustomXWPFDocument document, Map<String, Object> textMap){
//        //获取段落集合
//        List<XWPFParagraph> paragraphs = document.getParagraphs();
//
//        for (XWPFParagraph paragraph : paragraphs) {
//            if(checkText(paragraph.getText())) {
//                eachRun(paragraph, textMap, document);
//            }
//            //判断此段落时候需要进行替换
//            /*String text = paragraph.getText();
//            if(checkText(text)){
//                List<XWPFRun> runs = paragraph.getRuns();
//                for (XWPFRun run : runs) {
//                    //替换模板原来位置
//                    run.setText(changeValue(run.toString(), textMap),0);
//                }
//            }*/
//        }
//
//    }
//
//    /**
//     * 替换表格对象方法
//     * @param document docx解析对象
//     * @param textMap 需要替换的信息集合
//     * @param tableList 需要插入的表格信息集合
//     */
//    public static void changeTable(CustomXWPFDocument document, Map<String, Object> textMap,
//                                   List<String[]> tableList){
//        //获取表格对象集合
//        List<XWPFTable> tables = document.getTables();
//        for (int i = 0; i < tables.size(); i++) {
//            //只处理行数大于等于2的表格，且不循环表头
//            XWPFTable table = tables.get(i);
//            if(table.getRows().size()>1){
//                //判断表格是需要替换还是需要插入，判断逻辑有$为替换，表格无$为插入
//                if(checkText(table.getText())){
//                    List<XWPFTableRow> rows = table.getRows();
//                    //遍历表格,并替换模板
//                    eachTable(rows, textMap, document);
//                }
//            }
//        }
//    }
//
//
//
//
//
//    /**
//     * 遍历表格
//     * @param rows 表格行对象
//     * @param textMap 需要替换的信息集合
//     * @param document 需要替换的信息集合
//     */
//    public static void eachTable(List<XWPFTableRow> rows ,Map<String, Object> textMap, CustomXWPFDocument document){
//        for (XWPFTableRow row : rows) {
//            List<XWPFTableCell> cells = row.getTableCells();
//            for (XWPFTableCell cell : cells) {
//                //判断单元格是否需要替换
//                if(checkText(cell.getText())){
//                    List<XWPFParagraph> paragraphs = cell.getParagraphs();
//                    for (XWPFParagraph paragraph : paragraphs) {
//                        eachRun(paragraph, textMap, document);
//                    }
//                }
//            }
//        }
//    }
//
//    public static void eachRun(XWPFParagraph paragraph ,Map<String, Object> textMap, CustomXWPFDocument document) {
//        List<XWPFRun> runs = paragraph.getRuns();
//        for (XWPFRun run : runs) {
//            Object ob = changeValue(run.toString(), textMap);
//            if (ob.getClass() != null) {
//                if (ob instanceof String) {
//                    run.setText(String.valueOf(ob),0);
//                } else if (ob instanceof Map) {
//                    //特殊处理图片
//                    int length = runs.size();
//                    //将原有的Run去掉
//                    if (length > 0) {
//                        for (int i = (length - 1); i >= 0; i--) {
//                            paragraph.removeRun(i);
//                        }
//                    }
//                    Map pic = (Map)ob;
//                    int width = Integer.parseInt(pic.get("width").toString());
//                    int height = Integer.parseInt(pic.get("height").toString());
//                    int picType = getPictureType(pic.get("type").toString());
//                    String imgurl = String.valueOf(pic.get("content"));
//                    //byte[] byteArray = (byte[]) pic.get("content");
//                    try {
//                        //String blipId = document.addPictureData(byteArray, picType);
//                        String blipId = document.addPictureData(new FileInputStream(new File(imgurl)), picType);
//                        int id = document.getNextPicNameNumber(picType);
//                        document.createPicture(blipId, id, width, height, paragraph);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
//
//    /**
//     * 判断文本中时候包含$
//     * @param text 文本
//     * @return 包含返回true,不包含返回false
//     */
//    public static boolean checkText(String text){
//        boolean check  =  false;
//        if(text.indexOf("$")!= -1){
//            check = true;
//        }
//        return check;
//
//    }
//
//    /**
//     * 匹配传入信息集合与模板
//     * @param value 模板需要替换的区域
//     * @param textMap 传入信息集合
//     * @return 模板需要替换区域信息集合对应值
//     */
//    /*public static String changeTextValue(String value, Map<String, Object> textMap){
//        String ob = value.substring(0, value.lastIndexOf("：") + 1);
//        Set<Map.Entry<String, Object>> textSets = textMap.entrySet();
//        for (Map.Entry<String, Object> textSet : textSets) {
//            //匹配模板与替换值 格式${key}
//            String key = "${"+textSet.getKey()+"}";
//            if(value.indexOf(key)!= -1){
//                value = ob + String.valueOf(textSet.getValue());
//                break;
//            }
//        }
//        //模板未匹配到区域替换为空
//        if(checkText(value)){
//            value = "";
//        }
//        return value;
//    }*/
//
//    /**
//     * 匹配传入信息集合与模板
//     * @param value 模板需要替换的区域
//     * @param textMap 传入信息集合
//     * @return 模板需要替换区域信息集合对应值
//     */
//    public static Object changeValue(String value, Map<String, Object> textMap){
//        Object ob = new Object();
//        Set<Map.Entry<String, Object>> textSets = textMap.entrySet();
//        for (Map.Entry<String, Object> textSet : textSets) {
//            //匹配模板与替换值 格式${key}
//            String key = "${"+textSet.getKey()+"}";
//            if(value.indexOf(key)!= -1){
//                ob = textSet.getValue();
//                textMap.remove(textSet.getKey());
//                break;
//            }
//        }
//        //模板未匹配到区域替换为空
//        if(checkText(String.valueOf(ob))){
//            ob = "";
//        }
//        return ob;
//    }
//
//    /**
//     * 根据图片类型，取得对应的图片类型代码
//     * @param picType
//     * @return int
//     */
//    private static int getPictureType(String picType){
//        int res = CustomXWPFDocument.PICTURE_TYPE_PICT;
//        if(picType != null){
//            if(picType.equalsIgnoreCase("png")){
//                res = CustomXWPFDocument.PICTURE_TYPE_PNG;
//            }else if(picType.equalsIgnoreCase("dib")){
//                res = CustomXWPFDocument.PICTURE_TYPE_DIB;
//            }else if(picType.equalsIgnoreCase("emf")){
//                res = CustomXWPFDocument.PICTURE_TYPE_EMF;
//            }else if(picType.equalsIgnoreCase("jpg") || picType.equalsIgnoreCase("jpeg")){
//                res = CustomXWPFDocument.PICTURE_TYPE_JPEG;
//            }else if(picType.equalsIgnoreCase("wmf")){
//                res = CustomXWPFDocument.PICTURE_TYPE_WMF;
//            }
//        }
//        return res;
//    }
//
//    /**
//     * 将输入流中的数据写入字节数组
//     * @param in
//     * @return
//     */
//    public static byte[] inputStream2ByteArray(InputStream in, boolean isClose){
//        byte[] byteArray = null;
//        try {
//            int total = in.available();
//            byteArray = new byte[total];
//            in.read(byteArray);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally{
//            if(isClose){
//                try {
//                    in.close();
//                } catch (Exception e2) {
//                    System.out.println("关闭流失败");
//                }
//            }
//        }
//        return byteArray;
//    }
//}
