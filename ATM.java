import java.util.Scanner;  // ye line zaroori hai

public class ATM {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Sample Data (arrays)
        int accountNumbers[] = {101, 102, 103};
        int pins[] = {1111, 2222, 3333};
        int balances[] = {5000, 10000, 7500};
        int n = accountNumbers.length;

        System.out.println("--- Welcome To Sarty ATM Machine ---");

        // Step 1: Login
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Pin: ");
        int pin = sc.nextInt();

        int userIndex = -1;  // fixed (small 'u')
        for (int i = 0; i < n; i++) {
            if (accountNumbers[i] == accNo && pins[i] == pin) {
                userIndex = i;  // fixed (same small 'u')
                break;
            }
        }

        if (userIndex == -1) {
            System.out.println(" Invalid Account Number or PIN!!!");
            return; // Program exit
        }

        System.out.println("✅ Login Successful!\n");

        // Step 2: Menu
        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(" Current Balance: " + balances[userIndex]);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    int deposit = sc.nextInt();
                    balances[userIndex] += deposit;
                    System.out.println(" Deposited! New Balance: " + balances[userIndex]);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    int withdraw = sc.nextInt();
                    if (withdraw <= balances[userIndex]) {
                        balances[userIndex] -= withdraw;
                        System.out.println(" Withdraw Successful! New Balance: " + balances[userIndex]);
                    } else {
                        System.out.println(" Insufficient Balance!!");
                    }
                    break;

                case 4:
                    System.out.println(" Thank you for using Sarty ATM!!");
                    return;

                default:
                    System.out.println(" Invalid Choice!!");
            }
        }
    }
}
