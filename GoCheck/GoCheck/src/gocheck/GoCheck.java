package gocheck;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GoCheck {

    static Scanner in = new Scanner(System.in);
    static TaskStack TaskStack = new TaskStack();
    static GoalsStack GoalStack = new GoalsStack();
    static AdminTaskStack TaskStackAdmin = new AdminTaskStack();
    static AdminGoalsStack GoalStackAdmin = new AdminGoalsStack();
    static UserGC myUser;
    static AdminGC myAdmins;

    static {
        System.out.println("\n\t\tGO CHECK");
    }

    
    public static void main(String[] args) {

        boolean registeredUser = false;
        String continueChoice = " ";

        ImageIcon icon = new ImageIcon("logo.png");

        myUser = new UserGC();
        myAdmins = new AdminGC();

        do {

            String choice = JOptionPane.showInputDialog("\n1_USER\n2_ADMIN\n");

            while (!choice.equals("1") && !choice.equals("2")) {
                // JOptionPane:
                JOptionPane.showMessageDialog(null, "You have entered a wrong response.", "Wrong",
                        JOptionPane.ERROR_MESSAGE);

                choice = JOptionPane.showInputDialog(" Please enter 1 or 2");
            }

            // int choice = in.nextInt();
            if (choice.equals("1")) {

                int result = JOptionPane.showConfirmDialog(null, "Do You Have An Account in GoCheck?", "GoCheck", JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    in.nextLine();
                    System.out.println("Enter a username");
                    String username = in.next();
                    System.out.println("Enter a password: ");
                    String password = in.next();

                    if (myUser.validateUser(username, password)) {
                        // JOptionPaneout
                        System.out.println("Account is found Welcome agine to  Go Check!");
                        JOptionPane.showMessageDialog(null, "Account is found Welcome again to Go Check!", "@" + username + " Welcome",
                                JOptionPane.PLAIN_MESSAGE, icon);
                        registeredUser = true;
                        
                    }
                }
                if (!registeredUser) {
                    myUser.createAccount();
                    registeredUser = true;
                    JOptionPane.showMessageDialog(null, "Account is Created Welcome to Go Check!", " Welcome",
                            JOptionPane.PLAIN_MESSAGE, icon);
                }

                if (registeredUser == true) {
                    showUsermenu();
                }
            } // end user part
            else if (choice.equals("2")) {

                myAdmins.adminAccounts();

                in.nextLine();
                System.out.println("Enter a username: ");

                String username1 = in.next();

                System.out.println("Enter a password: ");

                String password = in.next();

                if (myAdmins.validateUser(username1, password)) {
                    // JOptionPaneout:
                    JOptionPane.showMessageDialog(null, "Account is found Welcome again to Go Check!", "@" + username1 + " Welcome",
                            JOptionPane.PLAIN_MESSAGE, icon);
                    // admin codes
                    showAdminMenu();
                } else {
                    System.out.println("You're not a registerd admin");
                }
            } // end Admin part

            System.out.println("\n\nDo you want to continue in the application? (y/n)");
            continueChoice = in.next();
            System.out.println("");

        } while (continueChoice.charAt(0) == 'y' || continueChoice.charAt(0) == 'y');

        // end do while
    }

    public static void showUsermenu() {
        System.out.print("\n1_Choose from our Suggestions"
                + "\n2_Create your list"
                + "\n3_Manage your list"
                + "\n4_Back"
                + "\n-->");
        int ch = in.nextInt();
        while (ch != 4) {
            switch (ch) {
                case 1:
                    myUser.suggestions(TaskStack, GoalStack);
                    break;
                case 2:
                    myUser.YourList(TaskStack, GoalStack);
                    break;
                case 3:
                    myUser.manage(TaskStack, GoalStack);
                    break;
                default:
                    System.out.println("Invalid");
            }

            in.nextLine();
            System.out.print("\n1_Choose from our Suggestions"
                    + "\n2_Creat your list"
                    + "\n3_Manage your list"
                    + "\n4_Back"
                    + "\n-->");
            ch = in.nextInt();
        }
    }

    public static void showAdminMenu() {
        System.out.println("\n1_Create a Suggestions Templates"
                + "\n2_Manage your created lists"
                + "\n3_Print your Report"
                + "\n4_Back"
                + "\n-->");
        int ch = in.nextInt();
        while (ch != 4) {

            switch (ch) {
                case 1:
                    myAdmins.createTemplate(TaskStackAdmin, GoalStackAdmin);
                    break;

                case 2:
                    myAdmins.manage();
                    break;

                case 3:
                    myAdmins.printReport("AdminReport.txt");
                    break;

                default:
                    break;
            }

            System.out.println("\n1_Create a Suggestions Templates"
                    + "\n2_Manage your created lists"
                    + "\n3_Print your Report"
                    + "\n4_Back"
                    + "\n-->");
            ch = in.nextInt();
        }
    }

    public static boolean inputValidation(String answer) {
        while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
            // JOptionPaneout:
            JOptionPane.showMessageDialog(null, "You have entered a wrong response", "input Validation",
                    JOptionPane.ERROR_MESSAGE);
            System.out.println("Please enter 'y' or 'n'");
            answer = in.nextLine();
        }

        return answer.equalsIgnoreCase("y");
    }// end inputValidation

}
