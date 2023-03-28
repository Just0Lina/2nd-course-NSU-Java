<#import "parts/common.ftlh" as c>
<#import "parts/style.ftlh" as s>

<@c.page "Registration">
<@s.styleGreen/>

<body>
<#if message??>
    ${message}
</#if>
<div class="registration-form">
    <h2>Register Here</h2>
    <form method="post" action="/registration">
        <label for="username">Name:</label>
        <input type="text" id="name" name="username" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="phone">Phone:</label>
        <input type="tel" id="phone" name="phone" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <input type="hidden" name="_csrf" value="{{#_csrf}}{{_csrf.token}}{{/_csrf}}">

        <button type="submit">Submit</button>
    </form>

</div>
</@c.page>

