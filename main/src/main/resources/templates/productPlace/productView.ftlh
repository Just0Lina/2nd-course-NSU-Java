<#import "../parts/common.ftlh" as c>
<#import "../parts/style.ftlh" as s>

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

            <button type="button" class="btn btn-primary add-to-cart-btn" data-product-id="${product.id}"
                    data-product-name="${product.productName}" data-product-price="${product.price}">
                Add to cart
            </button>
            </form>

        </div>
        <!--            <div class="card-footer">-->
        <!--                <small class="text-muted">Last updated 3 mins ago</small>-->
        <!--            </div>-->
    </div>
</div>
</#list>

</div>
</#if>

</@c.page>
