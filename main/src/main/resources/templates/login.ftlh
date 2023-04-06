<#import "parts/common.ftlh" as c>
<#import "parts/style.ftlh" as s>
<#import "parts/login.ftlh" as l>


<@c.page "Authorization">
<!--<@s.styleLightGreen/>-->
<#if message??>
${message}
</#if>

<@l.login "/login" false/>
</@c.page>
