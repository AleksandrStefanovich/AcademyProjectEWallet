<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  </head>
  <body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/Academium/home">Academium</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">

      <sec:authorize access="isAuthenticated()">
        <li class="nav-item">
         <a class="nav-link " href="/Academium/logout" tabindex="-1" >Logout</a>
        </li>
      </sec:authorize>
      <sec:authorize access="!isAuthenticated()">
        <li class="nav-item">
         <a class="nav-link " href="/Academium/login" tabindex="-1" >Log in</a>
        </li>
      </sec:authorize>
      <sec:authorize access="!isAuthenticated()">
        <li class="nav-item">
         <a class="nav-link " href="/Academium/register.html" tabindex="-1" >Register</a>
        </li>
      </sec:authorize>
        <li class="nav-item">
          <a class="nav-link" href="/Academium/coins.html">Coins</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/Academium/about.html">About</a>
        </li>
      </ul>
    </div>
  </nav>