package BankApplication;

import java.util.Scanner;

public class BankingApplication extends TransactionProcess {
	// Warning message for invalid amount format
	public static void worning() {
		System.out.println("your Entered invalid Amount Format,Check properly Do it Again");
	}

	// Farewell message
	public static void lastWishes() {
		System.out.println("THANK YOU FOR VISIT,HAVE A NICE DAY");
	}

	// Prompt for decision to continue the process
	public static void decisionWorning() {
		System.out.print("if you want to continue the process press 'yes' or 'Y',otherwise press 'no':");
	}

	// Warning for verification
	public static void verificationWorning() {
		System.out.print("invalid,if you want to continue the process press 'yes' or 'Y',otherwise press 'no':");
	}

	// Main method to initiate the banking process
	public void process() {
		super.SNo = 0;
		TransactionProcess tp = new TransactionProcess();
		Scanner sc = new Scanner(System.in);
		boolean passw = true;
		boolean decision = false;
		int DAmount = 0;
		int Dwithdraw = 0;
		boolean loggedIn = false;
		boolean loggedIn1 = false;
		int verficationvalidity = 0;
		final int limit = 3;
		do {
			SNo++;
			System.out.print("Enter the Account Number:");
			String acc = sc.nextLine();
			String[] pass = acc.split("");
			if (acc.equals(tp.getAccountnumber())) {
				passw = false;
			}
			if (passw) {
				for (int j = 0; j < pass.length; j++) {
					for (int i = 65; i <= 122; i++) {
						String[] stringArray = new String[] { String.valueOf((char) i) };
						int count = 0;
						if (pass[j].equals(stringArray[count])) {
							passw = true;
							break;
						}
						++count;
					}

				}
			}
			if (!acc.equals(tp.getAccountnumber()) || passw) {
				verficationvalidity++;
				BankingApplication.verificationWorning();
				String acc1 = sc.nextLine();
				if (acc1.equalsIgnoreCase("yes") || acc1.equalsIgnoreCase("y")) {
					loggedIn = false;
				} else if (acc1.equalsIgnoreCase("no") || acc1.equalsIgnoreCase("n")) {
					lastWishes();
					loggedIn = true;

				}

			} else {
				System.out.print("Enter the username:");
				String user = sc.nextLine();
				if (!user.equalsIgnoreCase(tp.getUsername())) {
					verficationvalidity++;
					BankingApplication.verificationWorning();
					String user1 = sc.nextLine();
					if (user1.equalsIgnoreCase("yes") || user1.equalsIgnoreCase("y")) {
						loggedIn = false;
					} else if (user1.equalsIgnoreCase("no") || user1.equalsIgnoreCase("n")) {
						lastWishes();
						loggedIn = true;

					}

				} else {
					System.out.print("Enter the password:");
					String pas = sc.nextLine();
					if (!pas.equalsIgnoreCase(tp.getPassword())) {
						verficationvalidity++;
						BankingApplication.verificationWorning();
						String pas1 = sc.nextLine();
						if (pas1.equalsIgnoreCase("yes") || pas1.equalsIgnoreCase("y")) {
							loggedIn = false;
						} else if (pas1.equalsIgnoreCase("no") || pas1.equalsIgnoreCase("n")) {
							lastWishes();
							loggedIn = true;

						}

					}
					if (user.equalsIgnoreCase(tp.getUsername()) && pas.equalsIgnoreCase(tp.getPassword())
							&& acc.equals(tp.getAccountnumber())) {
						System.out.println("LOGIN SUCCESSFULLY");
						System.out.println("***" + "WELCOME TO ICICI BANK" + "**");
						loggedIn = true;
						decision = true;
					}

				}
			}
			if (verficationvalidity >= limit) {
				System.out.println("Maximum login attempts reached,Try after sometime");
				lastWishes();
				loggedIn = true;
			}

		} while (!loggedIn);
		if (decision) {
			String choice = null;

			do {
				System.out.println("choose the option:");
				System.out.println("1.Deposit" + '\n' + "2.Withdrawn" + "\n" + "3.Balance Check" + '\n'
						+ "4.Get Your Account Number" + '\n' + "5.Exit");
				int option = sc.nextInt();
				if (option < 1 || option > 5) {
					System.out.println("invalid Details");
					loggedIn1 = false;
				} else if (option >= 1 && option <= 5) {

					switch (option) {
					case 1:
						System.out.print("Enter your deposit Amount:");
						String depositeamount = sc.next();
						depositeAmount = Integer.parseInt(depositeamount);
						boolean validation = false;
						for (int i = 0; i < depositeamount.length(); i++) {
							char ch = depositeamount.charAt(i);
							if (!Character.isAlphabetic(ch) && !Character.isLetterOrDigit(ch)) {
								validation = true;
								break;
							}
						}
						if (validation == false) {
							String[] str = depositeamount.split("");
							boolean flag1 = false;
							boolean flag2 = true;
							for (int j = 0; j < str.length; j++) {
								for (int i = 65; i <= 122; i++) {
									String[] stringArray = new String[] { String.valueOf((char) i) };
									int count = 0;
									if (str[j].equals(stringArray[count])) {
										flag1 = true;
										break;
									}
									++count;
								}

							}

							if (flag1 == false) {
								DAmount = Integer.parseInt(depositeamount);
								flag2 = false;
							}

							if (flag2 || flag1) {
								BankingApplication.worning();
								break;
							} else if (DAmount < 0)
								BankingApplication.worning();
							else {
								tp.deposite(DAmount);
							}
						} else {
							BankingApplication.worning();
						}
						break;

					case 2:
						System.out.print("Enter your withdrawn Amount:");
						String withdrawnamount = sc.next();
						withdrawAmount = Integer.parseInt(withdrawnamount);
						boolean validation1 = false;
						for (int i = 0; i < withdrawnamount.length(); i++) {
							char ch = withdrawnamount.charAt(i);
							if (!Character.isAlphabetic(ch) && !Character.isLetterOrDigit(ch)) {
								validation1 = true;
								break;
							}
						}

						if (validation1 == false) {
							String[] str1 = withdrawnamount.split("");
							boolean flag3 = false;
							boolean flag4 = true;
							for (int j = 0; j < str1.length; j++) {
								for (int i = 65; i <= 122; i++) {
									String[] stringArray = new String[] { String.valueOf((char) i) };
									int count = 0;
									if (str1[j].equals(stringArray[count])) {
										flag3 = true;
										break;
									}
									++count;
								}

							}
							if (flag3 == false) {
								Dwithdraw = Integer.parseInt(withdrawnamount);
								flag4 = false;
							}
							if (flag3 || flag4) {
								BankingApplication.worning();
								break;
							}
							if (Dwithdraw < 0)
								BankingApplication.worning();

							else {
								if (Dwithdraw > tp.getAmount()) {
									System.out.println(
											"you have insufficient balance in your Bank Account to withdraw,currently your account has "
													+ tp.getAmount() + " Rupees");
									break;
								} else {
									tp.withdrawn(Dwithdraw);
								}
							}
						} else {
							BankingApplication.worning();
						}
						break;
					case 3:
						super.Balance = tp.balanceCheck();
						break;
					case 4:
						tp.accountnumber();
						break;
					case 5:
						BankingApplication.lastWishes();
						return;
					}
				}
				BankingApplication.decisionWorning();
				choice = sc.next();
				if (choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("n")) {
					break;
				}

			} while ((choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) || !loggedIn1);

			BankingApplication.lastWishes();

		}

	}

}
