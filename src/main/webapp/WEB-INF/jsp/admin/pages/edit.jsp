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
    <div class="col-lg-4" >
<%--        <%@ include file = "parts/edit_page_form.jsp"  %>--%>
        <jsp:include page="parts/edit_page_form.jsp">
            <jsp:param name="page" value="${page}" />
        </jsp:include>
    </div>
    <div class="col-lg-8" style="padding: 10px 0px 10px 5px; ">
        <div>
            <textarea id="codemirror-textarea" style="width: 80%" class="code-input">${page.content}</textarea>
        </div>
    </div>
</div>


<%--<script src="/resources/vendor/codemirror/codemirror.js"></script>--%>
<%--<script src="/resources/vendor/codemirror/modes/htmlmixed.js"></script>--%>

<script>
    var language = "htmlmixed";
    var theme = "darcula";

    var editor = CodeMirror.fromTextArea(document.getElementById("codemirror-textarea"), {
        mode: language,
        theme: theme,
        height: "auto",
        lineNumbers: true,
        matchBrackets: true,
        lineWrapping: true,
        htmlMode: true,
        extraKeys: {"Ctrl-Space": "autocomplete"},
    });
    console.log("editor");
    console.log(editor);
</script>

<script>

    var formBtn = $("#newPageFormSubmitBtn");

    var form;
    var formdata;
    var formJsonObject = {};
    formBtn.click(function(){

        form  = $("#newPageForm");

        formdata = form.serializeArray();
        formJsonObject = {};
        $(formdata).each(function(index, obj){
            formJsonObject[""+obj.name] = obj.value;
        });
        formJsonObject["content"] = editor.getValue();
        console.log(formdata);
        console.log(formJsonObject);

        var formBtn = $("#newPageFormSubmitBtn");


        // $.post("/admin/pages/new",form.serialize(),function(data){
        //     alert(data);
        $.ajax({
            type: "PUT",
            contentType: "application/json",
            url: "/admin/pages/${page.id}",
            headers: {"X-CSRF-TOKEN": formJsonObject._csrf},
            data: JSON.stringify(formJsonObject),
            dataType: "json",
            complete: function(xhr) {
                if (xhr.readyState == 4) {
                    if (xhr.status == 201) {
                        alert("Created");
                    }
                } else {
                    alert("NoGood");
                }
            }

        })

        console.log("button clicked");
    })
</script>

<style>
    .CodeMirror {
        border: 1px solid #eee;
        height: calc(100%  - 20px);
        width: calc(100% - 5px);
        border-radius: 5px;
    }
</style>

</body>
</html>
