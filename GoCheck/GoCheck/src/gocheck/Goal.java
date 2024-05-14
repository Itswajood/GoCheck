package gocheck;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Goal {

    private String goal_text;
    private Priority goal_priority;
    private LocalDateTime goal_dueDate;
    private Aspact goal_aspact;

    public Goal() {
    }

    public Goal(String task_text, Priority task_priority, LocalDateTime task_dueDate, Aspact goal_aspact) {
        this.goal_text = task_text;
        this.goal_priority = task_priority;
        setGoal_dueDate(task_dueDate);
        this.goal_aspact = goal_aspact;
    }

    public Goal(String goal_text, Priority goal_priority, Aspact goal_aspact) {
        this.goal_text = goal_text;
        this.goal_priority = goal_priority;
        this.goal_aspact = goal_aspact;
    }
    

    public String getGoal_text() {
        return goal_text;
    }

    public void setGoal_text(String goal_text) {
        this.goal_text = goal_text;
    }

    public Priority getGoal_priority() {
        return goal_priority;
    }

    public void setGoal_priority(Priority goal_priority) {
        
        this.goal_priority = goal_priority;
    }

    public LocalDateTime getGoal_dueDate() {
        return goal_dueDate;
    }

    public String toString_dueDate() { // to print the in the format I wanted
        return goal_dueDate.getYear() + "-" + goal_dueDate.getMonth() +"-" + goal_dueDate.getDayOfMonth() + " " + goal_dueDate.getHour() + ":" + goal_dueDate.getMinute();
    }

    public void setGoal_dueDate(LocalDateTime goal_dueDate) {
        
        boolean flag = false;

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        Scanner input = new Scanner(System.in);
        do {
            if (goal_dueDate.isBefore(currentDateTime)) {
                System.out.println("Invalid date,try again");
                String newDateTime = input.nextLine();
                goal_dueDate = LocalDateTime.parse(newDateTime, formatter);
            } else {
                this.goal_dueDate = goal_dueDate;
                flag = true;
            }
        } while (!flag);
    }

    public Aspact getGoal_aspact() {
        return goal_aspact;
    }

    public void setGoal_aspact(Aspact goal_aspact) {
        this.goal_aspact = goal_aspact;
    }

    @Override
    public String toString() {
        return "Goal [Goal = " + goal_text + ", Aspact = " + goal_aspact + ", Priority = " + goal_priority + ", Due Date = " + toString_dueDate()
                + "]";
    }

}

enum Aspact {
    CAREER,
    SPIRITUALITY,
    PHYSICAL_HEALTH,
    PERSONAL_GROWTH,
    ENTERTAINMENT,
    RELATIONSHIPS,
    FINANCES
}

