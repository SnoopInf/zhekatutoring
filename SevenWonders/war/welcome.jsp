<%@ page language="java" contentType="text/html; charset=UTF8"
    pageEncoding="UTF8"%>
   <%@ page import="com.google.appengine.api.users.*" %>
<!-- gwt-hosting.jsp -->
<html>
 <head>
 <link type="text/css" rel="stylesheet" href="SevenWonders.css">
<%
   UserService userService = UserServiceFactory.getUserService();
   if (userService.isUserLoggedIn()) {
%>
    <script type="text/javascript" src="sevenwonders/sevenwonders.nocache.js"></script>
    <script type="text/javascript">
      var info = { "email" : "<%= userService.getCurrentUser().getEmail() %>" };
    </script>
  </head>
  <body>
  <a href="<%= userService.createLogoutURL(request.getRequestURI()) %>">Log out</a>
<%
   } else {
%>
  </head>
  <body>
    <a href="<%= userService.createLoginURL(request.getRequestURI()) %>">Log in</a>
<%
   }
%>
 </body>
</html>