<#import "/spring.ftl" as spring/>

<!doctype html>
<html>
<head>
    <title>Tobaccos</title>
    <link href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/css/index.css" rel="stylesheet"/>
    <script type="text/javascript" src="/webjars/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<h1>Tobacco</h1>
<form  action="/tobacco/tobacco" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="row">
        <div class="col">
            <input type="text" name="name" class="form-control" placeholder="Name" >
        </div>
        <div class="col">
            <input type="text" name="supportid" class="form-control" placeholder="Supportid">
        </div>
        <div class="col">
            <input type="text" name="price" class="form-control" placeholder="Price">
        </div>
        <div class="col">
            <button id="create" type="submit" name="${_csrf.parameterName}" value="${_csrf.token} class="btn btn-primary">CREATE TOBACCO</button>
        </div>
    </div>
</form>

<#list tobaccos>
    <table class="table table-hover table-dark">
        <thead>
        <tr>
            <th scope="col">#id</th>
            <th scope="col">NAME</th>
            <th scope="col">SUPPORTID</th>
            <th scope="col">PRICE</th>
        </tr>
        </thead>
        <tbody>
        <#items as tobacco>
            <tr>
                <td scope="row">${tobacco.tobaccoid}</td>
                <td>${tobacco.name}</td>
                <td>${tobacco.supportid}</td>
                <td>${tobacco.price}</td>
            </tr>
        </#items>
        </tbody>
    </table>
<#else >
    Table is empty
</#list>
</body>
</html>