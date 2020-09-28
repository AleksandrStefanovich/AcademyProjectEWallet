<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <title>New user</title>
    <jsp:include page="header.jsp"/>

<h1>New User</h1>
<form action="/Academium/register.html" method="post">
  <div class="form-group">
        <label for="formGroupExampleInput2">User name</label>
        <input type="text" class="form-control" name="userId" id="formGroupExampleInput1" placeholder="User name">
  </div>
  <div class="form-group">
      <label for="formGroupExampleInput2">Password</label>
      <input type="text" class="form-control" name="password" id="formGroupExampleInput2" placeholder="Password">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>



    <jsp:include page="footer.jsp"/>