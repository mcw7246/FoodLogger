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

<body>
<div class = "page">
    <div class = "container">
        <p> ${signupmsg}</p>
        <form action="./signup" method="POST">
            <label for="name"><b>First name: </b></label>
            <input type="text" placeholder="Name" name="fname" required>
            <label for="email"><b>Email: </b></label>
            <input type="text" placeholder="your-email@yahoo.com" name="email" required>
            <label for="username"><b>Username</b></label>
            <input type="text" name="username" placeholder="Username">
            <label for="psw"><b>Password</b></label>
            <input type="password" name="psw" placeholder="Password">
            <button type="submit">Sign up!</button>
        </form>
    </div>
</div>
</body>