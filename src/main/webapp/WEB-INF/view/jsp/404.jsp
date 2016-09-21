<%@ include file="/WEB-INF/view/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/view/jspf/directive/taglib.jspf" %>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/view/jspf/main/head.jspf" %>
<body>
<!--==============================header=================================-->
<header>
    <div class="container">
        <div class="row">
            <div class="span12">
                <div class="header-block clearfix">
                    <div class="clearfix header-block-pad">
                        <h1 class="brand"><a href="index.html"><img src="assets/img/logo.png" alt=""></a><span>Fashion brand</span></h1>
                        <form id="search-form" action="search.php" method="GET" accept-charset="utf-8" class="navbar-form" >
                            <input type="text" name="s" onBlur="if(this.value=='') this.value=''" onFocus="if(this.value =='' ) this.value=''"  >
                            <a href="#" onClick="document.getElementById('search-form').submit()"></a>
                        </form>
                        <span class="contacts">Call Us Toll Free:  <span>+1 234 567 89 90</span><br>E-mail: <a href="#">company@demolink.org</a></span>
                    </div>
                    <div class="navbar navbar_ clearfix">
                        <div class="navbar-inner navbar-inner_">
                            <div class="container">
                                <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse_">MENU</a>
                                <div class="nav-collapse nav-collapse_ collapse">
                                    <ul class="nav sf-menu">
                                        <li class="li-first"><a href="index.html"><em class="hidden-phone"></em><span class="visible-phone">Home</span></a></li>
                                        <li class="sub-menu"><a href="index-1.html">about</a>
                                            <ul>
                                                <li><a href="#">Welcome Message</a></li>
                                                <li class="sub-menu"><a href="#">Company Profile</a>
                                                    <ul>
                                                        <li><a href="#">Our Capabilities</a></li>
                                                        <li><a href="#">Advantages</a></li>
                                                        <li><a href="#">Work Team</a></li>
                                                        <li><a href="#">Partnership</a></li>
                                                        <li><a href="#">Support</a></li>
                                                    </ul>
                                                </li>
                                                <li><a href="#">Our History</a></li>
                                                <li><a href="#">Testimonials</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="index-2.html">services</a></li>
                                        <li><a href="index-3.html">collections</a></li>
                                        <li><a href="index-4.html">styles</a></li>
                                        <li><a href="index-5.html">contacts</a></li>
                                    </ul>
                                </div>
                                <ul class="social-icons">
                                    <li><a href="#"><img src="assets/img/icon-1.png" alt=""></a></li>
                                    <li><a href="#"><img src="assets/img/icon-2.png" alt=""></a></li>
                                    <li><a href="#"><img src="assets/img/icon-3.png" alt=""></a></li>
                                    <li><a href="#"><img src="assets/img/icon-4.png" alt=""></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<section id="content">
    <div class="sub-content">
        <div class="container">
            <div class="row block-404">
                <div class="span8">
                    <img src="assets/img/404.png" alt="">
                </div>
                <div class="span4">
                    <h1>Sorry!</h1>
                    <h4>404 page not found</h4>
                    <p class="p3">The page you are looking for might have been removed, had its name changed, or is temporarily unavailable.</p>
                    Please try using our search box below to look for information on the website
                    <form id="form-search" action="search.php" method="GET" accept-charset="utf-8" class="form-404" >
                        <div class="clearfix">
                            <input type="text" name="s" onBlur="if(this.value=='') this.value=''" onFocus="if(this.value =='' ) this.value=''" >
                            <a href="#" onClick="document.getElementById('form-search').submit()" class="btn btn_ btn-small_">search</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<%@include file="/WEB-INF/view/jspf/main/footer.jspf" %>
</body>
</html>
