<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Test upload</h1>
	
	<!-- Upload d'une image avec un type d'encodage multipart -->
	<!-- Appel de la Servlet associée au formulaire -->
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="text" name="description" /> <input type="file"
			name="file" /> <input type="submit" />
	</form>
</body>
</html>