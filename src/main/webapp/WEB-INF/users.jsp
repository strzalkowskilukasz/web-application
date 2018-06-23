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
                <table class="table table-boarded table-striped table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Imię</th>
                        <th>Nazwisko</th>
                        <th>E-mail</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach var = "user" items="${usersList}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            </div>
        <div class="row">
            <div class="col-xs-offset-4 col-md-offset-5">
    <a class = "btn btn-primary" href="/WEB-INF/users.jsp">Wróć do menu</a>
            </div>
        </div>
    </div>


</body>
</html>