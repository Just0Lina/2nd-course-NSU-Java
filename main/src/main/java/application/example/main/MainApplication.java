package application.example.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}


//<!--<#import "parts/common.ftlh" as c>-->
//<!--<#import "parts/style.ftlh" as s>-->
//<!--<#import "parts/login.ftlh" as l>-->
//<!--<#include "parts/security.ftlh">-->
//
//
//
//<!--<@c.page "MAIN PAGE">-->
//<!--&lt;!&ndash;    <@s.styleGreen/>&ndash;&gt;-->
//<!--<div class="main-info-form" >-->
//<!--    &lt;!&ndash;    <h2>Show my tags</h2>&ndash;&gt;-->
//<!--    <div class="form-row">-->
//<!--        <div class="form-group col-md-6">-->
//<!--            <form method="post" action="filterTags" class="form-inline">-->
//<!--                <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">-->
//<!--                <button type="submit" class="btn btn-primary ml-2">${currentUserId} Show my tags</button>-->
//<!--            </form>-->
//<!--        </div>-->
//<!--    </div>-->
//<!--    <#if tags??>-->
//<!--    <#list tags as tag>-->
//<!--    <div>-->
//<!--        <b>${tag.id}</b>-->
//<!--        <b>${tag.tag}</b>-->
//<!--        <span>${tag.username}</span>-->
//<!--    </div>-->
//<!--    <#else> No tags-->
//<!--</#list>-->
//<!--</#if>-->
//
//<!--</@c.page>-->
//
//
//
//<!--&lt;!&ndash;#D8E1E5;&ndash;&gt;-->
//<!--&lt;!&ndash;72ae66&ndash;&gt;-->
//<!--&lt;!&ndash;75a848&ndash;&gt;-->
//<!--&lt;!&ndash;bbda97&ndash;&gt;-->
//<!--&lt;!&ndash;c5e1a5&ndash;&gt;-->
//
//<!--&lt;!&ndash;2f4858&ndash;&gt;-->
//<!--&lt;!&ndash;33658a&ndash;&gt;-->
//<!--&lt;!&ndash;0E94A0&ndash;&gt;-->
//


//
//<!--<div class="main-info-form">-->
//<!--    &lt;!&ndash;    <h2>Show my tags</h2>&ndash;&gt;-->
//<!--    <div class="form-row">-->
//<!--        <div class="form-group col-md-6">-->
//<!--            <form method="post" action="showAll" class="form-inline">-->
//<!--                <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">-->
//<!--                <button type="submit" class="btn btn-primary my-2">Show All Users</button>-->
//<!--            </form>-->
//<!--        </div>-->
//<!--    </div>-->
//<!--    <#if tags??>-->
//<!--    <#list users as user>-->
//<!--    <div>-->
//<!--        <b>${user.id}</b>-->
//<!--        <b>${user.username}</b>-->
//<!--        <span>${user.password}</span>-->
//<!--        <i>${user.phone}</i>-->
//<!--        <i>${user.email}</i>-->
//<!--    </div>-->
//<!--    <#else> No users-->
//<!--</#list>-->
//<!--</#if>-->
//
//<!--&lt;!&ndash;</div>&ndash;&gt;-->
//<!--&lt;!&ndash;</div>&ndash;&gt;-->
//
//<!--<a class="btn btn-primary ml-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"-->
//<!--   aria-controls="collapseExample">-->
//<!--    Subscribe on a tag-->
//<!--</a>-->
//<!--<div class="collapse" id="collapseExample">-->
//<!--    <div class="form-group mt-3">-->
//<!--        <form method="post" action="subscribe" enctype="multipart/form-data">-->
//<!--            <div class="form-group">-->
//<!--                <input type="text" class="form-control" name="tag" placeholder="Tag">-->
//<!--            </div>-->
//<!--            <div class="form-group">-->
//<!--                <div class="custom-file">-->
//<!--                    <input type="file" name="file" id="customFile">-->
//<!--                    <label class="custom-file-label" for="customFile">Choose file</label>-->
//<!--                </div>-->
//<!--            </div>-->
//<!--            <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">-->
//<!--            <div class="form-group">-->
//<!--                <button type="submit" class="btn btn-primary">Subscribe</button>-->
//<!--            </div>-->
//<!--        </form>-->
//<!--    </div>-->
//<!--</div>-->
//
//
//<!--<div>-->
//<!--    <form action="showTags" method="post" class="form-inline">-->
//<!--        <button type="submit" class="btn btn-primary my-2">Show All Tags</button>-->
//<!--    </form>-->
//<!--    <#if settings??>-->
//<!--    <#list settings as setting>-->
//<!--    <#if setting.filename??>-->
//<!--    <img src="/img/${setting.filename}">-->
//<!--</-->
//<!--#if>-->
//<!--<div class="m-2">-->
//<!--    <i>${setting.tag}</i>-->
//<!--</div>-->
//<!--<div>-->
//<!--    ${setting.username}-->
//<!--</div>-->
//<!--</div>-->
//<!--</#list>-->
//<!--</div>-->
//<!--<#else>-->
//<!--No message-->
//<!--</#if>-->
//<!--</div>-->


