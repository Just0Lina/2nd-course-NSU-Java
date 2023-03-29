<!--<!DOCTYPE html>-->
<!--<html xmlns="http://www.w3.org/1999/xhtml">-->
<!--    <head>-->
<#import "parts/common.ftlh" as c>
<#import "parts/style.ftlh" as s>


<@c.page "Authorization">
<@s.styleLightGreen/>

    <body>
    <div class="sign-in-form">

    <form action="/login" method="post">
            <h2>Sign in Here</h2>
        <div><label for="username">Username</label>
            <input type="text" id="username" name="username" required></div>
        <div><label for="password">Password</label>
            <input type="password" id="password" name="password" required></div>
         <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">
            <div><input type="submit" value="Sign In"/></div>

        </form>
    </div>
    <form action="/registration">
        <input type="submit" value="Add new user" />
    </form>
    </@c.page>
