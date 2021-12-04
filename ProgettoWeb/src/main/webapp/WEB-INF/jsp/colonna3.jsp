<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



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