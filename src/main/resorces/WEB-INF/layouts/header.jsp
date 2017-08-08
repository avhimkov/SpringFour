<div id="header" xmlns:jsp="http://java.sun.com/JSP/Page"
     xmlns:spring="http://www.springframework.org/tags"
     xmlns:sec="http://www.springframework.org/security/tags"
     version="2.0">
    <jsp:directive.page contentType="text/html;charset=UTF-8"/>
    <jsp:output omit-xml-declaration="yes"/>
    <spring:message code="header_text" var="headerText"/>
    <spring:message code="label logout" var="labelLogout"/>
    <spring:message code="label_welcome" var="labelWelcome"/>
    <spring:url var="logoutUrl" value="/j_spring_security_logout"/>
    <div id="appname">
        <h1>${headerText}</h1>
    </div>
    <div id="userinfo">
        <sec:authorize access="isAuthenticated()">${labelWelcomel}
            <sec:authentication property="principal.username"/><br/>
            <a href="${logoutUrl}">${labelLogout}</a>
        </sec:authorize>
    </div>
</div>