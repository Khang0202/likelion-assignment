package vn.edu.likelion.project.day01072024.bai2.models;

import vn.edu.likelion.helpers.CheckHelper;

import java.time.LocalDate;

public class Student {
    //only in class
    private static final String staticName = "STUDENT";
    private static int numOfStudents = 0;
    //can get
    private final String id;
    private String name;
    private LocalDate dob;
    private String citizenIdentification;

    public Student() {
        this.id = generateId();
    }

    public Student(String name, LocalDate dateOfBirth, String citizenIdentification) {
        this.id = generateId();
        this.name = CheckHelper.checkString(name);
        if (CheckHelper.checkLocalDateIsBefore(dateOfBirth)) {
            this.dob = dateOfBirth;
        }else {
            throw new RuntimeException("Date of birth is not available");
        }
        if (checkCitizenIdentification(citizenIdentification)){
            this.citizenIdentification = citizenIdentification;
        }
    }

    //Getter
    //lấy tống số học sinh
    public static int getNumOfStudents() {
        return numOfStudents;
    }

    //lấy id
    public String getId() {
        return id;
    }

    //lấy tên
    public String getName() {
        return name;
    }

    //lấy ngày sinh
    public LocalDate getDob() {
        return dob;
    }

    //lấy cccd
    public String getCitizenIdentification() {
        return citizenIdentification;
    }


    //Setter
    public String updateName(String name) {
        if (name.equals(this.name)) {
            throw new RuntimeException("The name you have entered is the same as the old name");
        } else {
            return this.name = CheckHelper.checkString(name);
        }
    }

    public LocalDate updateDateOfBirth(LocalDate dob) {
        if (dob.equals(this.dob)) {
            throw new RuntimeException("The date you have entered is the same as the old date");
        } else {
            if (CheckHelper.checkLocalDateIsBefore(dob)){
                this.dob = dob;
                return this.dob;
            }else {
                throw new RuntimeException("The date you have entered is the same as the old date");
            }
        }
    }

    public String updateCitizenIdentification(String citizenIdentification) {
        if (citizenIdentification.equals(this.citizenIdentification)) {
            throw new RuntimeException("The citizen identification you have entered is the same as the old citizen identification");
        } else {
            if (checkCitizenIdentification(citizenIdentification)){
                return this.citizenIdentification = citizenIdentification;
            } else {
                throw new RuntimeException("The citizen identification is invalid");
            }
        }
    }

    //trả về chuỗi cccd nếu khác null, không rỗng, hoặc khác 12 ký tự
    private boolean checkCitizenIdentification(String citizenIdentification) throws RuntimeException {
        if (citizenIdentification == null || citizenIdentification.isEmpty()) {
            throw new RuntimeException("Citizen Identification cannot be null or empty");
        } else if (citizenIdentification.length() != 12) {
            throw new RuntimeException("Citizen Identification must be 12 characters");
        } else if (!CheckHelper.checkStringIsNumberic(citizenIdentification)){
            throw new RuntimeException("Citizen Identification contains invalid characters");
        } else {
            return true;
        }
    }

    private String generateId() {
        return staticName + "-" + String.format("%04d", ++numOfStudents);
    }

    public void show(){
        System.out.println("ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Date of birth: " + dob);
        System.out.println("Citizen Identification: " + citizenIdentification);
    }
}
