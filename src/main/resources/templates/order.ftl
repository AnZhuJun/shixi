<#import "/spring.ftl" as spring/>

<!doctype html>
<html>
<head>
    <title>Orders</title>
    <link href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/css/index.css" rel="stylesheet"/>
    <script type="text/javascript" src="/webjars/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<h1>Order</h1>
<form  action="/order/order" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="row">
        <div class="col">
            <input type="text" name="tobaccoid" class="form-control" placeholder="TobaccoId">
        </div>
        <div class="col">
            <input type="text" name="userid" class="form-control" placeholder="UserId" >
        </div>
        <div class="col">
            <button id="create" type="submit" name="${_csrf.parameterName}" value="${_csrf.token} class="btn btn-primary">CREATE TOBACCO</button>
        </div>
    </div>
</form>

<form  action="/order/delete" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="row">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="col">
            <input type="text" name="OrderId" class="form-control" placeholder="OrderId" >
        </div>
        <div class="col">
            <button id="delete" type="submit" name="${_csrf.parameterName}" value="${_csrf.token} class="btn btn-primary">DELETE TOBACCO</button>
        </div>
    </div>
</form>

<#list orders>
    <table class="table table-hover table-dark">
        <thead>
        <tr>
            <th scope="col">#id</th>
            <th scope="col">OrderId</th>
            <th scope="col">UserId</th>
        </tr>
        </thead>
        <tbody>
        <#items as order>
            <tr>
                <td scope="row">${order.orderid}</td>
                <td>${order.tobaccoid}</td>
                <td>${order.userid}</td>
            </tr>
        </#items>
        </tbody>
    </table>
<#else >
    Table is empty
</#list>
</body>
</html>