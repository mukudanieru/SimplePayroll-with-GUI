package payroll;

import payroll.employees.CommissionedEmployee;
import payroll.employees.HourlyEmployee;
import payroll.employees.SalariedEmployee;
import payroll.interfaces.CommissionedEmpSim;
import payroll.interfaces.EmployeeSimulator;
import payroll.interfaces.HourlyEmpSim;
import payroll.interfaces.SalariedEmpSim;

/**
 *
 * @author mukudanieru
 */
public class Main {
    public static void main(String[] args) {
        simulator();
    }

    private static void simulator() {
        int greet = EmployeeSimulator.greet();

        if (greet == -1) {
            return;
        }

        while (true) {

            int choice = EmployeeSimulator.choice();

            if (choice == -1) {
                return;
            }

            int retry;

            if (choice == 0) {
                retry = getSalariedEmp();
            } else if (choice == 1) {
                retry = getHourlyEmp();
            } else if (choice == 2) {
                retry = getCommissionedEmp();
            } else {
                return;
            }

            if (retry == 1) {
                return;
            }
        }
    }

    private static int getSalariedEmp() {
        SalariedEmpSim salariedEmpSim = new SalariedEmpSim();

        String name = salariedEmpSim.getName();

        if (name == null) {
            return -1;
        }

        String jobTitle = salariedEmpSim.getJobTitle();

        if (jobTitle == null) {
            return -1;
        }

        double tax = salariedEmpSim.getTax();

        if (tax == -1) {
            return -1;
        }

        double salary = salariedEmpSim.getSalary();

        if (salary == -1) {
            return -1;
        }

        return EmployeeSimulator.displayInformation(new SalariedEmployee(name, jobTitle, tax, salary));
    }

    private static int getHourlyEmp() {
        HourlyEmpSim hourlyEmpSim = new HourlyEmpSim();

        String name = hourlyEmpSim.getName();

        if (name == null) {
            return -1;
        }

        String jobTitle = hourlyEmpSim.getJobTitle();

        if (jobTitle == null) {
            return -1;
        }

        double tax = hourlyEmpSim.getTax();

        if (tax == -1) {
            return -1;
        }

        double hourlyRate = hourlyEmpSim.getHourlyRate();

        if (hourlyRate == -1) {
            return -1;
        }

        double workHours = hourlyEmpSim.getWorkHours();

        if (workHours == -1) {
            return -1;
        }

        return EmployeeSimulator.displayInformation(new HourlyEmployee(name, jobTitle, tax, hourlyRate, workHours));

    }

    private static int getCommissionedEmp() {
        CommissionedEmpSim commissionedEmpSim = new CommissionedEmpSim();

        String name = commissionedEmpSim.getName();

        if (name == null) {
            return -1;
        }

        String jobTitle = commissionedEmpSim.getJobTitle();

        if (jobTitle == null) {
            return -1;
        }

        double tax = commissionedEmpSim.getTax();

        if (tax == -1) {
            return -1;
        }

        double commissionPercent = commissionedEmpSim.getCommissionPercent();

        if (commissionPercent == -1) {
            return -1;
        }

        int numberOfSales = commissionedEmpSim.getNumberOfSales();

        if (numberOfSales == -1) {
            return -1;
        }

        double[] sales = commissionedEmpSim.getSales(numberOfSales);

        if (sales == null) {
            return -1;
        }

        return EmployeeSimulator.displayInformation(new CommissionedEmployee(name, jobTitle, tax,
                commissionPercent, numberOfSales, sales));
    }
}
