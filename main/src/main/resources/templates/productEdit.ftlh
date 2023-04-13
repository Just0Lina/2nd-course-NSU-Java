<#import "parts/common.ftlh" as c>
<#import "parts/style.ftlh" as s>

<@c.page "Product Edit Page">
<!--<@s.styleLightGreen/>-->

<form action="/product" method="post">
    <h2>Edit product with id: <td>${product.id}</td> </h2>
    <input type="text" name="productName" value="${product.productName}">
    <input type="number" name="price" value="${product.price}">
    <input type="number" name="productCategory" value="${product.productCategory}">



    <input type="number" value="${product.id}" name="prodId">
<input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">
<button type="submit">Save</button>


</form>
</@c.page>
