<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template title="Lost And Found- Home">
<jsp:body>
<div class="content-wrapper">
	<div class="container-fluid">
		<ol class="breadcrumb">
			<li class="breadcrumb-item">
				<a href="#">Objeto</a>
			</li>
			<li class="breadcrumb-item active">Cadastro</li>
		</ol>

		<div class="row">
			<div class="col-12">
				<h2>Objeto </h2>
				<form action="item/insert" method="POST" id="validate">      
					<div class="form-group">
						<div class="form-row">							
							<div class="col-md-6">
								<label class="control-label" for="descricao"> Descrição *</label>

								<input id="descricao" name="descricao" placeholder="Digite a Descrição" class="form-control" >
							</div>

							<div class="col-md-3">
								<label for="local"> Local: </label>
								<input id="local" name="local" type="text" placeholder="Digite o Local" class="form-control ">
							</div>
						</div>
						<div class="form-row">
							<div class="col-md-3">
								<label for="horario"> Horario em que encontrou: </label>
								<input id="horario" name="horario" type="time" class="form-control" value="12:00:00">
							</div>
							<div class="col-md-3">
								<label for="data"> Data: </label>
								<input id="data" name="data" type="date" class="form-control">
							</div>

							<div class="col-md-3">
								<label> Status: </label>
								<input class="form-control" type="text" disabled placeholder="Digite o Numero" value="Novo">
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row">
							<button type="submit" class="btn btn-success mr-md-3"><i class="fa fa-floppy-o" aria-hidden="true"></i> Gravar</button>
							<a href="javascript:history.back()" class="btn btn-danger text-light"><i class="fa fa-reply" aria-hidden="true"></i> Voltar</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</jsp:body>
</t:template>