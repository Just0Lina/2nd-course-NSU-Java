<#import "parts/common.ftlh" as c>
<#import "parts/style.ftlh" as s>

<@c.page "User Page">
<@s.styleLightGreen/>
<form>
<h2>List of users:</h2>
<#if users??>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.username}</td>
        <td><#list user.roles as role>${role}<#sep>, </#list></td>
        <td><a href="/user/${user.id}">edit</a></td>
    </tr>
    </#list>
    </tbody>
</table>
</#if>
</form>
</@c.page>