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
<form action="/" method="GET">
    <button class="tablink">Home</button>
</form>

<button class="tablink" formaction="#" id="active">Sign Up!</button>


<h1>Food Logger | ${title}</h1>
<div>${signuperrormsg}</div>

<div class="container">

    <form action="/signup" method="POST">
        <label>Name: </label>
        <input type="text" placeholder="Name" name="name">
        <label>Email: </label>
        <input placeholder="your-email@yahoo.com" name="email" type="text">
        <input type="password" placeholder="password" name="psw">

        <button type="submit">Sign up!</button>
    </form>

</div>
</body>
</html>
