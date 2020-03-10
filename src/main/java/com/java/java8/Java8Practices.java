package com.java.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Practices {

	public static void main(String[] args) {
		
		 List<Hosting> list = new ArrayList<>();
	        list.add(new Hosting(1, "liquidweb.com", 80000));
	        list.add(new Hosting(2, "linode.com", 90000));
	        list.add(new Hosting(3, "digitalocean.com", 120000));
	        list.add(new Hosting(4, "aws.amazon.com", 200000));
	        list.add(new Hosting(5, "mkyong.com", 1));
	        list.add(new Hosting(6, "linode.com", 100000));

	 
	 LinkedHashMap<String, Long> collect = list.stream().sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
	              .collect(                    		 
	                		 Collectors.toMap(Hosting::getName, Hosting::getWebsites, 
	                				                            (oldValue,newValue)->oldValue,LinkedHashMap::new)
	                 	   );
	
	
	 //System.out.println(collect);
	
	 List<String> names = new ArrayList<>();
     
	 names.add("David");          
	 names.add("Johnson");
	 names.add("Samontika");
	 names.add("Brijesh");	          
	 names.add("John");	          
	 names.add("David");	          
	 names.add("Brijesh");
	  
	 //limit() : Selects first n elements
	 
	List<String> collect2 = names.stream().limit(4).collect(Collectors.toList());
	 
	//System.out.println(collect2);
	  
	// skip() : Skips first n elements
	
	List<String> collect3 = names.stream().skip(3).collect(Collectors.toList());
	
	//System.out.println(collect3);
	 
	 //map
	List<Integer> collect4 = names.stream().map(String::length).collect(Collectors.toList());
	 
	//System.out.println(collect4);
	 
	//normal sorting 
	 
	List<String> collect5 = names.stream().sorted().collect(Collectors.toList());
	 
	// System.out.println(collect5);
	 
	 //descending order
	 
	 List<String> collect6 = names.stream().sorted((str1,str2)->-str1.compareTo(str2)).collect(Collectors.toList());	 
	 
	 //System.out.println(collect6);
	 
	 
	 Comparator<String> c=(Str1,Str2)->{
		
		 int i1=Str1.length();
		 int i2=Str2.length();
		 
		 return (i1>i2)?-1:(i1<i2)?1:0;
	 };
	 
	 
	 List<String> collect7 = names.stream().sorted(c).collect(Collectors.toList());
	 
	//System.out.println(collect7);
	 
	 
	 List<String> nam = new ArrayList<>();
     
	 nam.add("David");	          
	 nam.add("Johnson");
	 nam.add("Samontika");	          
	 nam.add("Brijesh");	          
	 nam.add("John");
	 
	 //allMatch
	 
	 boolean allMatch = nam.stream().allMatch(str->str.length()>3);
	
	//anyMatch
	 
	boolean anyMatch = nam.stream().anyMatch(str->str.startsWith("S"));
	
	//noneMatch
	boolean noneMatch = nam.stream().noneMatch(str->str.startsWith("x"));
	
	//System.out.println(allMatch+" "+anyMatch+" "+noneMatch);
	
	nam.stream()
	   .filter(str->str.length()>5)
	   .peek(str->System.out.println("filter Name:"+str))
	   .map(String::toUpperCase)
	   .peek(str->System.out.println("map name:"+str))
	   .toArray();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}