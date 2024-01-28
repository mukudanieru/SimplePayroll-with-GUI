package payroll.employees;

/**
 * Represents a commissioned employee, who earns a percentage commission on total sales.
 */
public class CommissionedEmployee extends Employee {
    private final double commissionedPercent; // Commission rate as a percentage
    private final int numberOfSales; // Number of sales made by the employee
    private final double[] sales; // Array to store sales amounts

    /**
     * Constructs a CommissionedEmployee object with the specified parameters.
     * @param name The name of the employee.
     * @param jobTitle The job title of the employee.
     * @param tax The tax rate applicable to the employee's earnings.
     * @param commissionedPercent The commission rate as a percentage.
     * @param numberOfSales The number of sales made by the employee.
     * @param sales An array containing the amounts of each sale made by the employee.
     */
    public CommissionedEmployee(
            String name, String jobTitle, double tax,
            double commissionedPercent, int numberOfSales, double[] sales) {
        super(name, jobTitle, tax);
        this.commissionedPercent = commissionedPercent / 100; // Convert commission rate to decimal
        this.numberOfSales = numberOfSales;
        this.sales = sales;
    }

    /**
     * Generates a string representation of the CommissionedEmployee object.
     * @return A formatted string containing employee information, sales details, and earnings.
     */
    @Override
    public String toString() {
        return String.format(
                "Employee Information:%n%n" +
                        "Name: %s%n" +
                        "Job Title: %s%n" +
                        "Tax percentage: %.2f%%%n" +
                        "Commission rate: %.2f%%" +
                        "%n%n" +
                        "-- You sales details --" +
                        "%n%s%n" +
                        "Your total sales: ₱%,.2f%n%n" +
                        "Gross Pay: ₱%,.2f%n" +
                        "Tax Pay: ₱%,.2f%n" +
                        "Net Pay: ₱%,.2f%n",
                this.getName(), this.getJobTitle(), this.getTax() * 100,
                this.commissionedPercent * 100, this.perSales(), this.totalSales(),
                this.grossPay(), this.taxPay(), this.netPay());
    }

    /**
     * Calculates the total earnings of the employee based on commission.
     * @return The gross pay of the employee.
     */
    @Override
    public double grossPay() {
        return this.commissionedPercent * this.totalSales();
    }

    /**
     * Calculates the total sales made by the employee.
     * @return The total sales amount.
     */
    private double totalSales() {
        double sum = 0;
        
        for (int i = 0; i < this.numberOfSales; i++) {
            sum += sales[i];
        }
        
        return sum;
    }

    /**
     * Generates a string representation of the sales made by the employee.
     * @return A formatted string showing each sale made by the employee.
     */
    private String perSales() {
        StringBuilder perSales = new StringBuilder();

        for (int i = 0; i < this.numberOfSales; i++) {
            perSales.append(String.format("Sale #%d: ₱%,.2f%n", i+1, this.sales[i]));
        }

        return perSales.toString();
    }
}
