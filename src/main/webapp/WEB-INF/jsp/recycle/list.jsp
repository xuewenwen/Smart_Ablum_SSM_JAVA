<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${recycle}" var="rec">
    <input type="checkbox" value="${rec.recycle_id}" name="picture" ></input>
    <%--<label>${rec.recycle_id}</label>--%>
    <img src="${rec.picture_url}"/>
    <hr/>
</c:forEach>
