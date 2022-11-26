

 class Vehicle{
    String Brand = "TATA";
    public void display(){
        System.out.println("Welcome in TATA");
    }
}
public class Inheritance extends Vehicle {
     String Model="NEXON";

     public static void main(String args []){
         Inheritance c=new Inheritance();
         c.display();
     }

}