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

        myList.remove(0);
        myList.add(1);
        System.out.println(myList.toString());
        System.out.println(myList.size());
    }

}
