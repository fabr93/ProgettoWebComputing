


(() => {
	window.addEventListener('load', () => {
		
		
		
		

	
		

		

	
		$('.prova ').click(e => {
			
		
			
			const btn = $(e.target);
			idBtn= btn.val();
			
			testo= document.getElementById(idBtn).innerHTML;
			const text="Aggiungi a Preferiti";
			
			if ( testo==text){
				//alert("aggiungi");
				
				document.getElementById(idBtn).innerHTML="Rimuovi da Preferiti";
				
				$.post('/add',{ id: idBtn }).done(res => {
				alert("Brano aggiunto ai Preferiti");
				
			});
				
			}
			else {
				//alert("rimuovi");
				
				document.getElementById(idBtn).innerHTML="Aggiungi a Preferiti";
				
				$.post('/remove',{ id: idBtn}).done(res => {
				alert("Brano rimosso dai Preferiti");
				
			});
			
			}
			
			
			
			/*
			if( azione === "Aggiungi"){
				
				document.getElementById(idBtn).innerHTML="Rimuovi da Preferifi";
				
			}
			
			else{
				document.getElementById(idBtn).innerHTML="Aggiungi a Preferifi";
			}
			*/
			
			
			
			
			//alert(idBtn);
			//const azione = document.getElementById(idBtn).innerHTML ; //="<button value=\""+	idBtn+	"\" class=\"aggiungi\">Rimuovi da Preferiti</button>";
			//alert(azione);
			//document.getElementById(idBtn).innerHTML ="<button value=\""+	idBtn+	"\" class=\"rimuovi\">Rimuovi da Preferiti</button>";
			//idBtn= valore[0];
			//document.getElementById(idBtn).innerHTML="Rimuovi da Preferifi";
			//const  cl = "<button value=\"${"+	idBtn+	"}\" class=\"rimuovi\">Rimuovi da Preferiti</button>";
			//alert(cl); 
			//document.getElementById(idBtn).innerHTML=" <button value=${"+idBtn+"}  class=""rimuovi"" >Rimuovi da Preferiti</button>";  
			//document.getElementById(idBtn).innerHTML="<button >Rimuovi da Preferiti</button>";
			
			/*
			$.post('/rimuovi',{ id: idRiga}).done(res => {
				//alert(res);
				
			});
			*/
			
			
			

			
		});
		
		
		$('.rimuovi ').click(e => {
			
			alert("rimuovi");
			
			/*
			const btn = $(e.target);
			idBtn= btn.val();
			
			document.getElementById(idBtn).innerHTML="<button>Rimuovi da Preferiti</button>";
			const  cl = " prova virgolette\" /" ;
			alert(cl); 
			//document.getElementById(idBtn).innerHTML=" <button value=${"+idBtn+"}  class=""rimuovi"" >Rimuovi da Preferiti</button>";  
			//document.getElementById(idBtn).innerHTML="<button >Rimuovi da Preferiti</button>";
			
			
			$.post('/rimuovi',{ id: idRiga}).done(res => {
				//alert(res);
				
			});
			*/
			
			
			

			
		});
	
	
	
	
	
	
	});

 
	
})();





