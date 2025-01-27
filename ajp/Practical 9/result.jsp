<%@ taglib prefix="custom" uri="/WEB-INF/tags.tld" %>

<html>
  <head>
    <title>Sorted Numbers</title>
  </head>
  <body>
    <h2>Sorted Numbers:</h2>

    <!-- Retrieve numbers and order from request attributes -->
    <custom:sortNumbers numbers="${numbers}" order="${order}" />
  </body>
</html>
