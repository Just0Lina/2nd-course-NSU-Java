<#import "../parts/common.ftlh" as c>
<#import "../parts/style.ftlh" as s>

<@c.page "Authorization">
<!--<@s.styleLightGreen/>-->
<#if message??>
<div class="alert alert-success" role="alert">
${message}
    </div>
</#if>
<#if username??>
<h5>${username}</h5>
</#if>
<form method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Email:</label>
        <div class="col-sm-6">
<!--            <input type="email" name="email" class="form-control" placeholder="${email!''}" />-->

            <input type="email" name="email"
                   class="form-control ${(emailError??)?string('is-invalid', '')}"
                   value="${email!''}" />
            <#if emailError??>
            <div class="invalid-feedback">
                ${emailError}
            </div>
            </#if>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Phone:</label>
        <div class="col-sm-6">
            <input type="tel" name="phone" class="form-control" placeholder="${phone!''}" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password:</label>
        <div class="col-sm-6">
            <input type="password" name="password"
                   class="form-control ${(passwordError??)?string('is-invalid', '')}"
                   placeholder="Password" />
            <#if passwordError??>
            <div class="invalid-feedback">
                ${passwordError}
            </div>
        </#if>
    </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password:</label>
        <div class="col-sm-6">
            <input type="password" name="password2"
                   class="form-control ${(password2Error??)?string('is-invalid', '')}"
                   placeholder="Retype password" />
            <#if password2Error??>
            <div class="invalid-feedback">
                ${password2Error}
            </div>
        </#if>
    </div>
    </div>
<div class="col-sm-2">
    <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">
    <button class="btn btn-primary" type="submit">Save</button>
</div>

</form>
</@c.page>
