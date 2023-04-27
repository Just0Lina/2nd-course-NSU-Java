<#import "../parts/common.ftlh" as c>
<#import "../parts/style.ftlh" as s>
<#import "../parts/login.ftlh" as l>
<#include "../parts/security.ftlh">


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


<!--<iframe src="https://calendar.google.com/calendar/embed?height=600&wkst=1&bgcolor=%23ffffff&ctz=Asia%2FNovosibirsk&src=YWxpbmEucGFzaGtvdmEuMDMyNkBnbWFpbC5jb20&src=YWRkcmVzc2Jvb2sjY29udGFjdHNAZ3JvdXAudi5jYWxlbmRhci5nb29nbGUuY29t&src=cnUucnVzc2lhbiNob2xpZGF5QGdyb3VwLnYuY2FsZW5kYXIuZ29vZ2xlLmNvbQ&color=%23039BE5&color=%2333B679&color=%237986CB" style="border:solid 1px #777" width="800" height="600" frameborder="0" scrolling="no"></iframe>-->
</@c.page>


<!--#D8E1E5;-->
<!--72ae66-->
<!--75a848-->
<!--bbda97-->
<!--c5e1a5-->

<!--2f4858-->
<!--33658a-->
<!--0E94A0-->
