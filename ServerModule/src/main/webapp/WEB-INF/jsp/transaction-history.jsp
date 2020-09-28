<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <title>Transaction history</title>
    <jsp:include page="header.jsp"/>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Sender</th>
          <th scope="col">Receiver</th>
          <th scope="col">Amount</th>
          <th scope="col">Status</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${transactions}" var="transaction">
        <tr>
          <th scope="row">${transaction.id}</th>
          <td>${transaction.senderId}</td>
          <td>${transaction.receiverId}</td>
          <td>${transaction.amount}</td>
          <td>${transaction.status}</td>
        </tr>
       </c:forEach>
      </tbody>

    <jsp:include page="footer.jsp"/>