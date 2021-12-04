


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
  	<script src="http://www.w3schools.com/lib/w3data.js"></script>
 
 	<link rel="stylesheet" href="css/generale.css" type="text/css" />
 	<link rel="stylesheet" href="css/colonna1.css" type="text/css" >
 	<link rel="stylesheet" href="css/card.css" type="text/css" >
 	<link rel="stylesheet" href="css/libreria.css" type="text/css" >
 	 	
 	
 	<script src="js/include.js"></script>
 	<script src="/js/ricerca.js"></script>
 	<script src="/js/pref.js"></script>

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
				  <li><a href="https://google.com"><i class="fa fa-fw fa-plus"></i>Crea playlist</a></li>
				  <li><a href="doLogout"><i class="fa fa-fw fa-user"></i>Logout</a></li>
	  		</c:if>  
	  			  
	  			 
	  		<c:if test="${usernameLogged == null}"> 
	  			  <li><a href="" data-toggle="modal" data-target="#modalLogin"><i class="fa fa-fw fa-user"></i>Login</a></li>
	  		</c:if>
	</ul>


</div>



<div class="container" >
		
		
		
<div  id="categoria" class="row" >
	<div class="col">
	<h2 style="color:white"> Risultati ricerca </h2>
	</div>	
</div>




		
	<c:if test="${c != null }"> 
		<div class="row" >
			<div class="col">
			<h2 style="color:white"> Brani </h2>
			</div>	
		</div>
	</c:if>
	
	
		<div class=row>
	<table class="table">
  
				  <tbody>
				  <c:forEach var="can" items="${canzoni}">
				  <tr class="riga" >
				  	<td> ${can.titolo} </td>
				    <td> ${can.artista}</td>
				    <td> ${can.album}</td>
				    <td> ${can.durata}</td>
				    <c:if test="${usernameLogged != null}">
				    
				    	<c:if test= "${can.pre == false}">
				    		<td style="text-align:center" >
				    			<button   id="${can.id}" value="${can.id}" class="prova" >Aggiungi a Preferiti</button>
				    		</td>
				    	</c:if>
				    	
				    	
				    	
				    	<c:if test= "${can.pre == true}">
				    		<td style="text-align:center">
				    			<button  id="${can.id}" value="${can.id}" class="prova" >Rimuovi da Preferiti</button>
				    		</td>
				    	</c:if>
				    				    	
				    </c:if>
				  </tr>
				  </c:forEach>
				  </tbody>
				 
	</table>







	
	<c:if test="${a != null }"> 
		<div class="row" >
			<div class="col">
			<h2 style="color:white"> Artisti </h2>
			</div>	
		</div>
	</c:if>
		
		<div class="row"  >
			<div class="col">
			
			
				<c:forEach var="art" items="${artisti}">
				<div class="column">
    				<div class="card" style="background-image: url(images/${art.sfondo}.png)">
      				<a href="https://google.com" class="stretched-link"> <h4> ${art.nome} </h4> </a>
     				</div>
  				</div>
  				</c:forEach>
  		  				
			</div>		
		</div>
		










	<c:if test="${aa != null }"> 		
		<div class="row" >
			<div class="col">
			<h2 style="color:white"> Album </h2>
			</div>	
		</div>
	</c:if>
		
		<div class="row" >
			<div class="col">
			
			
				<c:forEach var="alb" items="${album}">
				<div class="column">
    				<div class="card" style="background-image: url(images/${alb.sfondo}.png)">
      				<a href="https://google.com" class="stretched-link"> <h4> ${alb.nome} </h4> </a>
     				</div>
  				</div>
  				</c:forEach>
  		  				
			</div>		
		</div>
		
		
		
		
		<c:if test="${p != null }"> 
		<div class="row" >
			<div class="col">
			<h2 style="color:white"> Playlist </h2>
			</div>	
		</div>
		</c:if>
		
		
		<div class="row"  >
			<div class="col">
			
			
				<c:forEach var="play" items="${playlist}">
				<div class="column">
    				<div class="card" style="background-image: url(images/${play.sfondo}.png)">
      				<a href="https://google.com" class="stretched-link"> <h4> ${play.nome} </h4> </a>
     				</div>
  				</div>
  				</c:forEach>
  		  				
			</div>		
		</div>
		
		
		
		
		
		
		
		<c:if test="${pp != null }"> 
		<div class="row" >
			<div class="col">
			<h2 style="color:white"> Podcast </h2>
			</div>	
		</div>
		</c:if>
		
		
		<div class="row"  >
			<div class="col">
			
			
				<c:forEach var="pod" items="${podcast}">
				<div class="column">
    				<div class="card" style="background-image: url(images/${pod.sfondo}.png)">
      				<a href="https://google.com" class="stretched-link"> <h4> ${pod.nome} </h4> </a>
     				</div>
  				</div>
  				</c:forEach>
  		  				
			</div>		
		</div>
		
		
		
		<c:if test="${vuoto != null }"> 
			

		<div class="row" >
			<div class="col">
			<h2 style="color:white; text-align: center;"> Nessun risultato trovato </h2>
			</div>	
		</div>

			
		</c:if>

</div>		
		
		
		
</div>




<div class="modal fade" id="modalLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
	  <div class="modal-dialog" role="document">
		 <form method="POST" action="doLogin">
		    <div class="modal-content">
		      <div class="modal-header text-center">
		        <h4 class="modal-title">Login</h4>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">          
		        </button>
		      </div>
		      <div class="modal-body mx-3">
		        <div class="md-form mb-5">          
		          <input type="text" id="form3" class="form-control" name="username">
		          <label  for="form3">Username</label>
		        </div>
		
		        <div class="md-form mb-4">          
		          <input type="password" id="form2" class="form-control" name="password">
		          <label for="form2">Password</label>
		        </div>
		
		      </div>
		      <div class="modal-footer justify-content-center">
		        <input type="submit" class="btn btn-success" value="Send"> 
		      </div>
		    </div>
	    </form>
	  </div>
</div>






<script> includeHTML(); </script>
</body>
</html>