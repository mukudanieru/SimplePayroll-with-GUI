package payroll.interfaces;

import javax.swing.*;

public class HourlyEmpSim extends EmployeeSimulator {
    public HourlyEmpSim() {}

    public double getHourlyRate() {
        double hourlyRate;

        while (true) {
            String input = JOptionPane.showInputDialog("Enter Hourly Rate: ");

            if (input == null) {
                return -1; // Error handling for cancellation
            }

            try {
                hourlyRate = Double.parseDouble(input);

                if (hourlyRate >= 0) {
                    break;
                }

                JOptionPane.showMessageDialog(null,
                        "Invalid input. Hourly rate must be a non-negative value.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid input. Please enter a valid numeric value for hourly rate.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        }

        return hourlyRate;
    }

    public double getWorkHours() {
        double workHours;

        while (true) {
            String input = JOptionPane.showInputDialog("Enter Work Hours: ");

            if (input == null) {
                return -1; // Error handling for cancellation
            }

            try {
                workHours = Double.parseDouble(input);

                if (workHours >= 0) {
                    break;
                }

                JOptionPane.showMessageDialog(null,
                        "Invalid input. Work hours must be a non-negative value.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid input. Please enter a valid numeric value for work hours.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        }

        return workHours;
    }

}