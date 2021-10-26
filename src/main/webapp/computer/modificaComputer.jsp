<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionecomputerjspservletmaven.model.Computer"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Modifica Elemento</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Modifica elemento</h5> 
				    </div>
				   <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
							<% Computer computerInPagina = (Computer)request.getAttribute("computerDaInviareAPaginaModifica"); %>
		
							<form method="post" action="ExecuteModificaComputerServlet?idComputer=<%=computerInPagina.getId() %>" class="row g-3" novalidate="novalidate">
							
							
								<div class="col-md-6">
									<label for="marca" class="form-label">Marca <span class="text-danger">*</span></label>
									<input type="text" name="marca" id="marca" class="form-control" placeholder="Inserire la marca"  
										value="<%=computerInPagina.getMarca()!=null?computerInPagina.getMarca():"" %>" required>
								</div>
								
								<div class="col-md-6">
									<label for="modello" class="form-label">Modello <span class="text-danger">*</span></label>
									<input type="text" name="modello" id="modello" class="form-control" placeholder="Inserire il modello"  
										value="<%=computerInPagina.getModello()!=null?computerInPagina.getModello():"" %>" required>
								</div>
							
								<div class="col-md-6">
									<label for="prezzo" class="form-label">Prezzo <span class="text-danger">*</span></label>
									<input type="number" class="form-control" name="prezzo" id="prezzo" placeholder="Inserire prezzo" 
									value="<%=computerInPagina.getPrezzo()!=null?computerInPagina.getPrezzo():"" %>" required>
								</div>
								
								<div class="col-md-3">
									<label for="dataRilascio" class="form-label">Data di Rilascio<span class="text-danger">*</span></label>
									<input class="form-control"  name="dataRilascio" id="dataRilascio" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<%=computerInPagina.getDataRilascio()!=null? new SimpleDateFormat("yyyy-MM-dd").format(computerInPagina.getDataRilascio()):""  %>" required/>
								</div>
								
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
							</div>
		
						</form>
				    
					<!-- end card-body -->			   
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