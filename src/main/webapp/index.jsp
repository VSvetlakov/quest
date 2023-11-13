<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 06.11.2023
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Главное</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
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
                    <a class="nav-link active" href="#">Квесты <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user.jsp">Профиль</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contact.jsp">Контакты</a>
                </li>
            </ul>
        </nav>
        <h3 class="text-muted">Портал развлечений</h3>
    </div>

    <div id="questPage" class="jumbotron" style="display: none;">
        <h2 class="display-3">Приключение 1</h2>
        <p id="question" class="lead"></p>
        <div id="answers" class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups" style="">

        </div>
    </div>


    <div id="quests" class="row marketing">
        <div class="col-lg-6">
            <h4>Приключение 1</h4>
            <p>
                <button type="button" class="btn btn-primary" onclick="startQuest(1);">Начать</button>
            </p>

        </div>

    </div>

    <footer class="footer">
        <p>© BestCompany 2023</p>
    </footer>

</div> <!-- /container -->

<script>

    function startQuest(questId){
        $("#quests").hide();
        $("#questPage").show();

        $.post("/questService", {questId: questId}, function (data) {

            $("#answers").empty();

            $.each(data, function (key, val) {

                if (key == "message")
                    $("#question").text(val);

                if (key == "answerList") {

                    $.each(val, function (id, answer) {

                        $('#answers').append('<div class="btn-group mr-2" role="group" aria-label="First group">' +
                            '<a answerId=' + answer.id + ' class="btn btn-lg btn-success" href="#" role="button" onclick="doStep(' + answer.id + ')";>' + answer.message + '</a></div>');

                    });
                }
            });
        });
    }

    function doStep(answerId){

        let questId = 1;

        $.post("/questService", {answerId: answerId}, function (data) {

            $("#answers").empty();

            $.each(data, function (key, val) {

                if (key == "result") {
                    $('#answers').append('<div class="btn-group mr-2" role="group" aria-label="First group">' +
                        '<a class="btn btn-lg btn-success" href="#" role="button" onclick="restart()";>Играть заново</a></div>');
                }
                if (key == "message")
                    $("#question").text(val);

                if (key == "answerList") {

                    $.each(val, function (id, answer) {

                        $('#answers').append('<div class="btn-group mr-2" role="group" aria-label="First group">' +
                            '<a answerId=' + answer.id + ' class="btn btn-lg btn-success" href="#" role="button" onclick="doStep(' + answer.id + ')";>' + answer.message + '</a></div>');

                    });
                }
            });
        });
    }

    function restart(){

        $("#quests").show();
        $("#questPage").hide();
    }

</script>
</body>
</html>
