package Utils;

import Main.config;
import bean.student;

public class StudentUtil {
    public static bean.student fillStudent() {
        String name = InputUtil.getText("Please,enter student's name");

        String surname = InputUtil.getText("Please enter student's surname");

        int age = InputUtil.getNumber("Please enter student's age");

        String className = InputUtil.getText("Please enter student's class");

        student st = new student(name, surname, age, className);
        return st;
    }

    public static void printallstudents() {
        if (config.students == null) {
            return;
        }
        for (int i = 0; i < config.students.length; i++) {
            student st = config.students[i];
            System.out.println((i+1)+"."+st.getfullinfo());
        }
    }

    public static void registerStudents() {
        int number = InputUtil.getNumber("How many students you want to add students' form?");
        config.students = new student[number];
        for (int i = 0; i < number; i++) {
            System.out.println((i + 1) + ".student");
            config.students[i] = StudentUtil.fillStudent();
        }
        System.out.println("Registration was finished successfully");
        StudentUtil.printallstudents();
    }

    public static void findStudentsandprint() {
        String text = InputUtil.getText("Please,enter student's name,surname or class");
        student[] chosedstudents = findStudents(text);
        for(int i=0;i<chosedstudents.length;i++){
            System.out.println(chosedstudents[i].getfullinfo());
        }
    }

    public static student[] findStudents(String text) {
        int count=0;
        for (int i = 0; i < config.students.length; i++) {
            student st = config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                count++;
            }
        }
        student[] result = new student[count];
        int found = 0;
        for (int i = 0; i < config.students.length; i++) {
            student st = config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                result[found++]=st;
            }
        }
        return result;
    }

    public static void updateStudentwithnewobject(){
        StudentUtil.printallstudents();
        int index = InputUtil.getNumber("Please, enter index of student whose information you want to change");
        System.out.println("Enter new student's info:");
        student s = StudentUtil.fillStudent();
        config.students[index-1] = s;
    }

    public static void updateStudentwithsameobject(){
        StudentUtil.printallstudents();
        int index = InputUtil.getNumber("Please, enter index of student whose information you want to change");
        System.out.println("Enter new student's info:");
        student selectedstudent = config.students[index-1];
        String changeparameters = InputUtil.getText("Which parameters do you want to change? Example:'name','surname'");
        if(changeparameters.contains("'name'")){
            selectedstudent.setName(InputUtil.getText("Enter student's name:"));
        }if(changeparameters.contains("'surname'")){
            selectedstudent.setSurname(InputUtil.getText("Enter student's surname:"));
        }if(changeparameters.contains("'age'")){
            selectedstudent.setAge(InputUtil.getNumber("Enter student's age:"));
        }if(changeparameters.contains("'surname'")){
            selectedstudent.setClassName(InputUtil.getText("Enter student's class:"));
        }
    }

    public static void updateStudentwithsplit(){
        StudentUtil.printallstudents();
        int index = InputUtil.getNumber("Please, enter index of student whose information you want to change");
        System.out.println("Enter new student's info:");
        student selectedstudent = config.students[index - 1];
        String changeparameters = InputUtil.getText("Which parameters do you want to change? Example:'name','surname'");
        String[] parameters = changeparameters.split(",");
        for (int i = 0; i < parameters.length; i++) {
            String param = parameters[i];
            if (param.equalsIgnoreCase("name")) {
                selectedstudent.setName(InputUtil.getText("Enter student's name:"));
            }else if (param.equalsIgnoreCase("surname")) {
                selectedstudent.setSurname(InputUtil.getText("Enter student's surname:"));
            }else if (param.equalsIgnoreCase("age")) {
                selectedstudent.setAge(InputUtil.getNumber("Enter student's age:"));
            }else if (param.equalsIgnoreCase("class")) {
                selectedstudent.setClassName(InputUtil.getText("Enter student's class:"));
            }
        }
    }
}