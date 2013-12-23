<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Welcome to Nerdsort</title>
</head>
	<style>
		header, section {
			display: block;
		}
		body {
			font-family: 'Droid Serif';
		}
		h1, h2 {
			text-align: left;
			font-weight: normal;
		}
		#features {
			margin: auto;
			width: 460px;
			font-size: 0.9em;
		}
		.connected, .sortable, .exclude, .handles {
			margin: auto;
			padding: 0;
			width: 800px;
			-webkit-touch-callout: none;
			-webkit-user-select: none;
			-khtml-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
		}
		.sortable.grid {
			overflow: hidden;
		}
		.connected li, .sortable li, .exclude li, .handles li {
			list-style: none;
			border: 1px solid #CCC;
			background: #F6F6F6;
			font-family: "Tahoma";
			color: #1C94C4;
			margin: 5px;
			padding: 5px;
			height: 22px;
			onclick: 
		}
		.handles span {
			cursor: move;
		}
		li.disabled {
			opacity: 0.5;
		}
		.sortable.grid li {

			float: left;
			width: 80px;
			height: 80px;
			text-align: center;
		}
		.sortable.grid.portrait li {
			width: 100px;
			height: 200px;
			position: relative;
			display: table-cell;
		}
		.sortable.grid.portrait img {
			max-width: 100px;
			max-height: 200px;
		}
		.sortable.grid.portrait img.x {
			max-width: 10px;
			max-height: 10px;
			float: right;
			position: absolute;
			right: 10px;	
			bottom: 5px;		
		}
		
		.sortable.grid.portrait div {		
			width: 100%;
			position: absolute;
			bottom: 0px;
		}
		
		.sortable.grid.portrait span {
			float: left;		
		}

		li.highlight {
			background: #FEE25F;
		}
		#connected {
			width: 440px;
			overflow: hidden;
			margin: auto;
		}
		.connected {
			float: left;
			width: 200px;
		}
		.connected.no2 {
			float: right;
		}
		li.sortable-placeholder {
			border: 1px dashed #CCC;
			background: none;
		}
	</style>
	<link href='http://fonts.googleapis.com/css?family=Droid+Serif' rel='stylesheet' type='text/css'>
<body>
		<form:form id="fullListSubmission" method="post" action="vote" modelAttribute="vote">
			<section>
				<c:forEach items="${allLists}" var="itemList">
					<section id="listId${itemList.listId}" class="itemListClass">
					<h2><label>${itemList.listTitle}</label></h2>
					<ul class="sortable grid portrait mylist">
						<c:forEach items="${itemList.items}" var="item">
			   				<li id="itemId${item.itemId}">
			   					<img src="resources/images/${item.imageUrl}">
			   					<div>
			   					<label>${item.name}</label>
			   						<img class="x" src="resources/images/x.png">
			   					</div>   					
			   				</li>   				
						</c:forEach>		
					</ul>			
					</section>
				</c:forEach>
				<form:input id="voteString" path="voteString" value="nothing"/>
			</section>
			<input type="Submit" value="Cast your vote">
		</form:form>
		
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="resources/jquery.sortable.js"></script>
	<script src="resources/json2.min.js"></script>
	<script>
		$(function() {
			$('.sortable').sortable();
			$('.handles').sortable({
				handle: 'span'
			});
			$('.connected').sortable({
				connectWith: '.connected'
			});
			$('.exclude').sortable({
				items: ':not(.disabled)'
			});
			$('.sortable.grid.portrait img.x').click(function() {
				$(this).parent().parent().remove();
			});			
			$('#fullListSubmission').submit(function (event) {
				var listVoting = {};
				$('.itemListClass').each(function (index, element) {
					var ordering = [];
					$(element).find('li').each(function (index2, element2) {						
						ordering.push(element2.id.substring(6));
					});
					listVoting[element.id] = ordering;					
				});
				
				
				
				console.log(listVoting);
				$('#voteString').val(JSON.stringify(listVoting));
			});
		});
	</script>
</body>
</html>
