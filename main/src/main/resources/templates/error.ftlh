<#import "parts/common.ftlh" as c>

<@c.page "Errors">
    <style>

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
            /*
            color: #2f4858;
            */
        }

        .custom-link {
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

        .custom-link:hover {
            color: #dcecd7;
            background-color: #2e4f45;
        }
    </style>
</head>
<body>
<h1>Oops! An error occurred.</h1>
<p>Sorry, something went wrong. Please try again later.</p>
<a class="custom-link" href="/">Go back home</a>
</@c.page>
