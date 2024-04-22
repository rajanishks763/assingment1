<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add a new Customer</title>
    <style>
    button{
    padding: 8px 12px;
    background-color: blue;
    color: white;
    text-align: right;
    border-radius: 5px;
    border:none;
    }
    input{
    padding:8px 12px;
    width: 200px;
    border-radius: 5px;
    }

    </style>
</head>
<body>

    <h2>Customer Details</h2>
    <form action="save" method="post">
        <table cellspacing="10px" cellpadding="5px">
        <tr>
        <td><input type="hidden" name="cmd" value="create"/></td>
        </tr>
            <tr>
                <td><input type="text" name="firstName" placeholder="First name"/></td>
                <td><input type="text" name="lastName" placeholder="Last name"/></td>
            </tr>
            <tr>
                <td><input type="text" name="street" placeholder="street"/></td>
                <td><input type="text" name="address" placeholder="address"/></td>
            </tr>
            <tr>
                <td><input type="text" name="city" placeholder="city"/></td>
                <td><input type="text" name="state" placeholder="state"/></td>
            </tr>
            <tr>
                <td><input type="text" name="email" placeholder="email"/></td>
                <td><input type="text" name="phone" placeholder="phone"/></td>
            </tr>
            <tr>
            <td></td>
            <td><button type="submit" value="save"/> Submit</button></td>
        </table>
        
    </form>
    ${msg}
</body>
</html>
