import java.util.Scanner;

public class InvestingCalculator {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter your current age: ");
        int currentAge = scnr.nextInt();

        System.out.print("Enter your starting balance: ");
        double initialBalance = scnr.nextDouble();

        System.out.print("Enter your desired retirement age: ");
        int retireToAge = scnr.nextInt();

        System.out.print("Enter your desired balance at retirement: ");
        double retireBalance = scnr.nextDouble();

        System.out.print("Enter your projected annual return in percent: ");
        double annualRate = scnr.nextDouble();

        double yearStart = initialBalance;
        double yearEnd = 0.00;
        double interest;
        double extra = 0.00;

        while (yearStart <= retireBalance) {

            extra = extra + 0.01;

            yearStart = initialBalance;

            for (int i = currentAge; i <= retireToAge; i++) {

                interest = yearStart * (annualRate / 100);

                yearEnd =  yearStart + interest + extra;

                yearStart = yearEnd;
            }

            if (yearEnd == retireBalance) {
                break;
            }
        }

        System.out.println("Extra is " + extra);

        // print projected growth with attained extra
        System.out.println("Projected growth: ");
        System.out.println("-----------------");
        System.out.println("Age\t\t Start\t\t Interest\t    Extra\t\t\t     End");

        yearStart = initialBalance;
        for (int i = currentAge; i <= retireToAge; i++) {
            interest = yearStart * (annualRate / 100);
            yearEnd =  yearStart + interest + extra;
            yearStart = yearEnd;
            System.out.format("%3d\t$%12.2f\t$%12.2f\t$%12.2f\t$%12.2f\n", i, yearStart, interest, extra, yearEnd);
        }

    }
}
