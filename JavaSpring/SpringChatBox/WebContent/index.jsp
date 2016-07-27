
<html>
  <head>  
  <style type="text/css">
      table, th, td {
    border: 1px solid black;
}

@media (min-width: 768px)
.col-md {
    float:left;
}
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
   
    <title>chat board</title>  

        
    <head>
    <body>
         <h1>
           Chat Room
        </h1> 
         <div style="width:32%; float: left;text-align: center; background-color:pink; height:90%"> 
            <form  action="register" method="post">
                <center><h3>Register</h3></center> <br>
                <label>User Name: </label><input type="text" name="username"></input><br><br>
                <label>Password: </label><input type="password" name="password" > </input> <br><br><br><br><br>
                <input type="submit" >
            </form>
        </div>
        <div style="width:32%; float: left; text-align: center; margin-left: 5px;background-color:lightgreen;height:90%"><form  action="login" method="post">
                <center><h3>Login</h3></center> <br>
                <label>User Name: </label><input type="text" name="username" ></input><br><br>
                <label>Password: </label><input type="password" name="password" > </input> <br><br><br><br><br>
                <input type="submit" >
            </form>
        </div>
        
        
        
        <div style="width:32%; float: left;text-align: center; background-color:skyblue; height:90%"> 
            <form  action="Admin" method="post">
                <center><h3>Register</h3></center> <br>
                <label>User Name: </label><input type="text" name="username" ></input><br><br>
                <label>Password: </label><input type="password" name="password" > </input> <br><br><br><br><br>
                <input type="submit" >
            </form>
        </div>
  </body>
</html>