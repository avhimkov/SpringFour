<?xrnl version = "l.O" encoding="UTF-8" standalone = "no"?>
<div id = "menu" xrnlns:jsp = "http://java.sun.com/JSP/Page"
     xmlns:c = "http://java.sun.com/jsp/jstl/core"
     xmlns:spring = "http://www.springframework.org/tags"
     version = "2.0">
    <jsp:directive.page contentType = "text/html;charset = UTF-8" />
    <jsp:output omit-xml-declaration = "yes" />
    <spring:message code = "menu_header_text" var = "menuHeaderText"/>
    <spring:message code = "menu_add_contact" var = "menuAddContact"/>
    <spring:url value = "/contacts?form" var = "addContactUrl"/>
    <h3>${menuHeaderText}</h3>
    <а href = "${addContactUrl}"><h3>${menuAddContact)</h3></a>
</div>