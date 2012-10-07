<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty TabJs}">
${TabJs}
</c:if>
<form:form modelAttribute="sysUser">
<form:hidden path="uloginName"/>
<table width="100%" border="0" cellspacing="1" cellpadding="3" align="center">
		    <tr>
			    <td class="table_body">
                    用户名</td>
			    <td class="table_none" >
                    <span id="ctl00_PageBody_U_LoginName_Txt">${sysUser.uloginName}</span></td>
		    </tr>
            <tr>
                <td class="table_body">
                    原始密码</td>
                <td class="table_none">                
                <form:password path="oldupassword" cssClass="text_input"/>
                <form:errors path="oldupassword"/>
                    </td>
            </tr>
            <tr>
                <td class="table_body">
                    新密码</td>
                <td class="table_none">
                <form:password path="newupassword" cssClass="text_input"/>
                <form:errors path="newupassword"/>
</td>
            </tr>
            <tr>
                <td class="table_body" nowrap>
                    重新输入新密码</td>
                <td class="table_none">
                <form:password path="renewupassword" cssClass="text_input"/>
                <form:errors path="renewupassword"/>
                   </td>
            </tr>
            <tr>
                <td class="table_body">
                    菜单样式</td>
                <td class="table_none">
                <form:select path="MenuSink">
                <form:option value="0">经典</form:option>
                <form:option value="1">流行(仅限IE)</form:option>
                <form:option value="2">朴素</form:option>
                <form:option value="3">多级菜单</form:option>
                </form:select>
                   </td>
            </tr>
            <tr>
                <td class="table_body">
                    表格样式</td>
                <td class="table_none">
                <form:select path="TableSink">
                <form:option value="default">经典</form:option>
                <form:option value="blue">深蓝</form:option>
                <form:option value="red">深红</form:option>
                <form:option value="green">深绿</form:option>
                </form:select>
                    </td>
            </tr>            
            <tr>
                <td class="table_body" nowrap>
                    页码设定(每页/笔)</td>
                <td class="table_none">
                    <form:select path="PageSize">
                    <form:option value="10">10</form:option>
                    <form:option value="20">20</form:option>
                    <form:option value="40">40</form:option>
                    <form:option value="80">80</form:option>
                    </form:select>
                    </td>
            </tr>
            <tr>
                <td align="right" colspan="2">
                                    <input type="submit" name="ctl00$PageBody$Button1" value="确定" id="ctl00_PageBody_Button1" class="button_bak" />
                    <input id="Reset1" class="button_bak" type="reset" value="重填" />
                </td>
            </tr>
		</table>
		</form:form>
