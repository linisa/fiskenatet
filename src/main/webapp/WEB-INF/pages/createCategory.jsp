<%@ include file="taglib.jsp" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/default.css">

<title>Frågesport</title>

<script src="${pageContext.request.contextPath}/js/CreateCategoryScript.js"></script>

</head>
<body>
<jsp:include page="page-header.jsp"></jsp:include>
 
    <div id="addQuestion" class="pageclass">
      <h2>Skapa ny quiz</h2>
      <div id="fromResponse"></div>
         <div id="addCategoryList">
             <form:form id="newCategoryForm" action="${pageContext.request.contextPath}/createCategory.json" commandName="underCategoryModel">
                 <ul>
                   <li>
                     <label for="category">Kategori:</label>
                   	  <form:select path="category">
                       <form:option value="1">Geografi</form:option>
                       <form:option value="2">Sport</form:option>
                       <form:option value="3">Natur</form:option>
                       <form:option value="4">Film</form:option>
                       <form:option value="5">Musik</form:option>
                       <form:option value="6">Litteratur</form:option>
                     </form:select> 
                   </li>
                    <br>
                    <li>
                     <label for="underCategoryName">Underkategori:</label>
                     <input name="underCategoryName" id="underCategoryName" path="underCategoryName" value="${undercategory.underCategoryName}"/>
                   </li>
                    <br>
                   <li>
                       <input type="submit" value="Save" id="save" />
                   </li>
                 </ul>
             </form:form>
         </div>

 <br /><br />
 <a href="index">Tillbaka</a>
    </div>

<jsp:include page="page-footer.jsp"></jsp:include>
</body>
</html>
