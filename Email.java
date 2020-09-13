import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int emailCapacity = 100;
    private String alternateEmail;
    private String companyDomain = "mycompany.com";

    Scanner in = new Scanner(System.in);

    // Create a constructor which gets two parameters (first name, last name)
    public Email(String firstName, String lastName) {
        Scanner in = new Scanner(System.in);
        this.firstName = firstName;
        this.lastName = lastName;

        // If our employee wants to change his first name and last name
        System.out.println("You entered a name: " + this.firstName + " " + this.lastName);
        System.out.println("Is this right? y/n");
        String isTrue = in.next();
        if (isTrue.equals("n")) {
            setNameAndSurname();
        }

        // Call a method that asks employee about department
        this.department = setDepartment();
        // Creaing email-account which based on employee's first name, last name and department
        if (this.department == "") {
            email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + companyDomain;
            System.out.println("YOUR EMAIL IS CREATED: " + email);
        } else {
            email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + "." + companyDomain;
            System.out.println("YOUR EMAIL IS CREATED: " + email);
        }

        // Call a method that generates random password
        this.password = randomPassword();
        System.out.println("YOUR NEW PASSWORD IS: " + this.password);
        System.out.println("");

        // Ask an employee if he wants to change his password
        System.out.println("DO YOU WANNA CHANGE YOUR PASSWORD? y/n");
        isTrue = in.next();
        if (isTrue.equals("y")) {
            setPassword();
        }
    }

    // Method for choosing department
    private String setDepartment() {
        System.out.print("DEPARTMENT NUMBERS: \n1 - Sales\n2 - Development\n3 - Accounting\n0 - None\nEnter the department number: ");
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    // Method for changing a first name, and last name
    public void setNameAndSurname() {
        System.out.println("Enter your first name: ");
        this.firstName = in.next();
        System.out.println("Enter your last name: ");
        this.lastName = in.next();
    }

    // Method for generating random default password
    private String randomPassword() {
        String chars = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            password.append(chars.charAt((int) (Math.random() * chars.length())));
        }
        String newPassword = password.toString();
        return newPassword;
    }

    // Method for changing default password to new
    public void setPassword() {
        System.out.print("ENTER YOUR NEW PASSWORD: ");
        String myPassword = in.next();
        System.out.print("CONFIRM YOUR NEW PASSWORD: "); // To make sure, that an employee won't forget his new password
        String myPassword2 = in.next();
        if (!myPassword.equals(myPassword2)) {
            System.out.println("ERROR. PASSWORDS AREN'T THE SAME");
            System.out.println("");
            setPassword();
        } else if (myPassword.length() < 8) {
            System.out.println("ERROR. PASSWORD LENGTH MUST BE MORE OR EQUALS 8");
            System.out.println("");
            setPassword();
        } else {
            this.password = myPassword;
            System.out.println("PASSWORD IS CONFIRMED");
            System.out.println("");
        }
    }

    // Method for setting an alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Method for setting email capacity, default = 100mb
    public void setEmailCapacity(int capacity) {
        this.emailCapacity = capacity;
    }

    // Method that returns email capacity
    public int getEmailCapacity() {
        return emailCapacity;
    }

    // Method that gives us info about employee
    public void getInfo() {
        System.out.println(this.firstName + " " + this.lastName);
        System.out.println("EMAIL: " + this.email);
        System.out.println("MAILBOX CAPACITY: " + this.emailCapacity + "mb");
    }
}
