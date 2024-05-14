
package gocheck;

import static gocheck.UserGC.TaskStack;
import static gocheck.UserGC.validTaskDueDate;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class AdminGC extends AccountGC {

    static Scanner input = new Scanner(System.in);
    static AdminTaskStack TaskStack = new AdminTaskStack();
    static AdminGoalsStack GoalStack = new AdminGoalsStack();
    static String priorityVlaue;

    static int addCounter = 0,updateCounterText = 0, updateCounterPriority= 0,updateCounterDueDate=0,updateCounterAspact=0 ,displayCounter = 0, addGoalCounter = 0;

    public void welcome() {
        System.out.println("\n\t\tWelcome to GoCheck:)");
    }

    public AdminGC() {
    }

    public void createTemplate(AdminTaskStack TaskStack, AdminGoalsStack GoalsStack) { // calling in main showAdminMenu()

        // this method allows the admin to create a suggestions template

        addCounter++; // to count how many lists did the admin had created
        int answer, ch;
        String goalText = null, tasktxt = null;
        LocalDateTime goalDueDate, taskDueDate;
        Priority priority;

        do {

            String asp[] = { "CAREER", "SPIRITUALITY", "PHYSICAL HEALTH", "PERSONAL GROWTH", "ENTERTAINMENT",
                    "RELATIONSHIPS", "FINANCES" };
            JComboBox cb = new JComboBox<>(asp);

            int goalAsp = JOptionPane.showConfirmDialog(null, cb, "Choose the goal aspect of this template",
                    JOptionPane.DEFAULT_OPTION);

            int index = cb.getSelectedIndex();
input.nextLine();
            switch (index + 1) {
                
                case 1:
                    System.out.println("\t\t" + asp[0]);
                    
                    System.out.println("Write the goal: ");
                    goalText = input.nextLine();

                    System.out.println("Write what you want to do on a daily basis to achieve the goal?: ");
                    tasktxt = input.nextLine();

                    System.out.println("How would you describe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(input.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    input.nextLine();
                    goalDueDate = validGoalDueDate();
                    taskDueDate = validTaskDueDate();

                    Task taskobj1 = new Task(tasktxt, priority, taskDueDate, Aspact.CAREER);
                    TaskStack.push(taskobj1);
                    
                    Goal goalobj1 = new Goal(goalText, priority, goalDueDate, Aspact.CAREER);
                    GoalStack.push(goalobj1);

                    break;

                case 2:

                    System.out.println("\t\t" + asp[1]);
                    System.out.println("Write the goal: ");
                    goalText = input.nextLine();

                    System.out.println("Write what you want to do on a daily basis to achieve the goal?: ");
                    tasktxt = input.nextLine();

                    System.out.println("How would you describe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(input.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    input.nextLine();
                    goalDueDate = validGoalDueDate();
                    taskDueDate = validTaskDueDate();

                    Task taskobj2 = new Task(tasktxt, priority, taskDueDate, Aspact.SPIRITUALITY);
                    TaskStack.push(taskobj2);
                    Goal goalobj2 = new Goal(goalText, priority, goalDueDate, Aspact.SPIRITUALITY);
                    GoalStack.push(goalobj2);
                    break;

                case 3:
                    System.out.println("\t\t" + asp[2]);
                    System.out.println("Write the goal: ");
                    goalText = input.nextLine();

                    System.out.println("Write what you want to do on a daily basis to achieve the goal?: ");
                    tasktxt = input.nextLine();

                    System.out.println("How would you describe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(input.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    input.nextLine();
                    goalDueDate = validGoalDueDate();
                    taskDueDate = validTaskDueDate();

                    Task taskobj3 = new Task(tasktxt, priority, taskDueDate, Aspact.PHYSICAL_HEALTH);
                    TaskStack.push(taskobj3);
                    Goal goalobj3 = new Goal(goalText, priority, goalDueDate, Aspact.PHYSICAL_HEALTH);
                    GoalStack.push(goalobj3);
                    break;

                case 4:

                    System.out.println("\t\t" + asp[3]);
                    System.out.println("Write the goal: ");
                    goalText = input.nextLine();

                    System.out.println("Write what you want to do on a daily basis to achieve the goal?: ");
                    tasktxt = input.nextLine();

                    System.out.println("How would you describe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(input.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    input.nextLine();
                    goalDueDate = validGoalDueDate();
                    taskDueDate = validTaskDueDate();

                    Task taskobj4 = new Task(tasktxt, priority, taskDueDate, Aspact.PERSONAL_GROWTH);
                    TaskStack.push(taskobj4);
                    Goal goalobj4 = new Goal(goalText, priority, goalDueDate, Aspact.PERSONAL_GROWTH);
                    GoalStack.push(goalobj4);
                    break;

                case 5:

                    System.out.println("\t\t" + asp[4]);
                    System.out.println("Write the goal: ");
                    goalText = input.nextLine();

                    System.out.println("Write what you want to do on a daily basis to achieve the goal?: ");
                    tasktxt = input.nextLine();

                    System.out.println("How would you describe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(input.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    input.nextLine();
                    goalDueDate = validGoalDueDate();
                    taskDueDate = validTaskDueDate();

                    Task taskobj5 = new Task(tasktxt, priority, taskDueDate, Aspact.ENTERTAINMENT);
                    TaskStack.push(taskobj5);
                    Goal goalobj5 = new Goal(goalText, priority, goalDueDate, Aspact.ENTERTAINMENT);
                    GoalStack.push(goalobj5);
                    break;

                case 6:
                    System.out.println("\t\t" + asp[5]);
                    System.out.println("Write the goal: ");
                    goalText = input.nextLine();

                    System.out.println("Write what you want to do on a daily basis to achieve the goal?: ");
                    tasktxt = input.nextLine();

                    System.out.println("How would you describe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(input.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    input.nextLine();
                    goalDueDate = validGoalDueDate();
                    taskDueDate = validTaskDueDate();

                    Task taskobj6 = new Task(tasktxt, priority, taskDueDate, Aspact.RELATIONSHIPS);
                    TaskStack.push(taskobj6);
                    Goal goalobj6 = new Goal(goalText, priority, goalDueDate, Aspact.RELATIONSHIPS);
                    GoalStack.push(goalobj6);
                    break;

                case 7:
                    System.out.println("\t\t" + asp[6]);
                    System.out.println("Write the goal: ");
                    goalText = input.nextLine();

                    System.out.println("Write what you want to do on a daily basis to achieve the goal?: ");
                    tasktxt = input.nextLine();

                    System.out.println("How would you describe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(input.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    input.nextLine();
                    goalDueDate = validGoalDueDate();
                    taskDueDate = validTaskDueDate();

                    Task taskobj7 = new Task(tasktxt, priority, taskDueDate, Aspact.FINANCES);
                    TaskStack.push(taskobj7);
                    Goal goalobj7 = new Goal(goalText, priority, goalDueDate, Aspact.FINANCES);
                    GoalStack.push(goalobj7);
                    break;

                default:
                    System.out.println("Invalid");
                    break;
            }

            System.out.println("If you want to add another goal to your List choose:1 or 0 to exit: ");
            answer = input.nextInt();

        } while (answer != 0);

    }

    public void manage() {
        System.out.print("\n1_Add a Task"
                + "\n2_Update a Task"
                + "\n3_Display My List"
                + "\n4_Back"
                + "\n-->");
        int ch = input.nextInt();

        while (ch != 4) {
            switch (ch) {
                case 1:
                    addTask();
                    addCounter++;
                    break;

                case 2:
                    updateTask();
                    break;

                case 3:
                    display();
                    displayCounter++;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid", "Wrong choose", JOptionPane.ERROR_MESSAGE);

            }

           // input.nextInt();
            System.out.print("\n1_Add a Task"
                    + "\n2_Update a Task"
                    + "\n3_Display My List"
                    + "\n4_Back"
                    + "\n-->");
            ch = input.nextInt();

        }
    }


    public static void printReport(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("\n\n");
            writer.println("\t\t -------------------------------------------------------------------------");
            writer.println("\t\t|   Admin Report indicates the Number of Operation prformed by the Admin  |");
            writer.println("\t\t -------------------------------------------------------------------------");
            writer.println("\t\t Add opreation: " + addCounter);
            writer.println("\t\t Update Text opreation: " + updateCounterText);
            writer.println("\t\t Update Priority opreation: " + updateCounterPriority);
            writer.println("\t\t Update Due-Date opreation: " + updateCounterDueDate);
            writer.println("\t\t Update Aspact opreation: " + updateCounterAspact);
            writer.println("\t\t Display opreation: " + displayCounter);
            writer.println("\t\t--------------------------------------------------------------------------");
            System.out.println("\n\n ******** Your Report is printed in AdminReport File successfully ********");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + filename);
        }
    }

    public static void addTask() {
        GoCheck obj = new GoCheck();
        obj.showAdminMenu();
    }

    public static void updateTask() {
      
        input.nextLine();

        System.out.print("\nWhat would you like to update:"
                + "\n1-Goal Text of your created tasks"
                + "\n2-Task"
                + "\n-->");
        int update = input.nextInt();

        if (update == 1) {
            
            input.nextLine();
            System.out.println("\nType in the Text of the Goal:");
            String goalPos = input.nextLine();
            boolean found=false;
            
            while(true){
                 if (GoalStack.find(goalPos)==true){
                     found = true;
                     break;
                 }
               System.out.println("\nType in the Text of the Goal:");
                goalPos = input.nextLine();
            }
             updateCounterText++;
           
            if (found) {
                input.nextLine();
                System.out.println("\nType in the New Goal Text:");
                String newGoal = input.nextLine();
                GoalStack.updateGoal(goalPos, newGoal);
                 
            }
            
        } 
        else {
            input.nextLine();
            System.out.println("\nType in the Text of the Task:");
            String taskPos = input.nextLine();

            if (TaskStack.find(taskPos)) {

                System.out.print("\nWhat would you like to update:"
                        + "\n1-Task Text"
                        + "\n2-Task Priority"
                        + "\n3-Task Aspact"
                        + "\n4-Task Due-Date"
                        + "\n-->");
                update = input.nextInt();

                if (update == 1) {
                    updateCounterText++;
                    input.nextLine();
                    System.out.println("\nType in the New Task Text:");
                    String newTitle = input.nextLine();
                    TaskStack.updateText(taskPos, newTitle);
                } else if (update == 2) {
                    updateCounterPriority++;
                    input.nextLine();
                    System.out.println("\nType in the New Task Priority (HIGH, MEDIUM, LOW ):");
                    String newPriority = CheckPrioritValue(input.next());
                    TaskStack.updatePriority(taskPos, newPriority);
                } else if (update == 3) {
                    updateCounterAspact++;
                    input.nextLine();
                    System.out.println("\nType in the New Aspact"
                            + "CAREER,\n" +
                            "    SPIRITUALITY,\n" +
                            "    PHYSICAL_HEALTH,\n" +
                            "    PERSONAL_GROWTH,\n" +
                            "    ENTERTAINMENT,\n" +
                            "    RELATIONSHIPS,\n" +
                            "    FINANCES");
                    String aspact = input.next();
                    TaskStack.updateAspact(taskPos, aspact);
                } else if (update == 4) {
                    updateCounterDueDate++;
                    input.nextLine();
                    System.out.println("\nType in the New Task Due-Date:"
                            + "not availavle now");
                    LocalDateTime newDate = validTaskDueDate();
                    TaskStack.updateDueDate(taskPos, newDate);
                    return;
                } else {
                    System.out.println("Invalid");
                }
            }
        }
        

    }

    // display task method
    public static void display() {
        System.out.print("\n1_Display Goal List"
                + "\n2_Display Tasks List"
                + "\n3_Back"
                + "\n-->");
        int ch = input.nextInt();

        while (ch != 3) {
            switch (ch) {
                case 1:
                    GoalStack.displayGoal();
                    break;
                case 2:
                    TaskStack.displayTask();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid", "Invalid choose", JOptionPane.ERROR_MESSAGE);
            }

          
            System.out.print("\n1_Display Goal List"
                    + "\n2_Display Tasks List"
                    + "\n3_Back"
                    + "\n-->");
            ch = input.nextInt();
        }
    }

    public static String CheckPrioritValue(String answer) {
        while (true) {
            if (answer.equals("HIGH") || answer.equals("high") || answer.equals("LOW") || answer.equals("low")
                    || answer.equals("MEDIUM") || answer.equals("medium")) {
                break;
            } else {
                System.out.println(
                        "You have entered a wrong response. Please enter one of the following (HIGH, MEDUIM, LOW) that represnt the Priority of this goal");
                answer = input.next();
            }

        }
        return answer;
    }

    public static LocalDateTime validGoalDueDate() { // this method check if the entered due date is in the right format
                                                     // && it's a future date
        String gDueDate;
        DateTimeFormatter Gformatter;
        LocalDateTime goalDueDate = null;

        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("What's the due-date for the goal? (yyyy-MM-dd HH:mm)");
                gDueDate = input.nextLine();
                Gformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                goalDueDate = LocalDateTime.parse(gDueDate, Gformatter);

                // Check if the entered date is not in the past
                if (goalDueDate.isBefore(LocalDateTime.now())) {
                    System.out.println("Invalid date-time. Please enter a future date-time.");
                } else {
                    validInput = true;
                }
            } catch (Exception e) {
                System.out.println("Invalid date-time format. Please enter date-time in the format yyyy-MM-dd HH:mm.");
            }
        }

        return goalDueDate;
    }

    public static LocalDateTime validTaskDueDate() { // this method check if the entered due date is in the right format
                                                     // && it's a future date
        String tDueDate;
        DateTimeFormatter Tformatter;
        LocalDateTime taskDueDate = null;

        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("What's the due-date for the task? (yyyy-MM-dd HH:mm)");
                tDueDate = input.nextLine();
                Tformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                taskDueDate = LocalDateTime.parse(tDueDate, Tformatter);

                // Check if the entered date is not in the past
                if (taskDueDate.isBefore(LocalDateTime.now())) {
                    System.out.println("Invalid date-time. Please enter a future date-time.");
                } else {
                    validInput = true;
                }
            } catch (Exception e) {
                System.out.println("Invalid date-time format. Please enter date-time in the format yyyy-MM-dd HH:mm.");
            }
        }

        return taskDueDate;
    }

}
