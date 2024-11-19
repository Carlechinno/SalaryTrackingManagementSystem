package HR;

/**
 * Represents a worker in the Human Resources system.
 * Stores details such as the worker's name, ID, contact information, and salary.
 */
public class Worker implements Comparable<Worker> {

    /**
     * The first name of the worker.
     */
    protected String firstName;

    /**
     * The last name of the worker.
     */
    protected String lastName;

    /**
     * The unique identifier for the worker.
     */
    protected int id;

    /**
     * The email address of the worker.
     */
    protected String email;

    /**
     * The phone number of the worker.
     */
    protected String phone;

    /**
     * The residential address of the worker.
     */
    protected String address;

    /**
     * The monthly salary of the worker.
     */
    protected int monthlySalary;

    /**
     * Constructs a new Worker with the specified details.
     *
     * @param firstName     the first name of the worker
     * @param lastName      the last name of the worker
     * @param id            the unique identifier for the worker
     * @param email         the email address of the worker
     * @param phone         the phone number of the worker
     * @param address       the residential address of the worker
     * @param monthlySalary the monthly salary of the worker
     */
    public Worker(String firstName, String lastName, int id, String email, String phone, String address, int monthlySalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.monthlySalary = monthlySalary;
    }

    /**
     * Gets the first name of the worker.
     *
     * @return the first name of the worker
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the worker.
     *
     * @return the last name of the worker
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the unique identifier of the worker.
     *
     * @return the ID of the worker
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the email address of the worker.
     *
     * @return the email address of the worker
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the phone number of the worker.
     *
     * @return the phone number of the worker
     */
    public String getPhoneNumber() {
        return phone;
    }

    /**
     * Gets the residential address of the worker.
     *
     * @return the residential address of the worker
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the monthly salary of the worker.
     *
     * @return the monthly salary of the worker
     */
    public int getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * Compare workers based on their wage.
     *
     * @param otherWorker The worker to compare with.
     * @return A negative integer, zero, or a positive integer as this worker's
     *         wage is less than, equal to, or greater than the specified worker.
     */
    @Override
    public int compareTo(Worker otherWorker) {
        // Compare workers based on their wage
        return Integer.compare(this.monthlySalary, otherWorker.monthlySalary);
    }

    /**
     * Returns a string representation of the worker.
     *
     * @return A string representation containing worker details.
     */
    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + firstName + " " + lastName +
                ", Email: " + email +
                ", Phone: " + phone +
                ", Address: " + address +
                ", Wage: " + monthlySalary + " NIS";
    }
}