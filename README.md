This is a simple command line bank app written in java.  <br/>
<br/>
It is currently capable of: <br/>
- Generating a Bank Account (Name, Acct # (Random unique 10 digit #), Initial Balance)
- Storing the Bank Account information and any balance update in a JSON file via Jackson
- Authentication token system, Accounts can only be accessed with their unique account number
- Deposit funds
- Withdraw funds
- Has several pre-generated bank accounts in JSON_Data, the code to read/write
  JSON may have to be updated for your file location
