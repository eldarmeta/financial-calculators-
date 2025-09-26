import java.util.Scanner;

public class calculator2 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);

        System.out.println("====== Future value calculator ======");

        System.out.print("Please enter how much are you going to deposit: ");
        double deposit = scanner.nextDouble();
        System.out.println("---------------------------");
        System.out.print("Please enter your interest rate %: ");
        double interestRate = scanner.nextDouble();
        System.out.println("---------------------------");
        System.out.print("Please enter your deposit length years: ");
        int years = scanner.nextInt();
        int numberOfMonth = years * 12;

        double dailyRate = (interestRate / 100) / 365;
        double futureValue = deposit * Math.pow(1 + dailyRate, years * 365);
        double totalInterest = futureValue - deposit;

        System.out.printf("Total interest earned: %.2f \n", totalInterest);
        System.out.printf("Your CD future value is: %.2f \n", futureValue);
    }
}
