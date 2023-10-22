package org.example;


public class appStart {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(8);

        System.out.println(myList.hashCode());
        System.out.println(myList.toString());
        myList.remove(5);
        System.out.println(myList.toString());
        myList.add(5);
        System.out.println(myList.get(3));
        System.out.println(myList.toString());

    }

}
