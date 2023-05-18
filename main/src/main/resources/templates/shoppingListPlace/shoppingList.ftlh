<#import "../parts/common.ftlh" as c>
<#import "../parts/style.ftlh" as s>


<@c.page "ShoppingList">
<!--<form action="/product" method="post">-->
<!--    <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">-->
<!--    <button class="btn btn-primary" type="submit">Add product</button>-->
<!--</form>-->
<a href="/bucket/productView">Back to shop</a>
<form>
    <h2>List of products:</h2>
    <#if cart?? && cart.items??>
    <table>
        <thead>
        <tr>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list cart.items as position>
        <tr>
            <td>${position.productName}</td>
            <td>${position.quantity}</td>
            <td>${position.price}</td>
            <form action="/bucket/delete" method="post">
                <td>
                    <input type="hidden" name="prodId" value=${position.prod_id}>
                    <button type="submit" class="btn btn-primary">delete ${position.prod_id}</button>
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
