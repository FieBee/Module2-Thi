package Main;

import controller.ProductManager;
import model.Product;
import storage.ReadWriteFile;

import java.io.File;
import java.util.*;

public class Main {

    ProductManager productManager = new ProductManager();
    private List <Product> productList= productManager.productList;
    private ReadWriteFile readWriteFile = ReadWriteFile.getInstance();


    public static void main(String[] args) {

        menuManager();
    }


    public static void menuManager(){
        do {
            Scanner scanner = new Scanner(System.in);
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

                    displayProduct();
                    break;
                case 2:
                    addProduc();
                    break;
                case 3:
                    editProduc();
                    break;

                case 4:
                    deleteProduct();
                    break;
                case 5:
                    sortProduct();
                    break;
                case 6:
                    findMaxPrice();
                    break;
                case 7:
                    readFile();
                    break;
                case 8:
                    writeFile();
                    break;
                case 9:
                    System.out.println("Bye");
                    return;
                default:
                    break;
            }
        } while (true);
    }


    public static void displayProduct(){
        int stt = 1;
        for (Product element: productList
        ) {
            System.out.println(stt + ". "+element);
        }
    }

    public static void addProduc(){
        Scanner scanner  = new Scanner(System.in);
        Scanner scanner1  = new Scanner(System.in);
        System.out.println("Thêm sản phẩm");
        System.out.println("Nhập id sản phẩm muốn thêm mới: ");
        int id = scanner1.nextInt();
        System.out.println("Nhập tên sản phẩm muốn tạo mới: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá tiền:");
        int price = scanner.nextInt();
        System.out.println("Nhập số lượng:");
        int quantity = scanner.nextInt();
        System.out.println("Nhập mô tả: ");
        String describe = scanner1.nextLine();
        Product newProduct = new Product(id,name,price,quantity,describe);
        productList.add(newProduct);

        System.out.println("Thêm sản phẩm thành công : "+ newProduct);
    }

    public static void editProduc(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Sửa sản phẩm");

        int checkID = checkID();

        if (productList.get(checkID) == null){
            System.out.println("Id không tồn tại!!");
            return;
        }else {
            System.out.println("Nhập tên mới: ");
            productList.get(checkID).setName(scanner.nextLine())  ;
            System.out.println("Nhập giá tiền:");
            productList.get(checkID).setPrice(scanner.nextInt()) ;
            System.out.println("Nhập số lượng:");
            productList.get(checkID).setQuantity(scanner.nextInt() );
            System.out.println("Nhập mô tả: ");
            productList.get(checkID).setDescribe( scanner.nextLine() );
        }
    }
    public static int checkID(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("Nhập id sản phẩm can check: ");
        int checkID = scanner.nextInt();

        if (productList.get(checkID) == null){
            System.out.println("Id không tồn tại!!");
            return -1;
        }
        else {
            return checkID;
        }
    }

    public static void deleteProduct(){
        int checkId = checkID();
        productList.remove(checkId);
    }

    public static void sortProduct(){
        Collections.sort(productList, new Comparator<Product>() {
            public int compare(Product o1, Product o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        displayProduct();
    }

    public static void findMaxPrice(){


        Collections.sort(productList, new Comparator<Product>() {
            public int compare(Product o1, Product o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        System.out.println(" Sản phẩm giá đắt nhất là: ");
        System.out.println(productList.get(productList.size()-1));

    }

    public static void writeFile(){
        try{
            readWriteFile.writeData(productList);
            System.out.println("");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void readFile(){
        try{
            productList = readWriteFile.readData();
            displayProduct();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }







}
