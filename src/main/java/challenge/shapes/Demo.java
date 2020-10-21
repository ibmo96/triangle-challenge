package challenge.shapes;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Demo {
    

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 

        System.out.println("Welcome to the Keylane Triangle demo! \n This program takes three space seperated lengths of a triangles sides, and returns the type of triangle...");
        System.out.println("please type \"quit\" if you wish to exit the program");


        boolean operational = true; 

        double a = 2;  
        double b =2;
        double c = 2;

        double semiPerimeter = (a+b+c)/2; 

		//Herons formula 
        double area = Math.sqrt(semiPerimeter*((semiPerimeter-a)*(semiPerimeter-b)*(semiPerimeter-c))); 
        System.out.println(area);

        /* while (operational){
            String line = sc.nextLine(); 
            if (line.equals("quit")){
                operational = false; 
                break; 
            }

            StringTokenizer st = new StringTokenizer(line);

            double a = Double.parseDouble(st.nextToken()); 
            double b = Double.parseDouble(st.nextToken()); 
            double c = Double.parseDouble(st.nextToken()); 

            Triangle temp = Triangle.createWithLengths(a, b, c);

            System.out.println(temp);

        } */

        
        
    }
}
