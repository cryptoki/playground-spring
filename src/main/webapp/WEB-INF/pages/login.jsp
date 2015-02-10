<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login Dev</title>
</head>
<body>

<h1>Login Dev</h1>
<form action="/login" method="POST">
    <input type="text" size="30" name="username" value="${username}"/> <BR/>
    <input type="password" size="30" name="password" value="${password}"/> <BR/>
    <input type="submit" value="Submit"/>
</form>

</body>
</html>