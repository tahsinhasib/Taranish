

import java.lang.*;

public class Stall {

    private int stallNo;
    private double stallPrice;

    public Stall(int stallNo,
                 double stallPrice){

                    this.stallNo = stallNo;
                    this.stallPrice = stallPrice;
                 }
    
    public void showStall(){
        System.out.println("Stall  " +stallNo+ "  Price ");
        System.out.println("------------------------------");
        System.out.println("Price : " +stallPrice+ " Taka");
        System.out.println("------------------------------");

    }

    
}
