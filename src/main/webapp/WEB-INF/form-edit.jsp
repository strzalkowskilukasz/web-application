<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Formularz</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/users/update" method="POST" class="form-horizontal">
    <input type="hidden" name="id" value="${user.id}">
        <div class="form-group">
            <label for="firstName" class="col-md-2 control-label">Imię:</label>
            <div class="col-md-8">
                <input id="firstName" name="firstName" class="form-control"
                       type="text" placeholder="Podaj imię" required value="${user.firstName}">
            </div>
        </div>

        <div class="form-group">
            <label for="lastName" class="col-md-2 control-label">Nazwisko:</label>
            <div class="col-md-8">
                <input id="lastName" name="lastName" class="form-control"
                       type="text" placeholder="Podaj nazwisko" required value="${user.lastName}">
            </div>
        </div>

             <div class="form-group">
                    <label for="email" class="col-md-2 control-label">E-mail:</label>
                    <div class="col-md-8">
                        <input id="email" name="email" class="form-control"
                               type="email" placeholder="Podaj adres e-mail" required value="${user.email}">
                    </div>
                </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">Zapisz użytkownika</button>
                <a href="menu.html" class="btn btn-danger">Anuluj</a>
            </div>
        </div>
    </form>
</div>

</body>
</html>