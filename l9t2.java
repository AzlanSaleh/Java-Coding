package com;

class Person {
    private String name;
    private String CNIC;

    // Constructor
    public Person(String name, String CNIC) {
        this.name = name;
        this.CNIC = CNIC;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for CNIC
    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }
}

class Teacher extends Person {
    private String[] courseNames;

    // Constructor
    public Teacher(String name, String CNIC, int numberOfCourses) {
        super(name, CNIC);
        this.courseNames = new String[numberOfCourses];
    }

    // Method to set course names
    public void setCourseNames(String[] courseNames) {
        if (courseNames.length == this.courseNames.length) {
            System.arraycopy(courseNames, 0, this.courseNames, 0, courseNames.length);
        } else {
            System.out.println("Error: Number of courses does not match.");
        }
    }

    // Method to get course names
    public String[] getCourseNames() {
        return courseNames;
    }

    // Method to display teacher's full profile
    public void displayProfile() {
        System.out.println("Name: " + getName());
        System.out.println("CNIC: " + getCNIC());
        System.out.println("Courses Taught:");
        for (String course : courseNames) {
            System.out.println("- " + course);
        }
    }
}

public class l9t2 {
    public static void main(String[] args) {
        // Create a Teacher object
        Teacher teacher = new Teacher("John Doe", "12345-6789012-3", 3);

        // Set course names
        String[] courses = {"Mathematics", "Physics", "Computer Science"};
        teacher.setCourseNames(courses);

        // Display teacher's profile
        teacher.displayProfile();
    }
}
