package pattern.structural.Composite;

/**
 * The key point is the interface keeps a collection of type of itself
 *
 */
public interface Employee {

	public void add(Employee employee); // !!

	public void remove(Employee employee); // !!

	public Employee getTeamMember(int i); // !!

	public String getName();

	public double getSalary();
}
