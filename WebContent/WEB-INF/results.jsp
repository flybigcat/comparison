<!--author: Ann Huang 02/19/2016-->
<!--description: results page to deploy unique records for two input files-->

<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Philips Genomics Health | Comparison Results</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<script type="application/x-javascript"> addEventListener("load", function() {setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<!--meta charset utf="8"-->
		<!--fonts-->
			<link href="./css/css" rel="stylesheet" type="text/css">
			<link href="./css/css(1)" rel="stylesheet" type="text/css">
		    <link href="./css/owl.carousel.css" rel="stylesheet">
		<!-- bootstrap -->
			<link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<!--coustom css-->
			<link href="./css/style.css" rel="stylesheet" type="text/css">
		<!--default-js-->
	 		<script src="./js/jquery-2.1.4.min.js"></script> 
		<!--bootstrap-js-->
  			<script src="./js/bootstrap.min.js"></script>

	</head>
	<body>
		<div class="header" id="home">
			<div class="header_nav" id="home">
				<nav class="navbar navbar-default chn-gd">
					<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand logo-st" href="http://www.usa.philips.com">Philips</a>
					</div>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li>
						<a href="comparison" class="scroll">
						<span class="glyphicon glyphicon-home icn_pos hm" aria-hidden="true"></span><br>
						Home
						</a>
						</li>
						
					</ul>
					</div>
					<div class="clearfix"></div>
					</div>
				</nav>
			</div>
			<div class="header_banner">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">

					<div class="carousel-caption">
					<div class="item  image-wid">
						<img src="./images/results.jpg" alt="..." class="img-responsive">
					</div>
					</div>

				</div>
				</div>
			</div>
		</div>
		
	<!-- Show results -->		
	<div class="bottom-form">
		<div class="container">
		<div class="col-md-12 pd news" > 
		<c:choose>
		<c:when test="${not empty fileMap1 && fn:length(fileMap1) gt 0}">
			<c:set var="count1" value="0" scope="page" />
			<c:forEach items="${fileMap1}" var="entry1">
				<c:if test="${entry1.value.unique}">
					<c:set var="count1" value="${count1 + 1}" scope="page" />
				<c:if test="${count1==1}">
			<h3>The unique records in the first file ${fileName1} are:</h3>
			</c:if>
			<p>${entry1.value.id} &nbsp ${entry1.value.name} &nbsp
					<c:forEach items="${entry1.value.values}" var="v">
					${v}		
					</c:forEach>
			</p>
				</c:if>
			</c:forEach>
			<c:if test="${count1==0}">
     		<h3>There is no unique record in the first file ${fileName1}.</h3>
			</c:if>
		</c:when>

		<c:otherwise>
    	<h3> The first file ${fileName1} is empty.</h3>
		</c:otherwise>
		</c:choose>
		</div>
		
		<div class="col-md-12 pd news" >
		<c:choose>
		<c:when test="${not empty fileMap2 && fn:length(fileMap2) gt 0}">
			<c:set var="count2" value="0" scope="page" />
			<c:forEach items="${fileMap2}" var="entry2">
				<c:if test="${entry2.value.unique}">
					<c:set var="count2" value="${count2 + 1}" scope="page" />	
				<c:if test="${count2==1}">
				<h3>The unique records in the second file ${fileName2} are:</h3>
				</c:if>
				<p>${entry2.value.id} &nbsp ${entry2.value.name} &nbsp
					<c:forEach items="${entry2.value.values}" var="v">
					${v}		
					</c:forEach>
				</p>
				</c:if>
			</c:forEach>
			<c:if test="${count2==0}">
     		<h3>There is no unique record in the second file ${fileName2}.</h3>
			</c:if>
			
		</c:when>

		<c:otherwise>
     	<h3> The second file ${fileName2} is empty.</h3>
		</c:otherwise>

		</c:choose>
		</div>
		</div>
	</div>
				 

		<div class="footer">
			<div class="container">
				<div class="footer-text">
				<h3><a href="http://www.usa.philips.com">Philips</a></h3>
				<p>Philips Comparison Design by Ann Huang</p>
				</div>
			</div>
		</div>
		<a href="./entry.html#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	
</body></html>