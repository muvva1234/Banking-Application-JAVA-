package BankApplication;

import java.sql.*;

public class TransactionProcess implements BankingImplementation {
	private String accountnumber;
	private String username;
	private String password;
	private int Amount = 1000; // Initial amount
	public int depositeAmount = 0;
	public int withdrawAmount = 0;
	public int Balance = 0;
	public int SNo = 0; // Serial number for database insertion

	{
		accountnumber = "8309992046";
		username = "suresh@123";
		password = "nanswe@123S";
	}

	// Method to deposit money
	@Override
	public void deposite(int depositamount) {
		System.out.println("Your deposited Amount is:" + depositamount);
		Amount = Amount + depositamount;
	}

	// Method to withdraw money
	@Override
	public void withdrawn(int withdrawAmount) {
		System.out.println("Your Withdrawn Amount is:" + withdrawAmount);
		Amount = Amount - withdrawAmount;
	}

	// Method to check account balance
	@Override
	public int balanceCheck() {
		System.out.println("Your Available Balance in your Account:" + Amount);
		return Amount;
	}

	// Method to retrieve account number
	@Override
	public void accountnumber() {
		System.out.println("Your Account Number is:" + accountnumber);
	}

	// Getter methods for password, username, amount, and account number
	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public int getAmount() {
		return Amount;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	// Method to insert transaction details into the database
	public void databaseConnectivity() {
		String Username1 = "root";
		String Password1 = "nanswe@123S";
		String URL = "jdbc:mysql://localhost:3306/bank";
		String sql = "insert into transastionDetailsOfCustomers(SNo, username, password, accountNumber, depositeAmount, withdrawAmount, Balance)values(?,?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, Username1, Password1);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, SNo);
			ps.setString(2, this.username);
			ps.setString(3, this.password);
			ps.setString(4, accountnumber);
			ps.setInt(5, depositeAmount);
			ps.setInt(6, withdrawAmount);
			ps.setInt(7, Balance);
			int rows = ps.executeUpdate();
			System.out.println(rows + " row affected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
