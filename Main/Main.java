package Main;

import controller.ProductManager;
import model.Product;

import java.util.*;

public class Main {

static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        menuManager();
    }


    public static void menuManager() {
        try {
            do {
                Scanner scanner = new Scanner(System.in);
                Scanner scanner1 = new Scanner(System.in);
                System.out.println(" ---- CHƯƠNG TRÌNH QUẢN LÍ SẢN PHẨM ----");
                System.out.println("Chọn chức năng theo số");
                System.out.println("1. Xem danh sách");
                System.out.println("2. Thêm mới");
                System.out.println("3. Cập nhật ");
                System.out.println("4. Xóa");
                System.out.println("5. Sắp xếp");
                System.out.println("6.Tìm sản phẩm giá đắt nhất");
                System.out.println("7. Đọc từ file");
                System.out.println("8. Ghi vào file");
                System.out.println("9. Thoát");
                System.out.println("Chọn chức năng: ");
                System.out.println("----------------------------------");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        productManager.displayProduct();
                        System.out.println("----------------------------------");
                        break;
                    case 2:
                        System.out.println("Thêm sản phẩm");

                        try{
                            System.out.println("Nhập id sản phẩm muốn thêm mới: ");
                            int id = scanner.nextInt();
                            System.out.println("Nhập tên sản phẩm muốn tạo mới: ");
                            String name = scanner1.nextLine();
                            System.out.println("Nhập giá tiền:");
                            int price = scanner.nextInt();
                            System.out.println("Nhập số lượng:");
                            int quantity = scanner.nextInt();
                            System.out.println("Nhập mô tả: ");
                            String describe = scanner1.nextLine();
                            Product newProduct = new Product(id, name, price, quantity, describe);
                            productManager.addProduc(newProduct);

                            System.out.println("Thêm sản phẩm thành công!!" + newProduct);
                        }catch (InputMismatchException e){
                            System.out.println("Sai dữ liệu!!!");
                            System.out.println("----------------------------------");
                            menuManager();
                        }

                        break;
                    case 3:
                        try{
                            System.out.println("Nhập id sản phẩm muốn sửa: ");
                            int id1 = productManager.checkId(scanner.nextInt());
                            if (id1 == -1){
                                System.out.println("Id không tồn tại!!!");
                            }else{
                                System.out.println("Nhập tên sản phẩm muốn sửa: ");
                                String name1 = scanner1.nextLine();
                                System.out.println("Nhập giá tiền:");
                                int price1 = scanner.nextInt();
                                System.out.println("Nhập số lượng:");
                                int quantity1 = scanner.nextInt();
                                System.out.println("Nhập mô tả: ");
                                String describe1 = scanner1.nextLine();

                                Product newProduct1 = new Product(id1, name1, price1, quantity1, describe1);

                                productManager.editProduc(id1, newProduct1);

                                System.out.println("Sửa sản phẩm thành công!!" + newProduct1);
                            }
                            break;
                        }catch (InputMismatchException e){
                            System.err.println("Sai dữ liệu!!!");
                            System.out.println("----------------------------------");
                            menuManager();
                        }



                    case 4:

                        try{
                            System.out.println("Nhập id sản phẩm muốn xóa: ");
                            int id2 = scanner.nextInt();
                            productManager.checkId(id2);
                            if (id2 == -1){
                                System.out.println("Id không tồn tại!!!");
                            }else{
                                System.out.println();
                                productManager.deleteProduc(id2);
                            }
                        }catch (InputMismatchException e){
                            System.out.println("Sai dữ liêu");
                            System.out.println("----------------------------------");
                            menuManager();
                        }

                        break;
                    case 5:
                        try {
                            System.out.println("1. Sắp xếp");
                            System.out.println("2. Hiển thị danh sách đã sắp xếp");
                            System.out.println("3. Trở về menu chính");
                            int case5 = scanner.nextInt();
                            switch (case5){
                                case 1:
                                    productManager.sortProduct();
                                    break;
                                case 2:
                                    productManager.displayProduct();
                                    break;
                                case 3:
                                    menuManager();
                                    break;
                            }
                        } catch (InputMismatchException e){
                            System.err.println("Sai dữ liệu!!!");
                            System.out.println("----------------------------------");
                        }
                        break;

                    case 6:
                        System.out.println("Mặt hàng đắt nhất: ");
                        productManager.findMaxPrice();
                        System.out.println("----------------------------------");
                        break;
                    case 7:
                        productManager.readFile();
                        System.out.println("Đọc file: ");
                        System.out.println("----------------------------------");
                        break;
                    case 8:
                        productManager.writeFile();
                        System.out.println("Đã ghi file");
                        System.out.println("----------------------------------");
                        break;
                    case 9:
                        System.out.println("Bye");
                        System.exit(0);
                    default:
                        System.out.println("Lựa chọn không tồn tại!!!");
                        System.out.println("-----------------------------------");
                        break;
                }
            } while (true);
        }catch (Exception e){
            System.out.println("Lỗi gì đó khum biết (T.T) ");
            System.out.println("-------------------------------------");
            menuManager();
        }
    }

}
