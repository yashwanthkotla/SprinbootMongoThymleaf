<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        * {
            box-sizing: border-box;
        }
        .column1 {
            float: left;
            width: 33.33%;
            padding: 10px;
            height: 200px;
            /* Should be removed. Only for demonstration */
        }
        /* Clear floats after the columns */

        .row1:after {
            display: table;
            clear: both;
        }
    </style>
</head>
<body>
<body style="background-color: navy;">
    <div class="row1">
        <div class="column1">
        </div>
        <div class="column1">
            <h1 style="text-align:center;
                font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
              color: white;
              margin:0;
              font-size: 55px !important;">SEARCH MORE ITEMS</h1>
        </div>
        <div class="column1">
            <input type="text" id="testData" name="searchTxt" placeholder="enter item name..." style="width: 87%;
                    height: 60px;
                    width: 80%;
                    border-radius: 10px;">
            <button name="button" value="OK" type="button" onclick="redirect()" style="height: 60px;
                    border-radius: 10px;
                    width: 19%;">Search
            </button>
        </div>
    </div>
    <br>
    <div>
        <h1 style="text-align: center; color: antiquewhite;">You may like....</h1>
    </div>
    <br/>
    <br/>
    <br/>
    <br/>
    <div class="container" style="width: 100%">
        <div class="row" align="center">
            <div class="col-md-1"></div>
            <div class="col-md-2">
                <a href="./data/notepad">
                    <img src="notepad.jpeg" style="background-color: white;border-radius: 10px;" alt="step 1">
                </a>
            </div>
            <div class="col-md-2">
                <a href="./data/binder">
                    <img src="books.jpg" style="border-radius: 10px;" alt="step 1">
                </a>
            </div>
            <div class="col-md-2">
                <a href="./data/pens">
                    <img src="./pen.jpg" style="border-radius: 10px;" alt="step 1">
                </a>
            </div>
            <div class="col-md-2">
                <a href="./data/envelopes">
                    <img src="mail.png" style="border-radius: 10px;" alt="step 1">
                </a>
            </div>
            <div class="col-md-2">
                <a href="./data/laptop">
                    <img src="laptop.png" style="background-color: white;border-radius: 10px;" alt="step 1">
                </a>
            </div>
            <div class="col-md-1"></div>
        </div>
    </div>

    <!-- Latest compiled and minified JavaScript -->
        <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
        <script>
                function redirect() {
                    var item = document.getElementById("testData").value;
                    var url = "./data/" + item;
                    window.location.assign(url);
                }

        </script>
</body>
</body>
</html>