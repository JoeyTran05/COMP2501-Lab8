/**
 * @author joey tran
 */

public class Student {
    private String firstName;
    private String lastName;
    private String idNumber;
    private int birthYear;
    private double grade;
    private boolean pass;

    public Student() {
    }

    public Student(final String firstName, final String lastName, final String idNumber, final int birthYear, final double grade) {
        setFirstName(firstName);
        setLastName(lastName);
        setIdNumber(idNumber);
        setBirthYear(birthYear);
        setGrade(grade);
        this.pass = grade >= 60.0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public double getGrade() {
        return grade;
    }

    public boolean isPass() {
        return pass;
    }

    public void setFirstName(final String firstName) {
        if (firstName != null && !firstName.trim().isEmpty()) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Invalid first name");
        }
    }

    public void setLastName(final String lastName) {
        if (lastName != null && !lastName.trim().isEmpty()) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Invalid last name");
        }
    }

    public void setIdNumber(final String idNumber) {
        if (idNumber != null && !idNumber.trim().isEmpty()) {
            this.idNumber = idNumber;
        } else {
            throw new IllegalArgumentException("Invalid ID number");
        }
    }

    public void setBirthYear(final int birthYear) {
        if (birthYear > 0) {
            this.birthYear = birthYear;
        } else {
            throw new IllegalArgumentException("Invalid birth year");
        }
    }

    public void setGrade(final double grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
            this.pass = grade >= 60.0;
        } else {
            throw new IllegalArgumentException("Invalid grade percentage");
        }
    }

    @Override
    public String toString() {
        return "Student [firstName=" + firstName + ", lastName=" + lastName + ", idNumber=" + idNumber +
                ", birthYear=" + birthYear + ", grade=" + grade + ", pass=" + pass + "]";
    }
}
