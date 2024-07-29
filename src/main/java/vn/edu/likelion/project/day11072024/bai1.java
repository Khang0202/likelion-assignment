package vn.edu.likelion.project.day11072024;

import java.io.*;

public class bai1 {
    public static void main(String[] args) {
        String source = "src/main/java/vn/edu/likelion/project/day11072024/";
        String filenameB = "B.txt";
        String filenameA = "A.txt";
//        createB("akjcbacuoấnubad\n", source, filenameB);
//        createA(source, filenameA);
        createA(source, "StudentList.txt");
//        new Thread(()-> {writeB(readA(source, filenameA).toString(), source, filenameB);
//        new Thread(()->delete(source, filenameA));});


    }

    public static StringBuffer readA(String source, String fileName) {
        StringBuffer sb = new StringBuffer();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new String(source + fileName));
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                sb.append(new String(buffer, 0, bytesRead));
            }
            System.out.println("Đã đọc A thành công.");
            return sb;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static StringBuffer readB(String source,String fileName) {
        StringBuffer sb = new StringBuffer();
        FileReader fr = null;
        try {
            fr = new FileReader(new String(source + fileName));

            int character;
            while ((character = fr.read()) != -1) {
                sb.append((char) character);
            }
            System.out.println("Đã đọc B thành công.");
            return sb;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void createB(String content, String source, String fileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new String(source + fileName));
            fos.write(content.getBytes());
            System.out.println("Đã ghi B file thành công.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void writeB(String content, String source, String fileName) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(new String(source+ fileName), true);
            fw.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void createA(String source, String fileName) {
        FileOutputStream fos = null;
        String content = "1\tNguyễn Hồ Thanh Bền\ttrue\n" +
                "2\tNguyễn Thanh Dân\ttrue\n" +
                "3\tTrần Tuấn Duy\ttrue\n" +
                "4\tLê Thu Hà\ttrue\n" +
                "5\tNguyễn Huy Hảo\ttrue\n" +
                "6\tTrần Chí Hạo\ttrue\n" +
                "7\tLê Trần Trung Hiếu\ttrue\n" +
                "8\tNguyễn Đồng Hưng\ttrue\n" +
                "9\tNguyễn Mạnh Khang\ttrue\n" +
                "10\tNguyễn Hà Kiên\ttrue\n" +
                "11\tVõ Thành Lên\ttrue\n" +
                "12\tKhổng Thị Gia Linh\ttrue\n" +
                "13\tNguyễn Phương Nam\ttrue\n" +
                "14\tPhạm Đức Nghĩa\ttrue\n" +
                "15\tLê Minh Nhựt\ttrue\n" +
                "16\tNguyễn Trọng Phúc\ttrue\n" +
                "17\tNguyễn Đức Tấn\ttrue\n" +
                "18\tBùi Quốc Thịnh\ttrue\n" +
                "19\tLê Văn Tính\ttrue\n" +
                "20\tNguyễn Võ Song Toàn\ttrue\n" +
                "21\tTrương Anh Tuấn\ttrue\n" +
                "22\tHồ Vĩnh Tường\ttrue\n" +
                "23\tTrần Phúc Vinh\ttrue\n";
        try {
            fos = new FileOutputStream(new String(source + fileName));
            fos.write(content.getBytes());
            System.out.println("Đã ghi file A thành công.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void delete(String source, String fileName){
        File a = new File(source + fileName);
        a.delete();
    }

}
