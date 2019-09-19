<#import "/spring.ftl" as spring>
<!doctype html>
<html>
<head>
    <title>login page</title>
    <link type="text/css" href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet"/>
    <link type="text/css" href="/css/index.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <form action="/login" method="post" class="">
        <h1 class="" style="text-align: center">
            甘肃烟草管理系统登陆页面
        </h1>
        <div class="form-group">
            <span><#if message??>${message}</#if></span>
            <h3>用户名:</h3>
            <input name="username" type="text" class="form-control" placeholder="Type Username" autofocus="true"/>
            <h3>密码:</h3>
            <input name="password" type="password" class="form-control" placeholder="Type Password"/>
            <span><#if error??>${error}</#if></span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button class="btn btn-primary btn-lg btn-block" type="submit" value="submit">Login</button>
            <h4 class="text-center"><a href="/registration">Create an account</a></h4>
        </div>
    </form>
</div>
</body>

<script type="text/javascript" src="/webjars/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="/webjars/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</html>