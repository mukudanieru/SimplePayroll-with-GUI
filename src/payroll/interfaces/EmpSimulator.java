package payroll.interfaces;

/**
 * Interface for simulating employee data.
 */
public interface EmpSimulator {
    // Constant representing the title of the simulation
    String TITLE = "PaySim";

    /**
     * Retrieves the name of the simulated employee.
     * @return The name of the employee.
     */
    String getName();

    /**
     * Retrieves the job title of the simulated employee.
     * @return The job title of the employee.
     */
    String getJobTitle();

    /**
     * Retrieves the tax rate of the simulated employee.
     * @return The tax rate of the employee (in percentage).
     */
    double getTax();
}
