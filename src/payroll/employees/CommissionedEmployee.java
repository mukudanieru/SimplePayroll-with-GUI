package payroll.employees;

/**
 *
 * @author mukudanieru
 */
public class CommissionedEmployee extends Employee {
    private double commissionedPercent;
    private int numberOfSales;
    private double sales[];
    
    public CommissionedEmployee(
    String name, String jobTitle, double tax,
    double commissionedPercent, int numberOfSales, double sales[]) {
        super(name, jobTitle, tax);
        this.commissionedPercent = commissionedPercent / 100;
        this.numberOfSales = numberOfSales;
        this.sales = sales;
    }
    
    @Override
    public double grossPay() {
        return this.commissionedPercent * this.totalSales();
    }
            
    public double totalSales() {
        double sum = 0;
        
        for (int i = 0; i < this.numberOfSales; i++) {
            sum += sales[i];
        }
        
        return sum;
    }
}
