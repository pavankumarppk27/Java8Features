package com.java.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class java8ChallengesQuestions {

	public static void main(String[] args) {

		List<Employee> empList = new ArrayList<Employee>();

		empList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		empList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		empList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		empList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		empList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		empList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		empList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		empList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		empList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		empList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		empList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		empList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		empList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		empList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		empList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		empList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		empList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// ======>Query 3.1 : How many male and female employees are there in the
		// organization?

		Map<String, Long> countOfMaleAndFemale = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		// System.out.println(countOfMaleAndFemale);

		// =======>Query 3.2 : Print the name of all departments in the organization?

		List<String> listOfDepartments = empList.stream().map(emp -> emp.getDepartment()).distinct()
				.collect(Collectors.toList());

		// System.out.println(listOfDepartments);

		// ======>Query 3.3 : What is the average age of male and female employees?

		Map<String, Double> avgAgeOfMaleAndFemale = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

		// System.out.println(avgAgeOfMaleAndFemale);

		// ======>Query 3.4 : Get the details of highest paid employee in the
		// organization?

		// firstway
		Employee highestSalEmployee = empList.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
		// System.out.println(highestSalEmployee);

		// second way
		Employee highestSalaryEmployee = empList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get();
		// System.out.println(highestSalaryEmployee);

		// =====> Query 3.5 : Get the names of all employees who have joined after 2015?

		List<Employee> empListAfter2015 = empList.stream().filter(emp -> emp.getYearOfJoining() > 2015)
				.collect(Collectors.toList());

		// System.out.println(empListAfter2015);

		// =====> Query 3.6 : Count the number of employees in each department?

		Map<String, Long> eachDeptCount = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		// System.out.println(eachDeptCount);

		// ======> Query 3.7 : What is the average salary of each department?

		Map<String, Double> avgSalOfEachDept = empList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		// System.out.println(avgSalOfEachDept);

		// ====>Query 3.8 : Get the details of youngest male employee in the product
		// development department?

		Employee youngestMaleEmployee = empList.stream()
				.filter(emp -> emp.getGender().equalsIgnoreCase("male")
						&& emp.getDepartment().equalsIgnoreCase("product development"))
				.max(Comparator.comparingInt(Employee::getYearOfJoining)).get();

		// System.out.println(youngestMaleEmployee);

		// ======> Query 3.9 : Who has the most working experience in the organization?

		// firstWay:

		Employee mostExpInOrg = empList.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).get();

		// System.out.println(mostExpInOrg);

		Employee mostExprInOrg = empList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining))
				.findFirst().get();

		// System.out.println(mostExprInOrg);

		// =======>Query 3.10 : How many male and female employees are there in the
		// sales and marketing team?

		Map<String, Long> countOfMaleAndFemaleOfSalesAndMarketDept = empList.stream()
				.filter(emp -> emp.getDepartment().equalsIgnoreCase("sales and marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		// System.out.println(countOfMaleAndFemaleOfSalesAndMarketDept);

		// ========> Query 3.11 : What is the average salary of male and female
		// employees?

		Map<String, Double> avgSalOfMaleAndFemale = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));

		// System.out.println(avgSalOfMaleAndFemale);

		// =======>Query 3.12 : List down the names of all employees in each department?

		Map<String, List<Employee>> listOfEachDept = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		// System.out.println(listOfEachDept);

		// =======>Query 3.13 : What is the average salary and total salary of the whole
		// organization?

		DoubleSummaryStatistics avgAndTotSal = empList.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));

		// System.out.println(avgAndTotSal);

		// ======>Query 3.14 : Separate the employees who are younger or equal to 25
		// years from those employees who are older than 25 years.

		Map<Boolean, List<Employee>> partitionBYAge25 = empList.stream()
				.collect(Collectors.partitioningBy(emp -> emp.getAge() > 25));

		// System.out.println(partitionBYAge25);

		partitionBYAge25.values().stream();

		// =======>Query 3.15 : Who is the oldest employee in the organization? What is
		// his age and which department he belongs to?

		Employee oldestEmployee = empList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Employee::getAge)))
				.get();

		// System.out.println(oldestEmployee);

		
		//===>get oldest Employee in each department.
		
		Map<String, Optional<Employee>> collect = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment,
				Collectors.maxBy(Comparator.comparingInt(Employee::getAge))));

		for(Map.Entry<String, Optional<Employee>> m:collect.entrySet()) {
			
			//System.out.println(m.getKey()+"  "+m.getValue().get());
		}
		
		collect.forEach((key,value)->{
			//System.out.println(key+"  "+value.get());
		});
		
		
		//get sum of all employes salary
		
		Double sumOfSal = empList.stream().collect(Collectors.summingDouble(Employee::getSalary));
		
		//System.out.println(sumOfSal);
		
		
		//converting list to map
		
		Map<Integer, String> collect4 = empList.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
		
		
		//System.out.println(collect4);
		
		//list to set
		Set<Employee> collect2 = empList.stream().collect(Collectors.toSet());
		
		}
}
