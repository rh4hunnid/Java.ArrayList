import java.util.NoSuchElementException;

public class MyArrayList implements MyList {
    
    private int capacity = 8;
    private int size = 0;
    private Object storage[] = new Object[8];
    
    public void print(){
       for (Object n : storage){
          System.out.println(n);
       }
       
    }
    
    
    public void addToEnd(Object obj) {
       if (size < capacity){
          storage[size] = obj; 
          size++;
       } else { 
          makeCapacity(2*size);
          storage[size -1] = obj;
          size++;
       }
       
       
    }
    
    public void insertAt(int num, Object obj) {
       if ((size < 1) && (num == 0)){
          storage[0] = obj;
          size++;
       } else if ((num < 0) || (num > size)){
          throw new NoSuchElementException();
       } else if (size >= capacity) {
          makeCapacity(2*size);
          Object[] newobb = new Object[size];
          // all nums before the added value
          for (int i = 0; i < num; i++){
             newobb[i] = storage[i];
          }
          // all nums after the added value
          for (int i = num +1; i < size; i++){
             newobb[i] = storage[i-1];
          }
           newobb[num] = obj;
           storage = newobb;
           size++;
          } else{
          
          Object[] newobb = new Object[capacity];
          // all nums before the added value
          int j = 0;
          for (int i = 0; i < newobb.length; i++){
             if (i == num){
            newobb[num] = obj;
             } else {
                newobb[i] = storage[j];
                j++;
             }
          }
           storage = newobb;
            size++;
       }
     
       
    }
    
    public void removeAt(int num){
       if ((num >= 0) && (num < size)){
         Object[] newarg = new Object[size-1];
         int j = 0;
         for (int i = 0; i <size; i++){
            if (i != num){
               newarg[j++] = storage[i];
                  }
               } size--;
               storage = newarg;
          } else {
          throw new NoSuchElementException();
          
       }
       
    }
    
    
    public Object getAt(int num){
       if ((num < 0) || (num >= size)){
          throw new NoSuchElementException();
         
       } else { return storage[num];}
       
       
    }
    
    public int getSize(){
       return size;
    }
    
    public void makeCapacity(int num){
       if (num > 8){
       if ((num > capacity)  || (num >= size)){
          capacity = num;
          Object newStore[] = new Object[num];
          for (int i = 0; i < storage.length; i++){
             newStore[i] = storage[i];
             
          }
          storage = newStore;
       }
       }
    }
    
    public void trimExcess(){
       if (storage.length > size){
          Object[] newarr = new Object[size];
          for (int i = 0; i < size; i++){
             newarr[i] = storage[i]; 
          }
          storage = newarr;
          
       }
       
    }
    
    
   
    
    public MyListIterator getIterator() {
        return new MyArrayListIterator();
    }
    
    private class MyArrayListIterator implements MyListIterator {
        int currentIndex = -1;

        
        public Object next() {
            ++currentIndex;
            return storage[currentIndex];
        }

       
        public boolean hasNext() {
            return currentIndex < size - 1;
        }
    }   
}

