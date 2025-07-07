package com;

import java.util.ArrayList;
import java.util.List;

// Abstract class Person
abstract class Person {
    private String name;
    private String id;

    // Constructor
    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    // Abstract method
    public abstract String getDetails();
}

// Interface Evaluatable
interface Evaluatable {
    void evaluatePerformance();
}

// Student class
class Student extends Person implements Evaluatable {
    private String program;
    private int semester;

    // Constructor
    public Student(String name, String id, String program, int semester) {
        super(name, id);
        this.program = program;
        this.semester = semester;
    }

    // Getters
    public String getProgram() {
        return program;
    }

    public int getSemester() {
        return semester;
    }

    // Overriding getDetails method
    @Override
    public String getDetails() {
        return "Student [Name: " + getName() + ", ID: " + getId() + ", Program: " + program + ", Semester: " + semester + "]";
    }

    // Implementing evaluatePerformance method
    @Override
    public void evaluatePerformance() {
        System.out.println(getName() + " is evaluated based on GPA and coursework.");
    }
}

// Faculty class
class Faculty extends Person implements Evaluatable {
    private String designation;
    private String department;

    // Constructor
    public Faculty(String name, String id, String designation, String department) {
        super(name, id);
        this.designation = designation;
        this.department = department;
    }

    // Getters
    public String getDesignation() {
        return designation;
    }

    public String getDepartment() {
        return department;
    }

    // Overriding getDetails method
    @Override
    public String getDetails() {
        return "Faculty [Name: " + getName() + ", ID: " + getId() + ", Designation: " + designation + ", Department: " + department + "]";
    }

    // Implementing evaluatePerformance method
    @Override
    public void evaluatePerformance() {
        System.out.println(getName() + " is evaluated based on teaching performance and research output.");
    }
}

// Main class
public class l10t2 {
    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> people = new ArrayList<>();

        // Add Student and Faculty objects to the list
        people.add(new Student("azlan ", "S123", "Computer Science", 3));
        people.add(new Faculty("sabeer", "F456", "Professor", "Mathematics"));
        people.add(new Student("rafy", "S789", "Electrical Engineering", 2));
        people.add(new Faculty("ali", "F101", "Assistant Professor", "Physics"));

        // Iterate through the list and call getDetails() and evaluatePerformance()
        for (Person person : people) {
            System.out.println(person.getDetails());
            if (person instanceof Evaluatable) {
                ((Evaluatable) person).evaluatePerformance();
            }
            System.out.println();
        }
    }
}