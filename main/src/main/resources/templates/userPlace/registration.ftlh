<#import "../parts/common.ftlh" as c>
<#import "../parts/login.ftlh" as l>

<@c.page "Registration">
<body>
<#if message??>
    ${message}
</#if>
<div class="registration-form">
    <h2>Register Here</h2>
    <@l.login "/registration" true />
</div>
</@c.page>

