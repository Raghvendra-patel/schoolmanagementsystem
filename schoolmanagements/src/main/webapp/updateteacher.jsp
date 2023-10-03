<%@page import="schoolmanagements.dto.teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
    <title>Update Teacher Detail</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h1 {
        text-align: center;
            color: #333;
        }
        form {
            width: 300px;
            margin: 0 auto;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input[type="number"],
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 18px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <%teacher t=(teacher)session.getAttribute("t1");%>
    <h1>Update Teacher Detail</h1>
    <form action="updatet" method="post">
        <label for="id">ID:</label>
        <input type="number" value="<%=t.getId()%>" name="id"><br>
        <label for="name">Name:</label>
        <input type="text" value="<%=t.getName()%>" name="name"><br>
        <label for="age">Age:</label>
        <input type="number" value="<%=t.getAge()%>" name="age"><br>
        <label for="email">Email:</label>
        <input type="email" value="<%=t.getEmail()%>" name="email"><br>
        <label for="password">Password:</label>
        <input type="password" value="<%=t.getPassword()%>" name="password"><br>
        <input type="submit" value="Update">
    </form>
</body>
</html>
