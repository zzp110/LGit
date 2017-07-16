package learnAutoCloseable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AutoCloseableClass {
    public static void main(String[] args) {
        try (Resource res = new Resource();) {
            res.doSome();
          } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
