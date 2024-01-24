package payroll.employees;

/**
 *
 * @author mukudanieru
 */
public abstract class Employee implements EmpInterface {
    private static int nextEmployeeId = 0;
    // Static variable - shared among all instances of Employee
    // to keep track the count of Employee ID
    
    protected final int employeeId;
    // the unique ID of an employee
    
    protected String name;
    protected String jobTitle;
    protected double tax;
    
    protected Employee(String name, String jobTitle, double tax) {
        nextEmployeeId++;
        this.employeeId = nextEmployeeId;
        this.name = name;
        this.jobTitle = jobTitle;
        this.tax = tax / 100;
    }

    @Override
    public abstract double grossPay();

    @Override
    public String toString() {
        return String.format(
                "Employee Information: %n%nName: %s%nJob Title: %s%nTax: %.2f%%%n%nGross Pay: %,.2f%nTax Pay: %,.2f%nNet Pay: %,.2f%n",
                this.getName(), this.getJobTitle(), this.getTax() * 100,
                this.grossPay(), this.taxPay(), this.netPay());
    }

    public double taxPay() {
        return this.grossPay() * this.tax;
    }
    
    public double netPay() {
        return this.grossPay() - this.taxPay();
    }
    
    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getTax() {
        return tax;
    }
}