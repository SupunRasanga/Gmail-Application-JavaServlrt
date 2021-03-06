<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    import = "com.dto.UserDTO"
   	import = "com.controller.LoginServlet"
 %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="styles.css">
    <title>Login</title>
</head>
<body>
    <div class="container">
        <div class="row">
        <div class="col-3"></div>
        
        <div class="col-6 mag">
            <div class="card">
                <div class="row mt-4">
                    <div class="col text-center text-primary">
                        <h2>Google</h2>
                    </div>   
                </div>
                <div class="row">
                    <div class=" col text-center text-success">
                        <h4>Sign in</h4>
                    </div>   
                </div>
                <div class="row">
                    <div class=" col text-center text-secondary">
                        <h6>to Continue to Gmail</h6>
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-1"></div>
                    <div class="col-10">
                        <form action="login" method="post" class="needs-validation">
                            <div class="form-group has-validation">
                          
                                <%
				            		if(request.getAttribute("email") != null){
				            		%>
					         		<!-- status model starts here -->
					         		<input type="email" class="form-control is-invalid" placeholder="Enter Email Address" name="email" required>
									<div class="invalid-feedback">
								     <% out.print(request.getAttribute("email")); %>
								    </div>
									<!-- status model ends here -->
									<%
				            			}else{
									%>
									<!-- status model starts here -->
					         		<input type="email" class="form-control" value="<% if(request.getAttribute("emailC") != null){ out.println(request.getAttribute("emailC")); }%>" placeholder="Enter Email Address" name="email" required>								
									<!-- status model ends here -->
									
									<% }
                                %>
                            </div>
                            
                            
                            <div class="form-group has-validation mb-4">
                                
                                <%
				            		if(request.getAttribute("password") != null){
				            		%>
					         		<!-- status model starts here -->
					         		<input type="password" class="form-control is-invalid" placeholder="Enter Password" name="pass" required>
									<div class="invalid-feedback">
								     <% out.print(request.getAttribute("password")); %>
								    </div>
									<!-- status model ends here -->
									<%
				            			}else{
									%>
									<!-- status model starts here -->
					         		<input type="password" class="form-control" placeholder="Enter Password" name="pass" required>					
									<!-- status model ends here -->
									
									<% } %>
                            </div>

                            <div class="row mb-4">
                                <div class="col">
                                    <p class=" text-center">Not your computer? Use Guest mode to sign in privately
                                        <a href="#" class="text-warning ml-4">Learn more</a>
                                    </p>
                                </div>
                            </div>

                            

                             <div class="row mb-4">
                                 <div class="col-3"></div>
                                <div class="col-3">
                                    <div class="btn-group">
                                        <a href="register.jsp"><button type="button" class="form-control btn-primary">Sign up</button></a>
                                    </div>
                                </div>
                                <div class="col-3">
                                    <div class="btn-group">
                                        <input type="submit" class="form-control btn-success" value="Login">
                                    </div>
                                </div>
                             </div>   
                        </form>
                    </div>
                    <div class="col-1"></div>
    
                </div>
            </div>
         </div>
        </div>
            
    </div>
    
</body>
</html>