package payroll.interfaces;

import javax.swing.*;

/**
 * Simulates the data input process for a commissioned employee.
 */
public class CommissionedEmpSim extends EmployeeSimulator {
    public CommissionedEmpSim() {}

    /**
     * Prompts the user to enter the commission percentage.
     * @return The commission percentage entered by the user.
     */
    public double getCommissionPercent() {
        double commissionPercent;

        while (true) {
            String input = JOptionPane.showInputDialog("Enter Commission Percentage (%): ");

            if (input == null) {
                return -1;
            }

            try {
                commissionPercent = Double.parseDouble(input);

                if (commissionPercent >= 0 && commissionPercent <= 100) {
                    break;
                }

                this.raiseError(
                        "Invalid input. Commission percentage must be a non-negative value and not more than 100.",
                        "Invalid input for commission percent!");

            } catch (NumberFormatException e) {
                this.raiseError(
                        "Invalid input. Please enter a valid numeric value for commission percentage.",
                        "Invalid input for commission percent!");
            }
        }

        return commissionPercent;
    }

    /**
     * Prompts the user to enter the number of sales.
     * @return The number of sales entered by the user.
     */
    public int getNumberOfSales() {
        int numberOfSales;

        while (true) {
            String input = JOptionPane.showInputDialog("Enter Number of Sales: ");

            if (input == null) {
                return -1;
            }

            try {
                numberOfSales = Integer.parseInt(input);

                if (numberOfSales >= 0) {
                    break;
                }

                this.raiseError(
                        "Invalid input. Number of sales must be a non-negative value.",
                        "Invalid number of sales!");

            } catch (NumberFormatException e) {
                this.raiseError(
                        "Invalid input. Please enter a valid numeric value for number of sales.",
                        "Invalid input for the number of sales!");
            }
        }

        return numberOfSales;
    }

    /**
     * Prompts the user to enter the sales amounts.
     * @param numberOfSales The number of sales for which to enter amounts.
     * @return An array containing the sales amounts entered by the user.
     */
    public double[] getSales(int numberOfSales) {
        double[] sales = new double[numberOfSales];

        for (int i = 0; i < numberOfSales; i++) {

            while (true) {

                String input = JOptionPane.showInputDialog(String.format("Sale #%d: (₱)", i + 1));

                if (input == null) {
                    return null;
                }

                try {
                    sales[i] = Double.parseDouble(input);

                    if (sales[i] >= 0) {
                        break;
                    }

                    this.raiseError(
                            "Invalid input. Sale must be a non-negative value.",
                            "Invalid sale input!");

                } catch (NumberFormatException e) {
                    this.raiseError(
                            "Invalid input. Please enter a valid numeric value for sale.",
                            "Invalid sale input!");
                }

            }

        }

        return sales;
    }
}
