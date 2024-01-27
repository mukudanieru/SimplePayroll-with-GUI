package payroll.interfaces;

import payroll.employees.HourlyEmployee;

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
        double totalHours = 0;

        for (int i = 0; i < HourlyEmployee.WORKDAYS; i++) {

            while (true) {
                String input = JOptionPane.showInputDialog(String.format("Work hours for Day %d: ", i + 1));

                if (input == null) {
                    return -1; // Error handling for cancellation
                }

                try {
                    totalHours += Double.parseDouble(input);

                    if (totalHours >= 0) {
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

        }

        return totalHours;
    }

}