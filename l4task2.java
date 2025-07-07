class student {
    String name;
    int rollNo;
    double marks;
}
public class l4task2 {
    public static void main(String[] args) {
        student std1 = new student();
        std1.name = "Azlan Saleh";
        std1.rollNo = 015;
        std1.marks = 75;
        System.out.println("Name : "+ std1.name);
        System.out.println("Roll No : "+ std1.rollNo);
        System.out.println("Marks : "+ std1.marks);
    }
}
