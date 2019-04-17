<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:forEach items="${pic}" var="pic" varStatus="picStatus">
    <%--<script> var name  = "${pic.pictureName}"</script>--%>
        <div class="col-xs-6 col-md-3" data-toggle="modal" data-target="#myCarouselModal">
            <a href="#" class="thumbnail" style="text-align:center;"  pic_index="${picStatus.index}" >
                <label class="option block mn" style="text-align:left;display:none">
                    <input type="checkbox" value="${pic.pictureId}" class="picture" name="picture">
                    <span class="checkbox mn"></span>
                </label>
                <img src="${pic.pictureUrl}" alt="..." >
            </a>
        </div>
</c:forEach>

<!-- 轮播图 start-->

<%--<script>--%>

    <%--$(".modal-backdrop").remove();--%>

<%--</script>--%>
<div class="modal fade bs-example-modal-lg" id="myCarouselModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" >
    <div class="modal-backdrop" role="document">
        <div class="modal-dialog" style="width:600px">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="exampleModalLabel">相片查看</h4>
                </div>
                <!-- 指示符 -->


                <div id="myCarousel" class="carousel slide">
                    <!-- 轮播（Carousel）项目 -->
                    <div class="carousel-inner">
                        <c:forEach items="${pic}" var="pic1" varStatus="picIndex">
                            <div class='item <c:if test="${picIndex.index == 0}">active</c:if>'>
                                <img src="${pic1.pictureUrl}" alt="First slide">
                            </div>

                        </c:forEach>
                    </div>
                    <!-- 轮播（Carousel）导航 -->
                    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
                <!-- 轮播图end -->
            </div>
        </div>
    </div>
</div>
<script>
    $(function () {
        $(".thumbnail").on("click",function () {
            var picIndex=$(this).attr("pic_index");
            $(".item").removeClass("active");
            $(".item:eq("+picIndex+")").addClass("active");
        })
    })
</script>