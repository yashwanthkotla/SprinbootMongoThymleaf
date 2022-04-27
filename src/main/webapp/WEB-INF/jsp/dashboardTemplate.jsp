<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <title>Locations</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <!-- Optional theme -->
    <!--     <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css"> -->
    <!-- Current doc CSS -->
    <link rel="stylesheet" href="index.css">
    <style>
        .nopadding {
            border-radius: 10px;
            background-color: white;
            color: black;
            border-color: white;
            padding: 10px !important;
        }

        #nav button:hover {
            transform: scale(1.5);
        }
    </style>
</head>

<body style="background-color: navy;">
<div>
    <h1 style="text-align: center;font-size: 60px;color: white;padding-bottom: 25px;" >
        ${data.item}
    </h1>
    <c:forEach items="${data.locations}" var="location">
        <div class="container" style="width: 100%">
            <div class="col-md-2">
                <img src="../arrow.png" alt="step 1">
            </div>
            <div class="col-md-9">
                <br/>
                <br/>
                <a th:href="/data/${data.item}/${location}">
                    <button type="button" class="btn btn-primary btn-lg btn-block nopadding" >${location}</button>
                </a>
            </div>
            <div class="col-md-1"></div>
        </div>
    </c:forEach>
</div>
</body>

</html>