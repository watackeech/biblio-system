<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<form id="loginForm">
		<div class="form-floating mb-3 mt-3">
			<input type="text" class="form-control" name="barcodeId"
				id="barcode-id"><label
				for="publicationYear">バーコード番号</label>
		</div>
		<button type="submit" formaction="return-book" formmethod="post" class="btn btn-danger btn-block">返却！</button>
	</form>
</body>
</html>