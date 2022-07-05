

import java.lang.*;

public class Menu {
    
    //-------------------------------------attributes
    private String Fastfood;
    private String Drinks;
    private String Deserts;
    private String Lunch;

    private double FastfoodPrice;
    private double DrinksPrice;
    private double DesertsPrice;
    private double LunchPrice;

    //----------------------------------------association
    private Stall stl;

    //-------------------------------------initializing food and price
    public Menu(String Fastfood,
                String Drinks,
                String Deserts,
                String Lunch,
                double FastfoodPrice,
                double DrinksPrice,
                double DesertsPrice,
                double LunchPrice,
                Stall stl){

                    this.Fastfood = Fastfood;
                    this.Drinks = Drinks;
                    this.Deserts = Deserts;
                    this.Lunch = Lunch;
                    this.FastfoodPrice = FastfoodPrice;
                    this.DrinksPrice = DrinksPrice;
                    this.DesertsPrice = DesertsPrice;
                    this.LunchPrice = LunchPrice;
                    this.stl = stl;

                }

    //-----------------------------------------------showing details
    public void showMenu(){
        System.out.println("\n---------------------- Menu ----------------------");
        System.out.println("--------------------------------------------------");
        System.out.println("Type   -------   Item   -------   Price");
        System.out.println("---------------------------------------");
        System.out.println("Fastfood        : "+Fastfood+"           "+FastfoodPrice);
        System.out.println("Drinks          : "+Drinks+"             "+DrinksPrice);
        System.out.println("Deserts         : "+Deserts+"         "+DesertsPrice);
        System.out.println("Lunch           : "+Lunch+"            "+LunchPrice);
    }

    //--------------------------------------------performing association
    public void gotoStall(){
        System.out.println("\nStall here!");
        stl.showStall();
    }

}
