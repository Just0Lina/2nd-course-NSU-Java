<#import "parts/common.ftlh" as c>

<@c.page "Greetings">
<style>
     h1, p {
        font-size: 34px;
        text-align: center;
        margin-bottom: 20px;
    }
    .carousel-inner {
        background-color: #bdc2ac;
    }

    .carousel-item img {
        display: block;
        margin: 0 auto;
        border-radius: 10px;
        max-width: 100%;
        height: auto;
    }

    .carousel-control-prev,
    .carousel-control-next {
        width: 5%;
        background-color: rgba(0, 0, 0, 0.5);
    }

    .carousel-control-prev-icon,
    .carousel-control-next-icon {
        filter: invert(100%);
    }
</style>

<h1>Welcome!</h1>
<p>Thank you for visiting our website. We hope you enjoy your stay!</p>

<div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item">
            <img src="../static/imgs/city1.jpg" class="d-block w-90" alt="city1">
        </div>
        <div class="carousel-item active">
            <img src="../static/imgs/city2.jpg" class="d-block w-90" alt="city2">
        </div>
        <div class="carousel-item">
            <img src="../static/imgs/city3.jpg" class="d-block w-90" alt="city3">
        </div>
        <div class="carousel-item">
            <img src="../static/imgs/city4.jpg" class="d-block w-90" alt="city4">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>

</div>

</@c.page>
