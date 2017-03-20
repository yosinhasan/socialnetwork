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
                    <div class="content-wrap">
                        <form:form method="POST" modelAttribute="userForm" class="form-signin">
                            <h6 class="form-signin-heading">Sign Up</h6>
                            <spring:bind path="email">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="email" path="email" class="form-control" placeholder="Email"
                                                autofocus="true" required="required"></form:input>
                                    <form:errors path="email"></form:errors>
                                </div>
                            </spring:bind>
                            <spring:bind path="password">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="password" path="password" required="required" class="form-control"
                                                placeholder="Password"></form:input>
                                    <form:errors path="password"></form:errors>
                                </div>
                            </spring:bind>
                            <spring:bind path="passwordConfirm">
                                <div class="form-group ${status.error ? 'has-error' : ''}">
                                    <form:input type="password" path="passwordConfirm" class="form-control"
                                                placeholder="Confirm your password" required="required"></form:input>
                                    <form:errors path="passwordConfirm"></form:errors>
                                </div>
                            </spring:bind>
                            <div class="action">
                                <button class="btn btn-primary signup" type="submit">Sign Up</button>
                            </div>
                        </form:form>
                    </div>
                </div>
                <div class="already">
                    <p>Have an account already?</p>
                    <a href="<spring:url value="/auth/login.fy"/>">Login</a>
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