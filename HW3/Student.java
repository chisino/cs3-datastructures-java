/* Author: Artiom Dolghi
 * Due date: Feb 5, 2020
 * Purpose: The various methods compare Students differently so they can be sorted as such
 * Credits: I did all of the work independently on my own
 */
//import java.io.*; 
import java.util.*; 

// A class 'Student' that implements Comparable 
class Student implements Comparable<Student> { 
  private String firstName;
  private String lastName;
  private String major; 
  private double gpa; 

  //Implement the following method, so that students can be sorted by their lastname
  public int compareTo(Student m) { 
	  return this.lastName.compareTo(m.lastName);
  } 
  
  // Constructor 
  public Student(String fn, String ln, String major, double gpa) { 
    this.firstName = fn;
    this.lastName = ln;
    this.major = major; 
    this.gpa = gpa; 
  } 
  
  // Getter methods for accessing private data 
  public String getLastName() { return lastName; }
  public String getFirstName() { return firstName; }
  public String getMajor() { return major; }
  public double getGPA() { return gpa; }

  public static void main(String[] args) { 
    ArrayList<Student> list = new ArrayList<Student>(); 
    list.add(new Student("Ellen", "Smith", "cs", 3.78)); 
    list.add(new Student("Ava", "Johnson", "math", 3.92)); 
    list.add(new Student("Mia", "Williams", "cs", 3.66));
    list.add(new Student("Sophie", "Brown", "math", 3.72)); 
    list.add(new Student("Nele", "Davis", "cs", 3.88)); 
    
    //Sort by last name
    System.out.println("Sorted by last name:");
    Collections.sort(list);
    for (Student student: list) {
        System.out.println(student.getLastName() + " " +  student.getFirstName() + " " + student.getMajor() + " " + student.getGPA()); 
      }
    
    //Sort by first name
    System.out.println("\nSorted by first name:");
    FirstNameCompare firstNameCompare = new FirstNameCompare();
    Collections.sort(list, firstNameCompare);
    for (Student student: list) {
    	System.out.println(student.getLastName() + " " +  student.getFirstName() + " " + student.getMajor() + " " + student.getGPA());
      }
    
    //Sort by major
    System.out.println("\nSorted by major:");
    MajorCompare majorCompare = new MajorCompare();
    Collections.sort(list, majorCompare);
    for (Student student: list) {
    	System.out.println(student.getLastName() + " " +  student.getFirstName() + " " + student.getMajor() + " " + student.getGPA()); 
      }
    
    //Sort by GPA
    System.out.println("\nSorted by GPA (highest to lowest):");
    GPACompare gpaCompare = new GPACompare();
    Collections.sort(list, gpaCompare);
    Collections.reverse(list);
    for (Student student: list) {
    	System.out.println(student.getLastName() + " " +  student.getFirstName() + " " + student.getMajor() + " " + student.getGPA()); 
      }
    
  }
}


class FirstNameCompare implements Comparator<Student> { 
	public int compare(Student s1, Student s2) { 
		return s1.getFirstName().compareTo(s2.getFirstName());
	} 
} 

class MajorCompare implements Comparator<Student> { 
	public int compare(Student s1, Student s2) { 
		return s1.getMajor().compareTo(s2.getMajor());
	} 
} 

class GPACompare implements Comparator<Student> { 
	public int compare(Student s1, Student s2) { 
		if (s1.getGPA() < s2.getGPA()) return -1; 
		if (s1.getGPA() > s2.getGPA()) return 1; 
		else return 0; 
	} 
} 