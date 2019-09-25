<#import "/spring.ftl" as spring/>

<!doctype html>
<html>
<head>
    <title>Users</title>
    <link href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/css/index.css" rel="stylesheet"/>
    <script type="text/javascript" src="/webjars/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<h1>User</h1>
<form  action="/user/user" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="row">
        <div class="col">
            <input type="text" name="name" class="form-control" placeholder="真实姓名" >
        </div>
        <div class="col">
            <input type="text" name="username" class="form-control" placeholder="用户名">
        </div>
        <div class="col">
            <input type="text" name="telephone" class="form-control" placeholder="电话号码">
        </div>
        <div class="col">
            <input type="text" name="password" class="form-control" placeholder="密码">
        </div>
        <div class="col">
            <button id="create" type="submit" name="${_csrf.parameterName}" value="${_csrf.token} class="btn btn-primary">创建用户</button>
        </div>
    </div>
</form>

<form  action="/user/delete" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="row">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="col">
            <input type="text" name="UserId" class="form-control" placeholder="用户id" >
        </div>
        <div class="col">
            <button id="delete" type="submit" name="${_csrf.parameterName}" value="${_csrf.token} class="btn btn-primary">删除用户</button>
        </div>
    </div>
</form>

<#list users>
    <table class="table table-hover table-dark">
        <thead>
        <tr>
            <th scope="col">#id</th>
            <th scope="col">NAME</th>
            <th scope="col">Username</th>
            <th scope="col">telephone</th>
        </tr>
        </thead>
        <tbody>
        <#items as user>
            <tr>
                <td scope="row">${user.userid}</td>
                <td>${user.name}</td>
                <td>${user.username}</td>
                <td>${user.telephone}</td>
            </tr>
        </#items>
        </tbody>
    </table>
<#else >
    Table is empty
</#list>
</body>
</html>