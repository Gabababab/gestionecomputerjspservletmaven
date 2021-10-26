<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionecomputerjspservletmaven.model.Computer"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="it" class="h-100">
<head>

<!-- Common imports in pages -->
<jsp:include page="../header.jsp" />

<title>Conferma Elemento Da Rimuovere</title>
</head>
<body class="d-flex flex-column h-100">

	<!-- Fixed navbar -->
	<jsp:include page="../navbar.jsp"></jsp:include>


	<!-- Begin page content -->
	<main class="flex-shrink-0">
		<div class="container">

			<div class='card'>
				<div class='card-header'>
					<h5>Visualizza dettaglio</h5>
				</div>


				<div class='card-body'>
					<dl class="row">
						<dt class="col-sm-3 text-right">Marca:</dt>
						<dd class="col-sm-9"><c:out value="${computerDaInviareAPaginaRimuovi.getMarca()}"/></dd>
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Modello:</dt>
						<dd class="col-sm-9"><c:out value="${computerDaInviareAPaginaRimuovi.getModello()}"/></dd>					
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Prezzo:</dt>
						<dd class="col-sm-9"><c:out value="${computerDaInviareAPaginaRimuovi.getPrezzo()}"/></dd>
					</dl>
					   
					<dl class="row">	
						 <dt class="col-sm-3 text-right">Data di Rilascio:</dt>
						<dd class="col-sm-9">
						  <fmt:formatDate value="${computerDaInviareAPaginaRimuovi.getDataRilascio()}"  pattern="dd/MM/yyyy" var="datarilascio"/>
			      		  <c:out value="${datarilascio}"/></dd>
					 </dl>

				</div>

				<div class='card-footer'>
					<a href="ListComputerServlet" class='btn btn-outline-secondary'
						style='width: 80px'> <i class='fa fa-chevron-left'></i> Back
					</a>

					<form action="ExecuteRimuoviComputerServlet?idComputer=${computerDaInviareAPaginaRimuovi.getId()}"
						method="post">

						<button type="submit" name="submit" value="submit" id="submit"
							class="btn btn-outline-danger btn-sm" class="btn btn-primary">Conferma
							Rimozione</button>

					</form>
				</div>
				<!-- end card -->
			</div>


			<!-- end container -->
		</div>

	</main>

	<!-- Footer -->
	<jsp:include page="../footer.jsp" />
</body>
</html>