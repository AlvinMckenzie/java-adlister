<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: alvinmckenzie
  Date: 12/15/22
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<form action="/login.jsp" method="post">
    <div class="imgcontainer">
        <img src="img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
        <%--@declare id="psw"--%><%--@declare id="uname"--%><label for="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>

        <button type="submit">Login</button>
        <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me
        </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
</form>

<%
    if(request.getMethod().equalsIgnoreCase("POST")) {
        String uname = request.getParameter("uname");
        String psw = request.getParameter("psw");

        if (uname.equalsIgnoreCase("admin") && psw.equalsIgnoreCase("password")) {
            response.sendRedirect("/profile.jsp");
        } else {
            PrintWriter outWriter = response.getWriter();
            outWriter.println("<h3>Try Again</h3>");
        }
    }
%>


</body>
</html>
