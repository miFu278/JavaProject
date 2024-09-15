/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


import java.util.Scanner;
/**
 *
 * @author Acer
 */
public class Part1 {
    public static void main(String[] args) {
        int rows;
        int cols;
        int matrix[][];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        rows = sc.nextInt();
        System.out.println("Enter nuber of cols: ");
        cols = sc.nextInt();
        matrix = new int[rows][cols];
        System.out.println("Enter the matrix: ");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print("\nm["+i+"]["+j+"] = ");
                matrix[i][j] = sc.nextInt();
            }
        } 
        System.out.println("Matrix Inputted: ");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.format("%3d", matrix[i][j]);
            }
            System.out.println("\n");
        }
        int sum = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                sum += matrix[i][j];
            }
        }
        System.out.println("Sum = " + sum);
        System.out.println("Average:" +(float)sum/(rows*cols));
    }
}
