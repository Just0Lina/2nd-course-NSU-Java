<#import "parts/common.ftlh" as c>
<#import "parts/style.ftlh" as s>

<@c.page "MAIN PAGE">
    <@s.styleGreen/>
<div class="main-info-form">
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">
        <input type="submit" value="Sign Out"/>
    </form>
    <h2>Find user by name</h2>
    <form method="post" action="filter">
        <input type="text" name="filter">
        <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">

        <button type="submit">Search</button>
    </form>
    <form method="post" action="showAll">
        <button type="submit">Show All Users</button>
    </form>

    <#if users??>
    <#list users as user>
            <div>
                <b>${user.id}</b>
                <b>${user.username}</b>
                <span>${user.password}</span>
                <i>${user.phone}</i>
                <i>${user.email}</i>
            </div>
        <#else> No users
        </#list>
    </#if>

</div>
<h3></h3>

<div class="tag-info-form">
    <h2>Subscribe on a tag</h2>
    <div>
        <form method="post" action="subscribe">
            <input type="text" name="tag" placeholder="Tag">
            <button type="submit">Subscribe</button>
        </form>
    </div>

    <form action="showTags" method="post">
        <button type="submit">Show All Tags</button>
    </form>
    <#if settings??>
    <#list settings as setting>
    <div>
        <b>${setting.id}</b>
        <b>${setting.tag}</b>
        <span>${setting.username}</span>
    </div>
    <#else> No settings
</#list>
</#if>
</div>
</@c.page>

<!--</body>-->
<!--</html>-->


<!--#D8E1E5;-->
<!--72ae66-->
<!--75a848-->
<!--bbda97-->
<!--c5e1a5-->

<!--2f4858-->
<!--33658a-->
<!--0E94A0-->
