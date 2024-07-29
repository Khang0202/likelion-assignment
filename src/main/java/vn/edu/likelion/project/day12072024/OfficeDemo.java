package vn.edu.likelion.project.day12072024;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.*;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;

public class OfficeDemo {

	public static void main(String[] args) {
		String source = "src/main/java/vn/edu/likelion/project/day12072024/";
		String fileDocx = source + "output.docx";
		String fileXlsx = source + "output.xlsx";
		String filePdf = source + "output.pdf";
//		writeDocx(fileDocx);
//		readDocx(fileDocx);
//
//
//		writeXlsx(fileXlsx);
//		readXlsx(fileXlsx);
//
//		writePdf(filePdf);
//		readPdf(filePdf);



    }

	public static void writePdf(String filename){
		try {
			//tạo 1 đối tượng pdf
			PDDocument document = new PDDocument();

			//tạo ra 1 trang từ đối tượng PDF
			PDPage page = new PDPage();

			//tạo ra lớp cho phép vẽ văn bản
			PDPageContentStream content = new PDPageContentStream(document, page);

			//set font
			content.setFont(PDType1Font.HELVETICA, 18);
			//bọc nội dung - start
			content.beginText();
			//kiểm tra tọa độ của 1 page trong file
			System.out.println(page.getBleedBox());
			content.newLineAtOffset(20, 772);

			content.showText("Hello World");

			content.newLineAtOffset(0,-20);
			content.showText("Hello World2");

			content.endText();
			//bọc nội dung - end

			File file = new File(filename);
			document.addPage(page);
			content.close();

			document.save(file);

			document.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void readPdf(String filename){
		try {
			File file = new File(filename);

			PDDocument document = PDDocument.load(file);

			PDFTextStripper stripper = new PDFTextStripper();

			String s = stripper.getText(document);

			System.out.println(s);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void writeXlsx(String filename){
		//tạo đối tượng xử lý file excel
		XSSFWorkbook workbook = new XSSFWorkbook();
		//tạo sheet mới trong workbook
		Sheet sheet = workbook.createSheet();
		//tạo 1 row trong sheet
		Row row = sheet.createRow(0);
		//tạo ra một cell trong row
		Cell cell1 = row.createCell(0);
		cell1.setCellValue("test1");

		Cell cell2 = row.createCell(1);
		cell2.setCellValue("test2");

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

	public static void readXlsx(String filename){
		try {
			//Lấy file excel vật lý
			FileInputStream fis = new FileInputStream(filename);

			//tạo ra 1 workbook từ file
			Workbook workbook = new XSSFWorkbook(fis);

			//lấy sheet trong workbook
			Sheet sheet = workbook.getSheetAt(0);

			//duyệt từng row trong sheet
			for(Row row : sheet){
				//duyệt từng cell trong row
				for(Cell cell : row){
					switch(cell.getCellType()){
						case STRING:
							System.out.println(cell.getStringCellValue());
							break;
						case NUMERIC:
							System.out.println(cell.getNumericCellValue());
							break;
						case BOOLEAN:
							System.out.println(cell.getBooleanCellValue());
							break;
						case FORMULA:
							System.out.println(cell.getCellFormula());
							break;
						case BLANK, _NONE:
							System.out.println("");
							break;
						case ERROR:
							System.out.println(cell.getErrorCellValue());
							break;
                        default:
							System.out.println(cell.getDateCellValue());
							break;
					}
					System.out.println(row.getRowNum() + "," + cell.getColumnIndex() + "," + cell.getStringCellValue());
				}
			}

			workbook.close();
			fis.close();


		} catch (IOException e) {
           	e.printStackTrace();
        }
    }

	public static void readDocx(String filename){
		File file = new File(filename);

		try {
			InputStream is = new FileInputStream(file);
			XWPFDocument document = new XWPFDocument(is);

			for (XWPFParagraph paragraph : document.getParagraphs()) {
				System.out.println(paragraph.getText());
			}

			is.close();
			document.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeDocx(String filename){
		XWPFDocument doc = new XWPFDocument();

		XWPFParagraph paragraph = doc.createParagraph();

		XWPFRun run = paragraph.createRun();
		run.setText("Hello World\n");
		run.setText("Được viết bằng Java");

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

}
