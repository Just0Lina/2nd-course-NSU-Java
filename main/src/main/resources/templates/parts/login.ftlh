<#marco logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">
    <input type="submit" value="Sign Out"/>
</form>
</#marco>