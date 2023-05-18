<#import "../parts/common.ftlh" as c>

<@c.page "Products View">

<#if products??>
<div class="row row-cols-1 row-cols-md-3 g-4">
    <#list products as product>
    <div class="col">
        <div class="card h-100 ">
            <#if product.filename??>
                <img src="/img/${product.filename}" class="card-img-top" height="200">
            </#if>
            <div class="card-body">
            <h5 class="card-title">${product.productName}</h5>
            <p class="card-text">${product.price} Р</p>
                <form action="/bucket/add-to-cart" method="post">
                        <input type="hidden" name="productId" value=${product.id}>
                    <input type="hidden" name="productName" value=${product.productName}>
                    <input type="hidden" name="productPrice" value=${product.price}>

                    <input type="hidden" name="productQuantity" value=1>

                    <button type="submit" class="btn btn-primary">
                        Add to cart ${product.id}</button>
                </form>
            </div>
        </div>
    </div>
</#list>
</div>
</#if>
</@c.page>
