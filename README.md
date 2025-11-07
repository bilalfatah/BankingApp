🏦 Console-Based Banking Application

This is a simple Java console application developed to practice Object-Oriented Programming (OOP) principles and secure database interaction using Java Database Connectivity (JDBC).

✨ Features

Account Creation: Create a new user account (Name, Email, Mobile).
Initial Deposit: Record an initial balance upon account creation.
Withdrawal: Safely subtracts funds from the account balance.
Data Integrity: Implements JDBC Transactions  to ensure deposits and withdrawals either fully succeed or fully fail.
Robust Error Handling: Catches specific SQL exceptions (e.g., `Duplicate Email`) to provide user-friendly feedback.



🛠️ Technology Stack

Language: Java (JDK 8+)
Database: MySQL
Connectivity: JDBC
IDE: Eclipse


🚀 Setup and Installation

  1. Database Setup

1.  Ensure you have a running MySQL instance.
2.  Create the database (e.g., `bankingapp`).
3.  Run the following SQL commands to set up the necessary tables:

    ```sql
    -- Create the Account Table
    CREATE TABLE account (
        id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(255) NOT NULL,
        email VARCHAR(255) UNIQUE,
        mobile VARCHAR(20),
        amount DECIMAL(10, 2) NOT NULL DEFAULT 0.00
    );
    ```

   2. Project Configuration

1.  Clone this repository to your local machine.
2.  Open the project in Eclipse.
3.  Add the MySQL Connector/J JAR file to your project's Build Path.
4.  Update the connection details (URL, Username, Password) in the `Conn.java` file to match your local database configuration.

   3. Running the Application

1.  Run the `Main.java` class.
2.  Follow the on-screen console menu options (Press 1 to Create Account, 4 to Withdraw, etc.).


🤝 Contact

Feel free to connect or provide feedback!

[GitHub Profile](https://github.com/bilalfatah)
