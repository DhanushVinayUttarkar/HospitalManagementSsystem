
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HMS</title>
        <link href="css/style.css" rel="stylesheet" media="all" />
        <link href="css/registration-style.css" rel="stylesheet" type="text/css"/>


        <script>
            function validateform()
            {
                alert("Registered Successfully");


                var pname = document.myForm.username.value;
                var ppass = document.myForm.password.value;
                var pdept = document.myForm.dept.value;
                var pphone = document.myForm.phone.value;
                var pemail = document.myForm.uemail.value;

                 if (pname == "" || pname == null)
                {
                    alert("pleas enter the name");
                    return false;
                }

                if (ppass == "" || ppass == null)
                {
                    alert("pleas enter the password");
                    return false;
                }

                if (pdept == "" || pdept == null)
                {
                    alert("pleas enter the Department");
                    return false;
                }

                if (pphone == "" || pphone == null)
                {
                    alert("pleas enter the Phone-Number");
                    return false;
                }
                else if (pphone.length < 10 || pphone.length > 10)
                {
                    alert("not a valid phone number");
                    return false;
                }

                if (pemail == "" || pemail == null)
                {
                    alert("pleas enter the email");
                    return false;
                }
            }
        </script>

    </head>

    <body>
        <%
    session.invalidate();
    %>
        <script>
            function validate() {
                alert("Registered Successfully");

                var name = document.myForm.username.value;


                alert(name);
            }
        </script>
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
                        <li><a href="registration.jsp">Registration</a></li>
                         <li><a href="Plogin.jsp">Patient </a></li>
                        <li><a href="PReg.jsp">Registration</a></li>
                    </ul>      
                </div>
                <div class="clear"></div>
            </div>
        </div>


        <div style="width: 900px; background-image:url(../images/pattern_bg1.gif);  margin: -20px auto 0px;">

            <div class="login" >
                <div class="login-screen">
                    <div class="app-title">
                        <h1 style="color: #2980B9">REGISTRATION</h1>
                    </div>
                    <!---->
                    <form action="Preg" method="post" name="myForm" onsubmit="return validateform()">
                        <div class="login-form">
                            <div class="control-group">
                                <input type="text" class="login-field" name="pusername" placeholder="username" id="username" >
                                <label class="login-field-icon fui-user" for="login-name"></label>
                            </div>
                            <div class="control-group">
                                <input type="password" class="login-field" name="ppassword" placeholder="password" id="password" >
                                <label class="login-field-icon fui-lock" for="login-pass"></label>
                            </div>
<!--                            <div class="control-group">
                                <input type="text" class="login-field" name="pdept" placeholder="department" id="dept" >
                                <label class="login-field-icon fui-lock" for="login-pass"></label>
                            </div>-->

                            <div class="control-group">
                                <input type="number" class="login-field" name="pphone" placeholder="phone" id="phone" >
                                <label class="login-field-icon fui-lock" for="login-pass"></label>
                            </div>
                            <div class="control-group">
                                <input type="email" class="login-field" name="puemail" placeholder="e-mail" id="uemail" >
                                <label class="login-field-icon fui-lock" for="login-pass"></label>
                            </div>

                            <input type="submit" value="Register" class="btn btn-primary btn-large btn-block"><br>
                            <input type="reset" value="Clear" class="btn btn-primary btn-large btn-block">
                        </div>
                    </form>
                </div>
            </div>

        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
