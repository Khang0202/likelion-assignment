package vn.edu.likelion.project.day01072024.bai2;

import vn.edu.likelion.helpers.Input;
import vn.edu.likelion.project.day01072024.bai2.services.ClassroomService;
import vn.edu.likelion.project.day01072024.bai2.services.StudentService;


/**
 * Dự án quản lý lớp học:
 * Yêu cầu: Tạo 1 chương trình quản lý lớp học, trong đó:
 * Lớp học có thể sắp xếp tối đa 10 bàn, mỗi bàn 1 học sinh
 * Học viên cần đăng ký đầy đủ các thông tin sau để được vào lớp:
 * Tên, ngày tháng năm sinh, CCCD
 * Học viên nào *đăng ký thành công* sẽ nhận đc mã học viên,
 * cần #xem được danh sách các học viên trong lớp# và #thông tin chi tiết của họ#
 * Một số học viên đọc sai thông tin, cần #sửa lại được thông tin của học viên
 * Trong thời gian học, có 1 số bạn #bỏ học,
 * cần lưu lại #danh sách những bạn đó và lý do bỏ học
 * Trường có 3 lớp và 3 giáo viên, mỗi giáo viên dạy 2 lớp,
 * cần xem được danh sách học viên của mỗi giáo viên,
 * tuy nhiên cần đảm bảo tốc độ đã đc tối ưu khi hiển thị danh sách (Yêu cầu bổ sung, có thể bỏ qua)
 * Điều kiện:
 * Khi đủ học viên thì lớp mới bắt đầu, học viên sẽ được tính ngày giờ nhập học kể từ lúc lớp học bắt đầu
 * Từ 18-20 tuổi mới được đăng ký học
 */
public class Main {
    public static StudentService studentService = new StudentService();
    public static ClassroomService classroomService = new ClassroomService();

    public static void main(String[] args) {
        do {
            System.out.println("Manage School");
            System.out.println("Input a number to start");
            System.out.println("0: Exits");
            if (Input.inputInt() == 0) {
                System.out.println("Exit...");
                break;
            }
            switchCaseManageData();
        }while (true);

    }

    public static void switchCaseManageData() {
        int choice;
        do {
            System.out.println(
                    "Manage\n" +
                            "1: Manage Classroom\n" +
                            "2: Manage Student\n" +
                            "3: List Classroom\n" +
                            "4: List Student\n" +
                            "5: Add 1 Classroom\n" +
                            "6: Add 1 Student\n" +
                            "0: Exits");
            choice = Input.inputInt();
            if (choice == 0) {
                System.out.println("Exit...");
                break;
            }
            switch (choice) {
                case 1:
                    try {
                        switchCaseManageClassroom();
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 2:
                    try {
                        switchCaseManageStudent();
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 3:
                    try {
                        classroomService.findAll();
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 4:
                    try {
                        studentService.findAll();
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 5:
                    try {
                        classroomService.inputConsole();
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 6:
                    try {
                        studentService.inputConsole();
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                default:
                    System.out.println("Error input, Exit...");
                    break;
            }
        } while (true);
    }

    public static void switchCaseManageClassroom(){

    }

    public static void switchCaseManageStudent(){

    }
}
