<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Product</title>
</head>
<body>
    <h1>Add Product</h1>
    <form method="POST" action="add-product">
        <input type="hidden" name="sessionID" value="${param.sessionID}">
        <label>Product Name: </label>
        <input type="text" name="productName">
        <input type="submit" value="Submit">
    </form>
</body>
</html>