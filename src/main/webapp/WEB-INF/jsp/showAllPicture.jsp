<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:forEach items="${pictureUrl}" var="pictureUrl" varStatus="picStatus">
    <%--<script> var name  = "${pic.pictureName}"</script>--%>
        <div class="col-xs-6 col-md-3" data-toggle="modal" data-target="#myCarouselModal">
            <a href="#" class="thumbnail" style="text-align:center;"  pic_index="${pictureUrl}" >
                <img src="${pictureUrl}" alt="..." id="look">
                <style>
                    #look{
                        weight:200px;
                        height:150px;
                        border:1px solid #CCCCCC;
                    }
                </style>
            </a>
        </div>
</c:forEach>

<!-- 轮播图 start-->

<%--<script>--%>

    <%--$(".modal-backdrop").remove();--%>

<%--</script>--%>
                <!-- 指示符 -->



            </div>
        </div>
    </div>
</div>
