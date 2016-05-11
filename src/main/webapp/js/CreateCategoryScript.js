$(document).ready(function() {

    $("#newCategoryForm").submit(function(event) {
      var category = $("category").val();
      var underCategoryName = $("underCategoryName").val();
      var json = {"category":category,"underCategoryName":underCategoryName};

      $.ajax({
        url: $("#newCategoryForm").attr("action"),
        data: JSON.stringify(json),
        type : "POST",

        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
          },
      	success: function(data) {
			var response = "";

			response += "<span class="succes">kategorin har skapats: [";
			response += underCategoryModel.underCategoryName + "]</span>";
			$("#fromResponse").html(response);
		}
      });
      event.preventDefault();
    });
});
