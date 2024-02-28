<%@page import="service.*"%>
<jsp:useBean id="u" class="model.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
UserService userService = new UserImpl();
userService.delete(u);
response.sendRedirect("viewusers.jsp");
%>