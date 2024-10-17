/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Products extends HashMap<String, Product> {

    public Products() {
        super();
    }

    public void showAll(List<Product> list) {
        for (Product i : list) {
            System.out.println(i);
        }
    }

    public void showAll() {
        for (Product i : toList()) {
            System.out.println(i);
        }
    }

    public List<Product> toList() {
        return new ArrayList<>(this.values());
    }

    public List<Product> filterBySupplier(String supplier) {
        List<Product> list = new ArrayList<>();
        for (Product i : toList()) {
            if (i.getSupplier().equalsIgnoreCase(supplier)) {
                list.add(i);
            }
        }
        return list;
    }

    public void sortByName() {
        //-- create object to compare
        Comparator<Product> comp = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (o1.getProductName().compareToIgnoreCase(o2.getProductName()));
            }
        };

        //-- call sort of Support class
        List<Product> list = toList();
        Collections.sort(list, comp);
        //-- show
        showAll(list);
    }

    public void sortByValue() {
        List<Product> products = toList();
        products.sort(Comparator.comparing(Product::value).reversed());
        products.forEach(System.out::println);
    }

    public void statisticsBySupplier() {
        Map<String, Integer> productCountBySupplier = new HashMap<>();
        Map<String, Float> totalValueBySupplier = new HashMap<>();

        for (Product product : this.values()) {
            String supplier = product.getSupplier();
            productCountBySupplier.put(supplier, productCountBySupplier.getOrDefault(supplier, 0) + 1);
            totalValueBySupplier.put(supplier, totalValueBySupplier.getOrDefault(supplier, 0f) + product.value());
        }

        for (String supplier : productCountBySupplier.keySet()) {
            System.out.println("Supplier: " + supplier);
            System.out.println("Number of Products: " + productCountBySupplier.get(supplier));
            System.out.println("Total Value: " + totalValueBySupplier.get(supplier));
            System.out.println("----------");
        }
    }

    public int saveDataToFile(String fileName) {
        int res = 0;
        FileOutputStream fos = null;
        try {
            File f = new File(fileName);
            fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Product i : toList()) {
                oos.writeObject(i);
            }
            oos.close();
            res = 1;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return res;
    }

    public int loadDataFromFile(String fileName) {
        FileInputStream fis = null;
        int res = 0;

        try {
            File f = new File(fileName);
            fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                Product x = (Product) ois.readObject();
                this.put(x.getProductCode(), x);
                res++;
            }
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return res;
    }

}
