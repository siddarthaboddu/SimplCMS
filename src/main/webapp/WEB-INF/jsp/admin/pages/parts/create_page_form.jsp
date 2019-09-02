<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    body {font-family: Arial, Helvetica, sans-serif;}
    * {box-sizing: border-box;}

    input[type=text], select, textarea {
        width: 100%;
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 2px;
        box-sizing: border-box;
        margin-top: 2px;
        margin-bottom: 9px;
        resize: vertical;
    }

    button {
        background-color: #7386D5;
        color: white;
        padding: 6px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        margin-top: 10px;
    }

    button:hover {
        background-color: #6076d1;
    }

    .container {
        border-radius: 5px;
        /*background-color: #f2f2f2;*/
        padding: 8px;
    }

    label {
        padding: 0px;
        margin-bottom: 2px;
    }
</style>

<h4 style="margin: 25px 10px 10px 8px">Create Page</h4>
<div class="container">
    <form id="newPageForm" action="/admin/pages/new" method="post">
        <label for="name">Name</label>
        <input type="text" id="name" name="name" placeholder="Page name...">

        <label for="route">route url</label>
        <input type="text" id="route" name="route" placeholder="route url...">

        <label for="route">description</label>
        <input type="text" id="description" name="description" placeholder="Page description...">

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <button id="newPageFormSubmitBtn" type="button">Submit</button>
    </form>
</div>


