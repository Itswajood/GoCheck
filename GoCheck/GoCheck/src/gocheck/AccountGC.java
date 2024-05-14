package gocheck;

import javax.swing.*;
import java.util.Scanner;

public class AccountGC {
    public Scanner input = new Scanner(System.in);

    Node head = null;
    Node tail = null;

    int size = 0;

    private class Node {

        private Node next, prev;

        private String fname;
        private String lname;
        private String age;
        private String gender;
        private String username;
        private String email;
        private String password;
        private String phoneNumber;



        public Node(String fname, String lname, String age, String gender, String username,String email, String password, String phoneNumber, Node next, Node prev) {
            this.next = next;
            this.prev = prev;
            this.fname = fname;
            this.lname = lname;
            this.age = age;
            this.gender = gender;
            this.username = username;
            this.email = email;
            this.password = password;
            this.phoneNumber = phoneNumber;
        }


        public Node() {

        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getLname(){
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }


        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            boolean flag;
            do {
                flag = false;
                if (isUsernameUnique(username)) {
                    this.username = username;
                    flag = true;
                } else {
                    JOptionPane.showMessageDialog(null, "This username is already used, please try again.");
                    username = JOptionPane.showInputDialog("Enter Username:");
                }
            } while (!flag);
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            boolean flag;
            do {
                flag = false;
                if (isEmailUnique(email) && checkEmail(email)) {
                    this.email = email;
                    flag = true;
                    break;
                } else if (!checkEmail(email)) {
                    JOptionPane.showMessageDialog(null, "You have entered an invalid email, kindly try again.");
                    email = JOptionPane.showInputDialog("Enter Email:");
                } else {
                    JOptionPane.showMessageDialog(null, "This Email is already used, please try again.");
                    email = JOptionPane.showInputDialog("Enter Email:");
                }
            } while (!flag);
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            boolean flag;
            do {
                flag = false;
                if (checkPassword(password)) {
                    this.password = password;
                    flag = true;
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "You have entered an invalid password, kindly try again.\nHint: Your Password must:\n1- Be between 8 and 15 characters. \n2- Include at least one letter.\n3- Include at least one number.\n4- Include at least one symbol (@,#,%,$,&)");
                    password = JOptionPane.showInputDialog("Enter Password:");
                }
            } while (!flag);
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            boolean flag;
            do {
                flag = false;
                if (checkPNumber(phoneNumber) && isPhoneNumberUnique(phoneNumber)) {
                    this.phoneNumber = phoneNumber;
                    flag = true;
                    break;
                } else if (!isPhoneNumberUnique(phoneNumber)) {
                    JOptionPane.showMessageDialog(null, "This Phone Number is already used, please try again.");
                    phoneNumber = JOptionPane.showInputDialog("Enter Phone Number:");
                } else {
                    JOptionPane.showMessageDialog(null, "You have entered an invalid Phone Number, kindly try again.\nHint: Phone number must be a 10 digits:)");
                    phoneNumber = JOptionPane.showInputDialog("Enter Phone Number:");
                }
            } while (!flag);
        }

        

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }



    } // end node

    public AccountGC() {
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void addUser(Node newNode) {

        // this method will be called in createAccount() method
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            newNode.prev = head;
        } else {
            newNode.prev = head;
            tail.next = newNode;
            head.prev = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;


    }

    public void find(String username) {

        if (isEmpty()) {
            System.out.println("The program has no users yet");
            return;
        }

        Node current = head;
        boolean found = false;

        do {
            if (current.getUsername().equals(username)) {
                System.out.println("The username " + username + " is found");
                found = true;
                return;
            }

            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("The username " + username + " not found");
        }
    }

    public void dispalyAccounts() {

        if (isEmpty()) {
            System.out.println("The List is Empty!");
            return;
        }

        Node current = head;
        System.out.println("The Avaliable Accounts: ");

        do {
            System.out.println("username : " + current.getUsername());
            System.out.println("name: " + current.getFname() + " " + current.getLname());
            System.out.println("age: " + current.getAge());
            System.out.println("email: " + current.getEmail());
            System.out.println("phone number: " + current.getPhoneNumber());
            System.out.println("_________________________________________________");

            current = current.next;

        } while (current != head);

    }

    public void createAccount() {

        Node newNode = new Node();

        System.out.println("--- CREATING NEW ACCOUNT ---");
        System.out.println("Please Enter the needed data to create your account");

        JTextField fnameField = new JTextField(10);
        JTextField lnameField = new JTextField(10);
        JTextField ageField = new JTextField(3);
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        JTextField emailField = new JTextField(20);
        JTextField passwordField = new JTextField(20);
        JTextField phoneNumberField = new JTextField(12);
        JTextField usernameField = new JTextField(10);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("First Name:"));
        panel.add(fnameField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lnameField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(new JLabel("Gender:"));
        panel.add(maleButton);
        panel.add(femaleButton);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("Phone Number:"));
        panel.add(phoneNumberField);
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);

        int result = JOptionPane.showConfirmDialog(null, panel, "User Information", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String fname = fnameField.getText();
            String lname = lnameField.getText();
            String age = ageField.getText();
            String gender = maleButton.isSelected() ? "Male" : "Female";
            String email = emailField.getText();
            String password = passwordField.getText();
            String phoneNumber = phoneNumberField.getText();
            String username = usernameField.getText();

            // Set the values to the new node
            newNode.setFname(fname);
            newNode.setLname(lname);
            newNode.setAge(age);
            newNode.setGender(gender);
            newNode.setEmail(email);
            newNode.setPassword(password);
            newNode.setPhoneNumber(phoneNumber);
            newNode.setUsername(username);

            // Add the new node to the list
            addUser(newNode);
        } else {
            System.out.println("User cancelled the operation.");
            int continueDialog = JOptionPane.showConfirmDialog(null, "You Should Create an Account\nYES to create account\nNO to exit the program", "Do you want to create account", JOptionPane.YES_NO_OPTION);
            
            if (continueDialog == JOptionPane.YES_OPTION){
                createAccount();
            }else{
                System.exit(0);
            }
        }
    }

    private boolean isEmailUnique(String email) {
        if (isEmpty()) {
            return true; // No users in the system, so email is unique
        }

        Node current = head;
        do {
            if (current.getEmail().equalsIgnoreCase(email)) {
                return false; // Email already exists
            }
            current = current.next;
        } while (current != head);

        return true; // Email is unique
    }

    public boolean isPhoneNumberUnique(String phoneNumber) {
        if (isEmpty()) {
            return true;
        }
        Node current = head;
        do {
            if (current.getPhoneNumber().equals(phoneNumber)) {
                return false;
            }
            current = current.next;
        } while (current != head);
        return true;
    }

    public boolean isUsernameUnique(String username) {
        if (isEmpty()) {
            return true;
        }
        Node current = head;
        do {
            if (current.getUsername().equalsIgnoreCase(username)) {
                return false;
            }
            current = current.next;
        } while (current != head);
        return true;
    }

    public static boolean checkEmail(String email) {
        String emailRegex = "^[\\w.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
        return email.matches(emailRegex);
    }

    public static boolean checkPassword(String password) { // method that return true only if the password is valid to
                                                           // the conditions
        // pass should be > 8 charecter
        // at least 1 letter
        // at least 1 number
        // at least one spical char (@ , & , %, $, #)

        boolean hasLetter = false;
        boolean hasNumber = false;
        boolean hasChar = false;

        if (password.length() >= 8 && password.length() <= 15) {

            for (int i = 0; i < password.length(); i++) {

                char ch = password.charAt(i); // to make strings to char

                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                    hasLetter = true;
                } else if (ch >= '0' && ch <= '9') {
                    hasNumber = true;
                } else if (ch == '@' || ch == '#' || ch == '%' || ch == '$' || ch == '&') {
                    hasChar = true;
                }
            }
        }
        return hasLetter && hasNumber && hasChar;
    }

    public boolean validateUser(String username, String password){
        if (isEmpty()){
            System.out.println("No Accounts were founds");
            return false;
        }
        Node current = head;

        do {
            if (current.getUsername().equals(username) && current.getPassword().equals(password)){
                return true;
            }
            current = current.next;
        } while (current != head);

        return false;
    }

    public static boolean checkPNumber(String pNumber) {
        return pNumber.length() == 10; // true onlyif phone number is 10 digits
    }

    public void adminAccounts(){

        Node admin1 = new Node("Wajood", "Khalid", "21", "Female", "WajoodK", "2220001292@iau.edu.sa", "WKwk1234&", "0540326426", null, null);
        addUser(admin1);
        Node admin2 = new Node("Norah", "Alanzi", "21", "Female", "NorahAlanzi.51", "22200000572@iau.edu.sa", "No1222$#8935", "0551732744",null, null);
        addUser(admin2);
        Node admin3 = new Node("Nada","Alrshid","21","Female","Nada123","2220000552@iau.edu.sa","Nada34561","0543559646",null,null);
        addUser(admin3);
        Node admin4 = new Node("Lojain","Hafez","21","Female","Lojan23","2220000@iau.edu.sa","Lo456&","055555555",null,null);
        addUser(admin4);

    }

}
