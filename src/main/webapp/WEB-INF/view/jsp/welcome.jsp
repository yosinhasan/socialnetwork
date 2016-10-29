<%@ include file="/WEB-INF/view/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/view/jspf/directive/taglib.jspf" %>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/view/jspf/main/head.jspf" %>
<body>
<%@ include file="/WEB-INF/view/jspf/main/header.jspf" %>
<section id="content" class="main-content">
    <div class="container">
        <div class="row">
            <div class="span8">
                <div class="clearfix cols-1">
                    <h4 class="indent-2"><spring:message code="welcome"/></h4>
                </div>
            </div>
            <div class="span4">
                <h4 class="indent-2">Latest News:</h4>
                <h3>${user.name}</h3>
                <ul class="list-news">
                    <li>
                        <a href="#" class="btn btn_">Apr 21, 2016</a>
                        <p class="text-info">Title</p>
                         Short description <a href="#" class="underline">>></a>
                    </li>
                </ul>

                <h4 class="indent-2"></h4>
                <div class="container">
                    <div class="row">
                        <div class="span8 float">
                            Developed by Silver brain&copy;  2016  |   Template from <a rel="nofollow" href="http://www.templatemonster.com/category.php?category=0&type=1" target="_blank">here</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/view/jspf/main/footer.jspf" %>
</body>
</html>