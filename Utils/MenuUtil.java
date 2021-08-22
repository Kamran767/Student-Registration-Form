package Utils;

public class MenuUtil {
    public static void processmenu(int selectedmenu){
        switch (selectedmenu) {
            case 1 -> {
                StudentUtil.registerStudents();
                break;
            }
            case 2 -> {
                StudentUtil.printallstudents();
                break;
            }
            case 3 -> {
                StudentUtil.findStudentsandprint();
                break;
            }
            case 4 -> {
                StudentUtil.updateStudentwithnewobject();
                break;
            }
            default -> {
                break;
            }
        }
    }

}
