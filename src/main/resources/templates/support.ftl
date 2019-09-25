<#import "/spring.ftl" as spring/>

<!doctype html>
<html>
<head>
    <title>Supports</title>
    <link href="/webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet" />
    <link href="/css/index.css" rel="stylesheet"/>
    <script type="text/javascript" src="/webjars/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<h1>Support</h1>
<form  action="/support/support" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="row">
        <div class="col">
            <input type="text" name="name" class="form-control" placeholder="Name" >
        </div>
        <div class="col">
            <input type="text" name="telephone" class="form-control" placeholder="telephone">
        </div>
        <div class="col">
            <input type="text" name="information" class="form-control" placeholder="information">
        </div>
        <div class="col">
            <button id="create" type="submit" name="${_csrf.parameterName}" value="${_csrf.token} class="btn btn-primary">create support</button>
        </div>
    </div>
</form>

<form  action="/support/delete" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="row">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="col">
            <input type="text" name="SupportId" class="form-control" placeholder="SupportId" >
        </div>
        <div class="col">
            <button id="delete" type="submit" name="${_csrf.parameterName}" value="${_csrf.token} class="btn btn-primary">DELETE TOBACCO</button>
        </div>
    </div>
</form>

<#list supports>
    <table class="table table-hover table-dark">
        <thead>
        <tr>
            <th scope="col">#id</th>
            <th scope="col">NAME</th>
            <th scope="col">TELEPHONE</th>
            <th scope="col">INFORMATION</th>
        </tr>
        </thead>
        <tbody>
        <#items as support>
            <tr>
                <td scope="row">${support.supportid}</td>
                <td>${support.name}</td>
                <td>${support.telephone}</td>
                <td>${support.information}</td>
            </tr>
        </#items>
        </tbody>
    </table>
<#else >
    Table is empty
</#list>
</body>
</html>