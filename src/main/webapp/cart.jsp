<%@ page contentType="text/html;charset=UTF-8"%>
<span><%=application.getAttribute("onion").toString()%></span>
<span><%=application.getAttribute("eggs").toString()%></span>
<span><%=application.getAttribute("welshOnion").toString()%></span>
<span><%=application.getAttribute("apple").toString()%></span>
<span><%= "final price : "%> <%=request.getAttribute("money") %></span>
