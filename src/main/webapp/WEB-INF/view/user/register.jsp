<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Lost And Found- Dados">
	<jsp:body>
		<div class="content-wrapper">
    		<div class="container-fluid">
      		<ol class="breadcrumb">
       			<li class="breadcrumb-item">
          		<a href="#">Sistema</a>
      			</li>
      			<li class="breadcrumb-item active">Dados do Usuario</li>
			 </ol>
			 <div class="row">
            	<div class="col-12">
              		<h1>Dados Usuario </h1>
             	</div>
             </div>
             <form action="edit" method="POST" enctype="multipart/form-data" id="validate">           
                <div class="form-group">
                  <div class="form-row">
                    <div class="col-md-5">
                       <label for="login">Login: </label>                       
                       <input class="form-control"  type="text" name="login" size="45" value="<c:out value='${user.login}' />" />

                     </div>
                     <div class="col-md-7">
                      <label for="senha">Senha: </label>
                      <input class="form-control" id="senha" name="senha" type="text">
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <div class="form-row">
                    <div class="col-md-3">
                       <label for="telefone">Telefone: </label>                       
                       <input class="form-control" type="text" name="telefone" value="<c:out value='${user.getTelefone()}' />" />

                     </div>
                     <div class="col-md-9">
                      <label for="email">E-mail: </label>
                      <input class="form-control" type="email" name="email" value="<c:out value='${user.getEmail()}' />" />
                    </div>
                  </div>
                </div>
                <div class="form-group">
            <div class="form-row">
              <div class="col-md-2">
                <button class="btn btn-success btn-block" type="submit"> <i class="fa fa-floppy-o" aria-hidden="true"></i> Gravar </button> 
              </div>
              <div class="col-md-2">
                <a href="home" class="btn btn-danger btn-block text-white" type="reset"> <i class="fa fa-times" aria-hidden="true"></i> Cancelar</a>
              </div>
            </div>
          </div>
              </form>

			</div>
		</div>
	</jsp:body>
</t:template>