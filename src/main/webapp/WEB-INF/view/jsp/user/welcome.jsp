<%@ include file="/WEB-INF/view/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/view/jspf/directive/taglib.jspf" %>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/view/jspf/user/head.jspf" %>
<body>
<%@ include file="/WEB-INF/view/jspf/user/header.jspf" %>
<div class="banner-bg" id="top">
    <div class="banner-overlay"></div>
    <div class="welcome-text">
        <h2>My profile</h2>
        <h5>Check it out</h5>
    </div>
</div>

<!-- MAIN CONTENT -->
<div class="main-content">
    <div class="fluid-container">

        <div class="content-wrapper">

            <!-- ABOUT -->
            <div class="page-section" id="about">
                <div class="row">
                    <div class="col-md-12">
                        <h4 class="widget-title">Learn About Me</h4>
                        <div class="about-image">
                            <img src="/assets/user/img/8.jpg" alt="about me">
                        </div>
                        <p>Volton is free website design from <span class="blue">template</span><span class="green">mo</span>. You can use this template for any purpose. Please tell your friends about it. Thank you. Credit goes to <a rel="nofollow" href="http://unsplash.com" target="_parent">Unsplash</a> for images used in this design. You can <strong>change menu icons</strong> by checking <a rel="nofollow" href="http://fontawesome.info/font-awesome-icon-world-map/" target="_parent">Font Awesome</a> (version 4). Example: <strong>&lt;i class=&quot;fa fa-camera&quot;&gt;&lt;/i&gt;</strong></p>
                        <hr>
                    </div>
                </div> <!-- #about -->
            </div>

            <!-- PROJECTS -->
            <div class="page-section" id="projects">
                <div class="row">
                    <div class="col-md-12">
                        <h4 class="widget-title">PHOTOS OF WHAT I DO</h4>
                        <p>Duis sed odio sit amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Maecenas et lorem molestie, maximus justo dignissim, cursus nisl. Nullam at ante quis ex pharetra pulvinar quis id dolor. Integer lorem odio, euismod ut sem sit amet, imperdiet condimentum diam.</p>
                    </div>
                </div>
                <div class="row projects-holder">
                    <div class="col-md-4 col-sm-6">
                        <div class="project-item">
                            <img src="/assets/user/img/1.jpg" alt="">
                            <div class="project-hover">
                                <div class="inside">
                                    <h5><a href="#">Pellentesque porta ligula</a></h5>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam cursus</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div class="project-item">
                            <img src="/assets/user/img/2.jpg" alt="">
                            <div class="project-hover">
                                <div class="inside">
                                    <h5><a href="#">Pellentesque porta ligula</a></h5>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam cursus</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div class="project-item">
                            <img src="/assets/user/img/3.jpg" alt="">
                            <div class="project-hover">
                                <div class="inside">
                                    <h5><a href="#">Pellentesque porta ligula</a></h5>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam cursus.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div class="project-item">
                            <img src="/assets/user/img/4.jpg" alt="">
                            <div class="project-hover">
                                <div class="inside">
                                    <h5><a href="#">Pellentesque porta ligula</a></h5>
                                    <p>Quisque mattis sit amet dolor eu scelerisque. Vivamus bibendum massa et nisl tempus commodo.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div class="project-item">
                            <img src="/assets/user/img/5.jpg" alt="">
                            <div class="project-hover">
                                <div class="inside">
                                    <h5><a href="#">Pellentesque porta ligula</a></h5>
                                    <p>Quisque mattis sit amet dolor eu scelerisque. Vivamus bibendum massa et nisl tempus commodo.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div class="project-item">
                            <img src="/assets/user/img/6.jpg" alt="">
                            <div class="project-hover">
                                <div class="inside">
                                    <h5><a href="#">Pellentesque porta ligula</a></h5>
                                    <p>Quisque mattis sit amet dolor eu scelerisque. Vivamus bibendum massa et nisl tempus commodo.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> <!-- .projects-holder -->
            </div>
            <hr>

            <!-- CONTACT -->
            <div class="page-section" id="contact">
                <div class="row">
                    <div class="col-md-12">
                        <h4 class="widget-title">PLACE TO TALK WITH ME</h4>
                        <p>Vestibulum ac iaculis erat, in semper dolor. Maecenas et lorem molestie, maximus justo dignissim, cursus nisl. Nullam at ante quis ex pharetra pulvinar quis id dolor. Integer lorem odio, euismod ut sem sit amet, imperdiet condimentum diam.</p>
                    </div>
                </div>
                <div class="row">
                    <form action="#" method="post" class="contact-form">
                        <fieldset class="col-md-4 col-sm-6">
                            <input type="text" id="your-name" placeholder="Your Name...">
                        </fieldset>
                        <fieldset class="col-md-4 col-sm-6">
                            <input type="email" id="email" placeholder="Your Email...">
                        </fieldset>
                        <fieldset class="col-md-4 col-sm-12">
                            <input type="text" id="your-subject" placeholder="Subject...">
                        </fieldset>
                        <fieldset class="col-md-12 col-sm-12">
                            <textarea name="message" id="message" cols="30" rows="6" placeholder="Leave your message..."></textarea>
                        </fieldset>
                        <fieldset class="col-md-12 col-sm-12">
                            <input type="submit" class="button big default" value="Send Message">
                        </fieldset>
                    </form>
                </div> <!-- .contact-form -->
            </div>
            <hr>

            <div class="row" id="footer">
                <div class="col-md-12 text-center">
                    <p class="copyright-text">Copyright &copy; 2015 Company Name</p>
                </div>
            </div>

        </div>

    </div>
</div>
<%@include file="/WEB-INF/view/jspf/user/footer.jspf" %>
</body>
</html>