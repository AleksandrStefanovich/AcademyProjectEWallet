<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <title>Coins</title>
    <jsp:include page="header.jsp"/>
<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Previous Hash</th>
      <th scope="col">Hash</th>
      <th scope="col">Timestamp</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${coins}" var="coin">
    <tr>
      <th scope="row">${coin.id}</th>
      <td>${coin.previousHash}</td>
      <td>${coin.hash}</td>
      <td>${coin.timestamp}</td>
    </tr>
   </c:forEach>
  </tbody>
</table>

    <jsp:include page="footer.jsp"/>