<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jen's First JSP</title>

    <link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />
	<link href='http://fonts.googleapis.com/css?family=Roboto+Condensed' rel='stylesheet' type='text/css' />

</head>
<body>

    <div class="wrapper">

        <header id="header">

            <nav id="headerlinks">
                <a href="/java112" title="Portfolio">Home</a>
            </nav>

            <h1>Jen's First (Real) JSP</h1>
        </header>
    
        <main id="content">

            <img width="250px" src="images/cat.jpg" 
                    alt="A white and tabby cat peeking out from a basket.">

            <%= new java.util.Date() %> 

        </main>
    
        <footer id="footer">
            <div style="float: right;">
            <a href="#" title="Contact Us"><img src="images/contact.gif" alt="Contact" /></a>
            <a href="#" title="Sitemap"><img src="images/sitemap.gif" alt="Sitemap" /></a>
            <a href="#" title="Rss Feed"><img src="images/rss.png" alt="Rss Feed" /></a>
            </div>
            Theme #4 &copy; 2013 | <!-- You can use it for practically any personal or commercial use so long as you keep our footer credit links intact. -->Theme by <a target="_blank" href="http://codingdev.de" title="CodingDev">CodingDev</a>
        </footer>

    </div>

    
</body>
</html>