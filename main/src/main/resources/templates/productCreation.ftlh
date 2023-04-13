<#import "parts/common.ftlh" as c>
<#import "parts/style.ftlh" as s>
<#import "parts/login.ftlh" as l>


<@c.page "Product creation">

<form action="productCreation" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Product Name :</label>
        <div class="col-sm-6">
            <input type="text" name="productName"
                   class="form-control ${(productNameError??)?string('is-invalid', '')}"
                   placeholder="Product name" />
            <#if productNameError??>
            <div class="invalid-feedback">
                ${productNameError}
            </div>
        </#if>
    </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Price:</label>
        <div class="col-sm-6">
            <input type="number" name="price" value="0"
                   class="form-control ${(priceError??)?string('is-invalid', '')}"
                   placeholder="Price" />
            <#if priceError??>
            <div class="invalid-feedback">
                ${priceError}
            </div>
        </#if>
    </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Product Category:</label>
        <div class="col-sm-6">
            <input type="number" name="productCategory" value="0"
                   class="form-control ${(productCategoryError??)?string('is-invalid', '')}"
                   placeholder="category" />
            <#if productCategoryError??>
            <div class="invalid-feedback">
                ${productCategoryError}
            </div>
        </#if>
        </div>
    </div>


<input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">
<div class="form-group row">
    <label class="col-md-2 col-form-label">
        <button class="btn btn-primary" type="submit">Create</button>
    </label>

</div>

</form>

</@c.page>
