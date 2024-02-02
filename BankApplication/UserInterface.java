package BankApplication;

//Class for initiating the banking application
public class UserInterface {

	public static void main(String[] args) {
		BankingApplication BA = new BankingApplication();
		BA.process();
		BA.databaseConnectivity();

	}

}
