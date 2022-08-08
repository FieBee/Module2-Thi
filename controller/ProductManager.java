package controller;

import model.Product;
import storage.ReadWriteFile;

import java.util.Comparator;
import java.util.List;

public class ProductManager {

    private final ReadWriteFile readWriteFile = ReadWriteFile.getInstance();
    public List<Product> productList = readWriteFile.readData();


    public  void displayProduct(){
        int stt = 1;
        for (Product element: productList
        ) {
            System.out.println(stt + ". "+element);
        }
    }

    public void addProduc(Product product){
        productList.add(product);
    }

    public void editProduc(int id, Product product){
        productList.set(id, product);
    }

    public void deleteProduc(int id){
        productList.remove(id);
    }

    public void sortProduct(){
        productList.sort(Comparator.comparingInt(Product::getPrice));
        displayProduct();
    }
    public void writeFile(){
        try{
            readWriteFile.writeData(productList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void readFile(){
        try{
            productList = readWriteFile.readData();
            displayProduct();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public  void findMaxPrice(){
        productList.sort(Comparator.comparingInt(Product::getPrice));
        System.out.println(" Sản phẩm giá đắt nhất là: ");
        System.out.println(productList.get(productList.size()-1));

    }

    public int checkId(int id){
        if (productList.get(id) != null){
            return id;
        }else {
            System.out.println();
        }
        return -1;
    }

}
