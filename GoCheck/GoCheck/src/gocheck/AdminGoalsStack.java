/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gocheck;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author THINKPAD
 */
public class AdminGoalsStack {
    
     private static class Node {
        private Goal goal;
        private Node next = null;

        public Node(Goal goal, Node n) { // norah
            this.goal = goal;
            this.next = n;
        }

        public Goal getGoal() {
            return goal;
        }
    }// end node

    private static Node top = null;
    private static int size = 0;

    public AdminGoalsStack() {
    }

    public static boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public int size() {
        return size;
    }

    public void push(Goal goal) { // norah
        Node newNode = new Node(goal, null);
        newNode.next = top;
        top = newNode;
        size++;
      //  System.out.println("Your goal has been add to your goal list");
       JOptionPane.showMessageDialog(null, "Your goal has been add to your goal list", "Adding To the Goal List", JOptionPane.INFORMATION_MESSAGE); 

        System.out.println(goal.toString());
    }

    public Goal checkGoal() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }

        Goal temp = top.goal;
        top = top.next;
        size--;
        System.out.println("Top Goal is popped");
        return temp;
    }

    public void checkAtPos(int position)
    {
         if (isEmpty() || position <= 0) {
             JOptionPane.showMessageDialog(null, "Invalid", "Invalid position or List is empty", JOptionPane.ERROR_MESSAGE); 
            return;
        }

        if (position == 1) {
            top = top.next;
            System.out.println("Task is popped");
            size--;
            return;
        }

        Node temp = top;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (top == null || top.next == null) {
            System.out.println("Position is out of bounds");
            return;
        }

        temp.next = temp.next.next;
        size--;
        System.out.println("Goal is popped");
    }
    public Goal checkAll() {
        if (isEmpty()) {
            System.out.println("List is already Empty!");
            return null;
        }
        while (top != null) {
            top = top.next;
            size--;
        }
        
       
        System.out.println("List is Empty now");
        return null;
    }

    public void displayGoal() { // wajood
     
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        Node current = top;
        System.out.println("Goal List: ");
        while (current != null) {
            Goal goals = current.goal;
            System.out.println("Goal [Goal = " + goals.getGoal_text() + ", Aspact = " + goals.getGoal_aspact()
                    + ", Priority = " + goals.getGoal_priority()
                    + ", Due Date = " + goals.toString_dueDate() + "]");
            current = current.next;
        }
    }

    public static boolean find(String val) {
        if (isEmpty()) {
            System.out.println("The List Is Empty.");
            return false;
        }

        Node current = top;
        int counter = 0;
        boolean flag = false;

        while (current != null) {
            counter++;

            if (current.goal.getGoal_text().equals(val)) {
                System.out.println("Goal is Found at node: " + counter);
                flag = true;
            } // end if

            current = current.next;
        }
        if (flag) {
            return true;
        } else {
            System.out.println("The Goal Was not Found");
            return false;
        }
    }

    public static void updateGoal(String old, String newGoal) {
    
         
        Node current = top;
        int counter = 0;

        while (current != null) {
            counter++;

            if (current.goal.getGoal_text().equals(old)) {
                current.goal.setGoal_text(newGoal);
            } // end if

            current = current.next;
        }

    }

    public void timeLeft(Goal goal) { // wajood

        // this method calculate the time left for the task due date

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dueDateTime = goal.getGoal_dueDate();
        long daysLeft = ChronoUnit.DAYS.between(now, dueDateTime);
        long hoursLeft = ChronoUnit.HOURS.between(now, dueDateTime);
        long minutesLeft = ChronoUnit.MINUTES.between(now, dueDateTime);

        if (daysLeft > 0) {
            System.out.println("Task: " + goal.getGoal_text() + ", Days Left: " + daysLeft + ", Hours Left: "
                    + hoursLeft % 24 + ", Minutes Left: " + minutesLeft % 60);
        } else {
            System.out.println("Task: " + goal.getGoal_text() + ", Hours Left: " + hoursLeft + ", Minutes Left: "
                    + minutesLeft % 60);
        }
    }

    // sort methods

    // 1. Sort Based On the due date
    public void sortGoalsACS() { // sort from less time left to long time left

        if (isEmpty() || size() == 1) {
            return;
        }

        Node current = top;
        Node sorted = null;

        while (current != null) {
            Node next = current.next;

            if (sorted == null || sorted.goal.getGoal_dueDate().isAfter(current.goal.getGoal_dueDate())) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;

                while (temp.next != null && temp.next.goal.getGoal_dueDate().isBefore(current.goal.getGoal_dueDate())) {
                    temp = temp.next;
                }

                current.next = temp.next;
                temp.next = current;

            }
            current = next;
        }

        top = sorted;

    }

    public void sortGoalsDECS() { // sort from long time left to less time left

        if (isEmpty() || size() == 1) {
            return;
        }

        Node current = top;
        Node sorted = null;

        while (current != null) {
            Node next = current.next;

            if (sorted == null || sorted.goal.getGoal_dueDate().isBefore(current.goal.getGoal_dueDate())) { 
                current.next = sorted;
                sorted = current;
            } else {
                
                Node temp = sorted;

                while (temp.next != null && temp.next.goal.getGoal_dueDate().isAfter(current.goal.getGoal_dueDate())) { 
                    temp = temp.next;
                }

                current.next = temp.next;
                temp.next = current;

            }
            current = next;
        }

        top = sorted;

    }

    // 2. Sort based on the Priority

    public void sortByPriorityHigh() { // sort tasks based on priorty from high to low

        if (isEmpty() || size() == 1) {
            return;
        }

        Node current = top;
        Node sorted = null;

        while (current != null) {

            Node next = current.next;

            if (sorted == null
                    || sorted.goal.getGoal_priority().ordinal() >= current.goal.getGoal_priority().ordinal()) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;

                while (temp.next != null
                        && temp.next.goal.getGoal_priority().ordinal() < current.goal.getGoal_priority().ordinal()) {
                    temp = temp.next;
                }

                current.next = temp.next;
                temp.next = current;
            }
            current = next;
        }
        top = sorted;

        /*
         * ordinal() method is a part of the Enum class. It returns the ordinal value of
         * an enum constant.
         * The ordinal value is the position of the enum constant in its enum
         * declaration, starting from zero.
         */
    }

    public void sortByPriorityLow() { // sort tasks based on priorty from low to high

        if (isEmpty() || size() == 1) {
            return;
        }

        Node current = top;
        Node sorted = null;

        while (current != null) {

            Node next = current.next;

            if (sorted == null
                    || sorted.goal.getGoal_priority().ordinal() <= current.goal.getGoal_priority().ordinal()) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;

                while (temp.next != null
                        && temp.next.goal.getGoal_priority().ordinal() > current.goal.getGoal_priority().ordinal()) {
                    temp = temp.next;
                }

                current.next = temp.next;
                temp.next = current;
            }
            current = next;
        }
        top = sorted;

        /*
         * ordinal() method is a part of the Enum class. It returns the ordinal value of
         * an enum constant.
         * The ordinal value is the position of the enum constant in its enum
         * declaration, starting from zero.
         */
    }
}
