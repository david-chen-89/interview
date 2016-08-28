package pattern.structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {

	private String name;
	private double salary;
	List<Employee> employees = new ArrayList<Employee>();

	public Manager(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public void add(Employee employee) {
		employees.add(employee);
	}

	@Override
	public Employee getTeamMember(int i) {
		return employees.get(i);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getSalary() {
		return salary;
	}

	@Override
	public void remove(Employee employee) {
		employees.remove(employee);
	}
}