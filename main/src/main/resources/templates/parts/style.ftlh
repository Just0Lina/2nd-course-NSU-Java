<#macro styleGreen>
    <style>
    body {
        background-color: #b0c3c3;
        font-size: 16px;
        color: #333;
    }

    h1 {
        color: #3e6a5c;
        font-size: 36px;
        text-align: center;
        margin-top: 100px;
    }

    .main-info-form,
    .tag-info-form,
    .registration-form {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 8px rgba(0, 0, 0, 0.4);
        background-color: #fff;
    }

    label {
        display: block;
        margin-bottom: 10px;
        color: #1c6038;
        font-size: 20px;
    }



    input[type="text"],
    input[type="email"],
    input[type="tel"],
    input[type="password"]{
        color: #14462a;
        background-color: #d8e7cc;
        display: block;
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 16px;
        margin-bottom: 20px;
        box-sizing: border-box;
    }

    h2 {
        font-size: 30px;
        font-weight: bold;
        text-align: center;
        margin-bottom: 15px;
        color: #3e6a5c;
    }

    button[type="submit"],
    input[type="submit"]{
        width: 100%;
        display: block;
        margin-top: 20px;
        padding: 10px 20px;
        background-color: #3e6a5c;
        color: #E8F0F3;
        font-size: 18px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    button:hover {
        background-color: #3e6a5c;
    }

    input:focus {
        outline: none;
        box-shadow: 0 0 3px #3cb371;
    }
    </style>
</#macro>


<#macro styleLightGreen>
<style>
    body {
        background-color: #c5e1a5;
    }
    form {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 8px rgba(0, 0, 0, 0.4);
        background-color: #d8e7cc;
    }

    .sign-in-form label {
        display: block;
        margin-bottom: 10px;
        color: #1c6038;
        font-size: 20px;
    }
    input[type="text"],
    input[type="password"] {
        color: #14462a;
        background-color: #c5e1a5;
        display: block;
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 16px;
        margin-bottom: 20px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #75a848;
        color: #E8F0F3;
        border: none;
        display: block;
        margin-top: 20px;
        padding: 10px 20px;
        width: 100%;
        font-size: 18px;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: seagreen;
    }
    .sign-in-form h2 {
        font-size: 30px;
        font-weight: bold;
        text-align: center;
        margin-bottom: 15px;
        color: seagreen;
    }
</style>
</#macro>
