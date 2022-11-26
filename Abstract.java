
abstract class Animal{
    abstract void Name();
    public void info(){
        System.out.println("Name of the Animal");
    }
}
class Tiger extends Animal{
    public void sound(){
        System.out.println("Tiger roar");
    }

    @Override
    public void Name() {
        System.out.println("I am Tiger");
    }
}
public class Abstract {
    public static void main(String args []){
       Tiger t=new Tiger();
       t.info();
       t.sound();
       t.Name();
    }
}