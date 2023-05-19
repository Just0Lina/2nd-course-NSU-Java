<#import "../parts/common.ftlh" as c>
<#include "../parts/security.ftlh">

<#import "../parts/style.ftlh" as s>

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
            <td>${position.quantity}</td>
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
    <div>

        <div class="order-summary">Total: <span id="orderTotal"></span></div>
        <div class="address-select">
            <label for="address">Delivery Address:</label>
            <select id="address">
                <option value="address1">Address 1</option>
                <option value="address2">Address 2</option>
                <option value="address3">Address 3</option>
            </select>
        </div>
        <button class="btn btn-primary" type="submit">Order Product</button>

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

        rows.forEach(function(row) {
            const quantity = parseInt(row.querySelector("td:nth-child(2)").textContent);
            const price = parseFloat(row.querySelector("td:nth-child(3)").textContent.replace("\u00a0", ""));
            total += quantity * price;
        });

        return total.toFixed(2);
    }

    document.addEventListener("DOMContentLoaded", function() {
        const orderSummary = document.querySelector(".order-summary");


        // Initial calculation and display of order total
        const initialOrderTotal = calculateOrderTotal();
        orderSummary.textContent = "Total: " + initialOrderTotal + " Р";
    });
</script>

</@c.page>
