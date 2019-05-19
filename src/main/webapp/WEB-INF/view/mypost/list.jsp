<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Lost And Found- Meus posts">
	<jsp:body>
<div class="content-wrapper">
  <div class="container-fluid">
    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="#">Sistema</a>
      </li>
      <li class="breadcrumb-item active">Meus Posts</li>
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
							<div class="col-md-2">
								<a href="item/cadastro"
											class="btn btn-success text-white btn-block">Postar Objeto <i
											class="fa fa-plus" aria-hidden="true"></i></a>
							</div>
						</div>
					</div>                                             
				</form>
    		</div>
    </div>
    <div class="row">
            <c:forEach var="item" items="${listItems}">
                <div class="col-md-4 pb-3">
               	<div class="card m-b-30">
                    <img class="card-img-top img-fluid"
									src="resources/uploads/308x200.svg" alt="Card image cap">
                         <div class="card-body">
                             <h5 class="card-title">
										<c:out value="${item.getDescricao()}" />
									</h5>
                             <p class="card-text">
                             	<b>a</b>
                             </p>
                            <p class="card-text">
                                 <small class="text-muted"><c:out
												value="${item.getDate()}" /> - <c:out
												value="${item.getHorario()}" /> hrs</small>
                            </p>
                             <a href="#" class="btn btn-outline-primary">Mais Detalhes</a>
                             <a href="#" class="btn btn-primary">Status: Ativo</a> 
                                              	
                     </div>
                  </div>
           		</div>
            </c:forEach>         
     </div>
  </div>
</div>
</jsp:body>
</t:template>