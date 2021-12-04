


(() => {
	window.addEventListener('load', () => {
		
		
		
		

	
		

		

	
		$('.btn ').click(e => {
			
			const btn = $(e.target);
			idRiga= btn.val();
			document.getElementById(idRiga).innerHTML="";  
			
			
			
			$.post('/rimuovi',{ id: idRiga}).done(res => {
				//alert(res);
				
			});

			
			
			

			
		});
	});

 
	
})();





