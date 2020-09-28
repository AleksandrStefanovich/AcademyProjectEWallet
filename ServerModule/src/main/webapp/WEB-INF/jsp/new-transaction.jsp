<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <title>Transaction</title>
    <jsp:include page="header.jsp"/>
    <form action="/Academium/<sec:authentication property="principal.username"/>/new-transaction.html" method="post">
      <div class="form-group">
            <label for="formGroupExampleInput2">Reciever Id</label>
            <input type="text" class="form-control" name="receiverId" id="formGroupExampleInput1" placeholder="User name">
      </div>
      <div class="form-group">
          <label for="formGroupExampleInput2">Amount</label>
          <input type="long" class="form-control" name="amount" id="formGroupExampleInput2" placeholder="Amount">
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    <jsp:include page="footer.jsp"/>