<!DOCTYPE html>
<html>
  <head>
    <title>Enter Numbers</title>
  </head>
  <body>
    <h2>Enter Numbers to Sort</h2>

    <!-- Form to input numbers and sorting order -->
    <form action="SortServlet" method="POST">
      <label for="numbers">Enter numbers (comma-separated):</label><br />
      <input type="text" name="numbers" id="numbers" required /><br /><br />

      <label for="order">Sort order:</label><br />
      <select name="order" id="order">
        <option value="asc">Ascending</option>
        <option value="desc">Descending</option></select
      ><br /><br />

      <input type="submit" value="Sort Numbers" />
    </form>
  </body>
</html>
