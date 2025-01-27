<!DOCTYPE html>
<html>
  <head>
    <title>User Login</title>
  </head>
  <body>
    <h2>Login Form</h2>
    <form action="LoginServlet" method="POST">
      <label for="username">Username: </label>
      <input type="text" name="username" id="username" required /><br /><br />

      <label for="password">Password: </label>
      <input
        type="password"
        name="password"
        id="password"
        required
      /><br /><br />

      <input type="submit" value="Login" />
    </form>
  </body>
</html>
