<#import "../parts/common.ftlh" as c>
<#include "../parts/security.ftlh">


<@c.page "ShoppingList">

<a href="/bucket/productView">Back to shop</a>

<form>
    <h2>List of products:</h2>

    <#if cart?? && cart.items??>
    <table>
        <thead>
        <tr>
            <th>Product Name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list cart.items as position>
        <tr>
            <td>${position.productName}</td>
            <td>
                <form action="/bucket/changeQuantity" method="post">

                <div class="col-md-3 col-lg-3 col-xl-2 d-flex">

                        <button type="submit" class="btn btn-link px-2"
                                onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                            <i class="fas fa-minus"></i>
                        </button>
                        <input class="quantity fw-bold text-black" min="0" name="quantity" value="${position.quantity}"
                               type="number">
                        <input type="hidden" name="productId" value=${position.prod_id}>

                        <button type="submit" class="btn btn-link px-2"
                                onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                            <i class="fas fa-plus"></i>
                        </button>
                    </div>
                </form>


            </td>
            <td>${position.price}</td>
            <form action="/bucket/delete" method="post">
                <td>
                    <input type="hidden" name="prodId" value=${position.prod_id}>

                    <button type="submit" class="btn btn-primary">delete ${position.prod_id}</button>
                </td>
            </form>
        </tr>
        </#list>
        </tbody>
    </table>
    <div class="col-lg-4 bg-grey">
        <div class="p-5">
    <h3 class="fw-bold mb-3 mt-3 pt-1">Summary</h3>
    <hr class="my-4">
    <div>
        <h5 class="order-summary text-uppercase mb-3">Total: <span id="orderTotal"></span></h5>
        <div class="address-select">

            <div class="d-flex justify-content-between mb-3">
                <h5 for="address">Delivery Address:</h5>
                <select id="address">
                    <option value="address1">Address 1</option>
                    <option value="address2">Address 2</option>
                    <option value="address3">Address 3</option>
                </select>
            </div>

        </div>
        <div class="card mb-4">
            <div class="card-body d-flex">
                <div class="form-outline flex-fill">
                    <input type="text"  class="form-control form-control "  placeholder="Discount code"/>
                </div>
                <button type="button" class="btn btn-outline-warning btn-lg ms-3">Apply</button>
            </div>
        </div>
        <button class="btn btn-primary" type="submit">Order Product</button>
    </div>
        </div>
    </div>
    <#else>
    No positions in the list yet
</#if>

<#if name ="unknown">
<div class="navbar-text mr-3">${name}</div>
<a>You haven't login yet, <a href="/registration">click here to register</a>. <a href="/login">click here to sign up</a>.</a>
</#if>

</form>

<script>
    function calculateOrderTotal() {
        const rows = document.querySelectorAll("tbody tr");
        let total = 0;

        rows.forEach(function (row) {
            const quantity = parseInt(row.querySelector(".quantity").value);
            const price = parseFloat(row.querySelector("td:nth-child(3)").textContent.replace("\u00a0", ""));
            total += quantity * price;
        });

        return total.toFixed(2);
    }

    document.addEventListener("DOMContentLoaded", function () {
        const orderSummary = document.querySelector(".order-summary");


        // Initial calculation and display of order total
        const initialOrderTotal = calculateOrderTotal();
        orderSummary.textContent = "Total: " + initialOrderTotal + " Р";
    });
</script>

</@c.page>
