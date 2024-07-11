package vn.edu.likelion.project.day11072024;

import java.io.*;

public class bai1 {
    public static void main(String[] args) {
        String source = "src/main/java/vn/edu/likelion/project/day11072024/";
        String filenameB = "B.txt";
        String filenameA = "A.txt";
//        createB("akjcbacuoấnubad\n", source, filenameB);
//        createA(source, filenameA);

        new Thread(()-> {writeB(readA(source, filenameA).toString(), source, filenameB);
        new Thread(()->delete(source, filenameA));});


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
        String content = "1\tNguyễn Hồ Thanh Bền\n" +
                "2\tNguyễn Thanh Dân\n" +
                "3\tTrần Tuấn Duy\n" +
                "4\tLê Thu Hà\n" +
                "5\tNguyễn Huy Hảo\n" +
                "6\tTrần Chí Hạo\n" +
                "7\tLê Trần Trung Hiếu\n" +
                "8\tNguyễn Đồng Hưng\n" +
                "9\tNguyễn Mạnh Khang\n" +
                "10\tNguyễn Hà Kiên\n" +
                "11\tVõ Thành Lên\n" +
                "12\tKhổng Thị Gia Linh\n" +
                "13\tNguyễn Phương Nam\n" +
                "14\tPhạm Đức Nghĩa\n" +
                "15\tLê Minh Nhựt\n" +
                "16\tNguyễn Trọng Phúc\n" +
                "17\tNguyễn Đức Tấn\n" +
                "18\tBùi Quốc Thịnh\n" +
                "19\tLê Văn Tính\n" +
                "20\tNguyễn Võ Song Toàn\n" +
                "21\tTrương Anh Tuấn\n" +
                "22\tHồ Vĩnh Tường\n" +
                "23\tTrần Phúc Vinh\n";
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
