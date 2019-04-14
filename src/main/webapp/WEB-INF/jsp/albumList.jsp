<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach items="${album}" var="album">
        <div class="col-xs-6 col-md-3">
            <a href="/list/${album.albumId}" class="thumbnail" style="text-align:center;"  class="btn btn-default" data-html="true"
               data-toggle="tooltip" data-placement="right"
               title="${album.albumDescription}">
                <img src="${album.albumCover}" alt="..." >
                    ${album.albumName}
            </a>
        </div>

</c:forEach>
