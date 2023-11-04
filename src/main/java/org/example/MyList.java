package org.example;

import java.sql.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class MyList<T extends Number> implements Iterable<T> {

  private Object[] items;
  private int size;

  public MyList() {
    size = 0;
    items = new Object[10];
  }

  // Метод добовляет элемент в массив
  public void add(T item) {
    if (size >= items.length) {
      resize();
    }
    items[size++] = item;
  }

  // Метод для получения элемента из массива по индексу
  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index out of range");
    }
    return (T) items[index];
  }

  // Метод увеличивает массив если он заполнен
  private void resize() {
    int newSize = size * 2;
    items = Arrays.copyOf(items, newSize);
  }

  //Метод удаляет элемент по индексу из массива
  public T remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index out of range");
    }

    T item = (T) items[index];
    System.arraycopy(items, index + 1, items, index, size - index - 1);
    size--;
    items[size] = null;
    return item;
  }

  //Реализация метода map
  public <R extends Number> MyList<R> map(Function<T, R> function) {
    MyList<R> result = new MyList<>();
    for (int i = 0; i < size; i++) {
      result.add(function.apply((T) items[i]));
    }
    return result;
  }


  //Метод для получения размера массива
  public int size() {
    return size;
  }


  //метод преобразующий массив в String
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    for (int i = 0; i < size; i++) {
      sb.append(items[i].toString());
      if (i < size - 1) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }

  //Реализация метода hashCode
  @Override
  public int hashCode() {
    int result = 1;
    for (int i = 0; i < size; i++) {
      result = 17 * result + (items[i] == null ? 0 : items[i].hashCode());
    }
    return result;
  }

  //Реализация метода equals
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MyList<?> otherList = (MyList<?>) o;
    if (size != otherList.size) return false;
    for (int i = 0; i < size; i++) {
      if (items[i] == null) {
        if (otherList.items[i] != null) return false;
      } else {
        if (!items[i].equals(otherList.items[i])) return false;
      }
    }
    return true;
  }

  //Реализация итератора для работы foreach
  @Override
  public Iterator<T> iterator() {
    return new MyListIterable();
  }
  private class MyListIterable implements Iterator<T> {
    private int current = 0;

    @Override
    public boolean hasNext() {
      return current < size;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      return (T) items[current++];
    }
  }
}