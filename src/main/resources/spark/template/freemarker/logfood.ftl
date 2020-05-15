<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <title>FoodLogger | ${title}</title>
    <link href='https://fonts.googleapis.com/css?family=Annie Use Your Telescope' rel='stylesheet'>
    <link rel="stylesheet" type="text/css"  href="/css/style.css">
    <link rel="stylesheet" type="text/css"  href="/css/signin.css">
</head>

<body>


<form action="/" method="GET">
    <button class="tablink">Home</button>
</form>
<button formaction="#" id="active" class="tablink">Log Food</button>

<h1>Food Logger | ${title}</h1>

<div class="container">

    <form action="/logfood" method="POST">
        <label>Food: </label>
        <input type="text" placeholder="Food" name="food">
        <label>Calories: </label>
        <input placeholder="Calories" name="calories" type="number">
        <br>
        <label>Date: </label>
        <input type="date" placeholder="Date" name="date">

        <button type="submit">Log Food!</button>
    </form>

</div>

</body>
</html>
