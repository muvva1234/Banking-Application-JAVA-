package BankApplication;

public interface BankingImplementation {
	// Method to deposit money
	public abstract void deposite(int depositeamount);

	// Method to withdraw money
	public abstract void withdrawn(int withdrawAmount);

	// Method to check account balance
	public abstract int balanceCheck();

	// Method to retrieve account number
	public abstract void accountnumber();
}
