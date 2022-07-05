
import java.lang.*;

public class Start {
    public static void main(String[] args) {

        //------------------------------------------instantiating object
        Stall s1 = new Stall(1,
                             250);
        
        Menu m1 = new Menu("Burger", 
                            "Coke", 
                            "IceCream", 
                            "Lunch",
                            350,
                            25,
                            100,
                            1000,
                            s1);

        m1.showMenu();
        m1.gotoStall();
        //s1.showStall();
    }
}
