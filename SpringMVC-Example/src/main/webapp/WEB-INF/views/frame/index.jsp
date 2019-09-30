<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/static/commons/meta.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${title}</title>
    <%@ include file="/static/scripts/jquery-easyui-all.jsp"%>
    <style type="text/css">
        html, body, .easyui-layout {
            width: 100%;
            height: 100%;
            margin: 0;
        }
    </style>
</head>
<body>
<div class="easyui-layout">
    <div data-options="region:'north',title:'菲尔普斯专业山寨机'"></div>
    <div region="west" split="true" title="Navigator" style="width:150px;">
        <p style="padding:5px;margin:0;">Select language:</p>
        <ul>
            <li><a href="javascript:void(0)" onclick="showcontent('java')">Java</a></li>
            <li><a href="javascript:void(0)" onclick="showcontent('cshape')">C#</a></li>
            <li><a href="javascript:void(0)" onclick="showcontent('vb')">VB</a></li>
            <li><a href="javascript:void(0)" onclick="showcontent('erlang')">Erlang</a></li>
        </ul>
    </div>
    <div id="content" region="center" title="Language" style="padding:5px;">
    </div>
</div>
</body>
</html>
