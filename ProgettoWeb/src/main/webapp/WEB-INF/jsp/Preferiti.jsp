<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="css/generale.css" type="text/css" />
	<link rel="stylesheet" href="css/colonna1.css" type="text/css" >
 
 	
 	<script src="./js/include.js"></script>
 	<script src="./js/preferiti.js"></script>
 	<script src="./js/ricerca.js"></script>
 	

</head>






<body>


<div class="colonna1">
<h2 id="logo"> Musica</h2>
			
		
			<ul>
				  <li>
				 <div class="example" >
					<input type="text" placeholder="Artisti,brani o podcast" name="search" id="daCercare">
					<input type="submit" id="ricerca" value="Cerca" >
				</div>
				  </li>
	
					
					
			<c:if test="${usernameLogged != null}"> 
				  <li><a href="Playlist"><i class="fa fa-fw fa-book"></i>La tua libreria</a></li>
				  <li><a href="Preferiti"><i class="fa fa-fw fa-heart"></i>Brani preferiti</a></li>
				  <li><a href="#"><i class="fa fa-fw fa-plus"></i>Crea playlist</a></li>
				  <li><a href="doLogout"><i class="fa fa-fw fa-user"></i>Logout</a></li>
	  		</c:if>  
	  			  
	  			 
	  		<c:if test="${usernameLogged == null}"> 
	  			  <li><a href="" data-toggle="modal" data-target="#modalLogin"><i class="fa fa-fw fa-user"></i>Login</a></li>
	  		</c:if>
	</ul>


</div> 




<div class="container" >
		
		
	<div class="row" >
	
	
   <div class="col" style="border: solid black 0px;">
   		<div class="testo" >Brani preferiti </div>
   </div>
   

</div>

<div class=row>
	<table id="tblPreferiti" class="table">


  <thead>	
  <tr>
    <th>Titolo</th>
    <th>Artista</th>
    <th>Album</th>
    <th>Durata</th>
    <th></th>
  </tr>
  </thead>
  
  
  <tbody>
  <c:forEach var="pre" items="${listaPreferiti}">
  <tr class="riga" id="${pre.id}">
  	<td> ${pre.titolo} </td>
    <td> ${pre.artista}</td>
    <td> ${pre.album}</td>
    <td> ${pre.durata}</td>
    <td style="text-align: center"><button  value="${pre.id}" type="button" class="btn btn-danger">Rimuovi</button></td>
    
  </tr>
  </c:forEach>
  </tbody>
 
</table>


</div>	
		
		
		
		
		
		
		
</div>







<script> includeHTML(); </script> 
</body>
</html>