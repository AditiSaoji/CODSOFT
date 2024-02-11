import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}
class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int rollNumber) {
        boolean removed = false;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                System.out.println("Student removed successfully.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Student not found.");
        }
    }

    public void searchStudent(int rollNumber) {
        boolean found = false;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student found:\n" + student);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("All students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}


public class StudentsManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();
                    Student newStudent = new Student(name, rollNumber, grade);
                    system.addStudent(newStudent);
                    break;
                case 2:
                    System.out.print("Enter roll number of student to remove: ");
                    int removeRollNumber = sc.nextInt();
                    system.removeStudent(removeRollNumber);
                    break;
                case 3:
                    System.out.print("Enter roll number of student to search: ");
                    int searchRollNumber = sc.nextInt();
                    system.searchStudent(searchRollNumber);
                    break;
                case 4:
                    system.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
                    System.out.println("Please try again.");
            }
        }
    }
}