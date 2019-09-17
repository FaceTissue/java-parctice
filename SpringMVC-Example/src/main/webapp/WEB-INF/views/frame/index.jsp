<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/static/commons/meta.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>${title}</title>
    <script type="text/javascript" src="${ctx}/static/scripts/jquery-easyui-all.jsp"></script>
</head>
<body>
<div class="easyui-layout" style="width: 100%; height: 100%">
    <div data-options="region:'north',border:false" style="background-color: blue">north</div>
    <div data-options="region:'west',border:false" style="background-color: red">west</div>
    <div data-options="region:'center',border:false" style="background-color: green">center</div>
</div>
</body>
</html>
