<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <title>Home</title>
    <jsp:include page="header.jsp"/>
    <h1>Welcome to Academium!</h1>
    <sec:authorize access="isAuthenticated()">
             <h3>Hello <sec:authentication property="principal.username"/>!</h3>
             <a class="nav-link " href="
             <sec:authentication property="principal.username"/>/wallet" tabindex="-1" >Wallet</a>
             <a class="nav-link " href="
             <sec:authentication property="principal.username"/>/new-transaction" tabindex="-1" >New Transaction</a>
             <a class="nav-link " href="
             <sec:authentication property="principal.username"/>/transaction-history" tabindex="-1" >Transaction History</a>

     </sec:authorize>
    <jsp:include page="footer.jsp"/>