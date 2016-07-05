package com.epam.tasks.task1;

/**
 * Created by Kirill_Kaluga on 6/29/2016.
 */
public class Checker {
    public static boolean execute(String num) {
        if (num.length() != 4) {
            System.out.println("Not four-digit number");
            return false;
        }

        try{
            int c1 = Integer.parseInt(num.substring(0, 1)),
                    c2 = Integer.parseInt(num.substring(1, 2)),
                    c3 = Integer.parseInt(num.substring(2, 3)),
                    c4 = Integer.parseInt(num.substring(3, 4));
            if (c1 + c2 == c3 + c4) {
                return true;
            } else {
                return false;
            }
        }catch (NumberFormatException e){
            System.out.println("Not a number");
            return false;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
