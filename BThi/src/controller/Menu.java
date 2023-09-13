package controller;

import service.ProductManage;
import service.ReadWriteFile;

import java.util.Scanner;

public class Menu {
    public void menu(Scanner scanner, ProductManage productManage, ReadWriteFile readWriteFile) {
        productManage.loadListProduct(readWriteFile.readFile("ProductFile.csv"));
        do {
            System.out.println("MENU: ");
            System.out.println("1 . Hiển thị tất cả sản phẩm .");
            System.out.println("2 . Thêm sản Phẩm .");
            System.out.println("3 . Sửa sản phẩm .");
            System.out.println("4 . Xóa sản phẩm .");
            System.out.println("5 . Sắp xếp sản phẩm theo giá tăng dần.");
            System.out.println("6 . Sắp xếp sản phẩm theo giảm tăng dần.");
            System.out.println("7 . Hiển thị sản phẩm đắt tiền nhất .");
            System.out.println("8 . Viết tập tin .");
            System.out.println("9 . Đọc tập tin .");
            System.out.println("10. Exit!!!");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManage.displayProduct();
                    break;
                case 2:
                    productManage.creatProduct();
                    break;
                case 3:
                    productManage.updateProduct();
                    break;
                case 4:
                    productManage.deleteProduct();
                    break;
                case 5:
                    productManage.sortPriceAsc();
                    break;
                case 6:
                    productManage.sortPriceDesc();
                    break;
                case 7:
                    productManage.findPriceMax();
                    break;
                case 8:
                    readWriteFile.writeFile(productManage.listProduct());
                    System.out.println("Viết thành công!");
                    break;
                case 9:
                    productManage.loadListProduct(readWriteFile.readFile("ProductFile.csv"));
                    System.out.println("Đọc thành công!");
                    break;
                case 0:
                    readWriteFile.writeFile(productManage.listProduct());
                    System.exit(0);
            }
        } while (true);


    }
}
