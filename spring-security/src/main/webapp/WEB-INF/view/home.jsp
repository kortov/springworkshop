<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
    <title>luv2code Company Home Page</title>
</head>

<body>
<h2>luv2code Company Home Page</h2>
<hr>
<p>
    Welcome to the luv2code company home page!
</p>
<hr>
User: <security:authentication property="principal.username"/>
<br><br>
Role(s): <security:authentication property="principal.authorities"/>
<hr>
<hr>
<p>
    <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
    (Only for Manager peeps)
</p>
<p>
    <a href="${pageContext.request.contextPath}/systems">IT systems Meeting</a>
    (Only for Admin peeps)
</p>
<hr>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
<input type="submit" value="Logout">
</form:form>
</body>

</html>