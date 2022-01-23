package ITSOL.BusDriverManagement.fileIO;

import java.io.*;
import java.util.List;

public class IOFile {
    private static final String PATH = "C:\\Users\\TAV\\IdeaProjects\\BackEnd__T3H\\src\\ITSOL\\BusDriverManagement\\fileIO";
    public static  <T> void writeObjectToFile(T t, String s) {
        try {
            FileOutputStream f = new FileOutputStream(new File(PATH + s));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(t);
            o.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> readObjectFromFile(String fileName) {
        try {
            FileInputStream fi = new FileInputStream(new File(PATH + fileName));
            ObjectInputStream oi = new ObjectInputStream(fi);
            List<T> t = (List<T>) oi.readObject();
            return t;
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Chưa thể đọc! Gặp lỗi!");
        }
        return null;
    }
}
