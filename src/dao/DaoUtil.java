package dao;

import java.io.*;
import java.util.List;

public class DaoUtil {
    private DaoUtil() {}

    public static boolean saveDataToFile(Object obj, String filename){

        try{
            ObjectOutputStream dataOutputStream =new ObjectOutputStream(new FileOutputStream(filename));
            dataOutputStream.writeObject(obj);
            dataOutputStream.close();

        } catch (IOException e) {
            return false;
        }

        return true;
    }

    public static Object loadDataFromFile(String filename){
        try{
            ObjectInputStream dataInputStream = new ObjectInputStream(new FileInputStream(filename));
            Object obj = dataInputStream.readObject();
            dataInputStream.close();
            return obj;

        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
