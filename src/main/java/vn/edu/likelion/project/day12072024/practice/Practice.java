package vn.edu.likelion.project.day12072024.practice;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import vn.edu.likelion.helpers.DateTimeFormat;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Practice {

    public static void main(String[] args) {
        String source = "src/main/java/vn/edu/likelion/project/day12072024/practice/";
        String extXlsx = ".xlsx";
        String extDocx = ".docx";
        String date = "_" +  LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
        String fileStudentList = source + "StudentList.txt";
        String fileAppearance = source + "Appearance" + date + extXlsx;
        String fileNotAppearance = source + "NotAppearance"+ date + extDocx;
        ArrayList<Student> students = readStudentList(fileStudentList);

//        students.stream().forEach((student -> {
//            System.out.print(student.getNumber() +"\t" + student.getName() );
//        }));

        writeXlsx(fileAppearance, students);
        writeDocx(fileNotAppearance, students);


    }
    public static void writeDocx(String filename, ArrayList<Student> students){
        XWPFDocument doc = new XWPFDocument();

        XWPFParagraph paragraph = doc.createParagraph();

        XWPFRun run = paragraph.createRun();

        Student s;
        for (int i = 0; i < students.size(); i++) {
            s = students.get(i);
            if (!s.isStatus()){
                run.setText(String.valueOf(s.getNumber()));
                run.setText("\t");
                run.setText(s.getName());
                run.addCarriageReturn();
            }
        }

        try {
            FileOutputStream fos = new FileOutputStream(filename);
            doc.write(fos);

            System.out.println("File DOCX written to " + filename);

            fos.close();
            doc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeXlsx(String filename, ArrayList<Student> students){
        int counter = 0;
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Appearance");
        String header = "Student List";
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setItalic(true);
        headerFont.setColor(IndexedColors.RED1.getIndex());
        headerFont.setFontHeightInPoints((short) 32);

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);

        Row mainTitleRow = sheet.createRow(counter++);
        Cell mainTitleCell = mainTitleRow.createCell(0);
        mainTitleCell.setCellValue(header);
        mainTitleCell.setCellStyle(headerCellStyle);

        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));
//        sheet.autoSizeColumn(0);

        
        
        
        
        String[] titles = {"Number", "Name"};
        Font titleFont = workbook.createFont();
        titleFont.setBold(true);

        CellStyle titleCellStyle = workbook.createCellStyle();
        titleCellStyle.setFont(titleFont);
        titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
        titleCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        titleCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Row headRow = sheet.createRow(counter++);

        for (int i = 0; i < titles.length; i++) {
            Cell cell = headRow.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(titleCellStyle);
        }

        Student s;
        for (int i = 0; i < students.size(); i++) {
            s = students.get(i);
            if (s.isStatus()){
                Row row = sheet.createRow(counter++);
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(students.get(i).getNumber());

                Cell cell2 = row.createCell(1);
                cell2.setCellValue(Base64.getEncoder().encodeToString(students.get(i).getName().getBytes()));
            }
        }

        for (int i = 1; i < titles.length; i++) {
            sheet.autoSizeColumn(i);
        }

        try {
            FileOutputStream fos = new FileOutputStream(filename);
            workbook.write(fos);

            System.out.println("File XLSX written to " + filename);

            fos.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> readStudentList(String fileName) {
        try {
            ArrayList<Student> studentArrayList = new ArrayList<>();

            FileInputStream fis = new FileInputStream(fileName);
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
                Student s = new Student();
                if (fields.length == 3) {
                    s.setNumber( Integer.parseInt(fields[0]));
                    s.setName(fields[1].trim());
                    s.setStatus(Boolean.parseBoolean(fields[2].trim()));
                    studentArrayList.add(s);
                }
            }

            fis.close();

            return studentArrayList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
