<#macro edit path isEditForm>
<form action="${path}" method="post" enctype="multipart/form-data">
     <div class="form-group row">
         <label class="col-sm-2 col-form-label">Product Name :</label>
            <div class="col-sm-6">
                <input type="text" name="productName"
                       value="<#if product??>${product.productName}</#if>"
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
                <input type="number" name="price"
                       value="<#if product??>${product.price}<#else>0</#if>"
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
            <input type="number" name="productCategory"
                       value="<#if product??>${product.productCategory}<#else>0</#if>"
                       class="form-control ${(productCategoryError??)?string('is-invalid', '')}"
                       placeholder="category" />
                <#if productCategoryError??>
            <div class="invalid-feedback">
                ${productCategoryError}
            </div>
            </#if>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Picture:</label>
        <div class="form-group">
            <div class="custom-file">
                <input type="file" class="custom-file-input" name="file" id="customFile">
                <label class="custom-file-label" for="customFile">Choose file</label>
            </div>
        </div>
    </div>

        <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">
    <div class="form-group row">

    </label>
    <label class="col col-form-label">
        <#if isEditForm><input type="hidden" value="${product.id}" name="prodId"></#if>
        <button class="btn btn-primary" type="submit"><#if isEditForm>Save<#else>Add product</#if></button>
    </label>
    </div>
</form>


<script>
    // Add the following code if you want the name of the file appear on select
    $(".custom-file-input").on("change", function() {
        var fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });
</script>
</#macro>