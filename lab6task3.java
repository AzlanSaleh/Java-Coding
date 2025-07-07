class Person {
    private String name;
    private int age;

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

    public void displayPerson() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class lab6task3 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("azlan saleh");
        person.setAge(19);
        person.displayPerson();
    }
}