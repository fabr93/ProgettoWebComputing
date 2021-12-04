


(() => {
	window.addEventListener('load', () => {
		
		
		
		$('#ricerca').click(() => {
			search();
			
		});
		
		
		function search() {
			
			aaa = $('#daCercare').val();
			console.log(aaa);
			window.location.href = "Search?s=" + aaa;
			
		}
		
		
		
			

	
		
	});

 
	
})();





