<!--<!DOCTYPE html>-->
<!--<html xmlns="http://www.w3.org/1999/xhtml">-->
<!--    <head>-->
<#import "parts/common.ftlh" as c>
<#import "parts/style.ftlh" as s>
<#import "parts/login.ftlh" as l>


<@c.page "Authorization">
<!--<@s.styleLightGreen/>-->
<#if message??>
${message}
</#if>
<@l.login "/login" false/>

<!--    <form action="/registration">-->
<!--        <input type="submit" value="Add new user" />-->
<!--    </form>-->
    </@c.page>
