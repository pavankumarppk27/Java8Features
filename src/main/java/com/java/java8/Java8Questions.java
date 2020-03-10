package com.java.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Questions {

	
	public static void main(String[] args) {
		
		 List<String> names = Arrays.asList("Jon", "Ajeet", "Steve", "Ajeet", "Jon", "Ajeet");
	
		 
		 //Funcation.Identity
		 
		Map<String, Long> collect = names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		//System.out.println(collect);
		
		//set
		
		Set<String> collect6 = names.stream().collect(Collectors.toSet());
		
		//map
		
		//names.stream().collect(Collectors.toMap(keyMapper, valueMapper, mergeFunction))
		
		//Joining
		
		String collect2 = names.stream().collect(Collectors.joining());
		//System.out.println(collect2);
		
		String collect3 = names.stream().collect(Collectors.joining(", "));
		
		
		//System.out.println(collect3);
		
		String collect4 = names.stream().collect(Collectors.joining(" , ", "They are " ,", They are from Australia. "));
		
		//System.out.println(collect4);
		
		// TreeSet::new
		
		TreeSet<String> collect5 = names.stream().collect(Collectors.toCollection(TreeSet::new));
		
		System.out.println(collect5);
		
		//Iterating and displaying selected integers
		
		 Stream.iterate(3, count->count+1)  
	        .filter(number->number%5==0)  
	        .limit(6)  
	        .forEach(System.out::println);  
		
		 
		 List<String> name = new ArrayList<String>();
	      name.add("Maggie"); 
	      name.add("Michonne");
	      name.add("Rick");
	      name.add("Merle");
	      name.add("Governor"); 
	      //forEach - the output would be in any order
	    //  System.out.println("Print using forEach");
	      name.stream() 
	     .filter(f->f.startsWith("M"));
	     //.parallel() 
	     //.forEach(//n->System.out.println(n)); 
		
		
		name.stream()
		    .filter(f->f.startsWith("M"));
		    //.parallel()
		   // .forEachOrdered(n->System.out.println(n));
		
		//Map<String, String> collect7 = names.stream().collect(Collectors.toMap(str->str, str2->str2));
		
		//System.out.println(collect7);
		//above line will give you exception why because it has duplicate values.overcome that problem fallow below code.
			
		Map<String, String> collect8 = names.stream().collect(Collectors.toMap(str->str, str2->str2, (str,str2)->str));		
		System.out.println(collect8);
		
		Map<String, String> collect9 = names.stream().collect(Collectors.toMap(str->str, str2->str2, (oldVal,newVal)->newVal));		
		System.out.println(collect9);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
