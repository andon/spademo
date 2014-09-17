<%@include file="/libs/foundation/global.jsp" %><%
%><%@ page session="false"
           contentType="text/html; charset=utf-8"
		   import="com.day.cq.commons.Doctype,
                   org.apache.commons.lang3.StringEscapeUtils" %><%
    String xs = Doctype.isXHTML(request) ? "/" : "";
    String favIcon = currentDesign.getPath() + "/favicon.ico";
    if (resourceResolver.getResource(favIcon) == null) {
        favIcon = null;
    }
%><%@taglib prefix="cq" uri="http://www.day.com/taglibs/cq/1.0" %><%
%><cq:defineObjects/><%
%><head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"<%=xs%>>
    <meta name="keywords" content="<%= StringEscapeUtils.escapeHtml4(WCMUtils.getKeywords(currentPage, false)) %>"<%=xs%>>
    <meta name="description" content="<%= StringEscapeUtils.escapeHtml4(properties.get("jcr:description", "")) %>"<%=xs%>>
    <title>AEM-SPA Demo</title>
    <!--cq:include script="headlibs.jsp"/-->
    <cq:include script="/libs/wcm/core/components/init/init.jsp"/>
    <!-- cq:include script="stats.jsp"/-->
    <cq:includeClientLib js="apps.spademo" />
    <cq:includeClientLib css="apps.spademo" />
</head>