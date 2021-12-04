





<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<!DOCTYPE html>
<html>
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
 	<link rel="stylesheet" href="css/card.css" type="text/css" >
 	<link rel="stylesheet" href="css/libreria.css" type="text/css" >
 	
 	<script src="js/include.js"></script>
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
		<div id="nav" class="row" >
			<div id="aaa" class="col">
				<ul>
				  <li><a href="Playlist">Playlist</a></li>
				  <li><a href="Podcast">Podcast</a></li>
				  <li><a class="active" href="#">Artisti</a></li>
				  <li><a href="Album">Album</a></li>
				</ul>
			</div>
		</div>
		
		
		<div  id="categoria" class="row" >
			<div class="col">
			<h2 style="color:white"> Artisti </h2>
			</div>	
		</div>
		
		
		<div class="row" id="rigaCard" >
			<div class="col">
			
			
				<c:forEach var="art" items="${listaArtista}">
				<div class="column">
    				<div class="card" style="background-image: url(images/${art.sfondo}.png)">
      				<a href="#" class="stretched-link"> <h4> ${art.nome} </h4> </a>
     				</div>
  				</div>
  				</c:forEach>
  				
  				
  				
  				
  				
  				
  				
  				
  				
			</div>		
		</div>
		
		
		
</div>







<script> includeHTML(); </script>
</body>
</html>