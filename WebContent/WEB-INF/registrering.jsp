<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/index.css">
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Registere deg</title>
</head>
<body>
	<form method="post" action="Registrer" class="pure-form pure-form-aligned">
		<fieldset>
			<legend>Registrer deg</legend>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label>
					<input type="text" value="${validering.mobil}" id="phone" name="mobil" oninput="testTelefon()">
					<label id="mobil"></label> 
			</div>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label>
					<input type="text" value="${validering.fornavn}" id="firstName" name="fornavn" oninput="testFornavn()">
					<label id="fornavn"></label> 
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label>
					<input type="text" value="${validering.etternavn}" id="lastName" name="etternavn" oninput="testEtternavn()">
					<label id="etternavn"></label> 
			</div>
			<div class="pure-control-group">
				<label for="passord">Passord:</label>
					<input type="password" value="${validering.passord}" id="pass" name="passord"  oninput="testPassord()">
					<label id="passord"></label> 
			</div>
			<div class="pure-control-group">
				<label for="passord1">Gjenta passord:</label>
					<input type="password" value="${validering.passord1}" id="passConf" name="passord1" oninput="testPassordConfirmation()">
					<label id="passord2"></label> 
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Registrer Deg</button>
			</div>
		</fieldset>
	</form>
	<form action="LoggInn" class="pure-form pure-form-aligned">
		<div class="pure-controls">
			<button type="submit" class="pure-button pure-button-primary">Logg Inn</button>
		</div>
	</form>
	<script src="js/validation.js"></script>
</body>
</html>