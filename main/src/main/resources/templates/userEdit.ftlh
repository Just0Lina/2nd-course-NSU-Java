<#import "parts/common.ftlh" as c>
<#import "parts/style.ftlh" as s>

<@c.page "User Edit Page">
<@s.styleLightGreen/>

<form action="/user" method="post">
    <h2>Edit user with id: <td>${user.id}</td> </h2>
    <input type="text" name="username" value="${user.username}">
    <#if roles??>
    <#list roles as role>
    <div>
        <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
    </div>
</#list>
</#if>


<!--<input type="text" value="${user.id}" name="userId">-->
<input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">
<button type="submit">Save</button>
</form>
</@c.page>
