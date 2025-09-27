import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private int id;
    private String name;
    private double marks;

    public Main(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }

    // ================= MAIN LOGIC =================

    private static Map<Integer, Main> students = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> viewStudentById();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (students.containsKey(id)) {
            System.out.println("Student with this ID already exists!");
            return;
        }
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();
        students.put(id, new Main(id, name, marks));
        System.out.println("✅ Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            students.values().forEach(System.out::println);
        }
    }

    private static void viewStudentById() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        Main student = students.get(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("❌ Student with ID " + id + " not found.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Main student = students.get(id);
        if (student != null) {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new marks: ");
            double marks = scanner.nextDouble();
            student.setName(name);
            student.setMarks(marks);
            System.out.println("✅ Student updated successfully!");
        } else {
            System.out.println("❌ Student with ID " + id + " not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        if (students.remove(id) != null) {
            System.out.println("✅ Student deleted successfully!");
        } else {
            System.out.println("❌ Student with ID " + id + " not found.");
        }
    }
}