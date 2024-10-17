package Tools;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class Tools {
    
    public static String inputString(String mess){
        String s = "";
        Scanner sc = new Scanner(System.in);
        System.out.println(mess);
        s = sc.nextLine();
        return s;
    }
    
    public static int inputInt(String mess) {
        int res = 0;
        String temp = inputString(mess);
        res = Integer.parseInt(temp);
        return res;
    }
    
    public static double inputDouble(String mess) {
        double res;
        String temp = inputString(mess);
        res = Double.parseDouble(temp);
        return res;
    }
    
    public static float inputFloat(String mess){
        float res;
        String temp = inputString(mess);
        res = Float.parseFloat(temp);
        return res;
    }
    
    public static boolean inputHasPromotion(String mess){
        boolean res = true;
        int temp  = inputInt(mess);
        res = (temp == 1);
        return res;
    }
    
    public static Date inputDate(String mess){
        Date d = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String temp = inputString(mess);
        try {
            d = sdf.parse(temp);
        } catch (ParseException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
}
