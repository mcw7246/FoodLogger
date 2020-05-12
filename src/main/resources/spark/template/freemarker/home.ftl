<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>FoodLogger | ${title}</title>
    <link href='https://fonts.googleapis.com/css?family=Annie Use Your Telescope' rel='stylesheet'>
    <link rel="stylesheet" type="text/css"  href="/css/style.css">
    <link rel="stylesheet" type="text/css"  href="/css/signin.css">
</head>

<body>


<div id="home" class="tabcontent">
    <h1>Home Page</h1>
    <p>Welcome to FoodLogger!</p>
</div>

<button class="tablink" formaction="#" id="active">Home</button>
<#if !signin>
    <form action="/signin" method="GET">
        <button class="tablink">Sign in!</button>
    </form>
    <#else>
        <form action="/logfood" method="GET">
            <button class="tablink">Log food!</button>
        </form>
        <form action="/calendar" method="GET">
            <button class="tablink">Calendar</button>
        </form>
</#if>

<h1>Food Logger | ${title}</h1>



</div>
</body>
</html>
