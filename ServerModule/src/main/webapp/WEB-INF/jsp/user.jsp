<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <title>User</title>
    <jsp:include page="header.jsp"/>

    <h3>Welcome, ${user.userId}!</h3>
    <a class="nav-link" href="${userId}/wallet.html">Balance</a>
    <a class="nav-link" href="${userId}/new-transaction.html">New Transaction</a>
    <a class="nav-link" href="${userId}/transaction-history.html">My Transactions</a>

    <jsp:include page="footer.jsp"/>