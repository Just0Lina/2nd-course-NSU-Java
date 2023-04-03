<#import "parts/common.ftlh" as c>
<#import "parts/style.ftlh" as s>
<#import "parts/login.ftlh" as l>
<#include "parts/security.ftlh">


<@c.page "MAIN PAGE">
<!--    <@s.styleGreen/>-->
<div class="main-info-form">
    <form method="post" action="filterTags">
        <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">
        <button type="submit" class="btn btn-primary">${currentUserId} Show my tags</button>
    </form>
    <#if tags??>
    <div class="card-columns">
        <#list tags as tag>
        <div class="card my-3">
            <div class="m-2">
                <b>${tag.id}</b>
                <b>${tag.tag}</b>
                <span>${tag.username}</span>
            </div>
        </div>
        <#else> No tags
    </div>
</div>
</#list>
</#if>
</@c.page>


<!--#D8E1E5;-->
<!--72ae66-->
<!--75a848-->
<!--bbda97-->
<!--c5e1a5-->

<!--2f4858-->
<!--33658a-->
<!--0E94A0-->
