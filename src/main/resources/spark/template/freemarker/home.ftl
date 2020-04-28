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

<div id="signin" class="tabcontent">
    <h1>Sign In</h1>
</div>

<button class="tablink" formaction="#" id="active">HomePage</button>
<form action="/signin" method="GET">
    <button class="tablink">Sign In!</button>
</form>

<div class="content">
    <h1>FoodLogger | ${title}</h1>

    <div class="left">
        <h3>${info}</h3>
    </div>

    <div class="right">
        <h3>${info}</h3>
    </div>
</div>


</body>
</html>
