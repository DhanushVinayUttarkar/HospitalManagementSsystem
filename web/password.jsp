
<!DOCTYPE HTML>
<html>
<head>
<title>HMS</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/style.css" rel="stylesheet" media="all" />
<link href="css/login-box.css" rel="stylesheet" type="text/css"/>
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
      <script>
          function validate()
            {
                var name = document.myForm.dname.value;
                var pass = document.myForm.dpass.value;
                
                if(name == "" || name == null)
                {
                    alert("username is mandatory field");
                    return false;
                 }
                 
                 if(pass == "" || pass == null)
                 {
                     alert("password is mandatory field");
                     return false;
                 }
             }
      </script>
</head>
<body>
    <%
    session.invalidate();
    %>
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
        
        
        <form action="password" method="post" name="myForm" onsubmit="return validate()">
    <div id="login" style="padding: 50px 0 0 400px;">
<div id="login-box">

<div id="login-box-name" style="margin-top:20px;">
  
    Enter email:</div><div id="login-box-field" style="margin-top:20px;">
        <input type="email" name="dmail" class="form-login" title="Username" value="" size="30" maxlength="2048" /></div>
    
<br />

<br><button type="submit" name="Forgot password?" style="margin-left: 80px">Submit</button>
</div>

</div>
   </form><br>
   <br>
   
   <%@include file="footer.jsp" %>
</body>
</html>


