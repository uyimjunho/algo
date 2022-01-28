package DAY01.P1713;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        Item item1 = new Item(1, 3, 1);
        Item item2 = new Item(2, 2, 3);
        Item item3 = new Item(3, 1, 2);

        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        Collections.sort(list);
        System.out.println(list);

    }
}

class Item implements Comparable<Item>{
    int a,b,c;

    public Item(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "SortTest{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    //양수 : swqp
    //0 : -
    //음수 : -
    @Override
    public int compareTo(Item o) {
//        if (a < o.a) {
//            return -1;
//        } else if (a == o.a) {
//            return 0;
//        } else {
//            return 1;
//        }

//        return Integer.compare(a, o.a);//오름차순

        int comp1 = Integer.compare(a, o.a);
        if (comp1 == 0) {
            return Integer.compare(b, o.b);
        }
        return comp1;

    }
}
