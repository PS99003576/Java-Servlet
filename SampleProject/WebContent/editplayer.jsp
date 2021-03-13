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
int id=Integer.parseInt(request.getParameter("id"));
PlayerDao pd=new PlayerDao();
Player p1=pd.getPlayerById(id);
%>
<form action="./UpdatePlayerServlet" method="post">
Player Id: <%=p1.getPlayer_id() %> <br><br>
Player Name: <input type="text" value="<%=p1.getName()%>" name="Player_Name"><br><br>
Player DOB: <input type="text" value="<%=p1.getDateOfBirth() %>" name="DOB"><br><br>
Player Country: <input type="text" value="<%=p1.getNationality()%>" name="country"><br><br>
Skills: <input type="text" value="<%=p1.getSkills()%>" name="Skill"><br><br>
runs: <input type="text" value="<%=p1.getRuns()%>" name="country"><br><br>
wickets: <input type="text" value="<%=p1.getWickets()%>" name="country"><br><br>
number of matches: <input type="text" value="<%=p1.getNumber_of_matches() %>" name="country"><br><br>
Team Id: <input type="text" value="<%=p1.getTeam_id()%>" name="country"><br><br>

<input type="submit" value="Update Player">

</form>
</body>
</html>