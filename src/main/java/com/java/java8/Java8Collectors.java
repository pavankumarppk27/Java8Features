package com.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Java8Collectors {

	public static void main(String[] args) {

		List<Student> stdList = new ArrayList<Student>();

		stdList.add(new Student("Paul", 11, "Economics", 78.9));
		stdList.add(new Student("Zevin", 12, "Computer Science", 91.2));
		stdList.add(new Student("Harish", 13, "History", 83.7));
		stdList.add(new Student("Xiano", 14, "Literature", 71.5));
		stdList.add(new Student("Soumya", 15, "Economics", 77.5));
		stdList.add(new Student("Asif", 16, "Mathematics", 89.4));
		stdList.add(new Student("Nihira", 17, "Computer Science", 84.6));
		stdList.add(new Student("Mitshu", 18, "History", 73.5));
		stdList.add(new Student("Vijay", 19, "Mathematics", 92.8));
		stdList.add(new Student("Harry", 20, "History", 71.9));

		// =========> Collectors.toList() :

		List<Student> listStds = stdList.stream().collect(Collectors.toList());

		// ==========> Collectors.toSet() :

		Set<Student> collect = stdList.stream().collect(Collectors.toSet());

		// ===========> Collectors.toMap() :

		Map<Integer, String> collect2 = stdList.stream().collect(Collectors.toMap(Student::getId, Student::getName));

		Map<String, Double> collect3 = stdList.stream()
				.collect(Collectors.toMap(Student::getName, Student::getPercentage, (oldValue, newValue) -> oldValue));

		LinkedHashMap<String, Double> collect4 = stdList.stream().collect(Collectors.toMap(Student::getSubject,
				Student::getPercentage, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

		// =========> Collectors.toCollection() :

		LinkedList<Student> collect5 = stdList.stream().limit(4).collect(Collectors.toCollection(LinkedList::new));

		// =========> Collectors.joining() :
		String collect6 = stdList.stream().map(Student::getName).skip(2).collect(Collectors.joining(", "));

		// System.out.println(collect6);

		// ==========> Collectors.counting()

		Long collect7 = stdList.stream().collect(Collectors.counting());

		// System.out.println(collect7);

		// ===========> Collectors.maxBy() :

		Double double1 = stdList.stream().map(std -> std.getPercentage())
				.collect(Collectors.maxBy(Comparator.naturalOrder())).get();

		// System.out.println(double1);

		// ===========> Collectors.minBy() :

		Double double2 = stdList.stream().map(Student::getPercentage)
				.collect(Collectors.minBy(Comparator.naturalOrder())).get();

		// System.out.println(double2);

		// ============> summingInt(), summingLong(), summingDouble()

		Double collect8 = stdList.stream().collect(Collectors.summingDouble(Student::getPercentage));

		// System.out.println(collect8);

		// =========>averagingInt(), averagingLong(), averagingDouble()

		Double collect9 = stdList.stream().collect(Collectors.summingDouble(Student::getPercentage));

		// ==========>Collectors.groupingBy() :
		
		Map<String, List<Student>> collect10 = stdList.stream().collect(Collectors.groupingBy(Student::getSubject));
		
		//Collectors.partitioningBy() :
		
		Map<Boolean, List<Student>> collect11 = stdList.stream().collect(Collectors.partitioningBy(std -> std.getPercentage() > 80.0));
		
		
		//==========>Collectors.collectingAndThen() 
		//This method is most commonly used for creating immutable collections.
		
		List<Student> collect12 = stdList.stream().collect(Collectors.collectingAndThen(Collectors.toList(),Collections::unmodifiableList));
		
		//collect12.add(new Student("", 1, "", 55)); //=======>here we will get error because list is immutable

		//=========>Collectors.mapping()
		
		Double double3 = stdList.stream().collect(Collectors.mapping(Student::getPercentage, Collectors.maxBy(Double::compareTo))).get();
		
		//System.out.println(double3);
				
		//=========>Collectors.reducing()
		
		Integer orElse = stdList.stream()
				                .map(Std->Std.getId())
				.collect(Collectors.reducing((i1, i2) -> i1 + i2 /* here we can use any operion (i1*i2),(i1-i2) */))
				.orElse(-1);
		//System.out.println(orElse);
		
		
		
		
		 List<String> list = Arrays.asList("5.6", "7.4", "4", 
                 "1", "2.3"); 

		
		list.stream().map(l->l).forEach(System.out::println);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
