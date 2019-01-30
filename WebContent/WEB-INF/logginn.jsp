<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/index.css">
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Logg inn</title>
</head>
<body>
	<form action="LoggInn" method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<legend>Logg Inn</legend>
				<h3>${feilmelding}</h3>
				<div class="pure-control-group">
					<label>Mobil:</label><input type="text" name="mobil">
				</div>
				<div class="pure-control-group">
					<label>Passord:</label><input type="password" name="passord">
				</div>
				<div class="pure-controls">
					<button type="submit" class="pure-button pure-button-primary">Logg Inn</button>
				</div>
		</fieldset>
	</form>
</body>
</html>