package storage;

import java.util.ArrayList;
import java.util.List;

public interface ReadWriteData<E> {


    ArrayList<E> readData();

    void writeData(List<E> productsList);

}
