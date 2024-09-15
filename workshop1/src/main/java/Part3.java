
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class Part3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements of listname?");
        int n = sc.nextInt();
        sc.nextLine();
        String[] list = new String[10];
        for(int i = 0; i < n; i++){
            System.out.print("list["+i+"] = ");
            list[i] = sc.nextLine();
        }
        for(int i = 0; i < n; i++){
            list[i] = list[i].toUpperCase();
        }
        for(int i = 0; i < n; i++){
            System.out.println("list["+i+"] = " + list[i]);
        }
    }
}
