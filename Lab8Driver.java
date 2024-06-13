/**
 * @author joey tran
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Lab8Driver {
    private HashMap<String, Student> students = new HashMap<>();

    public static void main(final String[] args) {
        Lab8Driver driver = new Lab8Driver();
        System.out.println("DEBUG: calling readFromPrompt");
        driver.readFromPrompt();
        System.out.println("DEBUG: calling readFromFile");
        driver.readFromFile();
        driver.showStudents();
    }

    public void readFromPrompt() {
        Scanner scanner = new Scanner(System.in);
        boolean proceed = true;
        do {
            System.out.println("Do you wish to create a Student? (y/n): ");
            String choice = scanner.next().toLowerCase();
            if (choice.equals("y")) {
                scanner.nextLine(); // Consume newline

                System.out.println("Enter first name:");
                String firstName = scanner.nextLine();

                System.out.println("Enter last name:");
                String lastName = scanner.nextLine();

                System.out.println("Enter id number:");
                String idNumber = scanner.nextLine();

                System.out.println("Enter birth year as a whole number:");
                int birthYear = scanner.nextInt();

                System.out.println("Enter grade (percent) as a decimal number:");
                double grade = scanner.nextDouble();

                try {
                    Student student = new Student(firstName, lastName, idNumber, birthYear, grade);
                    students.put(idNumber, student);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error creating student: " + e.getMessage());
                }
            } else {
                proceed = false;
            }
        } while (proceed);
        System.out.println("Data entry finished!");
    }

    public void readFromFile() {
        try (Scanner fileScanner = new Scanner(new File("student_data.txt"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 5) {
                    try {
                        String firstName = data[0].trim();
                        String lastName = data[1].trim();
                        String idNumber = data[2].trim();
                        int birthYear = Integer.parseInt(data[3].trim());
                        double grade = Double.parseDouble(data[4].trim());
                        Student student = new Student(firstName, lastName, idNumber, birthYear, grade);
                        students.put(idNumber, student);
                    } catch (NumberFormatException e) {
                        System.out.println("Error reading line: " + line + " - " + e.getMessage());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public void showStudents() {
        System.out.println("List of Students created:");
        for (Student student : students.values()) {
            System.out.println(student);
        }
    }
}
