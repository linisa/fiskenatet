$(document).ready(function() {

		var deleteQuestion = $("a:contains('Delete')");

		$(deleteQuestion).click(function(event) {

			$.ajax({
				url: $(event.target).attr("href"),
			  	type: "DELETE",

			  	beforeSend: function(xhr) {
			  		xhr.setRequestHeader("Accept", "application/json");
			  		xhr.setRequestHeader("Content-Type", "application/json");
			  	},

			  	success: function(question) {
			  		var respContent = "";
			  		var rowToDelete = $(event.target).closest("tr");

			  		rowToDelete.remove();

			  		respContent += "<span class='success'>Frågan är raderad: [";
			  		respContent += questionModel.question  + "]</span>";

			  		$("#questionResponse").html(respContent);
			  	}
			});

			event.preventDefault();
		});

});
