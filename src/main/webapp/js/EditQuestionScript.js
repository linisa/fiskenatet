$(document).ready(function() {

    $("#editQuestionForm").submit(function(event) {
      var question = $("#question").val();
      var correctAnswer = $("#correctAnswer").val();
      var firstWrongAnswer = $("#firstWrongAnswer").val();
      var secondWrongAnswer = $("#secondWrongAnswer").val();
      var category = $("#category").val();
      var subCategory = $("#subCategory").val();
      var json = {"question":question,"correctAnswer":correctAnswer,"firstWrongAnswer":firstWrongAnswer,
            "secondWrongAnswer":secondWrongAnswer,"category":category,"subCategory":subCategory};

      $.ajax({
        url: $("#editQuestionForm").attr("action"),
        data: JSON.stringify(json),
        type : "POST",

        beforeSend: function(xhr) {
          xhr.setRequestHeader("Accept", "application/json");
          xhr.setRequestHeader("Content-Type", "application/json");
        },
        success: function(question) {
        		var respContent = "";

		  		respContent += "<span class='success'>Frågan är redigerad: [";
		  		respContent += questionModel.question + "]</span>";

        		$("#fromResponse").html(respContent);
        }
      });
      event.preventDefault();
    });
  });
