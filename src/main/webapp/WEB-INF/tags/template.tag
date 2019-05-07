<%@tag description="Template principal" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title"%>


<html>
<head>
<title>${title}</title>
<base href="${pageContext.request.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="icon" type="image/png" href="favicon.png" />

<!-- CSS -->
<link rel="stylesheet" href="resources/css/reset.css"></link>
<link rel="stylesheet" href="resources/css/bootstrap.min.css"></link>
<link rel="stylesheet" href="resources/css/style.css"></link>
<link rel="stylesheet"
	href="resources/lib/font-awesome/css/font-awesome.min.css"></link>

</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="#"> <img class="logo"
			src="resources/img/logo2.png">
		</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Home"><a class="nav-link" href=""> <i
						class="fa fa-home" aria-hidden="true"></i> <span
						class="nav-link-text">Home</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Feed"><a class="nav-link" href="feed"> <i
						class="fa fa-list-alt" aria-hidden="true"></i> <span
						class="nav-link-text">Feed</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Minhas Postagens"><a class="nav-link" href="meusposts"><i
						class="fa fa-th-list" aria-hidden="true"></i> <span
						class="nav-link-text">Minhas Postagens</span> </a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Dados"><a class="nav-link" href="usuarios/editar?id=5"> <i
						class="fa fa-id-card-o" aria-hidden="true"></i> <span
						class="nav-link-text">Dados</span>
				</a></li>
			</ul>
			<!-- FINAL MENU -->
			<ul class="navbar-nav sidenav-toggler">
				<li class="nav-item"><a class="nav-link text-center"
					id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
				</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="user"> <i
						class="fa fa-user-circle" aria-hidden="true"></i> Usuário: Username
				</a></li>
				<li class="nav-item">
					<form action="sair" method="post" class="inline">
						<input type="hidden" name="_metodo" value="DELETE"> <a
							href="" class="nav-link"
							onclick="event.preventDefault(); this.parentNode.submit()"> <i
							class="fa fa-fw fa-sign-out"></i>Sair
						</a>
					</form>
				</li>
			</ul>
		</div>
	</nav>

	<jsp:doBody />
	<!-- rodape-->
	<footer class="sticky-footer">
		<div class="container">
			<div class="text-center">
				<small>Copyright © 2018 UTFPR Todos os direitos
					reservados.</small>
			</div>
		</div>
	</footer>
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fa fa-angle-up"></i>
	</a>


	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
	<!-- Scroll Top Plugin GSGD-->
	<script src="resources/js/jquery.easing.min.js"></script>
	<script src="resources/js/geral.js"></script>
</body>
</html>
