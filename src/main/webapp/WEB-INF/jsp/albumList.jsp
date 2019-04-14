<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach items="${album}" var="album">
        <div class="col-xs-6 col-md-3">
            <a href="/list/${album.albumId}" class="thumbnail" style="text-align:center;"  class="btn btn-default" data-html="true"
               data-toggle="tooltip" data-placement="right"
               title="我们的青春太过匆忙，却来不及悲伤。彼时的你循规蹈矩，彼时的我墨守成规，沿着两点之间最短距离的直线去追求俗世的功名利禄，心向的方向难得的一致。以至于在我齿摇摇而发苍苍的时候只能看着你的照片，想想我们的缘分，枉叹空集!">
                <img src="${album.albumCover}" alt="..." >
                    ${album.albumName}
            </a>
        </div>

</c:forEach>
