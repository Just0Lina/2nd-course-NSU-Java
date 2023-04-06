<#import "parts/common.ftlh" as c>
<#import "parts/style.ftlh" as s>

<@c.page "Authorization">
<!--<@s.styleLightGreen/>-->
<#if message??>
${message}
</#if>
<h5>${username}</h5>
<form method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password:</label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="Password" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Email:</label>
        <div class="col-sm-6">
            <input type="email" name="email" class="form-control" placeholder="${email!''}" />
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Phone:</label>
        <div class="col-sm-6">
            <input type="tel" name="phone" class="form-control" placeholder="${phone!''}" />
        </div>
    </div>
<div class="col-sm-6">
    <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">
    <button class="btn btn-primary" type="submit">Save</button>
</div>
</form>
</@c.page>
