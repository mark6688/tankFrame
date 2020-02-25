package strategy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int[] a = {9,2,5,2,7,6};
        Cat[] a = {new Cat(3,1),new Cat(5,2),new Cat(4,4)};
        Dog[] d = {new Dog(1),new Dog(8),new Dog(3)};
        Sorter<Dog> sorter = new Sorter();
        sorter.sort(d,new DogComparator());
        System.out.println(Arrays.toString(d));

        Sorter<Cat> sorter1 = new Sorter();
//        sorter1.sort(a,new CatWeightComparator());
        //函数式接口：
        sorter1.sort(a,(o1,o2)->{
            if(o1.weight < o2.weight){return -1;}
            else if(o1.weight > o1.weight){return 1;}
            else return 0;
        });
        System.out.println(Arrays.toString(a));

    }

}
