<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template title="Lost And Found- Home">
	<jsp:body>
<div class="content-wrapper">
  <div class="container-fluid">
    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="#">Sistema</a>
      </li>
      <li class="breadcrumb-item active">Feed</li>
    </ol>
    <div class="row">
			<div class="col-lg-12">
				<form method="get" id="form_pag">       
					<div class="form-group">
						<div class="form-row">
							<div class="col-md-6">
								<input class="form-control" id="titulo" name ="titulo" type="text" placeholder="Filtre os resultados">
							</div>
							<div class="col-md-2">
								<button class="btn btn-info btn-block" type="submit"><i class="fa fa-search" aria-hidden="true"></i> Pesquisar </button>
							</div>
						</div>
					</div>                                             
				</form>
    		</div>
    </div>
    <div class="row">
           <div class="col-md-4 pb-3">
               <div class="card m-b-30">
                    <img class="card-img-top img-fluid"
								src="resources/uploads/308x200.svg" alt="Card image cap">
                         <div class="card-body">
                             <h5 class="card-title">Chave Carro</h5>
                             <p class="card-text">
                             	<b>Descrição: </b> Chave cor prata com chaveiro tipo A, encontrada no bloco A
                             </p>
                            <p class="card-text">
                                 <small class="text-muted">26/02/2019 - 10:40 hrs</small>
                            </p>
                             <a href="#" class="btn btn-outline-primary">Mais Detalhes</a>
                             <a href="#" class="btn btn-primary">Status: Ativo</a>
                     </div>
                  </div>
           </div>
           
           <div class="col-md-4 pb-3">
               <div class="card m-b-30">
                    <img class="card-img-top img-fluid"
								src="resources/uploads/308x200.svg" alt="Card image cap">
                         <div class="card-body">
                             <h5 class="card-title">Carteira</h5>
                             <p class="card-text">
                             	<b>Descrição: </b> Carteira em nome de Lucas Samuel, encontrada no bloco B
                             </p>
                             <p class="card-text">
                                 <small class="text-muted">26/02/2019 - 10:40 hrs</small>
                              </p>
                              
                              <a href="#" class="btn btn-outline-primary">Mais Detalhes</a>
                             <a href="#" class="btn btn-warning">Status: Pendente</a>
                           </div>
                    </div>
           </div>
           
           <div class="col-md-4 pb-3">
               <div class="card m-b-30">
                    <img class="card-img-top img-fluid"
								src="resources/uploads/308x200.svg" alt="Card image cap">
                         <div class="card-body">
                             <h5 class="card-title">Carteira</h5>
                             <p class="card-text">
                             	<b>Descrição: </b> Carteira em nome de Lucas Samuel, encontrada no bloco B
                             </p>
                             <p class="card-text">
                                 <small class="text-muted">26/02/2019 - 10:40 hrs</small>
                              </p>
                              
                              <a href="#" class="btn btn-outline-primary">Mais Detalhes</a>
                              <a href="#" class="btn btn-danger">Status: Expirado</a>
                           </div>
                    </div>
           </div>
           
           <div class="col-md-4 pb-3">
               <div class="card m-b-30">
                    <img class="card-img-top img-fluid"
								src="resources/uploads/308x200.svg" alt="Card image cap">
                         <div class="card-body">
                             <h5 class="card-title">Chave Carro</h5>
                             <p class="card-text">
                             	<b>Descrição: </b> Chave cor prata com chaveiro tipo A, encontrada no bloco A
                             </p>
                            <p class="card-text">
                                 <small class="text-muted">26/02/2019 - 10:40 hrs</small>
                            </p>
                             <a href="#" class="btn btn-outline-primary">Mais Detalhes</a>
                             <a href="#" class="btn btn-success">Status: Concluido</a>
                     </div>
                  </div>
           </div>
         
     </div>
  </div>
</div>
</jsp:body>
</t:template>