package payroll.interfaces;

import javax.swing.*;

public class CommissionedEmpSim extends EmployeeSimulator {
    public CommissionedEmpSim() {}

    public double getCommissionPercent() {
        double commissionPercent;

        while (true) {
            String input = JOptionPane.showInputDialog("Enter Commission Percentage: ");

            if (input == null) {
                return -1;
            }

            try {
                commissionPercent = Double.parseDouble(input);

                if (commissionPercent >= 0) {
                    break;
                }

                JOptionPane.showMessageDialog(null, "Invalid input. Commission percentage must be a non-negative value.",
                        "Error", JOptionPane.ERROR_MESSAGE);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid input. Please enter a valid numeric value for commission percentage.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        return commissionPercent;
    }

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

                JOptionPane.showMessageDialog(null, "Invalid input. Number of sales must be a non-negative value.",
                        "Error", JOptionPane.ERROR_MESSAGE);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid input. Please enter a valid numeric value for number of sales.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        return numberOfSales;
    }

    public double[] getSales(int numberOfSales) {
        double[] sales = new double[numberOfSales];

        for (int i = 0; i < numberOfSales; i++) {


            while (true) {

                String input = JOptionPane.showInputDialog(String.format("Sale #%d: ", i + 1));

                if (input == null) {
                    return null;
                }

                try {
                    sales[i] = Double.parseDouble(input);

                    if (sales[i] >= 0) {
                        break;
                    }

                    JOptionPane.showMessageDialog(null, "Invalid input. Sale must be a non-negative value.",
                            "Error", JOptionPane.ERROR_MESSAGE);

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Invalid input. Please enter a valid numeric value for sale.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }

        }

        return sales;
    }
}
