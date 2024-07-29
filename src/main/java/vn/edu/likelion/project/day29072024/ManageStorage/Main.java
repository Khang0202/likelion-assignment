package vn.edu.likelion.project.day29072024.ManageStorage;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vn.edu.likelion.project.day29072024.ManageStorage.model.Attribute;
import vn.edu.likelion.project.day29072024.ManageStorage.model.Product;
import vn.edu.likelion.project.day29072024.ManageStorage.model.Storage;
import vn.edu.likelion.project.day29072024.ManageStorage.service.ProductService;
import vn.edu.likelion.project.day29072024.ManageStorage.service.StorageService;
import vn.edu.likelion.project.day29072024.ManageStorage.service.UserService;
import vn.edu.likelion.project.day29072024.ManageStorage.utils.Input;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        do {
            if (LocalDB.localUser == null) {
                System.out.println("1. Login");
                System.out.println("0. Exit");
            } else {
                if (continueOrStop() == 0) break;
            }
            int choice = Input.inputInt();
            switch (choice) {
                case 1:
                    System.out.println("Input username: ");
                    String username = Input.inputString();
                    System.out.println("Input password: ");
                    String password = Input.inputString();
                    LocalDB.localUser = UserService.login(username, password);
                    if (LocalDB.localUser != null) {
                        System.out.println("success");
                        switchCaseChoiceManage();
                    } else System.out.println("failed");
                    break;
                case 2:
                    break;
                case 0:
                    System.out.println("Exit...");
                    LocalDB.localUser = null;
                    break;
                default:
                    System.out.println("Error Input, please try again");
                    break;
            }
            if (choice == 0) break;
        } while (true);
    }

    //done
    private static int continueOrStop() {
        System.out.println("1. Continue");
        System.out.println("2. Logout");
        System.out.println("0. Exit");
        do {
            int choice = Input.inputInt();
            switch (choice) {
                case 1:
                    switchCaseChoiceManage();
                    break;
                case 2:
                    LocalDB.localUser = null;
                    System.out.println("Logout Successfully.");
                case 0:
                    break;
                default:
                    System.out.println("Error Input, please try again");
                    break;
            }
            return choice;
        } while (true);
    }

    //done
    private static void switchCaseChoiceManage() {
        do {
            System.out.println("1: Manage Self Storage");
            System.out.println("2: Manage Storage");
            System.out.println("3: Manage User");
            System.out.println("4: Manage Product");
            System.out.println("0. Exit");
            int choice = Input.inputInt();
            if (choice == 0) break;
            switch (choice) {
                case 1:
                    manageSelfStorage();
                    break;
                case 2:
                    if (LocalDB.localUser != null) {
                        if (LocalDB.localUser.getPermissions().stream().anyMatch(permission -> permission.getTablename().equals("tbl_storage"))) {
                            manageStorage();
                        } else System.out.println("not permission");
                    } else System.out.println("login first");
                    break;
                case 3:
                    if (LocalDB.localUser != null) {
                        if (LocalDB.localUser.getPermissions().stream().anyMatch(permission -> permission.getTablename().equals("tbl_user"))) {
                            manageUser();
                        } else System.out.println("not permission");
                    } else System.out.println("login first");
                    break;
                case 4:
                    if (LocalDB.localUser != null) {
                        if (LocalDB.localUser.getPermissions().stream().anyMatch(permission -> permission.getTablename().equals("tbl_product") || permission.getTablename().equals("tbl_attribute"))) {
                            manageProduct();
                        } else System.out.println("not permission");
                    } else System.out.println("login first");
                    break;
                default:
                    System.out.println("Error Input, please try again");
                    break;
            }
        } while (true);
    }

    //done
    private static void manageStorage() {
        do {
            StorageService.showAllStorage();
            System.out.println("Manage storage");
            System.out.println("1. Add storage");
            System.out.println("2: Delete Storage");
            System.out.println("3: Revenue Storage");
            System.out.println("0. Exit");
            int choice = Input.inputInt();
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    StorageService.addStorage();
                    break;
                case 2:
                    StorageService.deleteStorage();
                    break;
                case 3:
                    StorageService.getAll();
                    writeXlsx(LocalDB.localStorage);
                default:
                    System.out.println("Error Input, please try again");
                    break;
            }
        } while (true);
    }

    //done
    private static void manageUser() {
        do {

            System.out.println("Manage storage");
            System.out.println("1. Add user");
            System.out.println("2: Update user");
            System.out.println("3: Delete user");
            System.out.println("0. Exit");
            int choice = Input.inputInt();
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    UserService.insertUser();
                    break;
                case 2:
                    UserService.updateUser();
                    break;
                case 3:
                    UserService.getAll();
                    System.out.println("Input User Id want to delete: ");
                    UserService.deleteUser(Input.inputInt());
                    break;
                default:
                    System.out.println("Error Input, please try again");
                    break;
            }
        } while (true);

    }

    //done
    private static void manageProduct() {
        do {
            ProductService.showAllProduct();
            System.out.println("Manage product");
            System.out.println("1. Add product");
            System.out.println("2: Update product");
            System.out.println("3: Delete Storage");
            System.out.println("0. Exit");
            int choice = Input.inputInt();
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    ProductService.addProduct();
                    break;
                case 2:
                    System.out.println("Updating product...");
                    System.out.println("Input product id: ");
                    int productId = Input.inputInt();
                    manageUpdateProduct(ProductService.get(productId));
                    break;
                case 3:
                    ProductService.deleteProduct();
                    break;
                default:
                    System.out.println("Error Input, please try again");
                    break;
            }
        } while (true);
    }

    //done
    private static void manageSelfStorage() {
        do {
            System.out.println("Manage self storage");
            System.out.println("1: Show information");
            System.out.println("2: Rename of your storage");
            System.out.println("3: Export revenue information");
            System.out.println("0. Exit");
            int choice = Input.inputInt();
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    StorageService.showSelfInfo();
                    break;
                case 2:
                    System.out.println("Input new name: ");
                    StorageService.updateStorageNameByStorageId(LocalDB.localUser.getStorage().getId(), Input.inputString());
                    break;
                case 3:
                    List<Storage> storages = new ArrayList<>();
                    storages.add(LocalDB.localUser.getStorage());
                    writeXlsx(storages);
                    break;
                default:
                    System.out.println("Error Input, please try again");
                    break;
            }
        } while (true);
    }

    //chưa check
    public static void writeXlsx(List<Storage> storageList) {
        int counter = 0;
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("User");
        String header = "Revenue information";
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 28);

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        headerCellStyle.setAlignment(HorizontalAlignment.CENTER);

        Row mainTitleRow = sheet.createRow(counter++);
        Cell mainTitleCell = mainTitleRow.createCell(0);
        mainTitleCell.setCellValue(header);
        mainTitleCell.setCellStyle(headerCellStyle);
        int lastColeMainTitle = 4 * storageList.size() - 1;
        // Corrected to merge across the first 3 columns
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, lastColeMainTitle));

        List<String> titles = new ArrayList<>();
        for (int i = 0; i < storageList.size(); i++) {
            titles.add(storageList.get(i).getName());
        }

        Font titleFont = workbook.createFont();
        titleFont.setItalic(true);
        titleFont.setColor(IndexedColors.WHITE.getIndex());

        CellStyle titleCellStyle = workbook.createCellStyle();
        titleCellStyle.setFont(titleFont);
        titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
        titleCellStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        titleCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Row headRow = sheet.createRow(counter++);

        for (int i = 0; i < titles.size(); i++) {
            int startCol = i * 4;
            int endCol = startCol + 3; // Merge 3 columns

            Cell cell = headRow.createCell(startCol);
            cell.setCellValue(titles.get(i));
            cell.setCellStyle(titleCellStyle);

            sheet.addMergedRegion(new CellRangeAddress(1, 1, startCol, endCol));
        }

        Row titlesProductRow = sheet.createRow(counter++);
        for (int x = 0; x < titles.size(); x++) {
            String[] titlesProduct = {"Product Name", "Count", "At Storage", "Attribute"};
            for (int i = 0; i < titlesProduct.length; i++) {
                Cell cell = titlesProductRow.createCell(i + x * titlesProduct.length);
                cell.setCellValue(titlesProduct[i]);
            }
        }


        Product s;
        for (int x = 0; x < storageList.size(); x++) {
            int temp = counter;
            List<Product> products = storageList.get(x).getProducts();

            for (int i = 0; i < products.size(); i++) {
                s = products.get(i);
                Row row;

                if (x == 0) {
                    row = sheet.createRow(temp++);
                }else {
                    row = sheet.getRow(temp++);
                }
                Cell cell1 = row.createCell(0 + x * 4);
                cell1.setCellValue(s.getName());
                Cell cell2 = row.createCell(1 + x * 4);
                cell2.setCellValue(s.getCount());
                Cell cell3 = row.createCell(2 + x * 4);
                cell3.setCellValue(s.getStorageId());
                s.getAttribute();
                for (Attribute a : s.getAttributes()) {
                    Row rowCellr = sheet.createRow(temp++);
                    Cell cell4 = rowCellr.createCell(3 + x * 4);
                    cell4.setCellValue(a.getName());
                }
            }
        }

        for (int i = 0; i < titles.size(); i++) {
            sheet.autoSizeColumn(i);
        }

        String formattedDate = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filename;
        if (storageList.size() == 1) {
            filename = "user_revenue_" + formattedDate + ".xlsx";
        }else {
            filename = "revenue_" + formattedDate + ".xls";
        }
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            workbook.write(fos);
            System.out.println("File XLSX written to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void manageUpdateProduct(Product product){
        do {
            product.show();
            System.out.println("1. Update product info");
            System.out.println("2. Update product attribute");
            System.out.println("3. Add product attribute");
            System.out.println("4. Delete product attribute");
            System.out.println("0. Exit");
            int choice = Input.inputInt();
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    ProductService.update(product.getId());
                    break;
                case 2:
                    product.show();
                    System.out.println("Input attribute id will be updated: ");
                    int id = Input.inputInt();
                    System.out.println("Input attribute name: ");
                    String name = Input.inputString();
                    ProductService.updateAttribute(new Attribute(id, name, product.getId()));
                    break;
                case 3:
                    ProductService.addAttribute(product.getId());
                    break;
                case 4:
                    product.show();
                    System.out.println("Input attribute id will be deleted: ");
                    int id1 = Input.inputInt();
                    ProductService.deleteAttribute(id1);
                    break;
                default:
                    System.out.println("Error Input, please try again");
                    break;
            }
        }while (true);
    }
}

