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
             <c:if test="${message != null}">
					<div class="alert alert-success alert-dismissible">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<p>${message}</p>
					</div>
			</c:if>
			
			<form action="${typeuser}/usuarios/update" method="POST"> 
             	<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>  
                <div class="form-group">
                  <div class="form-row">
                    <div class="col-md-5">
                       <label for="login">Login: </label>                       
                       <input class="form-control"  type="text" name="login" size="45" value="<c:out value='${user.login}' />" />

                     </div>
                     <div class="col-md-7">
                      <label for="pwd">Senha: </label>
                      <input class="form-control" id="pwd" name="pwd" type="password">
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
                <button class="btn btn-success btn-block" type="submit" value="Save"> <i class="fa fa-floppy-o" aria-hidden="true"></i> Gravar </button> 
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