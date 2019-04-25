<%@tag description="Template sem menu" pageEncoding="UTF-8"%>

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
<body class="bg-dark">
	
	<jsp:doBody />
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>
</body>
</html>
