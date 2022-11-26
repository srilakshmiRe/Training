
import java.util.*;
import java.util.stream.Stream;

public class DemoStream {

    public static void main(String args []){

        List<Integer> nums=Arrays.asList(9,4,5,7,8,1,3);

        Stream<Integer> da= nums.stream();
        Stream<Integer>sorted=da.sorted();
        sorted.forEach(n ->System.out.print(n));
       
    }

}