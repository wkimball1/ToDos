<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="ToDo.ManageToDo"%>
<%@ page import="ToDo.ToDoItem"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete To Do</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<%
  ManageToDo myList = new ManageToDo();
  List<String> newList = new ArrayList<String>();
  newList = myList.viewToDos();

%>
<body>
<div class="container">
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="index.jsp">View To Do's</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="AddToDo.jsp">Add To Do's</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="DeleteToDo.jsp">Delete To Do's</a>
        </li>
      </ul>

    </div>
  </div>
</nav>
    <div class="jumbotron jumbotron-fluid">
 		<div class="container">
    		<h1 class="display-4">Delete To Do</h1>
    		<p class="lead">Click delete next to the to do you want to remove.</p>
  		</div>
	</div>
	<%if (newList.size() > 0 && newList != null) { %>
	<form method="POST" action="deleteToDoProcesses">
		<div class="form-group mb-3">
			<table class="table">
				<thead>
					<tr>
            			<th scope="col">To Do's</th>
            			<th scope="col">Delete</th>
       				 </tr>
				</thead>
				<tbody>
					<% for(int i = 0; i < newList.size(); i++) { %>
				 		<tr>			 		    
							<td id="<%= (i) %>"><%= (newList.get(i)) %></td>
							<td><input type="checkbox" name="delete" class="form-control" value="<%=newList.get(i)%>"></td>	
						</tr>
					<% } %>
					<tr>
			        	<td><input type="reset" value="Clear" name="clear" class="form-control-md">
			    		<input type="submit" value="Submit" name="submit" class="form-control-md"></td>
			    	</tr>
					
				</tbody>
			</table>
		</div>
	</form>
 <% }
 else { %>
   <h2>The to do list is empty please <a href="AddToDo.jsp">add to do's</a></h2>
 <% } %>
</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>