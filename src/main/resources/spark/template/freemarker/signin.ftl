<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>Sign in</title>
    <link href='https://fonts.googleapis.com/css?family=Annie Use Your Telescope' rel='stylesheet'>
    <link rel="stylesheet" type="text/css"  href="/css/style.css">
    <link rel="stylesheet" type="text/css"  href="/css/signin.css">
</head>

<body>

<form action="/" method="GET">.
    <button class="tablink" >Home</button>
</form>

<button class="tablink" formaction="#" id="active">Sign In!</button>


<h1>Food Logger | ${title}</h1>
    <div>${signinerrormsg}</div>

    <div class="container">
        <form action="/signin" method="POST">
            <label>Email: </label>
            <input type="text" placeholder="your-email@yahoo.com" name="email">

            <label>Password" </label>
            <input type="password" placeholder="password" name="psw">


            <button type="submit">Sign in!</button>
        </form>

        <div class="options">
            <input type="checkbox">Remember me.
            <br>

            <form action="/signup" method="GET">
                <a href="/signup">Don't have an account? Create one!</a>
            </form>

        </div>
    </div>
</body>
</html>
