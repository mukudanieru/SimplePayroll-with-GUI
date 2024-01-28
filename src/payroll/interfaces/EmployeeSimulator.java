package payroll.interfaces;

import payroll.employees.Employee;
import javax.swing.*;

/**
 * Abstract class implementing the EmpSimulator interface to simulate employee data.
 */
public abstract class EmployeeSimulator implements EmpSimulator {
    public EmployeeSimulator() {}

    /**
     * Displays a welcome message to the user.
     * @return The user's choice (index of the selected option).
     * if user's choice == 1 { THE APP WILL CONTINUE }
     * else (which is just -1) { THE APP WILL BE TERMINATED }
     */
    public static int greet() {
        ImageIcon icon = new ImageIcon("src/payroll/interfaces/icon.png");
        String[] opt = {"OK"};

        return JOptionPane.showOptionDialog(null,
                "Welcome to PaySim!\nYour streamlined solution for efficient payroll management.",
                EmployeeSimulator.TITLE, JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, icon, opt, null);
    }

    /**
     * Displays a dialog to prompt the user to select an employee type.
     * @return The user's choice (index of the selected option).
     */
    public static int choice() {
        String[] options = {"Salaried", "Hourly", "Commissioned"};

        return JOptionPane.showOptionDialog(null,
                "Please select your employee type:",
                EmployeeSimulator.TITLE,
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                options, null);
    }

    /**
     * Displays information about the given employee.
     * @param emp The employee object to display information for.
     * @return The user's choice (index of the selected option).
     */
    public static int displayInformation(Employee emp) {
        String[] options = {"Retry", "Exit"};

        // if choice == 0 then the app will continue
        // if choice == 1 then the app will be terminated
        return JOptionPane.showOptionDialog(null, emp, EmployeeSimulator.TITLE,
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

    /**
     * Retrieves the name of the employee from user input.
     * @return The name of the employee.
     */
    @Override
    public String getName() {
        String name;

        while (true) {
            name = JOptionPane.showInputDialog("Enter Name: ");

            if (name == null) {
                return null; // User cancelled the input dialog
            }

            if (!name.trim().isEmpty()) {
                break;
            }

            this.raiseError(
                    "Invalid input. Please enter a valid name.",
                    "Invalid name!");
        }

        return name;
    }

    /**
     * Retrieves the job title of the employee from user input.
     * @return The job title of the employee.
     */
    @Override
    public String getJobTitle() {
        String jobTitle;

        while (true) {
            jobTitle = JOptionPane.showInputDialog("Enter Job Title: ");

            if (jobTitle == null) {
                return null; // User cancelled the input dialog
            }

            if (!jobTitle.trim().isEmpty()) {
                break;
            }

            this.raiseError(
                    "Invalid input. Job title cannot be empty.",
                    "Invalid job title!");
        }

        return jobTitle;
    }

    /**
     * Retrieves the tax rate of the employee from user input.
     * @return The tax rate of the employee.
     */
    @Override
    public double getTax() {
        double tax;

        while (true) {
            String input = JOptionPane.showInputDialog("Enter Tax Rate (%): ");

            if (input == null) {
                return -1; // User cancelled the input dialog
            }

            try {
                tax = Double.parseDouble(input);

                if (tax >= 0 && tax <= 100) {
                    break;
                }

                this.raiseError(
                        "Invalid input. Tax rate must be a non-negative value and not more than 100.",
                        "Invalid tax rate!");

            } catch (NumberFormatException e) {
                this.raiseError(
                        "Invalid input. Please enter a valid numeric value for tax.",
                        "Invalid tax rate!");
            }
        }

        return tax;
    }

    /**
     * Displays an error message dialog with the specified message and title.
     * @param message The error message to display.
     * @param title The title of the error message dialog.
     */
    protected void raiseError(String message, String title) {
        JOptionPane.showMessageDialog(
                null, message,title
                , JOptionPane.ERROR_MESSAGE);
    }
}
