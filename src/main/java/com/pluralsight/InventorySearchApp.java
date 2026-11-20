package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class InventorySearchApp {

    public static void main(String[] args) {

        ArrayList<Product> products = InventorySearchApp.getInventory();
        products = new ArrayList<Product>();

        System.out.println(getInventory());



    }

    private static ArrayList<Product> getInventory() {

        String fileName = "src/main/resources/inventory.csv";

        try {
            FileReader myReader = new FileReader(fileName);
            BufferedReader myBuffer = new BufferedReader(myReader);

            String line = myBuffer.readLine();
            line = myBuffer.readLine();

            while (line != null) {
                Product products = parseProduct(line);
                System.out.println("%d %)/
                line = myBuffer.readLine();

            }
            myBuffer.close();


        } catch (FileNotFoundException e) {
            System.out.println("doesn't exist");
        } catch (IOException e) {
            System.out.println("placeholder");
        }


        return null;
    }


    private static Product parseProduct(String inventoryCsv) {
        String[] productParts = inventoryCsv.split(Pattern.quote("|"));
        int id = Integer.parseInt(productParts[0]);
        String name = productParts[1];
        double price = Double.parseDouble(productParts[2]);

        Product product = new Product(id, name, price);

        return product;
    }

}






