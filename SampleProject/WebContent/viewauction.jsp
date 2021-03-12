<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import ="java.util.*,com.ltts.projectname.model.*,com.ltts.projectname.Dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AuctionDao pd=new AuctionDao();
List<Auction> li=pd.getAllAuction();
%>
<table>
<tr>
<th>Auction Id</th>
<th>player Id</th>
<th>Team Id</th>
<th>Year</th>
<th>amount</th>

</tr>
<%
for(Auction a:li){
%>
<tr>
<td><%=a.getAuctionId() %></td>
<td><%=a.getPlayerId() %></td>
<td><%=a.getTeamId() %></td>
<td><%=a.getYear() %></td>
<td><%=a.getAmount() %></td>

<td><a href="editplayer.jsp?id=<%=a.getAuctionId()%>">Update</a></td>
</tr>
<%} %>
</table>

</body>
</html>