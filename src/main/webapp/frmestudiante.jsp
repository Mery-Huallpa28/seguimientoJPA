<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Formulario</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        input[type="text"],
        input[type="date"],
        input[type="checkbox"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Formulario de Estudiantes</h1>
    <form action="MainController" method="post">
        <input type="hidden" name="id" value="${estudiante.id}" />
        <label>Nombre:</label>
        <input type="text" name="nombre" value="${estudiante.nombre}" />
        <label>Apellidos:</label>
        <input type="text" name="apellidos" value="${estudiante.apellidos}" />
        <label>Email:</label>
        <input type="text" name="email" value="${estudiante.email}" />
    
        <label>Fecha de Nacimiento:</label>
        <input type="text" name="fechaNacimiento" value="${estudiante.fechaNacimiento}" />
        <input type="submit" value="Guardar" />
    </form>
</div>
</body>
</html>