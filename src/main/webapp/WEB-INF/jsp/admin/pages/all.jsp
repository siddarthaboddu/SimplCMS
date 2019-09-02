<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.example.cms.models.Page" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>







<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/vendor/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/dashboard.css"/>
    <link rel="stylesheet" href="/resources/vendor/codemirror/codemirror.css"/>
    <link rel="stylesheet" href="/resources/vendor/codemirror/themes/darcula.css"/>
    <link rel="stylesheet" href="/resources/vendor/codemirror/addons/hints/show-hint.css"/>

    <script src="/resources/vendor/codemirror/codemirror.js"></script>
    <script src="/resources/vendor/codemirror/modes/htmlmixed.js"></script>
    <script src="/resources/vendor/codemirror/addons/hints/show-hint.js"></script>
    <script src="/resources/vendor/codemirror/modes/css.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.41.0/mode/xml/xml.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.41.0/mode/javascript/javascript.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.41.0/mode/css/css.js"></script>
    <script src="/resources/vendor/codemirror/addons/hints/css-hint.js"></script>
    <script src="/resources/vendor/codemirror/addons/hints/html-hint.js"></script>
    <script src="/resources/vendor/codemirror/addons/hints/javascript-hint.js"></script>
    <script src="/resources/vendor/codemirror/addons/hints/xml-hint.js"></script>


    <script src="/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
    <script src="/resources/vendor/bootstrap/js/popper.js"></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div>
    <%@ include file = "../parts/header.jsp" %>
</div>

<div style="float:left;height: calc(100vh - 70px)">
    <%@ include file = "../parts/sidebar.jsp" %>
</div>
<div class="row" style="width: calc(100% - 250px);height: calc(100vh - 70px)">
    <c:if test="${not empty pages}">

        <div style="width: 100%">
            <h3 style="margin: 20px 20px 20px 30px; color: #f62d51"> Pages (${pages.size()})</h3>

            <div class="" style="width: 95%; margin: 0px auto 0px;">
                <div class="row" style="margin-left: 0px;color: red;font-size: 1.2em">
                    <div class="col-md-4" >Name</div>
                    <div class="col-md-4" >Description</div>
                    <div class="col-md-4" >URL</div>
                </div>
            </div>

            <c:forEach var="listValue" items="${pages}">
                <div class="card" style="width: 95%; margin: 10px auto 20px;">
                    <div class="card-body row">
                        <a class="col-md-4 pagehref" href="/admin/pages/${listValue.id}">${listValue.name}</a>
                        <div class="col-md-4"  >${listValue.description}</div>
                        <div class="col-md-4"  >${listValue.route}</div>
                    </div>
                </div>
            </c:forEach>

        </div>

    </c:if>
</div>

<style>
    .CodeMirror {
        border: 1px solid #eee;
        height: calc(100%  - 20px);
        width: calc(100% - 5px);
        border-radius: 5px;
    }
     .pagehref {
         color: darkslateblue;
         background-color: transparent;
         text-decoration: none;
     }

    .pagehref:hover {
        color: red;
        background-color: transparent;
        text-decoration: underline;
    }

    .pagehref:active {
        color: yellow;
        background-color: transparent;
        text-decoration: underline;
    }

</style>

</body>
</html>
