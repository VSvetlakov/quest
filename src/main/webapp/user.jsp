<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 06.11.2023
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Профиль</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<%
    HttpSession currentSession = request.getSession();
    String userName = (String) currentSession.getAttribute("user");

    if (userName == null)
        response.sendRedirect("/auth.jsp");

    int winCount = (int) currentSession.getAttribute("winCount");

    int loseCount = (int) currentSession.getAttribute("loseCount");

%>
<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills float-right">
                <li class="nav-item">
                    <a class="nav-link" href="/index.jsp">Квесты </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/user.jsp">Профиль<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contact.jsp">Контакты</a>
                </li>
            </ul>
        </nav>
        <h3 class="text-muted">Портал развлечений</h3>
    </div>

    <div class="row marketing">
        <div class="col-lg-6">
            <h4>Имя</h4>
            <p>
                <%= userName %>
            </p>

            <h4>Количество выигранных игр</h4>
            <p>
                <%= winCount %>
            </p>

            <h4>Количество проигранных игр</h4>
            <p>
                <%= loseCount %>
            </p>
        </div>

    </div>

    <footer class="footer">
        <p>© BestCompany 2023</p>
    </footer>

</div> <!-- /container -->


</body>
</html>
