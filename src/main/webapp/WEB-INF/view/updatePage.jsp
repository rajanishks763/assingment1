<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Customer data</title>
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

<h2>Give update details</h2>
    
    <form action="/auth/update/${contact.id}" method="post">
        <table cellspacing="10px" cellpadding="5px">
        <tr>
        <td><input type="hidden" name="cmd" value="update"/></td>
        </tr>
            <tr>
                <td><input type="text" name="firstName" value="${contact.firstName}" /></td>
                <td><input type="text" name="lastName" value="${contact.lastName}"/></td>
            </tr>
            <tr>
                <td><input type="text" name="street" value="${contact.street}" /></td>
                <td><input type="text" name="address" value="${contact.address}" /></td>
            </tr>
            <tr>
                <td><input type="text" name="city" value="${contact.city}" /></td>
                <td><input type="text" name="state" value="${contact.state}" /></td>
            </tr>
            <tr>
                <td><input type="text" name="email" value="${contact.email}" /></td>
                <td><input type="text" name="phone" value="${contact.phone}" /></td>
            </tr>
            <tr>
            <td></td>
            <td><button type="submit" value="save"/> Submit</button></td>
        </table>
        
    </form>
    ${msg}
</body>
</html>
