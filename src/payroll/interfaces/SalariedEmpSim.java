package payroll.interfaces;

import payroll.employees.SalariedEmployee;
import javax.swing.*;

/**
 * Simulator class for SalariedEmployee to handle user input and validation.
 */
public class SalariedEmpSim extends EmployeeSimulator {
    public SalariedEmpSim() {}

    /**
     * Retrieves the monthly salary of the employee from user input.
     * @return The monthly salary of the employee.
     */
    public double getSalary() {
        double salary;

        while (true) {
            // Prompt user to enter monthly salary with minimum wage information
            String input = JOptionPane.showInputDialog(
                    String.format("Enter monthly salary (₱) [Minimum wage: %.0f]: ", SalariedEmployee.minimumSalary));

            if (input == null) {
                return -1; // User cancelled the input dialog
            }

            try {
                salary = Double.parseDouble(input);

                // Validate if the entered salary meets the minimum wage requirement
                if (salary >= SalariedEmployee.minimumSalary) {
                    break;
                }

                // Display error if salary is below minimum wage
                if (salary >= 0) {
                    this.raiseError(
                            String.format(
                                    "Salary must be at least the minimum threshold of ₱%.0f. %nPlease enter a higher salary value.", SalariedEmployee.minimumSalary),
                            "Minimum salary requirement not met!");
                } else {
                    this.raiseError(
                            "Invalid input. Salary must be a non-negative value.",
                            "Invalid salary input!");
                }

            } catch (NumberFormatException e) {
                // Display error for invalid numeric input
                this.raiseError(
                        "Invalid input. Please enter a valid numeric value for salary.",
                        "Invalid salary input!");
            }
        }

        return salary;
    }
}
