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
    if (start <= end) {
      for (int i = start; i <= end; i++) {
        out += data[i];
        if (i != end) out += ", ";
      }
    }
    else {
      for (int i = 1; i < size; i++) {
        if (i + start < data.length) {
          out += data[i+start];
        }
        else {
          out += data[i+start-data.length];
        }
        if (i+ start - data.length != end -1) {
          out += ", ";
        }
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



  public void addFirst(E element){}
  public void addLast(E element){
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
  }
  /*public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }*/


  public static void main(String[] args) {
    MyDeque<Integer> s = new MyDeque();
    s.addLast(5);
    s.addLast(12);
    System.out.println(s.start); //still 5
    System.out.println(s.end); //now 7
    System.out.println(s); //[5,12]
    s.addLast(2);//end is 8
    s.addLast(2); //end is 9
    s.addLast(6); //end is 0
    s.addLast(2); //end is 1
    s.addLast(2); //end is 2
    s.addLast(2); //end is 3;
    System.out.println(s.end);
    System.out.println(s);
    s.addLast(3); //end is 4... spicy time
    s.addLast(3); //no space

  }
}
