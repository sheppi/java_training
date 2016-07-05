package com.epam.tasks.task10;

/**
 * Created by Kirill_Kaluga on 7/4/2016.
 */
public class Runner {
    public static void main(String[] args) {
        try{
            int n = Integer.parseInt(args[0]);
            if (n%2 != 0) {
                System.err.println("Write num which will divided on 2");
                return;
            }

            Integer[][] array = Worker.createMatrix(n);
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please, enter 1 number!");
        } catch (NumberFormatException e){
            System.out.println("Please, enter the integer!");
        }
    }

}
