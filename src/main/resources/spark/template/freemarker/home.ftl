<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title>FoodLogger | ${title}</title>
    <link href='https://fonts.googleapis.com/css?family=Annie Use Your Telescope' rel='stylesheet'>
    <link rel="stylesheet" type="text/css"  href="/css/style.css">
</head>

<body>


<div id="home" class="tabcontent">
    <h1>Home Page</h1>
    <p>Welcome to FoodLogger!</p>
</div>

<button class="tablink" formaction="#" id="active">HomePage</button>
<#if signin>
    <form action="#">
        <button class="tablink">Log Food!</button>
    </form>
    <#else>
        <form action="/signin" method="GET">
            <button class="tablink">Sign In!</button>
        </form>
</#if>


<h1>Food Logger | ${title}</h1>
<#if signin>
    <h3>${homemsg}</h3>
</#if>

</body>
</html>
