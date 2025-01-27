<!DOCTYPE html>
<html>
  <head>
    <title>Bank Account Information</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f4f7fc;
        margin: 0;
        padding: 0;
      }
      .container {
        max-width: 500px;
        margin: 50px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      }
      h2 {
        text-align: center;
        color: #333;
      }
      .input-group {
        margin-bottom: 20px;
      }
      .input-group label {
        font-size: 14px;
        color: #333;
      }
      .input-group input {
        width: 100%;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 4px;
        font-size: 16px;
      }
      .input-group input:focus {
        border-color: #007bff;
        outline: none;
      }
      .btn {
        width: 100%;
        padding: 12px;
        background-color: #007bff;
        border: none;
        border-radius: 4px;
        color: #fff;
        font-size: 16px;
        cursor: pointer;
      }
      .btn:hover {
        background-color: #0056b3;
      }
      .message {
        text-align: center;
        font-size: 16px;
        color: #007bff;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h2>Bank Account Information</h2>

      <form action="BankServlet" method="POST">
        <div class="input-group">
          <label for="deposit">Deposit Amount:</label>
          <input type="number" name="deposit" id="deposit" value="0" />
        </div>

        <div class="input-group">
          <label for="withdraw">Withdraw Amount:</label>
          <input type="number" name="withdraw" id="withdraw" value="0" />
        </div>

        <button type="submit" class="btn">Submit</button>
      </form>

      <div class="message">
        <h3>Account Balance: Rs ${account.balance}</h3>
        <p>Account Number: ${account.accountNumber}</p>
      </div>
    </div>
  </body>
</html>
