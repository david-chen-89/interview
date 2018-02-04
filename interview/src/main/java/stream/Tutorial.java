package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class Tutorial {

	@Test
	public void test() {
		List<String> names = new ArrayList<>();
		List<Student> students = new ArrayList<>();
		int i = 10;
		while (i > 0) {
			if (i > 5) {
				Student s = new Student("A " + i);
				students.add(s);
			} else {
				Student s = new Student("B " + i);
				students.add(s);
			}
			i--;
		}
		for (Student student : students) {
			if (student.getName().startsWith("A")) {
				names.add(student.getName());
			}
		}

		//		List<String> names2 = students.stream().map(Student::getName).filter(name -> name.startsWith("A")).collect(Collectors.toList());
		students.stream().map(Student::getName).filter(name -> name.startsWith("A")).forEach(System.out::println);
	}

	@Test
	public void testOptional() {
		Integer value1 = null;
		Integer value2 = new Integer(10);

		//Optional.ofNullable - allows passed parameter to be null.
		Optional<Integer> a = Optional.ofNullable(value1);

		//Optional.of - throws NullPointerException if passed parameter is null
		Optional<Integer> b = Optional.of(value2);
		System.out.println(sum(a, b));
	}

	private int sum(Optional<Integer> a, Optional<Integer> b) {
		//Optional.isPresent - checks the value is present or not

		System.out.println("First parameter is present: " + a.isPresent());
		System.out.println("Second parameter is present: " + b.isPresent());

		//Optional.orElse - returns the value if present otherwise returns
		//the default value passed.
		Integer value1 = a.orElse(new Integer(0));

		//Optional.get - gets the value, value should be present
		Integer value2 = b.get();
		return value1 + value2;
	}
}
