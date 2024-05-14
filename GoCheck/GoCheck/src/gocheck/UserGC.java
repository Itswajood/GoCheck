
package gocheck;

import java.util.Scanner;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class UserGC extends AccountGC {

    static Scanner in = new Scanner(System.in);

    static TaskStack TaskStack = new TaskStack();
    static GoalsStack GoalStack = new GoalsStack();
    static String priorityVlaue;

    public UserGC() {
    }

    // suggestions method
    public static void suggestions(TaskStack TaskStack, GoalsStack GoalStack) {
        System.out.println("\n\n\t\t\t\t\tWelcome to Goals Gidince List\n\n\n");
        FileRead("GoalsList.txt");
        // print();
        String goaltxt = null, tasktxt = null;
        LocalDateTime dueDateTime;
        int answer, ch;

        do {

            String asp[] = { "CAREER", "SPIRITUALITY", "PHYSICAL HEALTH", "PERSONAL GROWTH", "ENTERTAINMENT",
                    "RELATIONSHIPS", "FINANCES" };
            JComboBox cb = new JComboBox<>(asp);

            int goalAsp = JOptionPane.showConfirmDialog(null, cb, "Choose the goal aspect of this template",
                    JOptionPane.DEFAULT_OPTION);

            int index = cb.getSelectedIndex();
            System.out.println("\t\t\t"+ asp[index]);

            System.out.println("choose the goal Number from the previouse Goals List: ");
            int goalnumber = CheckGoalnumber(in.nextInt());

            switch (index+1) {
                case 1:
                    System.out.println("How would you dicribe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(in.next());
                    Priority priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    if (goalnumber == 1) {
                        goaltxt = "Obtain a promotion to a managerial position within the next two years.";
                        tasktxt = "Dedicate 30 minutes each day to learning and acquiring new "
                                + "skills relevant to your desired managerial position,"
                                + " such as reading industry articles or taking online courses.";
                        dueDateTime = LocalDateTime.of(2026, 04, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 2) {
                        goaltxt = "Complete a professional certification program relevant to my field within the next six months.";
                        tasktxt = "Set aside time each day to work on a specific module or chapter of the"
                                + " professional certification program you are pursuing.";
                        dueDateTime = LocalDateTime.of(2024, 10, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 3) {
                        goaltxt = "Increase my professional network by attending at least two industry conferences or events each year.";
                        tasktxt = "Spend 15 minutes networking each day, whether it's reaching out to a professional contact, "
                                + "connecting with someone on LinkedIn, or attending virtual networking events.";
                        dueDateTime = LocalDateTime.of(2025, 04, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 4) {
                        goaltxt = "Improve my public speaking skills by joining a Toastmasters club and delivering regular presentations.";
                        tasktxt = "Practice public"
                                + " speaking for at least 10 minutes daily by recording yourself "
                                + "giving presentations or speeches and reviewing them for improvement.";
                        dueDateTime = LocalDateTime.of(2024, 10, 15, 23, 59); // default due date, then user can edit
                    } else {
                        goaltxt = "Launch my own business or freelance venture within the next five years.";
                        tasktxt = "Allocate time each day to research and plan "
                                + "for your future business or freelance venture, "
                                + "such as market analysis or developing a business plan.";
                        dueDateTime = LocalDateTime.of(2029, 04, 15, 23, 59); // default due date, then user can edit
                    }

                    Goal goalobj1 = new Goal(goaltxt, priority, dueDateTime, Aspact.CAREER);
                    GoalStack.push(goalobj1);
                    Task taskobj1 = new Task(tasktxt, priority, dueDateTime, Aspact.CAREER);
                    TaskStack.push(taskobj1);

                    break;

                case 2:
                    System.out.println("How would you dicribe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(in.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    if (goalnumber == 1) {
                        goaltxt = "Establish a consistent and focused daily routine for performing "
                                + "the five obligatory prayers (Salah) on time and with sincere devotion.";
                        tasktxt = "Perform the five daily prayers"
                                + " (Salah) at their prescribed times with focus by memorizing "
                                + "and reading a new chapter of Quran in each Rak'ah";
                        dueDateTime = LocalDateTime.of(2024, 07, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 2) {
                        goaltxt = "Engage in regular recitation, study, "
                                + "and reflection upon the Qur'an, seeking to understand its teachings and apply them in daily life.";
                        tasktxt = "Recite a 2 pages of the Qur'an each day, "
                                + "reflecting on its meaning and implementing its teachings in your life.";
                        dueDateTime = LocalDateTime.of(2024, 07, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 3) {
                        goaltxt = "Preserving the morning and evening Adhkar.";
                        tasktxt = "set Alarm for 7 am and 6 pm to read your Adhkar ";
                        dueDateTime = LocalDateTime.of(2024, 07, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 4) {
                        goaltxt = "Actively engage in acts of kindness, charity, and service to others. ";
                        tasktxt = "Donate 1 SAR daily ";
                        dueDateTime = LocalDateTime.of(2024, 07, 15, 23, 59); // default due date, then user can edit
                    } else {
                        goaltxt = "Meditate for at least 20 minutes every day to cultivate a sense of inner peace and mindfulness. ";
                        tasktxt = "Begin your day with a 20-minute meditation practice";
                        dueDateTime = LocalDateTime.of(2024, 07, 15, 23, 59); // default due date, then user can edit
                    }
                    Goal goalobj2 = new Goal(goaltxt, priority, dueDateTime, Aspact.SPIRITUALITY);
                    GoalStack.push(goalobj2);
                    Task taskobj2 = new Task(tasktxt, priority, dueDateTime, Aspact.SPIRITUALITY);
                    TaskStack.push(taskobj2);
                    break;
                case 3:
                    System.out.println("How would you dicribe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(in.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    if (goalnumber == 1) {
                        goaltxt = "Attain a black belt in a martial art. ";
                        tasktxt = "Engage in Martial Arts Training for at least 1 hour";
                        dueDateTime = LocalDateTime.of(2024, 9, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 2) {
                        goaltxt = "Exercising 5 days a week.";
                        tasktxt = "Enter chloe ting training program for workout";
                        dueDateTime = LocalDateTime.of(2024, 6, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 3) {
                        goaltxt = "Participate in an Olympic event.";
                        tasktxt = "Train for Your Chosen Olympic Event for a Minimum of 3-4 Hours";
                        dueDateTime = LocalDateTime.of(2024, 9, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 4) {
                        goaltxt = "Reduce stress levels through regular relaxation techniques such as yoga.";
                        tasktxt = "Practice a relaxation technique, such as deep breathing exercises or yoga,"
                                + " for 10 minutes to reduce stress levels.";
                        dueDateTime = LocalDateTime.of(2024, 6, 15, 23, 59); // default due date, then user can edit
                    } else {
                        goaltxt = "Maintain a balanced and nutritious diet by incorporating more fruits, vegetables, and whole grains.";
                        tasktxt = "Plan and prepare nutritious meals and snacks in advance.";
                        dueDateTime = LocalDateTime.of(2024, 7, 15, 23, 59); // default due date, then user can edit
                    }
                    Goal goalobj3 = new Goal(goaltxt, priority, dueDateTime, Aspact.PHYSICAL_HEALTH);
                    GoalStack.push(goalobj3);
                    Task taskobj3 = new Task(tasktxt, priority, dueDateTime, Aspact.PHYSICAL_HEALTH);
                    TaskStack.push(taskobj3);
                    break;
                case 4:
                    System.out.println("How would you dicribe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(in.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    if (goalnumber == 1) {
                        goaltxt = "Read at least one personal development or self-help book each month to expand my knowledge.";

                        // System.out.println("How many pages is the book that you want to read this
                        // month?");
                        String numOfPages = JOptionPane
                                .showInputDialog("\nHow many pages is the book that you want to read this month?");
                        // String numOfPages = in.next();
                        int convert = Integer.parseInt(numOfPages);
                        float nuumberOfpages = calculateDailyPagesOrsavingFor1Month(convert);
                        tasktxt = "read" + nuumberOfpages + " pages of your book daily to finish it in one month ";
                        dueDateTime = LocalDateTime.of(2025, 4, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 2) {
                        goaltxt = "Learn a new skill or hobby that challenges me and broadens my horizons.";
                        tasktxt = "Spend 15 minutes practicing a new skill or hobby that you're working on";
                        dueDateTime = LocalDateTime.of(2024, 9, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 3) {
                        goaltxt = "Journal regularly to reflect on my thoughts, emotions, and experiences.";
                        tasktxt = "Journal your day before sleeping";
                        dueDateTime = LocalDateTime.of(2024, 9, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 4) {
                        goaltxt = "Attend personal growth workshops, seminars, or courses to enhance my self-awareness and personal effectiveness.";
                        tasktxt = "Engage in online courses or educational platforms to learn and acquire "
                                + "new knowledge or skills.";
                        dueDateTime = LocalDateTime.of(2025, 4, 15, 23, 59); // default due date, then user can edit
                    } else {
                        goaltxt = "Learning a programing language such as Java.";
                        tasktxt = "Play Digital Steps game to learn the java with more fun (: ";
                        dueDateTime = LocalDateTime.of(2024, 9, 15, 23, 59); // default due date, then user can edit
                    }
                    Goal goalobj4 = new Goal(goaltxt, priority, dueDateTime, Aspact.PERSONAL_GROWTH);
                    GoalStack.push(goalobj4);
                    Task taskobj4 = new Task(tasktxt, priority, dueDateTime, Aspact.PERSONAL_GROWTH);
                    TaskStack.push(taskobj4);
                    break;
                case 5:
                    System.out.println("How would you dicribe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(in.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    if (goalnumber == 1) {
                        goaltxt = "Strengthen existing relationships (family and Friends).";
                        tasktxt = "Schedule quality time each day with a family member or friend, whether it's a phone call,"
                                + " video chat, or in-person meeting.";
                        dueDateTime = LocalDateTime.of(2024, 6, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 2) {
                        goaltxt = "Improve communication skills";
                        tasktxt = "Practice active listening and empathy in your conversations with others, "
                                + "seeking to understand their perspectives and feelings.";
                        dueDateTime = LocalDateTime.of(2024, 9, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 3) {
                        goaltxt = "Show appreciation and gratitude to loved ones through small gestures and acts of kindness.";
                        tasktxt = "Express appreciation and gratitude to"
                                + " loved ones through small gestures, such as writing a thank-you note or sending a "
                                + "thoughtful message.";
                        dueDateTime = LocalDateTime.of(2024, 5, 30, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 4) {
                        goaltxt = "Cultivate new friendships.";
                        tasktxt = "Reach out to one new person each day, whether it's sending a"
                                + " friendly message or initiating a conversation with someone you'd like to get to know better.";
                        dueDateTime = LocalDateTime.of(2024, 9, 15, 23, 59); // default due date, then user can edit
                    } else {
                        goaltxt = "maintaining family ties.";
                        tasktxt = "Plan to visit your family ties once a week";
                        dueDateTime = LocalDateTime.of(2024, 7, 15, 23, 59); // default due date, then user can edit
                    }
                    Goal goalobj5 = new Goal(goaltxt, priority, dueDateTime, Aspact.RELATIONSHIPS);
                    GoalStack.push(goalobj5);
                    Task taskobj5 = new Task(tasktxt, priority, dueDateTime, Aspact.RELATIONSHIPS);
                    TaskStack.push(taskobj5);
                    break;
                case 6:
                    System.out.println("How would you dicribe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(in.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    if (goalnumber == 1) {
                        goaltxt = "Save a specific amount of money each month towards a financial goal (e.g., emergency fund, down payment for a house).";
                        // System.out.print("\nHow many amount of money would you like to save for a
                        // month: ");

                        String floatnum = JOptionPane
                                .showInputDialog("\nHow many amount of money would you like to save for a month");
                        float convert = Float.parseFloat(floatnum);
                        float savingAmount = calculateDailyPagesOrsavingFor1Month(convert);
                        tasktxt = "Set aside a " + savingAmount + "SAR each day and transfer it to your "
                                + "designated savings or investment account.";
                        dueDateTime = LocalDateTime.of(2024, 9, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 2) {
                        goaltxt = "Develop additional streams of income.";
                        tasktxt = "Explore and research potential additional streams of income,"
                                + " such as brainstorming business ideas or studying investment opportunities.";
                        dueDateTime = LocalDateTime.of(2025, 9, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 3) {
                        goaltxt = "Reduce or eliminate debt by developing a repayment plan and sticking to it.";
                        tasktxt = "Spend 15 minutes each day researching and implementing strategies to reduce or eliminate debt,"
                                + " such as creating a debt repayment plan or negotiating lower interest rates.";
                        dueDateTime = LocalDateTime.of(2024, 5, 30, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 4) {
                        goaltxt = "Invest in personal finance education to grow my knowledge and make informed financial decisions.";
                        tasktxt = "Dedicate time to reading personal finance books, blogs, or articles to expand your financial knowledge.";
                        dueDateTime = LocalDateTime.of(2024, 9, 15, 23, 59); // default due date, then user can edit
                    } else {
                        goaltxt = "Reduce Eating Out Expenses. ";
                        tasktxt = "Reminder from your future bank account: Try cooking your meals in home today ):";
                        dueDateTime = LocalDateTime.of(2024, 5, 30, 23, 59); // default due date, then user can edit
                    }
                    Goal goalobj6 = new Goal(goaltxt, priority, dueDateTime, Aspact.FINANCES);
                    GoalStack.push(goalobj6);
                    Task taskobj6 = new Task(tasktxt, priority, dueDateTime, Aspact.FINANCES);
                    TaskStack.push(taskobj6);

                    break;
                case 7:
                    System.out.println("How would you dicribe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(in.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    if (goalnumber == 1) {
                        goaltxt = "Explore new genres of books, movies, or TV shows outside of my usual preferences.";
                        tasktxt = "Allocate 30 minutes each day to explore and indulge in a book,"
                                + " movie, or TV show from a different genre or culture.";
                        dueDateTime = LocalDateTime.of(2024, 6, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 2) {
                        goaltxt = "Visit new places and travel to different destinations to experience new cultures and broaden my perspective.";
                        tasktxt = "Research and plan for future travel destinations,"
                                + " discovering new cultures, attractions, or activities.";
                        dueDateTime = LocalDateTime.of(2024, 8, 31, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 3) {
                        goaltxt = "Connect with like-minded individuals through participation in hobby groups, clubs, or online communities.";
                        tasktxt = "try today to connect with like-minded individuals through online hobby groups or communities,"
                                + " participating in discussions or sharing experiences.";
                        dueDateTime = LocalDateTime.of(2024, 8, 15, 23, 59); // default due date, then user can edit
                    } else if (goalnumber == 4) {
                        goaltxt = "Engage in creative hobbies such as painting, writing, or photography on a regular basis.";
                        tasktxt = "Allocate 30 minutes each day to try a new hobby from your goal new  hobby list ";
                        dueDateTime = LocalDateTime.of(2024, 6, 30, 23, 59); // default due date, then user can edit
                    } else {
                        goaltxt = "Master a New Card Trick.";
                        tasktxt = "Practice and Refine Card Tricks for a Dedicated Time Slot (30-45 minutes)";
                        dueDateTime = LocalDateTime.of(2024, 6, 13, 23, 59); // default due date, then user can edit
                    }
                    Goal goalobj7 = new Goal(goaltxt, priority, dueDateTime, Aspact.ENTERTAINMENT);
                    GoalStack.push(goalobj7);
                    Task taskobj7 = new Task(tasktxt, priority, dueDateTime, Aspact.ENTERTAINMENT);
                    TaskStack.push(taskobj7);

                    break;

                default:
                    // JOptionPaneout:
                    System.out.println("Invalid");
            }

            System.out.println("If you want to add another goal to your List choose:1 or 0 to exit: ");
            answer = in.nextInt();

        } while (answer != 0);

    }

    public static void YourList(TaskStack TaskStack, GoalsStack GoalStack) {
        int answer, ch;
        String goalText = null, tasktxt = null;
        LocalDateTime goalDueDate, taskDueDate;
        do {
            String asp[] = { "CAREER", "SPIRITUALITY", "PHYSICAL HEALTH", "PERSONAL GROWTH", "ENTERTAINMENT",
                    "RELATIONSHIPS", "FINANCES" };
            JComboBox cb = new JComboBox<>(asp);

            int goalAsp = JOptionPane.showConfirmDialog(null, cb, "Choose the goal aspect of this template",
                    JOptionPane.DEFAULT_OPTION);

            int index = cb.getSelectedIndex();

            System.out.println("\t\t\t" + asp[index]);
            
            switch (index + 1) {

                case 1:
                    in.nextLine();
                    System.out.println("Write the goal: ");
                    goalText = in.nextLine();

                    System.out.println("Write what you want to do on a daily basis to achieve the goal?: ");
                    tasktxt = in.nextLine();

                    System.out.println("How would you dicribe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(in.next());
                    Priority priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    
                    in.nextLine();
                    goalDueDate = validGoalDueDate();
                    taskDueDate = validTaskDueDate();

                    Task taskobj1 = new Task(tasktxt, priority, taskDueDate, Aspact.CAREER);
                    TaskStack.push(taskobj1);
                    Goal goalobj1 = new Goal(goalText, priority, goalDueDate, Aspact.CAREER);
                    GoalStack.push(goalobj1);
                    break;

                case 2:
                    in.nextLine();
                    System.out.println("Write the goal: ");
                    goalText = in.nextLine();

                    System.out.println("Write what you want to do on a daily basis to achieve the goal?: ");
                    tasktxt = in.nextLine();

                    System.out.println("How would you dicribe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(in.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    
                    in.nextLine();
                    goalDueDate = validGoalDueDate();
                    taskDueDate = validTaskDueDate();

                    Task taskobj2 = new Task(tasktxt, priority, taskDueDate, Aspact.SPIRITUALITY);
                    TaskStack.push(taskobj2);
                    Goal goalobj2 = new Goal(goalText, priority, goalDueDate, Aspact.SPIRITUALITY);
                    GoalStack.push(goalobj2);
                    break;

                case 3:
                    in.nextLine();
                    System.out.println("Write the goal: ");
                    goalText = in.nextLine();

                    System.out.println("Write what you want to do on a daily basis to achieve the goal?: ");
                    tasktxt = in.nextLine();

                    System.out.println("How would you dicribe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(in.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    in.nextLine();
                    goalDueDate = validGoalDueDate();
                    taskDueDate = validTaskDueDate();

                    Task taskobj3 = new Task(tasktxt, priority, taskDueDate, Aspact.PHYSICAL_HEALTH);
                    TaskStack.push(taskobj3);
                    Goal goalobj3 = new Goal(goalText, priority, goalDueDate, Aspact.PHYSICAL_HEALTH);
                    GoalStack.push(goalobj3);
                    break;

                case 4:
                    in.nextLine();
                    System.out.println("Write the goal: ");
                    goalText = in.nextLine();

                    System.out.println("Write what you want to do on a daily basis to achieve the goal?: ");
                    tasktxt = in.nextLine();

                    System.out.println("How would you dicribe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(in.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    in.nextLine();
                    goalDueDate = validGoalDueDate();
                    taskDueDate = validTaskDueDate();

                    Task taskobj4 = new Task(tasktxt, priority, taskDueDate, Aspact.PERSONAL_GROWTH);
                    TaskStack.push(taskobj4);
                    Goal goalobj4 = new Goal(goalText, priority, goalDueDate, Aspact.PERSONAL_GROWTH);
                    GoalStack.push(goalobj4);
                    break;

                case 5:
                    in.nextLine();
                    System.out.println("Write the goal: ");
                    goalText = in.nextLine();

                    System.out.println("Write what you want to do on a daily basis to achieve the goal?: ");
                    tasktxt = in.nextLine();

                    System.out.println("How would you dicribe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(in.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    in.nextLine();
                    goalDueDate = validGoalDueDate();
                    taskDueDate = validTaskDueDate();

                    Task taskobj5 = new Task(tasktxt, priority, taskDueDate, Aspact.ENTERTAINMENT);
                    TaskStack.push(taskobj5);
                    Goal goalobj5 = new Goal(goalText, priority, goalDueDate, Aspact.ENTERTAINMENT);
                    GoalStack.push(goalobj5);
                    break;
                case 6:
                    in.nextLine();
                    System.out.println("Write the goal: ");
                    goalText = in.nextLine();

                    System.out.println("Write what you want to do on a daily basis to achieve the goal?: ");
                    tasktxt = in.nextLine();

                    System.out.println("How would you dicribe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(in.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    in.nextLine();
                    goalDueDate = validGoalDueDate();
                    taskDueDate = validTaskDueDate();

                    Task taskobj6 = new Task(tasktxt, priority, taskDueDate, Aspact.RELATIONSHIPS);
                    TaskStack.push(taskobj6);
                    Goal goalobj6 = new Goal(goalText, priority, goalDueDate, Aspact.RELATIONSHIPS);
                    GoalStack.push(goalobj6);
                    break;
                case 7:
                    in.nextLine();
                    System.out.println("Write the goal: ");
                    goalText = in.nextLine();

                    System.out.println("Write what you want to do on a daily basis to achieve the goal?: ");
                    tasktxt = in.nextLine();

                    System.out.println("How would you dicribe this goal priority? (HIGH, MEDIUM, LOW )");
                    priorityVlaue = CheckPrioritValue(in.next());
                    priority = Priority.valueOf(priorityVlaue.toUpperCase());
                    in.nextLine();
                    goalDueDate = validGoalDueDate();
                    taskDueDate = validTaskDueDate();

                    Task taskobj7 = new Task(tasktxt, priority, taskDueDate, Aspact.FINANCES);
                    TaskStack.push(taskobj7);
                    Goal goalobj7 = new Goal(goalText, priority, goalDueDate, Aspact.FINANCES);
                    GoalStack.push(goalobj7);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid", "Wrong choose", JOptionPane.ERROR_MESSAGE);

            }

            System.out.println("If you want to add another goal to your List choose:1 or 0 to exit: ");
            answer = in.nextInt();

        } while (answer != 0);

    }

    // myList method
    public static void manage(TaskStack TaskStack, GoalsStack GoalStack) {
        System.out.print("\n1_Add a Task"
                + "\n2_Update a Task"
                + "\n3_Check a Goal"
                + "\n4_Check a Task"
                + "\n5_Dispaly My List"
                + "\n6_Sort My Tasks"
                + "\n7_Back"
                + "\n-->");
        int ch = in.nextInt();
        while (ch != 7) {
            switch (ch) {
                case 1:
                    addTask();
                    break;
                case 2:
                    updateTask();
                    break;
                case 3:
                    checkGoal();
                case 4:
                    checkTask();
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    System.out.println("Sort by:" +
                            "\n1- Sort in ascending order of their due dates." +
                            "\n2- Sort in descending order of their due dates." +
                            "\n3- Sort tasks based on their priority (High to Low)" +
                            "\n4- Sort tasks based on their priority (Low to High)"
                            + "\n-->");
                    in.nextLine();
                    int sort = in.nextInt();

                    if (sort == 1) {
                        TaskStack.sortTasksACS();
                        TaskStack.displayTask();
                        return;
                    } else if (sort == 2) {
                        TaskStack.sortTasksDECS();
                        TaskStack.displayTask();
                        return;
                    } else if (sort == 3) {
                        TaskStack.sortByPriorityHigh();
                        TaskStack.displayTask();
                        return;
                    } else if (sort == 4) {
                        TaskStack.sortByPriorityLow();
                        TaskStack.displayTask();
                        return;
                    }

                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid", "Wrong choose", JOptionPane.ERROR_MESSAGE);
            }

            in.nextLine();
            System.out.print("\n1_Add a Task"
                    + "\n2_Update a Task"
                    + "\n3_Check a Goal"
                    + "\n4_Check a Task"
                    + "\n5_Dispaly My List"
                    + "\n6_Sort My Tasks"
                    + "\n7_Back"
                    + "\n-->");
            ch = in.nextInt();
        }
    }

    // add task method
    public static void addTask() {
        GoCheck obj = new GoCheck();
        obj.showUsermenu();
    }

    // update task method
    public static void updateTask() {
        in.nextLine();

        System.out.print("\nWhat would you like to update:"
                + "\n1-Goal Text of your created tasks"
                + "\n2-Task"
                + "\n-->");
        int update = in.nextInt();

        if (update == 1) {
            in.nextLine();
            System.out.println("\nType in the Text of the Goal:");
            String goalPos = in.nextLine();
            if (GoalStack.find(goalPos)) {
                in.nextLine();
                System.out.println("\nType in the New Goal Text:");
                String newGoal = in.nextLine();
                GoalStack.updateGoal(goalPos, newGoal);
            }
        } else {
            in.nextLine();
            System.out.println("\nType in the Text of the Task:");
            String taskPos = in.nextLine();

            if (TaskStack.find(taskPos)) {

                System.out.print("\nWhat would you like to update:"
                        + "\n1-Task Text"
                        + "\n2-Task Priority"
                        + "\n3-Task Aspact"
                        + "\n4-Task Due-Date"
                        + "\n-->");
                update = in.nextInt();

                if (update == 1) {
                    in.nextLine();
                    System.out.println("\nType in the New Task Text:");
                    String newTitle = in.nextLine();
                    TaskStack.updateText(taskPos, newTitle);
                } else if (update == 2) {
                    in.nextLine();
                    System.out.println("\nType in the New Task Priority (HIGH, MEDIUM, LOW ):");
                    String newPriority = CheckPrioritValue(in.next());
                    TaskStack.updatePriority(taskPos, newPriority);
                } else if (update == 3) {
                    in.nextLine();
                    System.out.println("\nType in the New Aspact"
                            + "CAREER,\n" +
                            "    SPIRITUALITY,\n" +
                            "    PHYSICAL_HEALTH,\n" +
                            "    PERSONAL_GROWTH,\n" +
                            "    ENTERTAINMENT,\n" +
                            "    RELATIONSHIPS,\n" +
                            "    FINANCES");
                    String aspact = in.next();
                    TaskStack.updateAspact(taskPos, aspact);
                } else if (update == 4) {
                    in.nextLine();
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

    // check task method
    public static void checkTask() {

        in.nextLine();
        System.out.print("\n1_Check First"
                + "\n2_Check At Position"
                + "\n3_Check All"
                + "\n4_Back"
                + "\n-->");
        int ch = in.nextInt();

        switch (ch) {
            case 1:
                TaskStack.checkTask();
                break;
            case 2:
                System.out.println("\nAt what position is the task?");
                int pos = in.nextInt();
                TaskStack.checkAtPos(pos);
                break;
            case 3:
                TaskStack.checkAll();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid", "Invalid choose", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void checkGoal() {

        System.out.print("\n1_Check First"
                + "\n2_Check At Position"
                + "\n3_Check All"
                + "\n4_Back"
                + "\n-->");
        int ch2 = in.nextInt();

        switch (ch2) {
            case 1:
                GoalStack.checkGoal();
                break;
            case 2:
                System.out.println("\nAt what position is the Goal?");
                int pos = in.nextInt();
                GoalStack.checkAtPos(pos);
                break;
            case 3:
                GoalStack.checkAll();
                break;
            case 4:
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid", "Invalid choose", JOptionPane.ERROR_MESSAGE);
        }

    }

    // display task method
    public static void display() {
        System.out.print("\n1_Display Goal List"
                + "\n2_Display Tasks List"
                + "\n3_Back"
                + "\n-->");
        int ch = in.nextInt();
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

            in.nextLine();
            System.out.print("\n1_Display Goal List"
                    + "\n2_Display Tasks List"
                    + "\n3_Back"
                    + "\n-->");
            ch = in.nextInt();
        }
    }



    public static void FileRead(String fileName) {

        try {

            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(fileName);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            // Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                System.out.println(strLine);
            }
            // Close the input stream
            in.close();
        } catch (Exception e) {// Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

    }

    public static int CheckGoalnumber(int answer) {
        while (true) {
            if (answer == 1 || answer == 2 || answer == 3 || answer == 4 || answer == 5) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "You have entered a wrong response.", "input Validation",
                        JOptionPane.ERROR_MESSAGE);
                System.out.println(
                        "Please enter one of the following numbers " + "(1,2,3,4,5) that represnt the goal you want");
                answer = in.nextInt();

            }
        }
        return answer;
    }

    public static String CheckPrioritValue(String answer) {
        while (true) {
            if (answer.equals("HIGH") || answer.equals("high") || answer.equals("LOW") || answer.equals("low")
                    || answer.equals("MEDIUM") || answer.equals("medium")) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "You have entered a wrong response.", "input Validation",
                        JOptionPane.ERROR_MESSAGE);
                System.out.println(
                        "Please enter one of the following (HIGH, MEDUIM, LOW) that represnt the Priority of this goal");
                answer = in.next();
            }

        }
        return answer;
    }

    public static float calculateDailyPagesOrsavingFor1Month(float number) {

        float dailyPagesOrsaving = (float) number / 30;
        return dailyPagesOrsaving;
    }

    public static LocalDateTime validGoalDueDate() {
        String gDueDate;
        DateTimeFormatter Gformatter;
        LocalDateTime goalDueDate = null;

        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("What's the due-date for the goal? (yyyy-MM-dd HH:mm)");
                gDueDate = in.nextLine();
                Gformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                goalDueDate = LocalDateTime.parse(gDueDate, Gformatter);

                // Check if the entered date is not in the past
                if (goalDueDate.isBefore(LocalDateTime.now())) {
                    JOptionPane.showMessageDialog(null, "Invalid date-time. Please enter a future date-time.", "Wrong ",
                            JOptionPane.ERROR_MESSAGE);
                    // System.out.println("Invalid date-time. Please enter a future date-time.");
                } else {
                    validInput = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid date-time format. Please enter date-time in the format yyyy-MM-dd HH:mm.", "Wrong ",
                        JOptionPane.ERROR_MESSAGE);
                // System.out.println("Invalid date-time format. Please enter date-time in the
                // format yyyy-MM-dd HH:mm.");
            }
        }

        return goalDueDate;
    }

    public static LocalDateTime validTaskDueDate() {
        String tDueDate;
        DateTimeFormatter Tformatter;
        LocalDateTime taskDueDate = null;

        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("What's the due-date for the task? (yyyy-MM-dd HH:mm)");
                tDueDate = in.nextLine();
                Tformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                taskDueDate = LocalDateTime.parse(tDueDate, Tformatter);

                // Check if the entered date is not in the past
                if (taskDueDate.isBefore(LocalDateTime.now())) {

                    System.out.println("Invalid date-time. Please enter a future date-time.");
                } else {
                    validInput = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Invalid date-time format. Please enter date-time in the format yyyy-MM-dd HH:mm.", "Wrong ",
                        JOptionPane.ERROR_MESSAGE);
                // System.out.println("Invalid date-time format. Please enter date-time in the
                // format yyyy-MM-dd HH:mm.");
            }
        }

        return taskDueDate;
    }

}// end class
