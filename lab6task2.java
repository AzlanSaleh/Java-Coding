class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    public void display() {
        System.out.println("Dog Name: " + name);
        System.out.println("Dog Age: " + age);
    }
}

public class lab6task2 {
    public static void main(String[] args) {
        Dog myDog = new Dog("job", 3);
        myDog.display();
    }
}
