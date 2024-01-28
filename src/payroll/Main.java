package payroll;

import payroll.employees.CommissionedEmployee;
import payroll.employees.HourlyEmployee;
import payroll.employees.SalariedEmployee;
import payroll.interfaces.*;

/**
 * Main class to run the payroll simulation program.
 * @author mukudanieru and Joeniesus Vidal
 */
public class Main {
    public static void main(String[] args) {
        simulator(); // Start of the simulation
    }

    /**
     * Method to simulate the payroll process.
     */
    private static void simulator() {
        // Display the greeting message and handle cancellation
        int greet = EmployeeSimulator.greet();

        if (greet == -1) {
            applicationTerminated();
            return;
        }

        while (true) {
            // Prompt the user to choose an employee type
            int choice = EmployeeSimulator.choice();

            int exit;

            // Based on the user's choice, collect employee information
            if (choice == 0) {
                exit = getSalariedEmp();
            } else if (choice == 1) {
                exit = getHourlyEmp();
            } else if (choice == 2) {
                exit = getCommissionedEmp();
            } else {
                applicationTerminated();
                return;
            }

            // If the user chooses to exit from the employee information display, terminate the application
            if (exit == 1) {
                applicationTerminated();
                return;
            }
        }
    }

    /**
     * Method to handle termination of the application.
     */
    private static void applicationTerminated() {
        System.out.println("Application terminated.");
    }

    private static void getInformationCancelled() {
        System.out.println("Information input cancelled. Returning to the main menu.");
    }

    /**
     * Method to collect information for a salaried employee.
     * @return Exit status (1 if canceled, 0 otherwise).
     */
    private static int getSalariedEmp() {
        // Create a SalariedEmpSim object to collect employee information
        SalariedEmpSim salariedEmpSim = new SalariedEmpSim();

        // Get employee name
        String name = salariedEmpSim.getName();

        if (name == null) {
            getInformationCancelled();
            return -1;
        }

        // Get employee job title
        String jobTitle = salariedEmpSim.getJobTitle();

        if (jobTitle == null) {
            getInformationCancelled();
            return -1;
        }

        // Get employee tax rate
        double tax = salariedEmpSim.getTax();

        if (tax == -1) {
            getInformationCancelled();
            return -1;
        }

        // Get employee salary
        double salary = salariedEmpSim.getSalary();

        if (salary == -1) {
            getInformationCancelled();
            return -1;
        }

        // Display employee information and handle cancellation
        return EmployeeSimulator.displayInformation(new SalariedEmployee(name, jobTitle, tax, salary));
    }

    /**
     * Method to collect information for an hourly employee.
     * @return Exit status (1 if canceled, 0 otherwise).
     */
    private static int getHourlyEmp() {
        // Create a HourlyEmpSim object to collect employee information
        HourlyEmpSim hourlyEmpSim = new HourlyEmpSim();

        // Get employee name
        String name = hourlyEmpSim.getName();

        if (name == null) {
            getInformationCancelled();
            return -1;
        }

        // Get employee job title
        String jobTitle = hourlyEmpSim.getJobTitle();

        if (jobTitle == null) {
            getInformationCancelled();
            return -1;
        }

        // Get employee tax rate
        double tax = hourlyEmpSim.getTax();

        if (tax == -1) {
            getInformationCancelled();
            return -1;
        }

        // Get employee hourly rate
        double hourlyRate = hourlyEmpSim.getHourlyRate();

        if (hourlyRate == -1) {
            getInformationCancelled();
            return -1;
        }

        // Get employee work hours
        double[] workHours = hourlyEmpSim.getWorkHours();

        if (workHours == null) {
            getInformationCancelled();
            return -1;
        }

        // Display employee information and handle cancellation
        return EmployeeSimulator.displayInformation(new HourlyEmployee(name, jobTitle, tax, hourlyRate, workHours));
    }

    /**
     * Method to collect information for a commissioned employee.
     * @return Exit status (1 if canceled, 0 otherwise).
     */
    private static int getCommissionedEmp() {
        // Create a CommissionedEmpSim object to collect employee information
        CommissionedEmpSim commissionedEmpSim = new CommissionedEmpSim();

        // Get employee name
        String name = commissionedEmpSim.getName();

        if (name == null) {
            getInformationCancelled();
            return -1;
        }

        // Get employee job title
        String jobTitle = commissionedEmpSim.getJobTitle();

        if (jobTitle == null) {
            getInformationCancelled();
            return -1;
        }

        // Get employee tax rate
        double tax = commissionedEmpSim.getTax();

        if (tax == -1) {
            getInformationCancelled();
            return -1;
        }

        // Get employee commission percentage
        double commissionPercent = commissionedEmpSim.getCommissionPercent();

        if (commissionPercent == -1) {
            getInformationCancelled();
            return -1;
        }

        // Get employee number of sales
        int numberOfSales = commissionedEmpSim.getNumberOfSales();

        if (numberOfSales == -1) {
            getInformationCancelled();
            return -1;
        }

        // Get employee sales amounts
        double[] sales = commissionedEmpSim.getSales(numberOfSales);

        if (sales == null) {
            getInformationCancelled();
            return -1;
        }

        // Display employee information and handle cancellation
        return EmployeeSimulator.displayInformation(new CommissionedEmployee(name, jobTitle, tax,
                commissionPercent, numberOfSales, sales));
    }
}
