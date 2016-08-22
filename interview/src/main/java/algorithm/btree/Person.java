package algorithm.btree;

public class Person implements Comparable<Person> {

	public int year;
	public String name;

	public Person(int year, String name) {
		super();
		this.year = year;
		this.name = name;
	}

	@Override
	public int compareTo(Person p) {
		return name.compareTo(p.name);
	}

}
