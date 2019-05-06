<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:simple title="Lost And Found- Login">
<jsp:body>
<div class="container">
 <div class="card mx-auto mt-5">
  <div class="card-header">
   <div class="text-center">
    <img src="resources/img/logo.png">
  </div>
</div>
<div class="card-body">
  <form action="usuarios/insert" method="POST" class="margin-bottom">           
    <div class="form-group">
      <div class="form-row">
        <div class="col-md-5">
         <label for="login">Login: </label>                       
         <input class="form-control"  type="text" name="login" size="45"/>

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
       <input class="form-control" type="text" name="telefone"/>

     </div>
     <div class="col-md-9">
      <label for="email">E-mail: </label>
      <input class="form-control" type="email" name="email"/>
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
</div>
</jsp:body>
</t:simple>
