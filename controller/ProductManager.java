package controller;

import jdk.jfr.internal.tool.Main;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    public List<Product> productList = new ArrayList<>();


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

    public void editProduc(int id){

    }
}
