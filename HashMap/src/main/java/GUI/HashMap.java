/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.Product;
import DTO.Products;
import Tools.Tools;

/**
 *

 * @author Acer
 */
public class HashMap {
    public static void main(String[] args) {
        Products listProduct = new Products();
        String fileName = "E:/Code/listOfProducts.dat";
        int choice = 0;
        do {
            choice = displayMenu();
            switch (choice) {
                case 1:
                    Product x = addProductInfo();
                    listProduct.put(x.getProductCode(), x);
                    break;
                case 2:
                    if (listProduct.isEmpty()) {
                        System.out.println("Do not have any product");
                    } else {
                        listProduct.showAll();
                    }
                    break;
                case 3:
                    String delPro = Tools.inputString("Enter productCode to delete: ");
                    if (listProduct.containsKey(delPro.toUpperCase())) {
//                        Product z = listProduct.remove(delPro);
                        listProduct.remove(delPro.toUpperCase());
                        System.out.println("Successfully deleted!");
                    } else {
                        System.out.println("Cannot find product with code: " + delPro);
                    }
                    break;
                case 4:
                    String supPro = Tools.inputString("Enter supplier: ");
                    if(listProduct.containsKey(supPro)){
                        listProduct.filterBySupplier(supPro);
                    }
                    else
                        System.out.println("Cannot find prodcut with supplier: " + supPro);
                    
                    break;
                case 5:
                    int option = Tools.inputInt("Choose: \n"
                            + "1: Sort by name(ASC)\n"
                            + "2: Sort by value(DES)");
                    if(option == 1)
                        listProduct.sortByName();
                    else 
                        listProduct.sortByValue();
                    break;
                case 6:
                    listProduct.statisticsBySupplier();
                    break;  
                case 7:
                    int z = listProduct.saveDataToFile(fileName);
                    if(z!=0)
                        System.out.println("Save succesfully");
                    else   
                        System.out.println("Error");
                    break;
                case 8:
                    int n = listProduct.loadDataFromFile(fileName);
                    if( n > 0)
                        System.out.println("Read succesfully " + n + "product form file: " + fileName);
                    else
                        System.out.println("Error");
                    break;
                case 9:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice!!");
            }

        } while (choice != 9);
    }

    private static int displayMenu() {
        int choice = Tools.inputInt("1 - Add product information\n"
                + "2 - Show all products\n"
                + "3 - Delete a product\n"
                + "4 - Filter products by SUPPLIER\n"
                + "5 - Sort and display products\n"
                + "6 - Statistics the product by SUPPLIER\n"
                + "7 - Save data to file\n"
                + "8 - Load data from file\n"
                + "9 - Exit program");
        return choice;
    }

    private static Product addProductInfo() {
        Product x = new Product();
        x.setProductCode(Tools.inputString("Product Code: "));
        x.setProductName(Tools.inputString("Product Name: "));
        x.setSupplier(Tools.inputString("Supplier: "));
        x.setHasPromotion(Tools.inputHasPromotion("Has promotion ? [1: Has Other: None] "));
        x.setPrice(Tools.inputDouble("Price: "));
        x.setQuantity(Tools.inputFloat("Quantity: "));
        return x;
    }
    
    
}
