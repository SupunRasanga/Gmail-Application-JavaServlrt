<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  
    
    import ="com.controller.RegisterServlet"
    import ="com.service.Services"
	import = "com.dto.UserDTO"
    
    %>

   
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="styles.css">
    <title>Register</title>
</head>
<body>
	<% UserDTO ud = new UserDTO(); %>
    <div class="container">
        <div class="row">
            <div class="col-1"></div>
            <div class="col-10">
                <div class="card mag">
                   <div class="container">
                    <div class="row mt-5">
                        <div class="col  text-primary">
                            <h5>Google</h5>
                        </div>   
                    </div>
                    <div class="row">
                        <div class="col ">
                            <h4>Create Your Google Account</h4>
                        </div>   
                    </div>
                    <div class="row mt-1">
                        <div class="col text-secondary">
                            <h6>to continue to Gmail</h6>
                        </div>   
                    </div>
                    <div class="row mt-3">
                       
                        <div class="col-12">
                            <form action="register" method="post">
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="First Name" name="fName" 
                                            value="<% if(request.getAttribute("fName") != null){ out.println(request.getAttribute("fName")); }%>" required>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Last Name" name="lName" 
                                            value="<% if(request.getAttribute("lName") != null){ out.println(request.getAttribute("lName")); }%>" required>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                	<div class="col-6">
	                                	<div class="form-group has-validation">
	                                		<div class="input-group">
			                                    
			                                    
			                                     <%
								            		if(request.getAttribute("emailS") != null){
								            		%>
									         		<!-- status model starts here -->
									         		<input type="text" class="form-control is-invalid" placeholder="User Name" name="email" required>
									         		<div class="input-group-append">
													<div class="input-group-text">@gmail.com</div>
													</div>
													<div class="invalid-feedback">
												     <% out.print(request.getAttribute("emailS")); %>
												    </div>
													<!-- status model ends here -->
													<%
								            			}else{
													%>
													<!-- status model starts here -->
									         		<input type="text" class="form-control" 
									         		value="<% if(request.getAttribute("emailC") != null){ out.println(request.getAttribute("emailC")); }%>" placeholder="User Name" name="email" required>	
									         		<div class="input-group-append">
													<div class="input-group-text">@gmail.com</div>
													</div>							
													<!-- status model ends here -->
													
													<% }
				                                %>

											</div>
	                                	</div>
                                	</div>
                                	
                                	<div class="col-6">
                                		<div class="form-group">
                                            <input type="text" class="form-control" placeholder="Date Of Birth" name="dob" onfocus="(this.type='date')" id="date" 
                                            value="<% if(request.getAttribute("dob") != null){ out.println(request.getAttribute("dob")); }%>"  required>
                                        </div>
                                	</div>
                                </div>

                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group mb-4 has-validation">
                                        	 <%
							            		if(request.getAttribute("genderS") != null){
							            		%>
                                            <select class="form-control is-invalid" name="gender" required>
                                                <option selected disabled>Select Gender</option>
                                                <option>Male</option>
                                                <option>Female</option>
                                                <option>Other</option>
                                            </select> 
                                            <div class="invalid-feedback">
											     <% out.print(request.getAttribute("genderS")); %>
											    </div>
												<!-- status model ends here -->
												<%
							            			}else{
												%>
												<select class="form-control" name="gender" required>
                                                <option selected disabled>Select Gender</option>
                                                <option>Male</option>
                                                <option>Female</option>
                                                <option>Other</option>
                                            </select> 
                                            <%
	            		}
					%>
                                        </div> 
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group mb-4">
                                           <input type="text" class="form-control" placeholder="Contact Number" name="conNo" 
                                           value="<% if(request.getAttribute("conNo") != null){ out.println(request.getAttribute("conNo")); }%>" required > 
                                        </div> 
                                    </div>
                                    
                                </div>
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group has-validation">
                                            
                                            <%
							            		if(request.getAttribute("password") != null){
							            		%>
								         		<!-- status model starts here -->
								         		<input type="password" class="form-control is-invalid" placeholder="Password" name="pass" required>
												<div class="invalid-feedback">
											     <% out.print(request.getAttribute("password")); %>
											    </div>
												<!-- status model ends here -->
												<%
							            			}else{
												%>
												<!-- status model starts here -->
								         		<input type="password" class="form-control" placeholder="Password" name="pass" value="<% if(request.getAttribute("passwordC") != null){ out.println(request.getAttribute("passwordC")); }%>" required>
												<!-- status model ends here -->
									
										<% } %>
                                            
                                            
                                            
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group has-validation">

                                          <%
							            		if(request.getAttribute("password") != null){
							            		%>
								         		<!-- status model starts here -->
								         		<input type="password" class="form-control is-invalid" placeholder="Confirm Password" name="comPass" required>
												<div class="invalid-feedback">
											     <% out.print(request.getAttribute("password")); %>
											    </div>
												<!-- status model ends here -->
												<%
							            			}else{
												%>
												<!-- status model starts here -->
								         		<input type="password" class="form-control" placeholder="Confirm Password" name="comPass" value="<% if(request.getAttribute("passwordC") != null){ out.println(request.getAttribute("passwordC")); }%>" required>
												<!-- status model ends here -->
									
					<%
	            		}
					%>
								
										</div>
                                    </div>
                                </div>

                                 <div class="row mb-5 mt-3">
                                     <div class="col-5"></div>
                                    <div class="col-2">
                                        <div class="btn-group">
                                            <input type="submit" class="form-control btn-primary mr-3" value="Register">
                                            <a href="login.jsp"><button type="button" class="form-control btn-success">Login</button></a>
                                        </div>
                                    </div>
                                 </div>   
                            </form>
	            		
                            
                        	</div>
                   		 </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</body>
</html>