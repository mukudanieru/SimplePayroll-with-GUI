package payroll.interfaces;

import javax.swing.*;

public class SalariedEmpSim extends EmployeeSimulator {
    public SalariedEmpSim() {}

    public double getSalary() {
        double salary;

        while (true) {
            String input = JOptionPane.showInputDialog("Enter Salary (₱) : ");

            if (input == null) {
                return -1; // Error handling for cancellation
            }

            try {
                salary = Double.parseDouble(input);

                if (salary >= 0) {
                    break;
                }

                JOptionPane.showMessageDialog(null,
                        "Invalid input. Salary must be a non-negative value.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid input. Please enter a valid numeric value for salary", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        }

        return salary;
    }
}
