<#import "../parts/common.ftlh" as c>
<#import "../parts/style.ftlh" as s>
<#import "../parts/login.ftlh" as l>


<@c.page "Products">
<!--<form action="/product" method="post">-->
<!--    <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">-->
<!--    <button class="btn btn-primary" type="submit">Add product</button>-->
<!--</form>-->
<a href="/product/productCreation">Add product</a>
<form>
    <h2>List of products:</h2>
    <#if products??>
    <table>
        <thead>
        <tr>
            <th>ProductName</th>
            <th>Price</th>
            <th>ProductCategory</th>
            <th>Edit</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list products as product>
        <tr>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.productCategory}</td>
            <td><a href="/product/${product.id}">edit</a></td>
            <form action="/product/delete" method="post">
                <td>
                    <input type="hidden" name="prodId" value=${product.id}>
                    <button type="submit" class="btn btn-primary">delete ${product.id}</button>
                </td></form>
        </tr>
        </#list>
        </tbody>
    </table>
<#else>
    There is no products yet
</#if>
</form>

</@c.page>
