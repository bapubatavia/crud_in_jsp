<%@page import="service.*"%>
<jsp:useBean id="u" class="model.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
UserService userService = new UserImpl();
int i=userService.save(u);
if(i>0){
response.sendRedirect("adduser-success.jsp");
}else{
response.sendRedirect("adduser-error.jsp");
}
%>