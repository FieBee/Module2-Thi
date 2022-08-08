package Main;

import controller.ProductManager;
import model.Product;
import storage.ReadWriteFile;

import java.io.File;
import java.util.*;

public class Main {

//    Main main = new Main();
static ProductManager productManager = new ProductManager();
    private ReadWriteFile readWriteFile = ReadWriteFile.getInstance();


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

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        productManager.displayProduct();
                        break;
                    case 2:
                        System.out.println("Thêm sản phẩm");
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

                        break;
                    case 3:
                        try{
                            System.out.println("Nhập id sản phẩm muốn sửa: ");
                            int checkId = 0;
                            do {
                                checkId = productManager.checkId(scanner.nextInt());

                            }while (checkId <0 && checkId >= productManager.productList.size());

                            if (checkId != -1) {
                                System.out.println("Nhập tên sản phẩm muốn sửa: ");
                                String name1 = scanner.nextLine();
                                System.out.println("Nhập giá tiền:");
                                int price1 = scanner.nextInt();
                                System.out.println("Nhập số lượng:");
                                int quantity1 = scanner.nextInt();
                                System.out.println("Nhập mô tả: ");
                                String describe1 = scanner1.nextLine();

                                Product newProduct1 = new Product(checkId, name1, price1, quantity1, describe1);

                                productManager.editProduc(checkId, newProduct1);

                                System.out.println("Sửa sản phẩm thành công!!");
                            } else {
                                menuManager();
                            }
                            break;
                        }catch (InputMismatchException e){
                            System.out.println("Id khong ton tai!!");
                            menuManager();
                        }



                    case 4:
                        System.out.println("Nhập id sản phẩm muốn xóa: ");
                        int id2 = scanner1.nextInt();

                        if (productManager.productList.get(id2) == null) {
                            System.out.println("Id không tồn tại!!");
                            menuManager();
                        } else {
                            productManager.deleteProduc(id2);
                        }
                        break;
                    case 5:
                        productManager.sortProduct();
                        break;
                    case 6:
                        productManager.findMaxPrice();
                        break;
                    case 7:
                        productManager.readFile();
                        break;
                    case 8:
                        productManager.writeFile();
                        break;
                    case 9:
                        System.out.println("Bye");
                        return;
                    default:
                        break;
                }
            } while (true);
        }catch (Exception e){
            System.out.println("Loi");
            menuManager();
        }
    }

}
