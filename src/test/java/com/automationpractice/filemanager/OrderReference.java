package com.automationpractice.filemanager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OrderReference {


    public static String screenShotDir = "OrderReference";

    /**
     * Methods to Read and write the Order Reference Number from the Order History Page into a text file
     * */
    public void createOrderReference(String fileName, String orderReference) throws IOException {
        try {
            FileWriter myFileWriter = new FileWriter(screenShotDir+ File.separator+fileName+".txt");
            myFileWriter.write("OrderNumber: " + orderReference);
            myFileWriter.flush();
        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
