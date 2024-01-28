package payroll.employees;

/*
 *  Abstract class representing an employee
 */
public abstract class Employee {
    private static int nextEmployeeId = 0;
    // Static variable - shared among all instances of Employee
    // to keep track of the next available Employee ID
    
    protected final int employeeId;
    // the unique ID of an employee
    
    protected String name; // name of the employee
    protected String jobTitle; // job title of the employee
    protected double tax;
    // tax rate of the employee (in percentage)


    /**
     * Constructor to initialize an Employee object.
     * @param name The name of the employee.
     * @param jobTitle The job title of the employee.
     * @param tax The tax rate of the employee (in percentage).
     */
    protected Employee(String name, String jobTitle, double tax) {
        nextEmployeeId++;
        this.employeeId = nextEmployeeId;
        this.name = name;
        this.jobTitle = jobTitle;
        this.tax = tax / 100; // convert tax rate from percentage to decimal
    }

    /**
     * Abstract method to calculate the gross pay of the employee.
     * @return The gross pay of the employee.
     */
    public abstract double grossPay();

    /**
     * Returns a string representation of the Employee object.
     * @return A string containing the employee information.
     */
    @Override
    public String toString() {
        return String.format(
                "Employee Information: %n%n" +
                "Name: %s%n" +
                "Job Title: %s%n" +
                "Tax percentage: %.2f%%" +
                "%n%n" +
                "Gross Pay: ₱%,.2f%n" +
                "Tax Pay: ₱%,.2f%n" +
                "Net Pay: ₱%,.2f%n",
                this.getName(), this.getJobTitle(), this.getTax() * 100,
                this.grossPay(), this.taxPay(), this.netPay());
    }

    /**
     * Calculates the tax amount to be paid by the employee.
     * @return The tax amount to be paid.
     */
    public double taxPay() {
        return this.grossPay() * this.tax;
    }

    /**
     * Calculates the net pay (after tax) of the employee.
     * @return The net pay of the employee.
     */
    public double netPay() {
        return this.grossPay() - this.taxPay();
    }

    /**
     * Getter method to retrieve the name of the employee.
     * @return The name of the employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method to retrieve the job title of the employee.
     * @return The job title of the employee.
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Getter method to retrieve the tax rate of the employee.
     * @return The tax rate of the employee.
     */
    public double getTax() {
        return tax;
    }
}