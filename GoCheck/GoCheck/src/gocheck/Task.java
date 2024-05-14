package gocheck;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Task {
    private String task_text;
    private Priority task_priority;
    private LocalDateTime task_dueDate;
    private Aspact aspact;

    public Task(String task_text, Priority task_priority, Aspact aspact) {
        this.task_text = task_text;
        this.task_priority = task_priority;
        this.aspact = aspact;
    }

    public Task(String task_text, Priority task_priority, LocalDateTime task_dueDate, Aspact aspact) {
        this.task_text = task_text;
        this.task_priority = task_priority;
        setTask_dueDate(task_dueDate);
        this.aspact = aspact;
    }
    


    Task() {

    }

    Task(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getTask_text() {
        return task_text;
    }


    public void setTask_text(String task_text) {
        this.task_text = task_text;
    }


    public Priority getTask_priority() {
        return task_priority;
    }


    public void setTask_priority(Priority task_priority) {
        this.task_priority = task_priority;
    }


    public LocalDateTime getTask_dueDate() {
        return task_dueDate;
    }

    public String toString_dueDate() { // to print the in the format I wanted
        return task_dueDate.getYear() + "-" + task_dueDate.getMonth() +"-" + task_dueDate.getDayOfMonth() + " " + task_dueDate.getHour() + ":" + task_dueDate.getMinute();
    }


    public void setTask_dueDate(LocalDateTime task_dueDate) {

        boolean flag = false;

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Scanner input = new Scanner(System.in);
        do {
            if (task_dueDate.isBefore(currentDateTime)) {
                System.out.println("Invalid date,try again");
                String newDateTime = input.nextLine();
                task_dueDate = LocalDateTime.parse(newDateTime, formatter);
            } else {
                this.task_dueDate = task_dueDate;
                flag = true;
            }
        } while (!flag);

    }

    public Aspact getAspact() {
        return aspact;
    }

    public void setAspact(Aspact aspact) {
        this.aspact = aspact;
    }


    @Override
    public String toString() {
        return "Task [Task = " + task_text + ", Priority= " + task_priority + ", Due Date= " + toString_dueDate()
                + "]";
    }
    
}//end class

enum Priority {
    HIGH, MEDIUM, LOW;
}

