<#import "parts/common.ftlh" as c>

<@c.page "Errors">
    <style>
        body {
            background-color: #b0c3c3;
            font-family: Arial, sans-serif;
        }

        h1 {
            color: #2f4858;
            font-size: 48px;
            text-align: center;
            margin-top: 100px;
        }

        p {
            font-size: 24px;
            text-align: center;
            margin-top: 50px;
            color: #2f4858;
        }

        a {
            display: block;
            font-size: 18px;
            text-align: center;
            margin-top: 50px;
            color: #e8f0f3;
            background-color: #2f4858;
            padding: 10px;
            border-radius: 5px;
            text-decoration: none;
            width: 200px;
            margin: 0 auto;
        }

        a:hover {
            background-color: #33658a;
        }
    </style>
</head>
<body>
<h1>Oops! An error occurred.</h1>
<p>Sorry, something went wrong. Please try again later.</p>
<a href="/">Go back home</a>
</@c.page>
