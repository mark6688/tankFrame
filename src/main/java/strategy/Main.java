package strategy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int[] a = {9,2,5,2,7,6};
        Cat[] a = {new Cat(3,1),new Cat(5,2),new Cat(4,4)};
        Dog[] d = {new Dog(1),new Dog(8),new Dog(3)};
        Sorter<Dog> sorter = new Sorter();
        sorter.sort(d,new DogComparator());

        Sorter<Cat> sorter1 = new Sorter();
        sorter1.sort(a,new CatWeightComparator());

        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.toString(a));
    }

}
