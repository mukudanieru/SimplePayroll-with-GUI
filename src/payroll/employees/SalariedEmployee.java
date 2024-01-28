package payroll.employees;

/**
 * Represents a salaried employee.
 */
public class SalariedEmployee extends Employee {
    private final double salary; // Monthly salary of the employee
    public final static double minimumSalary = 500;
    // minimum wage for salaried employee

    /**
     * Constructs a SalariedEmployee object.
     * @param name The name of the employee.
     * @param jobTitle The job title of the employee.
     * @param tax The tax rate of the employee (in percentage).
     * @param salary The monthly salary of the employee.
     */
    public SalariedEmployee(String name, String jobTitle, double tax, double salary) {
        super(name, jobTitle, tax);
        this.salary = salary;
    }

    /**
     * Calculates the gross pay of the salaried employee.
     * For a salaried employee, the gross pay is equal to their monthly salary.
     * @return The gross pay of the employee.
     */
    @Override
    public double grossPay() {
        return this.salary;
    }
}
