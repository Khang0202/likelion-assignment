package vn.edu.likelion.project.day25062024.assignment;


import vn.edu.likelion.project.day25062024.assignment.model.Customer;
import vn.edu.likelion.project.day25062024.assignment.model.Event;
import vn.edu.likelion.project.day25062024.assignment.service.CustomerService;
import vn.edu.likelion.project.day25062024.assignment.service.EventService;
import vn.edu.likelion.project.day25062024.assignment.service.impl.CustomerServiceImpl;
import vn.edu.likelion.project.day25062024.assignment.service.impl.EventServiceImpl;
import vn.edu.likelion.helpers.DateFormat;
import vn.edu.likelion.helpers.Input;

/**
 * Đề 5: Quản lý sự kiện
 * ❖ Yêu cầu:
 * ➢ Xây dựng ứng dụng quản lý sự kiện, trong đó có các chức năng:
 * EVENT
 * getEvents() - output: ArrayList<Event> - event: stt, name, dateStart, slot, registedSlot
 * ■ Xem danh sách các sự kiện: STT, ID sự kiện, tên sự kiện, ngày tổ chức, số lượng khách mời
 * eventDetail - stt, id, name, dateStart, Customer[] - customer: name, age
 * ● Xem chi tiết sự kiện (bằng ID): ID sự kiện, tên sự kiện, ngày tổ chức, danh sách khách mời hiện có
 * addEvent/ updateEvent - event
 * ● Thêm/sửa sự kiện: Tên sự kiện, ngày tổ chức, số lượng khách mời
 * deleteEvent - true
 * ● Xoá sự kiện
 * eventCustomers - Customer[]
 * ■ Xem danh sách khách mời: STT, tên khách mời, tuổi, tên sự kiện đăng ký, ngày đăng
 * ký
 * CUSTOMER
 * addCustomer - output name, age, event, dateRegis
 * ● Thêm/sửa thông tin khách mời: Tên khách mời, tuổi, tên sự kiện đăng ký, ngày đăng ký
 * deleteCustomerRegisted - true
 * ● Xoá khách mời
 * ❖ Lưu ý:
 * limit 5
 * limit-customer 3
 * ➢ Chỉ được tổ chức tối đa 5 sự kiện, mỗi sự kiện chỉ được tối đa 3 khách mời
 * cutomer-age >= 18
 * ➢ Khách mời phải từ 18 tuổi trở lên
 * dateStart < date.now() : editEvent ? can not edit
 * ➢ Khách mời không được thay đổi sự kiện trước 1 ngày diễn ra sự kiện (tính theo 24h)
 * limit event 1
 * ➢ Mỗi khách hàng chỉ được tham gia 1 sự kiện
 */

public class Main {
    public static EventService eventService = new EventServiceImpl();
    public static CustomerService customerService = new CustomerServiceImpl();

    public static void main(String[] args) {
        int choice;
        do {
            System.err.println("Đề 5\n" +
                    "Input a number to start\n" +
                    "0: Thoát");
            choice = Input.inputInt();
            if (choice == 0) break;
            try {
                int choiceInTry;
                do {
                    System.err.println("CHỌN LOẠI DỮ LIỆU\n" +
                            "1: Dữ liệu mẫu\n" +
                            "2: Tự nhập data\n" +
                            "0: Thoát");
                    choiceInTry = Input.inputInt();
                    switch (choiceInTry) {
                        case 1:
                            eventService.addEvent(new Event("abc1", DateFormat.parseStringToLocalDate("2024-06-30"), 1));
                            eventService.addEvent(new Event("abc2", DateFormat.parseStringToLocalDate("2024-06-28"), 2));
                            eventService.addEvent(new Event("abc3", DateFormat.parseStringToLocalDate("2024-06-29"), 3));
                            customerService.addCustomer(new Customer("custest1", 14));
                            customerService.addCustomer(new Customer("custest2", 19));
                            customerService.addCustomer(new Customer("custest3", 20));
                            switchCaseManageData();
                            break;
                        case 2:
                            eventService.input();
                            customerService.input();
                            switchCaseManageData();
                            break;
                        default:
                            System.out.println("Thoát........");
                            break;
                    }
                } while (choiceInTry != 0);
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }
        } while (choice != 0);
    }

    //chon loai quan ly
    public static void switchCaseManageData() {
        int choice;
        do {
            System.err.println(
                    "CHỌN LOẠI QUẢN LÝ\n" +
                            "1: Quản lý sự kiện\n" +
                            "2: Quản lý khách hàng\n" +
                            "3: Danh sách sự kiện\n" +
                            "4: Danh sách khách hàng\n" +
                            "5: Thêm 1 sự kiện\n" +
                            "6: Thêm 1 khách hàng\n" +
                            "0: Exits");
            choice = Input.inputInt();
            switch (choice) {
                case 1:
                    try {
                        switchCaseManageEvent();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    } finally {
                        break;
                    }
                case 2:
                    try {
                        switchCaseManageCustomer();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    } finally {
                        break;
                    }
                case 3:
                    try {
                        eventService.getEvents();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    } finally {
                        break;
                    }
                case 4:
                    try {
                        customerService.getCustomers();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    } finally {
                        break;
                    }
                case 5:
                    try {
                        eventService.inputConsole();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    } finally {
                        break;
                    }
                case 6:
                    try {
                        customerService.inputConsole();
                    } catch (RuntimeException e) {
                        System.err.println(e.getMessage());
                    } finally {
                        break;
                    }

                case 0:
                    System.out.println("Thoát trình quản lý");
                    break;
                default:
                    System.out.println("Chọn lại !!!!");
                    break;
            }
        } while (choice != 0);
    }

    //trinh quan ly su kien
    public static void switchCaseManageEvent() {
        eventService.getEvents();
        System.out.println("Nhập id sự kiện cần sửa");
        Event e = eventService.getEvent(Input.inputString());
        System.out.println("Sự kiện bạn muốn sửa");
        e.show();
        int choice;
        do {
            System.err.println(
                    "1: Sửa tên sự kiện\n" +
                            "2: Sửa ngày tổ chức\n" +
                            "3: Sửa số lượng khách hàng tối đa\n" +
                            "4: Xóa sự kiện\n" +
                            "0: Thoát chỉnh sửa sự kiện");
            choice = Input.inputInt();
            switch (choice) {
                case 1:
                    try {
                        e.updateEventName();
                        System.out.println("Thông tin đã cập nhật");
                        e.show();
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 2:
                    try {
                        e.updateDateStart();
                        System.out.println("Thông tin đã cập nhật");
                        e.show();
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 3:
                    try {
                        e.updateSlot();
                        System.out.println("Thông tin đã cập nhật");
                        e.show();
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 4:
                    try {
                        eventService.deleteEvent(e.getId());
                        System.out.println("Danh sách sự kiện sau khi xoá");
                        eventService.getEvents();
                        choice = 0;
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 0:
                    System.out.println("Thoát sự kiện: " + e.getName());
                    break;
                default:
                    System.out.println("Chọn lại !!!!");
                    break;
            }
        } while (choice != 0);
    }

    //trinh quan ly khach moi
    public static void switchCaseManageCustomer() {
        customerService.getCustomers();
        System.out.println("Nhập id khách hàng cần thao tác");
        Customer c = customerService.getCustomer(Input.inputString());
        System.out.println("Khách hàng bạn muốn thao tác");
        c.show();
        int choice;
        do {
            System.err.println(
                    "1: Sửa tên khách mời\n" +
                            "2: Sửa tuổi khách mời\n" +
                            "3: Đăng ký sự kiện\n" +
                            "4: Xóa khách mời\n" +
                            "0: Thoát thao tác khách mời");
            choice = Input.inputInt();
            switch (choice) {
                case 1:
                    try {
                        c.updateCustomerName();
                        System.out.println("Thông tin đã cập nhật");
                        c.show();
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 2:
                    try {
                        c.updateCustomerAge();
                        System.out.println("Thông tin đã cập nhật");
                        c.show();
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 3:
                    try {
                        eventService.getEvents();
                        System.out.println("Nhập id sự kiện muốn đăng ký");
                        c.regisEvent(eventService.getEvent(Input.inputString()));
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 4:
                    try {
                        customerService.deleteCustomer(c.getId());
                        System.out.println("Danh sách khách mời sau khi xoá");
                        customerService.getCustomers();
                        choice = 0;
                    } catch (RuntimeException ex) {
                        System.err.println(ex.getMessage());
                    } finally {
                        break;
                    }
                case 0:
                    System.out.println("Thoát thao tác khách mời " + c.getCustomerName());
                    break;
                default:
                    System.out.println("Chọn lại !!!!");
                    break;
            }
        } while (choice != 0);
    }
}
