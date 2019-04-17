<html>
<body>
  <div id="main">
    <h2>Party Parrot 4 Ever</h2>
      <!-- the URL to the action is currently set for the live server. To test locally, change this back to http://localhost:8080/etc... -->
    <form enctype="application/x-www-form-urlencoded" action="http://52.14.41.110:8080/PartyParrot4Ever/services/parrots/parrots/" method="POST">
        <label>Name: </label><input name="name"><br />
        <label>Link: </label><input name="link"><br />
        <label>HD Link:</label><input name="hdLink"><br />
        <label>Category:</label><input name="category"><br />
        <input type="submit" value="Add Parrot">
    </form>
  </div>
</body>
</html>
