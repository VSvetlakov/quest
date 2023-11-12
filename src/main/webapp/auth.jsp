<%--
  Created by IntelliJ IDEA.
  User: Vladislav
  Date: 06.11.2023
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>

<div class="container">
    <div class="header clearfix">
        <h3 class="text-muted">Портал развлечений</h3>
    </div>

    <form class="form-horizontal" method="post">
        <fieldset>

            <!-- Form Name -->
            <legend>Login</legend>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="username">username</label>
                <div class="col-md-4">
                    <input id="Username" name="username" type="text" placeholder="" class="form-control input-md">
                </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
                <label class="col-md-4 control-label" for="Password">Password</label>
                <div class="col-md-4">
                    <input id="Password" name="Password" type="password" placeholder="" class="form-control input-md">

                </div>
            </div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label" for="loginbutton"></label>
                <div class="col-md-4">
                    <input id="loginbutton" name="loginbutton" class="btn btn-primary" type="submit" value="login"/>
                    <!--<button id="loginbutton" name="loginbutton" class="btn btn-primary">Login</button>-->
                </div>
            </div>

        </fieldset>
    </form>

    <footer class="footer">
        <p>© BestCompany 2023</p>
    </footer>

</div> <!-- /container -->

</body>
</html>
