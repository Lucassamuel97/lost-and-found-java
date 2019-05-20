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
  <h2>Ooops!! Alguma coisa muito errada aconteceu!</h2>
		<p>Pedimos desculpas! A culpa não é sua, é nossa! A falha é nossa e em breve iremos corrigi-la!</p>
		<p>
			<strong>Mensagem de Erro: </strong>
			${errorBean.message} 
		</p>
</div>
</div>
</div>
</jsp:body>
</t:simple>