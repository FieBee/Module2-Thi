package storage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile implements ReadWriteData{

    private static ReadWriteFile instance = null;
    private ReadWriteFile() {
    }

    public static ReadWriteFile getInstance() {
        if (instance == null) instance = new ReadWriteFile();
        return instance;
    }

    @Override
    public ArrayList readData() {
        try{
            FileInputStream fileInputStream = new FileInputStream("products.csv");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object ob = objectInputStream.readObject();
            ArrayList products = (ArrayList)  ob;
            objectInputStream.close();
            fileInputStream.close();
            return products;

        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void writeData(List productsList) {
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("products.csv");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productsList);
            objectOutputStream.close();
            fileOutputStream.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }
}
