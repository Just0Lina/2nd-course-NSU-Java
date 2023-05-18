<#import "../parts/common.ftlh" as c>
<#import "../parts/style.ftlh" as s>
<#include "../parts/security.ftlh">


<@c.page "Other info">

<!--<@s.styleLightGreen/>-->


<div class="main-info-form">
    <form method="post" action="showAll">
        <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">
        <button type="submit" class="btn btn-primary">Show All Users</button>
    </form>
    <#if users??>
    <div class="card-columns">
        <#list users as user>
        <div class="card my-3">
            <div class="m-2">
                <b>${user.id}</b>
                <b>${user.username}</b>
                <span>${user.password}</span>
                <#if user.phone??><i>${user.phone}</i></#if>
            <#if user.email??><i>${user.email}</i></#if>
            </div>
        </div>
        <#else> No tags
    </div>
</#list>
</#if>




</@c.page>