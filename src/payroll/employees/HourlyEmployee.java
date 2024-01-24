package payroll.employees;

/**
 *
 * @author mukudanieru
 */
public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private double workHours;
    public static final int WORKDAYS = 5; // Days of work
    
    public HourlyEmployee(
    String name, String jobTitle, double tax,
    double hourlyRate, double workHours) {
        super(name, jobTitle, tax);
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }
    
    @Override
    public double grossPay() {
        return this.hourlyRate * this.workHours;
    }
}
