<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title>FoodLogger | ${title}</title>
    <link rel="stylesheet" type="text/css" href="/css/signin.css">
    <link href='https://fonts.googleapis.com/css?family=Annie Use Your Telescope' rel='stylesheet'>
    <link rel="stylesheet" type="text/css"  href="/css/style.css">
    <div class="top"><h1>FoodLogger</h1></div>
</head>

<div class="page">
    <div class="container">
        <label for="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required>
        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>

        <button type="submit">Login</button>
        <br>
        <div class="options">
            <label>
                <input type="checkbox" checked="checked" name="remember"> Remember me
            </label>


            <br>
            <label>
                <form action="/signup" method="GET">
                    <a href="/signup"> Don't have an account? Sign up!</a>

                </form>
            </label>
        </div>

    </div>

</div>

</html>