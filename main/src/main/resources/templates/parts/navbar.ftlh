<#include "security.ftlh">
<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-light">
    <a class="navbar-brand" href="/bucket/productView">Linacy</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>

            <#if isAdmin>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Admin menu</a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="/user">User list</a></li>
                    <li><a class="dropdown-item" href="/product">Products info</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="#">Separated link</a></li>
                </ul>
            </li>
        </#if>
        <#if user??>
        <li class="nav-item">
            <a class="nav-link" href="/user/profile">Profile</a>
        </li>
        </#if>
        </ul>


        <#if name !="unknown">
            <div class="navbar-text mr-3">${name}</div>
            <@l.logout/>
        </#if>
<div style="width: 10px;"></div>
    <form action="/bucket" method="get">
    <button class="btn btn-primary " type="submit">Bucket</button>
    </form>
    </div>
</nav>
