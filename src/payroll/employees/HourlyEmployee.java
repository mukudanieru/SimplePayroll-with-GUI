package payroll.employees;

public class HourlyEmployee extends Employee {
    public static final int WORKDAYS = 5; // Days of work
    private final double hourlyRate; // Hourly pay rate
    private final double[] workHours; // Array to store work hours for each day

    /**
     * Constructs an HourlyEmployee object with the specified parameters.
     * @param name The name of the employee.
     * @param jobTitle The job title of the employee.
     * @param tax The tax rate applicable to the employee's earnings.
     * @param hourlyRate The hourly pay rate of the employee.
     * @param workHours An array containing the number of work hours for each day.
     */
    public HourlyEmployee(
    String name, String jobTitle, double tax,
    double hourlyRate, double[] workHours) {
        super(name, jobTitle, tax);
        this.hourlyRate = hourlyRate;
        this.workHours = workHours;
    }

    /**
     * Generates a string representation of the HourlyEmployee object.
     * @return A formatted string containing employee information, work hours, and earnings.
     */
    @Override
    public String toString() {
        return String.format(
                "Employee Information:%n%n" +
                "Name: %s%n" +
                "Job Title: %s%n" +
                "Tax percentage: %.2f%%%n" +
                "Hourly rate: ₱%.2f per hour" +
                "%n%n" +
                "-- Your work hours for each day --" +
                "%n%s%n" +
                "Your total work hours: %.2f%n%n" +
                "Gross Pay: ₱%,.2f%n" +
                "Tax Pay: ₱%,.2f%n" +
                "Net Pay: ₱%,.2f%n",
                this.getName(), this.getJobTitle(), this.getTax() * 100,
                this.hourlyRate, this.hoursPerDay(), this.totalWorkHours(),
                this.grossPay(), this.taxPay(), this.netPay());
    }

    /**
     * Calculates the total earnings of the employee based on hourly pay and total work hours.
     * @return The gross pay of the employee.
     */
    @Override
    public double grossPay() {
        return this.hourlyRate * this.totalWorkHours();
    }

    /**
     * Calculates the total work hours of the employee.
     * @return The total work hours.
     */
    private double totalWorkHours() {
        double workHours = 0;

        for (int i = 0; i < HourlyEmployee.WORKDAYS; i++) {
            workHours += this.workHours[i];
        }

        return workHours;
    }

    /**
     * Generates a string representation of the work hours for each day.
     * @return A formatted string showing the work hours for each day.
     */
    private String hoursPerDay() {
        StringBuilder hoursPerDay = new StringBuilder();

        for (int i = 0; i < HourlyEmployee.WORKDAYS; i++) {
            hoursPerDay.append(String.format("Day %d: %.2f hours%n", i+1, this.workHours[i]));
        }

        return hoursPerDay.toString();
    }
}
