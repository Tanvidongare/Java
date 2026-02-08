import java.util.Scanner;

class StudentMarks {

    String studentName;
    int rollNumber;
    int[] marks = new int[5];
    int average;
    char grade;

    static int[] subjectTotal = new int[5];
    static int studentCount = 0;

    void input(Scanner sc) {
        System.out.println("Enter Name:");
        studentName = sc.nextLine();

        System.out.println("Enter Roll No:");
        rollNumber = sc.nextInt();

        System.out.println("Enter marks for 5 subjects:");
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            marks[i] = sc.nextInt();
            sum += marks[i];
            subjectTotal[i] += marks[i];
        }

        average = sum / 5;

        if (average >= 75)
            grade = 'A';
        else if (average >= 60)
            grade = 'B';
        else
            grade = 'C';

        studentCount++;
        sc.nextLine(); // clear buffer
    }

    void display() {
        System.out.println("\nName: " + studentName);
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Average Marks: " + average);
        System.out.println("Grade: " + grade);
    }

    static void displaySubjectAverages() {
        System.out.println("\nAverage Marks for Each Subject:");
        for (int i = 0; i < 5; i++) {
            System.out.println(
                    "Subject " + (i + 1) + ": " + (subjectTotal[i] / studentCount));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of students:");
        int n = sc.nextInt();
        sc.nextLine();

        StudentMarks[] students = new StudentMarks[n];

        for (int i = 0; i < n; i++) {
            students[i] = new StudentMarks();
            students[i].input(sc);
            students[i].display();
        }

        StudentMarks.displaySubjectAverages();
        sc.close();
    }
}
