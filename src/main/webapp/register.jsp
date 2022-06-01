<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  
    
    import ="com.controller.RegisterServlet"
    import ="com.service.Services"
    
    
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
    <div class="container">
        <div class="row">
            <div class="col-1"></div>
            <div class="col-8">
                <div class="card mag">
                    <div class="row mt-4 ml-5">
                        <div class="col  text-primary">
                            <h5>Google</h5>
                        </div>   
                    </div>
                    <div class="row ml-5">
                        <div class="col ">
                            <h4>Create Your Google Account</h4>
                        </div>   
                    </div>
                    <div class="row ml-5 mt-1">
                        <div class="col text-secondary">
                            <h6>to continue to Gmail</h6>
                        </div>   
                    </div>
                    <div class="row mt-3">
                        <div class="col-1"></div>
                        <div class="col-10">
                            <form action="register" method="post">
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="First Name" name="fName" required>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Last Name" name="lName" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control" placeholder="Username@gmail.com" name="email" pattern="[^@]+@[^@]+\.[a-zA-Z]{2,6}">
                                </div>

                                <div class="row">
                                    <div class="col-4">
                                        <div class="form-group">
                                            <input type="number" class="form-control" placeholder="Enter Birth Year" name="dYear" value="dob" required>
                                        </div>
                                    </div>
                                    <div class="col-4">
                                        <div class="form-group">
                                            <select class="form-control" name="dMonth" required>
                                                <option selected disabled>Select Month</option>
                                                <option>January</option>
                                                <option>February</option>
                                                <option>March</option>
                                                <option>April</option>
                                                <option>May</option>
                                                <option>June</option>
                                                <option>July</option>
                                                <option>August</option>
                                                <option>Septemfa-border</option>
                                                <option>October</option>
                                                <option>November</option>
                                                <option>December</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-4">
                                        <div class="form-group">
                                            <input type="number" class="form-control" placeholder="Enter Date" name="dDay" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group mb-4">
                                            <select class="form-control" name="gender" required>
                                                <option selected disabled>Select Gender</option>
                                                <option>Male</option>
                                                <option>Female</option>
                                                <option>Other</option>
                                            </select>
                                        </div> 
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group mb-4">
                                           <input type="number" class="form-control" placeholder="Contact Number" name="conNo" required> 
                                        </div> 
                                    </div>
                                    
                                </div>
                                <div class="row">
                                    <div class="col-6">
                                        <div class="form-group">
                                            <input type="password" class="form-control" placeholder="Password" name="pass" required>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <input type="password" class="form-control" placeholder="Confirm Password" name="comPass" required>
                                        </div>
                                    </div>
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
                                            <input type="submit" class="form-control btn-primary" value="Register">
                                        </div>
                                    </div>
                                    <div class="col-3">
                                        <div class="btn-group">
                                            <a href="login.html"><button type="button" class="form-control btn-success">Login</button></a>
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