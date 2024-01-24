package payroll.interfaces;


import payroll.employees.Employee;
import javax.swing.*;

public abstract class EmployeeSimulator implements EmpSimulator {
    public EmployeeSimulator() {}

    public static int greet() {
        ImageIcon icon = new ImageIcon("src/payroll/interfaces/icon.png");
        String[] opt = {"OK"};

        return JOptionPane.showOptionDialog(null,
                "Welcome to PaySim!\nYour streamlined solution for efficient payroll management.",
                EmployeeSimulator.TITLE, JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, icon, opt, null);
    }

    public static int choice() {
        String[] options = {"Salaried", "Hourly", "Commissioned"};

        return JOptionPane.showOptionDialog(null,
                "Please select your employee type:",
                EmployeeSimulator.TITLE,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                options, null);
    }

    public static int displayInformation(Employee emp) {
        String[] options = {"Retry", "Exit"};
        return JOptionPane.showOptionDialog(null, emp, EmployeeSimulator.TITLE,
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

    @Override
    public String getName() {
        String name;

        while (true) {
            name = JOptionPane.showInputDialog("Enter Name: ");

            if (name == null) {
                // Erorr handling
                return null;
            }

            if (!name.trim().isEmpty()) {
                break;
            }

            JOptionPane.showMessageDialog(
                    null, "Invalid input. Please enter a valid name.",
                    "Invalid Name", JOptionPane.ERROR_MESSAGE);
        }

        return name;
    }

    @Override
    public String getJobTitle() {
        String jobTitle;

        while (true) {
            jobTitle = JOptionPane.showInputDialog("Enter Job Title: ");

            if (jobTitle == null) {
                // Error handling
                return null;
            }

            if (!jobTitle.trim().isEmpty()) {
                break;
            }

            JOptionPane.showMessageDialog(
                    null, "Invalid input. Job title cannot be empty.",
                    "Invalid Job Title", JOptionPane.ERROR_MESSAGE);
        }

        return jobTitle;
    }

    @Override
    public double getTax() {
        double tax;

        while (true) {
            String input = JOptionPane.showInputDialog("Enter Tax Rate (%): ");

            if (input == null) {
                // Handling the cancellation or closed the
                return -1;
            }

            try {
                tax = Double.parseDouble(input);

                if (tax >= 0 && tax <= 100) {
                    break;
                }

                JOptionPane.showMessageDialog(null,
                        "Invalid input. Tax rate must be a non-negative value and not more than 100.", "Error",
                        JOptionPane.ERROR_MESSAGE);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid input. Please enter a valid numeric value for tax.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return tax;
    }
}
