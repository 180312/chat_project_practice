<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/index.css">
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Meldinger</title>
</head>
<body>
	<form action="Meldinger" method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<legend>Ny melding</legend>
			<div style="padding:1%">
				<textarea rows="4" cols="60" name="melding"></textarea>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Submit</button>
				<button type="reset" class="pure-button pure-button-primary">Nullstill</button>
			</div>
		</fieldset>
	</form>
	<div style="padding:1%">
		<h3>Brukere:</h3>
		<table>
		<c:forEach items="${brukere}" var="bruker">
			<tr style="padding:1%">
				<td>${bruker.fornavn}&nbsp;${bruker.etternavn}</td>
			</tr>
		</c:forEach>
	</table>
		<h3>Meldinger:</h3>
	<table>
		<c:forEach items="${messages}" var="melding">
			<tr style="padding:1%">
				<td>${melding.id}:&nbsp;</td>
				<td>${melding.date},&nbsp; </td>
				<td><b>${melding.navn}:&nbsp;</b></td>
				<td>${melding.melding}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>