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
public class AdminTaskStack {
     private static class Node {
        private Node next = null;
        private Task task; // wajood

        public Node(Task task, Node n) { // wajood
            this.task = task;
            this.next = n;
        }
         

        public Task getTask() { // wajood
            return this.task;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }// end node

    private static Node top = null;
    private static int size = 0;

    public AdminTaskStack() {
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

    public void push(Task task) { // Wajood
        Node newNode = new Node(task, null);
        newNode.next = top;
        top = newNode;
        size++;
       // System.out.println(task.getTask_text() + " has been pushed into the stack");
       // System.out.println("Your task has been add to your task list");
         JOptionPane.showMessageDialog(null, "Your Task has been add to your Task list", "Adding To the Task List", JOptionPane.INFORMATION_MESSAGE); 
        System.out.println(task.toString());
    }
    

    public Task checkTask() { // wajood // same as pop
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }

        Task temp = top.task;
        top = top.next;
        size--;
        System.out.println("Top Task is popped");
        return temp;
    }
    
    public void checkAtPos(int position)
    {
         if (isEmpty() || position <= 0) {
           // System.out.println("Invalid position or Stack is empty");
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
        System.out.println("Task is popped");
    }
    
    public Task checkAll()
    {
        if(isEmpty())
        {
            System.out.println("List is already Empty!");
            return null;
        }
        while(top != null)
         {
            top = top.next;
            size--;
         }
        System.out.println("List is Empty now");
        return null;
    }

    public void displayTask() { // wajood
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }

        Node current = top;
        System.out.println("Task List: ");
        while (current != null) {
            Task tasks = current.task;
                System.out.println("Task [Task = " + tasks.getTask_text() + ", Priority= " + tasks.getTask_priority() + ", Due Date= " + tasks.toString_dueDate()
                + ", aspact=" + tasks.getAspact() + "]");
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

            if (current.task.getTask_text().equals(val)) {
                System.out.println("Task is Found at node: " + counter);
                flag = true;
            } // end if

            current = current.next;
        }
        if (flag) {
            return true;
        } else {
            System.out.println("The Task Was not Found");
            return false;
        }
    }
    
    public static void updateText(String old,String newTask)
            
    {
       
        Node current = top;
        int counter = 0;

        while (current != null) {
            counter++;

            if (current.task.getTask_text().equals(old)) {
                current.task.setTask_text(newTask);
            } // end if

            current = current.next;
        }
        
    }
    
    public static void updatePriority(String old,String newTask)
    {
        
        Node current = top;
        int counter = 0;

        while (current != null) {
            counter++;

            if (current.task.getTask_text().equals(old)) {
                Priority priority = Priority.valueOf(newTask.toUpperCase());
                 current.task.setTask_priority(priority);
            } // end if

            current = current.next;
        }
    }
    
    public static void updateAspact(String old,String newTask)
    {
        
        Node current = top;
        int counter = 0;

        while (current != null) {
            counter++;

            if (current.task.getTask_text().equals(old)) {
                Aspact aspact = Aspact.valueOf(newTask.toUpperCase());
                current.task.setAspact(aspact);
            } // end if

            current = current.next;
        }
    }

    public static void updateDueDate(String old, LocalDateTime newDate){
  
        Node current = top;
        int counter = 0;

        while (current != null) {
            counter++;

            if (current.task.getTask_text().equals(old)) {
                current.task.setTask_dueDate(newDate);
            } // end if

            current = current.next;
        }

    }
   

    public void timeLeft(Task task) { // wajood

        // this method calculate the time left for the task due date

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dueDateTime = task.getTask_dueDate();
        long daysLeft = ChronoUnit.DAYS.between(now, dueDateTime);
        long hoursLeft = ChronoUnit.HOURS.between(now, dueDateTime);
        long minutesLeft = ChronoUnit.MINUTES.between(now, dueDateTime);

        if (daysLeft > 0) {
            System.out.println("Task: " + task.getTask_text() + ", Days Left: " + daysLeft + ", Hours Left: "
                    + hoursLeft % 24 + ", Minutes Left: " + minutesLeft % 60);
        } else {
            System.out.println("Task: " + task.getTask_text() + ", Hours Left: " + hoursLeft + ", Minutes Left: "
                    + minutesLeft % 60);
        }
    }

    // sort methods

    // 1. Sort Based On the due date
    public void sortTasksACS(){ // sort from less time left to long time left

        if (isEmpty() || size() == 1) {
            return; 
        }

        Node current = top;
        Node sorted = null;

        while (current != null){
            Node next = current.next;

            if(sorted == null || sorted.task.getTask_dueDate().isAfter(current.task.getTask_dueDate())){
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;

                while (temp.next != null && temp.next.task.getTask_dueDate().isBefore(current.task.getTask_dueDate())) {
                    temp = temp.next;
                }

                current.next = temp.next;
                temp.next = current;

            }
            current = next;
        }

        top = sorted;

    }

    public void sortTasksDECS(){  // sort from long time left to less time left

        if (isEmpty() || size() == 1) {
            return; 
        }

        Node current = top;
        Node sorted = null;

        while (current != null){
            Node next = current.next;

            if(sorted == null || sorted.task.getTask_dueDate().isBefore(current.task.getTask_dueDate())){ // the diiference is in this line
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;

                while (temp.next != null && temp.next.task.getTask_dueDate().isAfter(current.task.getTask_dueDate())) { // the diiference is in this line
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
            
            if (sorted == null || sorted.task.getTask_priority().ordinal() >= current.task.getTask_priority().ordinal()) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;

                while (temp.next != null && temp.next.task.getTask_priority().ordinal() < current.task.getTask_priority().ordinal()) {
                    temp = temp.next;
                }

                current.next = temp.next;
                temp.next = current;
            }
            current = next;
        }
        top = sorted;

        /* ordinal() method is a part of the Enum class. It returns the ordinal value of an enum constant. 
        The ordinal value is the position of the enum constant in its enum declaration, starting from zero. */
    }

    public void sortByPriorityLow() { // sort tasks based on priorty from low to high

        if (isEmpty() || size() == 1) {
            return; 
        }
    
        Node current = top;
        Node sorted = null;
    
        while (current != null) {
            
            Node next = current.next;
            
            if (sorted == null || sorted.task.getTask_priority().ordinal() <= current.task.getTask_priority().ordinal()) {
                current.next = sorted;
                sorted = current;
            } else {
                Node temp = sorted;

                while (temp.next != null && temp.next.task.getTask_priority().ordinal() > current.task.getTask_priority().ordinal()) {
                    temp = temp.next;
                }

                current.next = temp.next;
                temp.next = current;
            }
            current = next;
        }
        top = sorted;

        /* ordinal() method is a part of the Enum class. It returns the ordinal value of an enum constant. 
        The ordinal value is the position of the enum constant in its enum declaration, starting from zero. */
    }
    
}
