package Java8Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Function;

public class FunctionApplyProgram {
	
	public static void main(String args[]) {

		
		PriorityQueue pq = new PriorityQueue(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName));//First sort my age then sort by name
		Employee e1 = new Employee("Tom Jones", 456);
		Employee e2 = new Employee("Vai", 3);
		Employee e3 = new Employee("Muk", 67);
		Employee e4 = new Employee("a", 121);
		pq.add(e1);
		pq.add(e2);
		pq.add(e3);
		pq.add(e4);

		System.out.println("PEAK " + pq.peek());
	
		/*
		 * Create first function of emplyee name
		 */
		Function<Employee, String> funcEmpToString = (Employee e) -> {
			return e.getName();
		};
		/*
		 * Function of only first name
		 */
		Function<Employee, Employee> funcEmpFirstName = (Employee e) -> {
			int index = e.getName().indexOf(" ");
			String firstName = e.getName().substring(0, index);
			e.setName(firstName);
			return e;
		};
		List<Employee> employeeList = Arrays.asList(new Employee("Tom Jones", 45), new Employee("Harry Major", 25),
				new Employee("Ethan Hardy", 65), new Employee("Nancy Smith", 15),
				new Employee("Deborah Sprightly", 29));
		List<String> empFirstNameList = convertEmpListToNamesList(employeeList,
				funcEmpToString.compose(funcEmpFirstName));
		empFirstNameList.forEach(str -> {
			System.out.print(" " + str);
		});

	}

	public static List<String> convertEmpListToNamesList(List<Employee> employeeList,
			Function<Employee, String> funcEmpToString) {
		List<String> empNameList = new ArrayList<String>();
		for (Employee emp : employeeList) {
			empNameList.add(funcEmpToString.apply(emp));
		}
		return empNameList;
	}
}

class Employee {
	private String name;
	private int age;

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}

}
