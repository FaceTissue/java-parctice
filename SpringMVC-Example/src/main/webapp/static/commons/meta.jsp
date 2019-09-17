<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--jstl标签库--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--禁用缓存--%>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Expires" content="-1"/>
<meta http-equiv="Cache-Control" content="no-cache"/>

<%--全局系统变量设置--%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="title" value="菲尔普斯专业山寨机销售平台"/>

<%--title前的图标--%>
<link rel="shortcut icon" type="images/x-icon" href="${ctx}/static/images/login/favicon.ico"/>

<%-- scope作用域大小依次为：application->session->request->page --%>
<%-- jsp处理作用域的先后顺序为：page->request->session->application --%>
