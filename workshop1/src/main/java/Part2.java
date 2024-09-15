
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Acer
 */
public class Part2 {
    public static void main(String[] args) {
        float num1, num2;
        String op;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number 1: ");
        num1 = sc.nextFloat();
        System.out.println("Input number 2: ");
        num2 = sc.nextFloat();
        System.out.println("Input the operator(+, -, *, /)");
        sc = new Scanner(System.in);
        op = sc.nextLine();
        if(op.equals("+")){
            System.out.println("the result of " + num1 + " + " + num2 + " = " + (num1 + num2));
        }
        if(op.equals("-")){
            System.out.println("the result of " + num1 + " - " + num2 + " = " + (num1 - num2));
        }
        if(op.equals("*")){
            System.out.println("the result of " + num1 + " * " + num2 + " = " + (num1 * num2));
        }
        if(op.equals("/")){
            System.out.println("the result of " + num1 + " / " + num2 + " = " + (num1 / num2));
        }
    }
}
