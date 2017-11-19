<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@include file="./include/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>供应商信息平台-登录</title>
    <script type="text/javascript" src="${webcontext}/static/scripts/jquery/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="${webcontext}/static/scripts/scm/security/login.js"></script>
    <script type="text/javascript" src="${ctx}/static/scripts/jquery/jquery.validate.js"></script>
    <link href="${ctx}/static/style/scm_layout.css" rel="stylesheet" type="text/css" />
</head>

<body>
<script type="text/javascript">
    function changeValidateCode(obj){
        var timeNow = new Date().getTime();
        obj.src="${ctx}/generateCheckCode?time="+timeNow;
    }
</script>
<div id="wrap" class="wrap">
    <div id="do_b" class="do_b">
        <div class="head clearfix">
            <span><img width="55" height="56" src="static/images/logo.png"/></span>
            <span style="margin-left:10px">
			<div class="en_name" >SCM-Vendor Platform</div>
			<div class="zh_name">供应链管理系统--供应商信息平台</div></span>
        </div>
        <div class="f_body">
            <form action="j_spring_security_check" method="post" id="loginForm">


                <p class="clearfix">
                    <label style="width:80px"  for="j_username">用户名:&nbsp;</label>
                    <input type="text" class="w80 l_text" name="j_username" id="j_username" value="${userName }" tabindex="1"/></p>

                <p class="clearfix" >
                    <label style="width:80px"  for="j_password" >密&nbsp;&nbsp;码:&nbsp;</label>
                    <input type="password" class="w80 l_text" name="j_password" id="j_password" value="${pwd }" tabindex="2"/></p>
                <p class="clearfix" style="padding-bottom: 0;">
                    <label style="width:80px"  for="validCode" >验证码:&nbsp;</label>
                    <input type="text" class=" l_text" style="width:77px" id="validCode" name="validCode" tabindex="3" />
                    <img id="checkCodeImg "  src="${ctx}/generateCheckCode" onclick="changeValidateCode(this)" title="刷新验证码" style="cursor: hand;height:25px;float:left;margin-left:20px" />
                </p>

                <p class="txt_c rid clearfix" >
                	<span id="errors" class="errors">
                	<c:if test='${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message != null}'>
						<img src="<c:url value="/static/images/iconWarning.gif"/>"
                             class="icon"/>
                        ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}
                    </c:if>
					<c:if test='${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message == null && error}'>
						<img src="<c:url value="/static/images/iconWarning.gif"/>"
                             class="icon"/>
                        <spring:message code="userError"/>
                    </c:if>
					<c:if test="${error!=null && !error}">
						<img src="<c:url value="/static/images/iconWarning.gif"/>"
                             class="icon"/>
                        <spring:message code="codeError"/>
                    </c:if>
					<c:if test="${error == null && message}">
						<img src="<c:url value="/static/images/iconWarning.gif"/>"
                             class="icon"/>
                        <spring:message code="authenticationError" arguments=""/>
                    </c:if>
					<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session" />
                	</span>

                </p>
                <p style="padding:0" class="rid clearfix">
                    <a href="${ctx}/retrievePassword" class="link" style="margin-left:20px">忘记密码？</a>
                    <input class="l_Btn"  value="" type="submit" />
                </p>
            </form>
        </div>
    </div>
</div>
</body>
</html>
