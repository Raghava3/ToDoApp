<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>datapage</title>

<link rel="stylesheet" href="css/Datapage.css">
<script src="js/datapage.js" type="text/javascript" ></script>
</head>
<body id="ff1">
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="logout">Logout</a>
	</div>

<div class="buttons">

	<div
		style="margin-top: -10px; margin-left: -10px; margin-right: -10px;">
		<div style="padding-top: 14px" class="bb">
			<div id="innercontent">
				<span style="font-size: 20px; cursor: pointer" onclick="openNav()">&nbsp;&nbsp;<font
					color="#A96E04">&#9776;</font></span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;<font size="5px" color="black"><b>ToDoNotes</b></font>
				<input id="search" onclick="searchDiv()"class="ee"  placeholder="search" style="background-color: #CD8300; border:none;"> </input> 
			 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="Homepage"><i class="fa fa-refresh"style="font-size: 20px; color: #694403"></i></a>
    &nbsp;&nbsp;
   <b class="grid"><i id="gridicon" class="fa fa-th-large" style="font-size:15px;color:#694403"></i></b>
   
   <b class="list"><i id="listicon" class="fa fa-list" style="font-size:15px;color:#694403"></i></b>
   </div>	

			</div>
		</div>
	</div>


	<div id="main"  onclick="serchDivOriginal()">
		<!-- <div class="hh"> -->

		<div class="ff" class="entry" onclick="openEntry()">
			<div id="input" margin-left: 17px;">make a note...</div>
		</div>
		<div id="newNote" class="dd" style="display: none;">
			<form id="form" action="addNotes" method="get" style="padding: 00px">
				<table>
					<tr>
						<td><input id="title" type="text" name="title"
							placeholder="title" size="100" outline="none"></td>
					</tr>
					<tr>
						<td><input id="des" type="text" name="description"
							placeholder="description" size="100" outline="none"></td>
					</tr>
				</table>
				<table>
					<tr>
						<td><input type="submit" value="DONE"></td>
					</tr>
				</table>
			</form>
		</div>
		
	<div id="container">
	
	
	</form>
	<div id="TodoList">
		<c:forEach items="${dataList}" var="listofdata">
		
      <order>
      <div id="notes">
		 <div class="listcontent"  onclick="popUp('${listofdata.title}','${listofdata.description}')"style="word-wrap: break-word;">
				<span style="margin-left: 30px;">${listofdata.title}</span></br> 
				<span style="margin-left: 30px;">${listofdata.description}</span>
			</div>

			<div class="delandup" id="showcolor" style="margin-bottom:20px;">
				<a href="<c:url value='update?id=${listofdata.id}'/>"> <i
					class="fa fa-edit" style="font-size: 28px; color: #414754"></i></a>
					<a href="<c:url value='deleteNote?id=${listofdata.id}'/>"><i
					class="fa fa-trash" style="font-size: 28px; color: #41474B"></i></a>
			</div>
		</div>
	</order>
	</c:forEach>
	</div>
	
	</div>
	</a>
	</div>
	</div>
	<div class="abc" id="pop" style="visibility:hidden; word-wrap:break-word ; position: fixed; ">
</div>


</body>
</html>