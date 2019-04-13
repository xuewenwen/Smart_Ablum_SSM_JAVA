<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:forEach items="${pic}" var="pic">
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail" style="text-align:center;" >
                <label class="option block mn" style="text-align:left;display:none">
                    <input type="checkbox" value="${pic.pictureId}" class="picture" name="picture">
                    <span class="checkbox mn"></span>
                </label>
                <%--<form:checkbox path="picture" value="${pic.pictureId}" cssClass="picture"></form:checkbox>--%>
                <img src="${pic.pictureUrl}" alt="..." >
                    <%--${album.albumName}--%>
            </a>
        </div>
</c:forEach>

