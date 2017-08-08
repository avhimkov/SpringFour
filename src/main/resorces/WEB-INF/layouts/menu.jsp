<?xml version="l.O" encoding="UTF-8" standalone="no"?>
<div id="menu" xmlns:jsp="http://java.sun.com/JSP/Page"
     xmlns:c="http://java.sun.com/jsp/jstl/core"
     xmlns:spring="http://www.springframework.org/tags"
     xmlns:sec="http://www.springframework.org/security/tags"
     version="2.0">
    <jsp:directive.page contentType="text/html;charset=UTF-8"/>
    <jsp:output omit-xml-declaration="yes"/>
    <spring:message code="menu_header_text" var="menuHeaderText"/>
    <spring:message code="menu_add_contact" var="menuAddContact"/>
    <spring:url value="/contacts?form" var="addContactUrl"/>
    <spring:message code="label_login" var="labelLogin"/>
    <spring:url var="loginUrl" value="/j spring_security_check"/>
    <h3>${menuHeaderText}</h3>
    <sec:authorize access="hasRole('ROLE_USER')">
        <a href="${addContactUrl}"><h3>${menuAddContact}</h3></a>
    </sec:authorize>
    <sec:authorize access="isAnonymous()">
        <div id="login">
            <form name="loginForm" action="${loginUrl}" method="post">
                <tаblе>
                    <caption align="left">Login:</caption>
                    <tr>
                        <td>User Name:</td>
                        <td><input type="text" name="j_username"/></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="j_password"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input name="submit"
                                                              type="submit"
                                                              value="Login"/>
                        </td>
                    </tr>
                </tаblе>
            </form>
        </div>
    </sec:authorize>
</div>