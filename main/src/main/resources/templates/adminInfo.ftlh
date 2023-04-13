<#import "parts/common.ftlh" as c>
<#import "parts/style.ftlh" as s>
<#include "parts/security.ftlh">


<@c.page "Other info">

<!--<@s.styleLightGreen/>-->


<div class="main-info-form">
    <form method="post" action="showAll">
        <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">
        <button type="submit" class="btn btn-primary">Show All Users</button>
    </form>
    <#if users??>
    <div class="card-columns">
        <#list users as user>
        <div class="card my-3">
            <div class="m-2">
                <b>${user.id}</b>
                <b>${user.username}</b>
                <span>${user.password}</span>
                <#if user.phone??><i>${user.phone}</i></#if>
            <#if user.email??><i>${user.email}</i></#if>
            </div>
        </div>
        <#else> No tags
    </div>
</#list>
</#if>


<!--<h3></h3>-->

<button class="btn btn-primary my-2" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
   aria-controls="collapseExample">
    Subscribe on a tag
</button>
<div class="collapse  <#if setting??>show</#if>" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" action="subscribe" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" name="tag" class="form-control ${(tagError??)?string('is-invalid','')}"
                       value="<#if setting??>${setting.tag}</#if>" placeholder="Tag">
                <#if tagError??>
                <div class="invalid-feedback">
                    ${tagError}
                </div>
            </#if>
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Subscribe</button>
            </div>

        </form>
    </div>
</div>


<form method="post" action="showTags">
    <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">
    <button type="submit" class="btn btn-primary">Show All Tags</button>
</form>
<#if settings??>
<div class="card-columns">
    <#list settings as setting>
    <div class="card my-3">
        <div class="m-2">
            <b>${setting.id}</b>
            <b>${setting.tag}</b>
            <span>${setting.username}</span>
        </div>
        <#if setting.filename??>
        <img src="/img/${setting.filename}" class="card-img-top">
    </div>
    <#else> No tags
</div>
</#if>
</#list>
</#if>
</div>


</@c.page>