package payroll.interfaces;

import payroll.employees.HourlyEmployee;
import javax.swing.*;


/**
 * Simulator class for HourlyEmployee to handle user input and validation.
 */
public class HourlyEmpSim extends EmployeeSimulator {
    public HourlyEmpSim() {}

    /**
     * Retrieves the hourly rate of the employee from user input.
     * @return The hourly rate of the employee.
     */
    public double getHourlyRate() {
        double hourlyRate;

        while (true) {
            String input = JOptionPane.showInputDialog("Enter Hourly Rate (₱): ");

            if (input == null) {
                return -1; // User cancelled the input dialog
            }

            try {
                hourlyRate = Double.parseDouble(input);

                if (hourlyRate >= 0) {
                    break;
                }

                this.raiseError(
                        "Invalid input. Hourly rate must be a non-negative value.",
                        "Invalid hourly rate input!");
            } catch (NumberFormatException e) {
                this.raiseError(
                        "Invalid input. Please enter a valid numeric value for hourly rate.",
                        "Invalid hourly rate input!");
            }

        }

        return hourlyRate;
    }

    /**
     * Retrieves the work hours for each day of the week from user input.
     * @return An array containing the work hours for each day.
     */
    public double[] getWorkHours() {
        double[] workHours = new double[HourlyEmployee.WORKDAYS];

        for (int i = 0; i < HourlyEmployee.WORKDAYS; i++) {

            while (true) {
                String input = JOptionPane.showInputDialog(String.format("Work Hours for Day %d: ", i + 1));

                if (input == null) {
                    return null; // User cancelled the input dialog
                }

                try {
                    double hour = Double.parseDouble(input);

                    // Validate if work hours are non-negative and within valid range
                    if (hour >= 0 && hour <= 24) {
                        workHours[i] = hour;
                        break;
                    }

                    this.raiseError(
                            "Invalid input. Work hours must be a non-negative value and cannot exceed 24 hours.",
                            "Invalid work hour!");

                } catch (NumberFormatException e) {
                    this.raiseError(
                            "Invalid input. Please enter a valid numeric value for work hours.",
                            "Invalid input for work hours!");
                }
            }
        }

        return workHours;
    }
}
