<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>seguimiento </title>


    </head>
    <body>
        <div class="container">
           
            <h1>Registro</h1>
     
            <p><a href="MainController?action=add" class="action-links">Nuevo</a></p>

            <style>
                body {
                    font-family: Arial, sans-serif;
                    background-color: #f4f4f4;
                    margin: 0;
                    padding: 20px;
                }

                table {
                    width: 100%;
                    border-collapse: collapse;
                    border: 1px solid #ccc;
                    background-color: #fff;
                }

                th, td {
                    padding: 8px;
                    border: 1px solid #ccc;
                }

                th {
                    background-color: #f2f2f2;
                }

                tr:nth-child(even) {
                    background-color: #f9f9f9;
                }

                tr:hover {
                    background-color: #f0f0f0;
                }

                .action-links a {
                    color: #007bff;
                    text-decoration: none;
                    margin-right: 10px;
                }

                .action-links a:hover {
                    text-decoration: underline;
                }
            </style>
        </head>
        <body>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Correo Electronico</th>
                        <th>Fecha de Nacimiento</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="estudiante" items="${estudiantes}">
                        <tr>
                            <td>${estudiante.id}</td>
                            <td>${estudiante.nombre}</td>
                            <td>${estudiante.apellidos}</td>
                            <td>${estudiante.email}</td>
                            <td>${estudiante.fechaNacimiento}</td>
                            <td><a href="MainController?action=edit&id=${estudiante.id}">Editar</a></td>
                            <td><a href="MainController?action=delete&id=${estudiante.id}" onclick="return confirm('¿Está seguro de eliminar este estudiante?')" class="action-links">Eliminar</a></td>
                                
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </body>
</html>

