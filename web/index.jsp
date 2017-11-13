

<!DOCTYPE HTML>
<html>
<head>
<title>HMS</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/style.css" rel="stylesheet" media="all" />
<link rel="stylesheet" href="css/bjqs.css">
<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script src="js/bjqs-1.3.min.js"></script>
<script src="js/libs/jquery.secret-source.min.js"></script>
	<script>
    jQuery(function($) {

        $('.secret-source').secretSource({
            includeTag: false
        });

    });
    </script>
    <script class="secret-source">
        jQuery(document).ready(function($) {

          $('#banner-fade').bjqs({
            height      : 400,
            width       :1000,
            responsive  : true
          });

        });
      </script>
</head>
<body>
<div class="header-bg">
<div class="wrap">
	<div class="logo">
  		<a href="index.jsp"><img src="images/logo.png" alt=""> </a>
 	</div>
	
   <div class="clear"></div>
</div>
</div>
	<div class="clear"></div>
<div class="nav1-bg">
<div class="wrap">
	<div class="nav"> 
 	<ul>
 		<li class="active"><a href="index.jsp">Home</a></li>
 		<li><a href="adminlogin.jsp">Admin </a></li>
 		<li><a href="doctorlogin.jsp">Doctor </a></li>
                <li><a href="registration.jsp">Registration </a></li>
                <li><a href="Plogin.jsp">Patient </a></li>
                <li><a href="PReg.jsp">Registration</a></li>
 		
 	</ul>      
  	</div>
  	<div class="clear"></div>
</div>
</div>
	<div class="clear"></div>
<div class="body-content">
<div class="wrap">
	<div class="slider">
	<div id="container">
 	<div id="banner-fade">
      <ul class="bjqs">
      <li><img src="img/slide1.jpg" alt="" title="Hospital Management System helps patients to know about their diseases"></li>
      <li><img src="img/slide2.jpg" alt="" title="Information regarding the disease helps to take some precautionary actions"></li>
      <li><img src="img/slide3.jpg" alt="" title="Health care for better treatment, WE ARE WITH YOU"></li>
      </ul>
    </div>
	</div>
	</div>
<div class="content-main">
	<div class="grid-a">
	<ul>
	<li><img src="images/pic1.jpg" alt=""></li>
	<li><h5>natural resources</h5></li>
	<li><p>The Hospital Management System is based on visual examination. He/she describes the illness by its physical symptoms, providing important indications of the illness.</p></li>
	</ul>
    
    </div>
	<div class="grid-a">
	<ul>
	<li><img src="images/pic3.jpg" alt=""></li>
	<li><h5>Our services</h5></li>
	<li><p>HMS providing best report and suggestion to patient, connecting patient and doctor, providing fast information as soon as possible. </p></li>
	</ul>
	
	</div>
	<div class="grid-r">
	<ul>
	<li><img src="images/pic4.jpg" alt=""></li>
	<li><h5>Project flow</h5></li>
	<li><p>HMS helps you keep a personal contact with your doctor you can send details and symptoms about your illness and recieve a constultation for it with a prescription</p></li>
	</ul>
	
	</div>
	<div class="clear"></div>
</div>			

</div>
</div>
	<div class="clear"></div>
        
        <%@include file="footer.jsp" %>
</body>
</html>
