<%@ include file="/WEB-INF/view/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/view/jspf/directive/taglib.jspf" %>
<!DOCTYPE html>
<html>
<%@ include file="/WEB-INF/view/jspf/main/head.jspf" %>
<body class="login-bg">
<div class="header">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <!-- Logo -->
                <div class="logo">
                    <h1><a href="index.html"><spring:message code="welcome"/></a></h1>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="page-content container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-wrapper">
                <div class="box">
                    <form method="POST" action="<spring:url value="/auth/login.fy" />">
                        <div class="content-wrap">
                            <h6>Sign In</h6>
                            <div class="form-group ${error != null ? 'has-error' : ''}">
                                <span>${message}</span>
                                <input name="email" type="email" class="form-control" placeholder="Email"
                                       autofocus="true" required="required"/>
                                <input name="password" type="password" class="form-control" required="required"
                                       placeholder="Password"/>
                                <span>${error}</span>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="already">
                    <p>Don't have an account yet?</p>
                    <a href="<spring:url value="/auth/signup.fy"/>">Sign Up</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="<spring:url value="/assets/js/jquery.js"/>"></script>
<script src="<spring:url value="/assets/js/bootstrap.min.js"/>"></script>
<script src="<spring:url value="/assets/js/custom.js"/>"></script>
</body>
</html>