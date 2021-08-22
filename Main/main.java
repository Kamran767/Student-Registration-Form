package Main;


import Utils.InputUtil;
import Utils.MenuUtil;
import Utils.StudentUtil;
import bean.student;


public class main {
    public static void main(String[] args) {
        int choice = 0;
        while (true) {
            choice = InputUtil.getNumber("""
                    What do you want to do?
                    1. Register new student
                    2. Show all students
                    3. Find student
                    4. Update student's information""");
            MenuUtil.processmenu(choice);
        }
    }
}


