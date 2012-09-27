<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.hedgehog.outletss.domain.*"%>
<%@page import="com.hedgehog.outletss.Utils.QueryPara"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:if test="${not empty tags}">
<script language='javascript'>window.returnVal='增加应用字段成功';window.parent.hidePopWin(true);</script>
</c:if>
<form:form modelAttribute="fieldvalue">
<table id="ctl00_PageBody_Table_Manager_FieldValue" width="100%" border="0" cellspacing="1" cellpadding="3" align="center">
	<tr id="ctl00_PageBody_TopTr">
		<td class="table_body">
                字段Key</td>
		<td class="table_none">
                <span id="ctl00_PageBody_F_Key"><form:hidden path="vfKey"/>${fieldvalue.vfKey}</span></td>
	</tr>
	<tr>
		<td class="table_body">
                    字段名称</td>
		<td class="table_none">
                    <span id="ctl00_PageBody_F_CName">${fieldvalue.sysField.fcname}</span></td>
	</tr>
	<tr>
		<td class="table_body">
                    字段值</td>
		<td class="table_none">
		<form:input path="vtext" cssClass="text_input"/>
                <form:errors path="vtext" cssClass="error" />  
                    </td>
	</tr>
	<tr id="ctl00_PageBody_Tr1">
		<td class="table_body">
                    字段编码</td>
		<td class="table_none">
		<form:input path="vcode" cssClass="text_input"/>
                <form:errors path="vcode" cssClass="error" />  
                    </td>
	</tr>
	<tr>
		<td colspan="2" align="right" style="height: 26px">
                                    <input type="submit" name="ctl00$PageBody$Button1" value="确定" id="ctl00_PageBody_Button1" class="button_bak" />
                                    <input type="submit" name="ctl00$PageBody$Button2" value="删除" onclick="return doConfirm(this.form);" id="ctl00_PageBody_Button2" class="button_bak" />
                    <input id="Reset1" class="button_bak" type="reset" value="重填" />
                </td>
	</tr>
</table>
</form:form>