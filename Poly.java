

class Animal1{
    public void sound(){
        System.out.println("Animal Sound");
    }
}
 class Bird extends Animal1{
     public void sound(){
         System.out.println("Bird Sound");
     }
 }
 class Dog extends Animal1{
     public void sound(){
         System.out.println("Dog Sound");
     }
 }
public class Poly {
    public static void main(String args []){
        Animal1 an =new Animal1();
        Animal1 br =new Bird();
        Animal1 dg =new Dog();
        an.sound();
        br.sound();
        dg.sound();
    }
}
