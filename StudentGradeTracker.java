import java.util.ArrayList;
import java.util.Scanner;

// Student class to store individual student data
class Student {
    String name;
    ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public int getHighest() {
        if (grades.isEmpty()) return 0;
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public int getLowest() {
        if (grades.isEmpty()) return 0;
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}

// Main class to run the program
public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            Student student = new Student(name);

            System.out.print("Enter the number of grades for " + name + ": ");
            int numGrades = scanner.nextInt();

            for (int j = 0; j < numGrades; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                int grade = scanner.nextInt();
                student.addGrade(grade);
            }
            scanner.nextLine(); // Consume the leftover newline
            students.add(student);
        }

        double totalAverage = 0;
        int overallHighest = Integer.MIN_VALUE;
        int overallLowest = Integer.MAX_VALUE;

        System.out.println("\n--- Student Report ---");
        for (Student student : students) {
            double avg = student.getAverage();
            int high = student.getHighest();
            int low = student.getLowest();
            totalAverage += avg;

            if (high > overallHighest) overallHighest = high;
            if (low < overallLowest) overallLowest = low;

            System.out.println("Student: " + student.name);
            System.out.printf("Average: %.2f\n", avg);
            System.out.println("Highest: " + high);
            System.out.println("Lowest: " + low);
            System.out.println();
        }

        double classAverage = students.isEmpty() ? 0 : totalAverage / students.size();
        System.out.println("--- Class Summary ---");
        System.out.printf("Class Average: %.2f\n", classAverage);
        System.out.println("Overall Highest Grade: " + overallHighest);
        System.out.println("Overall Lowest Grade: " + overallLowest);

        scanner.close();
    }
}
