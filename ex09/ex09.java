import java.util.*; 
public class ArrayListExample { 
public static void main(String args[]) { 
/*Creation of ArrayList: I'm going to add String elements so I made it of string type */ 
ArrayList<String> obj1 = new ArrayList<String>(); 
/*This is how elements should be added to the array list*/ 
obj1.add("Rajini"); 
obj1.add("Ajith"); 
obj1.add("Vijay"); 
obj1.add("Surya"); 
obj1.add("Karthi"); 
/* Displaying array list elements */ 
System.out.println("\nCurrently the array list obj1 has following elements:"+obj1); 
/*Append element at the end*/ 
obj1.add("Dhanush"); 
obj1.add("Soori"); 
/*Append collection element to ArrayList*/ 
ArrayList<String> obj2 = new ArrayList<String>(); 
obj2.add("Vishal"); 
obj2.add("Pradeep"); 
obj2.add("Kavin"); 
//Adding ArrayList obj2 into ArrayList obj1 
obj1.addAll(obj2); 
System.out.println("\nArrayList obj1 after add All:"+obj1); 
/*Add element at the given index*/ 
obj1.add(0, "Kamal"); 
obj1.add(1, "Siva"); 
System.out.println("\nArrayList obj1 after add element at the given index:"+obj1); 
/*Search an element*/ 
System.out.println("\nEnter the Search element:"); 
Scanner input=new Scanner(System.in); 
String search=input.nextLine(); 
System.out.println("\nArrayList obj1 contains the string "+search+":"+obj1.contains(search)); 
/*Remove elements from array list like this*/ 
obj1.remove("Vijay"); 
obj1.remove("Ajith"); 
System.out.println("\nCurrent array list of obj1 after removing element is:"+obj1); 
/*Remove element from the given index*/ 
obj1.remove(1); 
System.out.println("\nCurrent array list of obj1 after removing element through index is:"+obj1); 
System.out.println("\nEnter the letter to display all the string start with given letter:"); 
search=input.nextLine(); 
ArrayList<String> obj3 = new ArrayList<String>(); 
 
 
for(int i=0;i<obj1.size();i++) 
{ 
if(obj1.get(i).startsWith(search.toUpperCase())) 
{ 
obj3.add(obj1.get(i)); 
} 
} 
if(obj3.size()>0) 
{ 
System.out.println("\nArrayList obj1 contains all the string start with given"+search+":"+obj3); 
} 
 else 
{ 
System.out.println("\nNo Name start with "+search+" letter in Arraylist obj1"); 
} 
} 
} 