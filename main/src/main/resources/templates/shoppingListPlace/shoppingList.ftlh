<#import "../parts/common.ftlh" as c>
<#import "../parts/style.ftlh" as s>


<@c.page "ShoppingList">
<!--<form action="/product" method="post">-->
<!--    <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">-->
<!--    <button class="btn btn-primary" type="submit">Add product</button>-->
<!--</form>-->
<a href="/">Back to shop</a>
<form>
    <h2>List of products:</h2>
    <#if list??>
    <table>
        <thead>
        <tr>
            <th>User</th>
            <th>Quantity</th>
            <th>Product</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list list as position>
        <tr>
            <td>${position.user}</td>
            <td>${position.quantity}</td>
            <td>${position.product}</td>
            <form action="/bucket/delete" method="post">
                <td>
                    <input type="hidden" name="posId" value=${position.id}>
                    <button type="submit" class="btn btn-primary">delete ${position.id}</button>
                </td></form>
        </tr>
        </#list>
        </tbody>
    </table>
    <#else>
    No positions in a list yet
    </#if>
</form>

</@c.page>
