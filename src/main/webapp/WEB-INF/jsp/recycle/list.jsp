<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<c:forEach items="${recycle}" var="rec">--%>
    <%--<input type="checkbox" value="${rec.recycle_id}" name="picture" ></input>--%>
    <%--&lt;%&ndash;<label>${rec.recycle_id}</label>&ndash;%&gt;--%>
    <%--<img src="${rec.picture_url}"/>--%>
    <%--<hr/>--%>
<%--</c:forEach>--%>

<c:forEach items="${recycle}" var="rec">
<div class="col-xs-6 col-md-3">
    <a href="#" class="thumbnail" style="text-align:center";>
        <label class="option block mn" style="text-align:left">
            <input type="checkbox" value="${rec.recycle_id}" name="picture">
            <span class="checkbox mn"></span>
        </label>
        <img src="${rec.picture_url}" alt="...">
    </a>
</div>
</c:forEach>