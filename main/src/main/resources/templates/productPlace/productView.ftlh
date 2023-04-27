<#import "../parts/common.ftlh" as c>
<#import "../parts/style.ftlh" as s>

<@c.page "Products View">

<#if products??>

<div class="row row-cols-1 row-cols-md-3 g-4">
    <#list products as product>
    <div class="col">
        <div class="card h-100 ">
            <#if product.filename??>
                <img src="/img/${product.filename}"  class="card-img-top" height="200">
            </#if>
            <div class="card-body">
                <h5 class="card-title">${product.productName}</h5>
                <p class="card-text">${product.price} Р</p>
            </div>
        <a href="/main" class="btn btn-primary stretched-link">Go somewhere</a><!--            <div class="card-footer">-->
<!--                <small class="text-muted">Last updated 3 mins ago</small>-->
<!--            </div>-->
        </div>
    </div>
    </#list>

</div>
</#if>

</@c.page>
