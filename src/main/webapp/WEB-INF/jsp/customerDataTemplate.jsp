<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <title>Sale Data</title>
    <style>
        td {
            border: 2px solid white;
        }

        tr {
            border: 4px solid white;
        }

        tr:nth-of-type(odd) {
            background-color: rgb(151, 187, 139);
        }

        tr:nth-of-type(even) {
            background-color: rgb(222, 238, 226);
        }

        h1 {
            font-weight: bold;
            background-color: navy;
            color: white !important;
            padding-top: 10px;
            padding-bottom: 10px;
            margin-top: 0px !important;
            margin-bottom: 2px !important;
        }
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

    <h1 style="text-align: center; font-size: 50px;">
    <div class="container" style="width: 100%">
        <div class="row" align="center">
            <div class="col-md-5" style="text-align: left;">
                <p th:text="${data.item}"></p>
            </div>
            <div class="col-md-2"></div>
            <div class="col-md-5" style="text-align: right;">
               <div th:text="${data.location}"></div>
            </div>
        </div>
</h1>

    <table class="table" style="text-align: center;">
    <thead style="text-align: center !important;">
    <tr style="background-color: rgb(24, 188, 24); color: white; font-size: large">
        <th style="text-align: center !important;border: 2px solid white;">QUANTITY</th>
        <th style="text-align: center !important;border: 2px solid white;">PRICE</th>
        <th style="text-align: center !important;border: 2px solid white;">SALE DATE</th>
        <th style="text-align: center !important;border: 2px solid white;">EMAIL</th>
        <th style="text-align: center !important;border: 2px solid white;">AGE</th>
        <th style="text-align: center !important;border: 2px solid white;">GENDER</th>
        <th style="text-align: center !important;border: 2px solid white;">PURCHASE METHOD</th>
    </tr>
    </thead>
    <tbody th:each="sale: ${data.sales}"  style="font-size: small;">
        <tr>
            <td th:text="${sale.quantity}"/>
            <td th:text="${sale.price}"/>
            <td th:text="${sale.saleDate}"/>
            <td th:text="${sale.email}"/>
            <td th:text="${sale.age}"/>
            <td th:text="${sale.gender}"/>
            <td th:text="${sale.purchaseMethod}"/>
        </tr>
    </tbody>
</table>

    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
</body>
</html>