import java.lang.*;
import java.util.Scanner;

public class Main{
    static Scanner input = new Scanner(System.in);

    //-----------------------------------------variables
    private static int start;
    private static int contents;
    private static int SimpleCalculation;
    private static double a, b;
    private static int Cosine;
    public static void main(String[] args){

        //----------------------------------------------objects
        Home h1 = new Home();
        Menu m1 = new Menu();
        SimpleCalculation sc1 = new SimpleCalculation();
        TrigonometricCalculation tc1 = new TrigonometricCalculation();


        //----------------------------------------------start
        h1.GreetMSG();

        System.out.print("\nEnter here : ");
        start = input.nextInt();


        switch(start){
            case 1:
                m1.MenuList();
                break;
            case 2:
                System.out.println("\nThank you for using!");
                break;
            default:
                System.out.println("Invalid operation!");

        }

        System.out.println("\nSelect the content from below");
        System.out.print("Enter here : ");
        contents = input.nextInt();

        //-----------------------------------------for content choice
        switch(contents){
            //-------------------------------------------------for arithmatic choice
            case 1:
            System.out.println("---------------------------------------------------");
            System.out.println("\nSelect option here :\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division");
            System.out.print("Enter here : ");

            SimpleCalculation = input.nextInt();

            switch(SimpleCalculation){
                case 1:
                    System.out.print("\nEnter numbers : ");
                    a = input.nextDouble();
                    b = input.nextDouble();
                    System.out.println(sc1.Addition(a, b));
                    break;
                case 2:
                    System.out.print("\nEnter numbers : ");
                    a = input.nextDouble();
                    b = input.nextDouble();
                    System.out.println(sc1.Subtraction(a, b));
                    break;
                case 3:
                    System.out.print("\nEnter numbers : ");
                    a = input.nextDouble();
                    b = input.nextDouble();
                    System.out.println(sc1.Multiplication(a, b));
                    break;
                case 4:
                    System.out.print("\nEnter numbers : ");
                    a = input.nextDouble();
                    b = input.nextDouble();
                    System.out.println(sc1.Division(a, b)); 
                    break;
                default:
                    System.out.println("\nInvalid request!");
            }
                break;
            
            //----------------------------------------for trigonometric operation
            case 2:
            System.out.println("---------------------------------------------------");
            System.out.println("\nSelect option here :\n1.Sin\n2.Cos\n3.Tan");
            System.out.print("Enter here : ");

            Cosine = input.nextInt();

            switch(Cosine){
                case 1:
                    System.out.print("\nEnter value of sin : ");
                    a = input.nextInt();
                    System.out.println("\nThe value is : "+tc1.sinFunc(a));
                    break;
                case 2:
                    System.out.print("\nEnter value of cos : ");
                    a = input.nextInt();
                    System.out.println("\nThe value is : "+tc1.cosFunc(a));
                    break;
                case 3:
                    System.out.print("\nEnter value of tan : ");
                    a = input.nextInt();
                    System.out.println("\nThe value is : "+tc1.tanFunc(a));
                    break;
                default:
                    System.out.println("Invalid request!");
            }
            break; // for case 2
            default:
                System.out.println("\nInvalid Operation!");
        }
    }
}