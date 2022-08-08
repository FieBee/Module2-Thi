package login;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        menuLogin();
    }

    public static void menuLogin(){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("  1. Đăng nhập                              ");
            System.out.println("  2. Đăng ký tài khoản                      ");
            System.out.println("  0. Thoát                                  ");
            System.out.println("---------------------------------------------");
            System.out.print("Nhập lựa chọn: ");
            System.out.println("");
            try{
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn không tồn tại!!!");
                        break;
                }
            }catch (InputMismatchException e){
                System.err.println("Lựa chọn sai!!!");
                menuLogin();

            }

        } while (true);
    }

}
