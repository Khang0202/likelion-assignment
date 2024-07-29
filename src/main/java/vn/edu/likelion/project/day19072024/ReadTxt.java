package vn.edu.likelion.project.day19072024;

import vn.edu.likelion.project.day19072024.model.Student;
import vn.edu.likelion.project.day19072024.service.StudentService;
import vn.edu.likelion.project.day19072024.service.UsersService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ReadTxt {
    public static void readStudentListToDatabase() {
        StudentService studentService = new StudentService();
        try {
            FileInputStream fis = new FileInputStream("src/main/java/vn/edu/likelion/project/day19072024/StudentList.txt");
            byte[] buffer = new byte[1024];
            int bytesRead;

            StringBuilder fileContent = new StringBuilder();

            while ((bytesRead = fis.read(buffer)) != -1) {
                fileContent.append(new String(buffer, 0, bytesRead));
            }

            String content = fileContent.toString();
            String[] lines = content.split("\n");

            for (String line : lines) {
                String[] fields = line.split("\t");
                if (fields.length == 3) {
                    studentService.save(new Student(fields[1].trim()));
                }
            }

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
