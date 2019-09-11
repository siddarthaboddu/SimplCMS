<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Uploading Files Example with Spring Boot, Freemarker</title>
    <link rel="stylesheet" href="/resources/vendor/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/dashboard.css"/>
</head>

<body onload="updateSize();">
<div>
    <%@ include file = "parts/header.jsp" %>
</div>

<div style="float:left;height: calc(100vh - 70px)">
    <%@ include file = "parts/sidebar.jsp" %>
</div>

<div class="row" style="width: calc(100% - 300px);height: calc(100vh - 70px);margin-left:30px;margin-right:0px;float:left">
    <form name="uploadingForm" enctype="multipart/form-data" action="/admin/upload" method="POST">
        <p>
            <input type = "hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <input id="fileInput" type="file" name="uploadingFiles" onchange="updateSize();" multiple>
            selected files: <span id="fileNum">0</span>;
            total size: <span id="fileSize">0</span>
        </p>
        <p>
            <input type="submit" value="Upload files">
        </p>
    </form>
    <div>
        <div>Uploaded files:</div>

        <% File[] files = (File[]) request.getAttribute("files"); %>

        <div class="row">
            <% for(int i=0;i < files.length;i++) { %>
                <% File file = files[i]; %>
                <% if(i%6 == 0){%>
                    <div class="column">
                <% } %>
                    <img  src='/resources/user-uploaded-images/<%= file.getName() %>'/>
                <% if( i%6 == 5 ){%>
                    </div>
                <% } %>
            <% } %>
        </div>
    </div>

</div>

<script>
    function updateSize() {
        var nBytes = 0,
            oFiles = document.getElementById("fileInput").files,
            nFiles = oFiles.length;
        for (var nFileId = 0; nFileId < nFiles; nFileId++) {
            nBytes += oFiles[nFileId].size;
        }

        var sOutput = nBytes + " bytes";
        // optional code for multiples approximation
        for (var aMultiples = ["KiB", "MiB", "GiB", "TiB", "PiB", "EiB", "ZiB", "YiB"], nMultiple = 0, nApprox = nBytes / 1024; nApprox > 1; nApprox /= 1024, nMultiple++) {
            sOutput = nApprox.toFixed(3) + " " + aMultiples[nMultiple] + " (" + nBytes + " bytes)";
        }
        // end of optional code

        document.getElementById("fileNum").innerHTML = nFiles;
        document.getElementById("fileSize").innerHTML = sOutput;
    }
</script>
<style>
    * {
        box-sizing: border-box;
    }

    body {
        margin: 0;
        font-family: Arial;
    }

    .header {
        text-align: center;
        padding: 32px;
    }

    .row {
        display: -ms-flexbox; /* IE10 */
        display: flex;
        -ms-flex-wrap: wrap; /* IE10 */
        flex-wrap: wrap;
        padding: 0 4px;
    }

    /* Create four equal columns that sits next to each other */
    .column {
        -ms-flex: 25%; /* IE10 */
        flex: 25%;
        max-width: 25%;
        padding: 0 4px;
    }

    .column img {
        margin-top: 8px;
        vertical-align: middle;
        width: 100%;
    }

    /* Responsive layout - makes a two column-layout instead of four columns */
    @media screen and (max-width: 800px) {
        .column {
            -ms-flex: 50%;
            flex: 50%;
            max-width: 50%;
        }
    }

    /* Responsive layout - makes the two columns stack on top of each other instead of next to each other */
    @media screen and (max-width: 600px) {
        .column {
            -ms-flex: 100%;
            flex: 100%;
            max-width: 100%;
        }
    }
</style>
<script src="/resources/vendor/bootstrap/js/popper.js"></script>
<script src="/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
