import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    start = 0;
    end = 0;
    size = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[]) new Object[initialCapacity];
    start = 0;
    end = 0;
    size = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String out = "[";
    if (size == 0) return "[]";
    if (end <= start) {
      for (int i = start; i < data.length; i++) {
        out+= data[i] + ", ";
      }
      for (int i = 0; i <= end; i++) {
        if (i == end) out+= data[i];
        else out+= data[i] + ", ";
      }
    }
    else {
      for (int i = start; i <= end; i++) {
        if (i == end) out+= data[i];
        else out+= data[i] + ", ";
      }
    }
    out += "]";
    return out;
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] n = (E[]) new Object[(data.length-1) * 2];
    int in = size -start;
    if (start <= end) {
      for (int i = start; i <= end; i++) {
        n[i] = data[i]; //copy over
      }
    }
    else {
      for (int i = 0; i < size; i++) {
        if (i + start < data.length) {
          n[n.length - (in--)] = data[i+start];
        }
        else {
          n[i + start - data.length] = data[i + start - data.length];
          //other method of copying over when end is not after start
        }
      }
      start = n.length - (size - start);
    }
    data = n;
  }


  //basically same as addLast but start vs end
  public void addFirst(E element){
    if (element == null) throw new NullPointerException("deque does not permit null elements");
    if (start == 0) {
      if (end != data.length -1) {
        start = data.length -1;
        data[data.length - 1] = element;
      }
    else {
      resize();
      start--;
      data[start] = element;
    }
  }
  else {
    start --;
    data[start] = element;
  }
  size++;
}
  public void addLast(E element){
    if (element == null) throw new NullPointerException("deque does not permit null elements");
    if (size == 0) data[end] = element; //free for all
    else if (size == data.length) {
      resize();
      end++;
      data[end] = element; //necessary since no avaliable space anywehere
    }
    else if (start > end) {
      end++;
      data[end] = element; //keep going
    }
    else {
      if (end == data.length -1) {
        end = 0;
        data[0] = element; //put to front when space avail @ front
      }
      else {
        end++;
        data[end] = element; //regular
      }
    }
    size++;
  }
  public E removeFirst(){
    if (size == 0) throw new NoSuchElementException("deque is empty");
    E removed = data[start];
    if (start == data.length -1) {
      start = 0;
    }
    else start++;
    size--;
    return removed;
  }
  public E removeLast(){
    if (size == 0) throw new NoSuchElementException("deque is empty");
    E removed = data[end];
    if (end == data.length -1) {
      end = 0;
    }
    else if (end == 0) {
      end = data.length -1;
    }
    else end--;
    size--;
    return removed;
  }
  public E getFirst(){
    if (size == 0) throw new NoSuchElementException("deque is empty");
    return data[start];
  }
  public E getLast(){
    if (size == 0) throw new NoSuchElementException("deque is empty");
    return data[end];
  }


  public static void main(String[] args) {
    MyDeque<Integer> s = new MyDeque();
    s.addLast(5);
    s.addLast(12);
    s.addLast(2);
    s.addLast(3);
    s.addLast(6);
    s.addLast(7);
    s.addLast(8);
    s.addLast(9);
    System.out.println(s.end); //7
    System.out.println(s);
    s.addFirst(40);
    System.out.println("Size : " + s.size()); //9
    System.out.println(s.start); //9
    System.out.println(s); //[40, 5, 12, 2, 3, 6, 7, 8, 9];
    System.out.println(s.getFirst()); //40
    System.out.println(s.removeFirst()); //40;
    System.out.println(s); //[5,12,2,3,6,7,8,9];
    System.out.println("Size : " +  s.size); //8
    System.out.println(s.removeLast()); //9
    System.out.println(s); //[5,12,2,3,6,7,8]
    s.removeLast();
    System.out.println(s); //[5,12,2,3,6,7]
    s.removeLast();
    System.out.println(s); //[5,12,2,3,6]
    s.removeLast();
    System.out.println(s); //[5,12,2,3]
    s.removeLast();
    System.out.println(s); //[5,12,2]
    s.removeLast();
    System.out.println(s); //[5,12]
    s.removeLast();
    System.out.println("Size : " +  s.size); //1
    System.out.println(s); //[5]
    s.removeFirst();
    System.out.println(s); //[]


  }
}
