<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Tabela</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"
</head>
<body>

    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-md-6 col-md-offset-3">
                <!--lg md sm xs-->
                <table class="table table-boarded table-striped table-hover text-center">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Imię</th>
                        <th>Nazwisko</th>
                        <th>E-mail</th>
                        <th>Akcja</th>

                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var = "user" items="${usersList}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <td>
                        <a href="/users/update?id=${user.id}" class = "btn btn-primary">edytuj</a>
                        <form action="/users/delete" method= POST">
                        <input type="hidden" name="id" value="${user.id}">
                        <button type="submit" class = "btn btn-danger">usuń</button>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            </div>
        <div class="row">
            <div class="col-xs-offset-3 col-md-offset-4">
         <a href="/users/create" class="btn btn-primary">Dodaj użytkownika</a>
         <a class = "btn btn-primary" href="/">Wróć do menu</a>
        </div>
    </div>


</body>
</html>