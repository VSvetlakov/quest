<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 06.11.2023
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Контакты</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<%
    HttpSession currentSession = request.getSession();
    String userName = (String) currentSession.getAttribute("user");

    if (userName == null)
        response.sendRedirect("/auth.jsp");

%>
<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills float-right">
                <li class="nav-item">
                    <a class="nav-link" href="/index.jsp">Квесты </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user.jsp">Профиль</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/contact.jsp">Контакты<span class="sr-only">(current)</span></a>
                </li>
            </ul>
        </nav>
        <h3 class="text-muted">Портал развлечений</h3>
    </div>



    <div class="row marketing">
        <div class="col-lg-6">
            <h4>Почта</h4>
            <p>starly.vlad@gmail.com</p>

            <h4>Адрес</h4>
            <p>Большие комары</p>

        </div>

    </div>

    <footer class="footer">
        <p>© BestCompany 2023</p>
    </footer>

</div> <!-- /container -->


</body>
</html>
