package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MyListTest {

  //Тестирование добавления элементов
  @Test
  public void test_MyList_add() {
    MyList<Integer> myList = new MyList<>();
    myList.add(1);
    myList.add(2);
    myList.add(3);
    myList.add(3);
    myList.add(3);
    Assertions.assertEquals(1, myList.get(0)); //проверка корректности добаленного заначения
    Assertions.assertNotEquals(5, myList.get(2)); //проверка корректности добаленного заначения
    Assertions.assertEquals(5, myList.size()); //Проверка размерности списка
  }

  //Тестирование метода get
  @Test
  public void test_MyList_get() {
    MyList<Integer> myList = new MyList<>();
    myList.add(1);
    myList.add(2);

    Assertions.assertEquals(1, myList.get(0)); //Тест получения существующего элемента
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myList.get(-1)); //Тест получения элемента при отрицательном индексе
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myList.get(3)); //Тест получения элемента при выходе за пределы размеров списка
  }

  //Тестирование метода remove
  @Test
  public void test_MyList_remove() {
    MyList<Integer> myList = new MyList<>();
    myList.add(1);
    myList.add(2);
    myList.add(3);
    myList.add(4);

    myList.remove(0);
    Assertions.assertEquals(2, myList.get(0)); //Тест удаление первого элемента
    myList.remove(2);
    Assertions.assertEquals(3, myList.get(1)); //Тест удаление последнего элемента
    Assertions.assertEquals(2, myList.size()); //Тест на проверку размерности списка после удаления элементов
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myList.remove(-1)); //тест на удаление элемента за пределами списка
  }

  //Тестирование метода toString
  @Test
  public void test_MyList_toString() {
    MyList<Integer> myList = new MyList<>();

    Assertions.assertEquals("[]", myList.toString()); //тест пустого списка

    myList.add(1);
    myList.add(2);
    myList.add(3);
    Assertions.assertEquals("[1, 2, 3]", myList.toString()); //тест заполненного списка
  }

  //Тестирование метода hasCode
  @Test
  public void test_MyList_hasCode() {
    MyList<Integer> myList = new MyList<>();
    myList.add(1);
    myList.add(2);
    myList.add(3);

    MyList<Double> myList1 = new MyList<>();
    myList1.add(1.1);
    myList1.add(2.2);
    myList1.add(3.3);

    Assertions.assertEquals(myList.hashCode(), myList.hashCode()); //Тест сравнение двух одинаковых списков.
    Assertions.assertNotEquals(myList1.hashCode(), myList.hashCode()); //Тест сравнение двух разных списков.
  }

  //Тестирование метода equals
  @Test
  public void test_MyList_equals() {
    MyList<Integer> myList = new MyList<>();
    myList.add(1);
    myList.add(2);
    myList.add(3);

    MyList<Integer> myList1 = new MyList<>();
    myList1.add(1);
    myList1.add(2);
    myList1.add(3);

    String str = "test";
    Assertions.assertTrue(myList.equals(myList)); //Тест объект должен быть равен самому себе.
    Assertions.assertTrue(myList.equals(myList1) && myList1.equals(myList)); //Тест список 1 должен быть равен списку 2 с одинаковми заначениями.
    Assertions.assertFalse(myList.equals(null)); //Тест список не равен null
    Assertions.assertFalse(myList.equals(str)); //Тест список не равен другому объекту
    myList1.add(4);
    Assertions.assertFalse(myList.equals(myList1)); //Тест список 1 не равен списку 2 с другими значениями
  }

  //Тестирование итератора
  @Test
  public void test_MyList_iterator() {
    MyList<Integer> myList = new MyList<>();
    Iterator<Integer> iterator = myList.iterator();
    Assertions.assertThrows(NoSuchElementException.class, iterator::next); //Тест итерация пустого

    myList.add(1);
    myList.add(2);
    myList.add(3);

    Assertions.assertTrue(iterator.hasNext());  //итерация списка
    Assertions.assertEquals(1, iterator.next());
    Assertions.assertTrue(iterator.hasNext());
    Assertions.assertEquals(2, iterator.next());
    Assertions.assertTrue(iterator.hasNext());
    Assertions.assertEquals(3, iterator.next());
    Assertions.assertFalse(iterator.hasNext());

  }

  //Тестирование метода map
  @Test
  public void test_MyList_map() {
    MyList<Integer> myList = new MyList<>();

    MyList<Integer> mapList1 = myList.map(num -> num);
    Assertions.assertEquals(0, mapList1.size());

    myList.add(1);
    myList.add(2);
    myList.add(3);

    MyList<Double> mapList = myList .map(num -> num * 1.0);
    Assertions.assertEquals(3, mapList.size());
    Assertions.assertEquals(1.0, mapList.get(0));
    Assertions.assertEquals(2.0, mapList.get(1));
    Assertions.assertEquals(3.0, mapList.get(2));

  }
}
