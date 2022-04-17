package Dev_J110;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;




public class ArrayLinkedList <T> {
       
    private Node first; //изначально null
      
    //Вспомогательные методы
    //Метод, который создает коллекцию из нашего списка
    public ArrayList<T> toCollection(){
        Node current = first;
        ArrayList<T> list = new ArrayList<>();
        if(!isEmpty()){
           list.addAll(first.toList());
           while(current.toNext != null) {
                 list.addAll(current.toNext.toList());
                 current = current.toNext; }
           list.removeIf(Objects::isNull);
        return list;  
        }        
        else
            throw new NullPointerException("Список пустой.");    
    }
        
    //Метод для реверса массива
    public T[] reverse(T[] list) {
        T[] result = (T[])new Object[list.length];
        for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
             result[j] = list[i]; }
        return result;
    }
    //Метод для очистки списка
    public void erasingList() {
        if (!isEmpty()) 
            first = null;                    
    }
    //Метод, возвращающий количество элементов списка.
    public int sizeList() {
              
        return toCollection().size();       
    }
    
    /*Метод, возвращающий индекс свободного (пустого) элемента в массиве данных текущего узла.
      Если все элементы массива текущего узла не Null, возвращается -1. */
    public int searcherNull(T[] array){
        int res = 0;
        for(int i = 4; i >= 0; i--) {
            if(array[i] == null) {
                res = i;
                break; }
            if(i == 0 && array[0] != null)
                res = -1;
        }
        return res;
    }
    //Метод, возвращающий индекс первого по порядку элемента в массиве данных текущего узлане, который не Null.
    public int searcherNotNull(T[] array){
        int res = 0;
        for(int i = 0; i < 5; i++) {
            if(array[i] != null) {
               res = i;
               break; }
        }
        return res;
    }
 
    //Метод, определяющий, является ли список пустым, или нет;    
    public boolean isEmpty() {
        return first == null;
    } 
    
    //Метод добавляет данные в начало списка.
    public void addFirst(T dat) {
        if(isEmpty() || searcherNull((T[])first.data) == -1) {
           Node <T> newNode = new Node<>();
           newNode.data[4] = dat; 
           newNode.toNext = first;
           first = newNode;}
        else
           first.data[searcherNull((T[])first.data)] = dat; 
    }
   
    //Метод добавляет данные в начало списка из массива с сохранением порядка.
    public void addFromArray(T[] dat) {
        
        Arrays.asList(reverse(dat)).forEach(this::addFirst); 
    }
    
    //Метод добавляет данные в конец списка из массива с сохранением порядка.
    public void addFromArrayTail(T[] dat) {
        
         Arrays.asList(dat).forEach(this::addToTail);
    }

    //извлечение значения из начала списка без его удаления из списка
    public T extractFirst() {
        if (!isEmpty())
            return (T)first.data[searcherNotNull((T[])first.data)]; 
        else
            throw new NullPointerException("Список пустой.");       
    }

    //Извлечение значения из начала списка с удалением его из списка
    public T extractFirstAndRemove() {
        if (!isEmpty()) {
            T res;
            if(searcherNotNull((T[])first.data) != 4) {
               res = extractFirst();
               first.data[searcherNotNull((T[])first.data)] = null;  }
            else {
               res = extractFirst();
                first = first.toNext;}
            return res;   
        }
        else
            throw new NullPointerException("Список пустой.");
    }
    
    //добавление значения в конец списка
    public void addToTail(T data) {
        if (isEmpty()) 
            addFirst(data);
        else {
            List<T> list = toCollection();
            list.add(data);
            Collections.reverse(list);
            erasingList();
            list.forEach(this::addFirst);
        }
    }

    //извлечение значения из конца списка без его удаления
    public T extractTailData() {
        if (!isEmpty()) {
            Node current = first;
            while (current.toNext != null) {
                   current = current.toNext; }
            return (T)current.data[4]; }        
        else
            throw new NullPointerException("Список пустой.");   
    }

    //извлечение значения из конца списка с удалением
    public T extractTailAndRemove() {

         T res = extractTailData();
         List<T> list = toCollection();
         list.remove(list.size() - 1);
         Collections.reverse(list);
         erasingList();
         list.forEach(this::addFirst);
         
         return res;
    }
   
    //Метод, определяющий, содержит ли список заданное значение, или нет

    public boolean isInList(T toEquals) {
        return toCollection().contains(toEquals);    
    }

    //печать всех значений списка
    public void printAll() {
        Node current = first;
        if (current == null) {
            System.out.println("Элементы списка отсутствуют, список пустой.");
        } else if (current.toNext == null) {
            current.printNodeData();
            System.out.println();
        } else {
            while (current.toNext != null) {
                current.printNodeData();
                current = current.toNext;
                if (current.toNext == null) {
                    current.printNodeData();
                }
            }
            System.out.println();
        }
    }

    //Метод удаляющий заданное значение из списка; если значения в списке нет, то ничего происходить не должно.
    public void removeIfHas(T toRemove) {
 
        List<T> list = toCollection();
        list.removeIf(x -> x.equals(toRemove)); 
        Collections.reverse(list);
        erasingList();
        list.forEach(this::addFirst);
    }
    //Метод добавляет все значения заданной коллекции coll в начало списка с сохранением порядка.
    public void mergeCollection(Collection<T> coll) {
        ArrayList<T> list = toCollection();
        list.addAll(0, coll);
        Collections.reverse(list);
        erasingList();
        list.forEach(this::addFirst);
    }
    //Метод добавляет все значения заданной коллекции collection в конец списка с сохранением порядка.
    public void mergeCollectionTail(Collection<T> coll) {
        ArrayList<T> list = toCollection();
        list.addAll(sizeList(), coll);
        Collections.reverse(list);
        erasingList();
        list.forEach(this::addFirst);
    }
    //Метод, при помощи которого текущий список поглощает список listToMerge с добавлением значений в начало первого списка; после поглощения список listToMerge очищается;
    public void mergeLists(ArrayLinkedList <T> listToMerge) {

        mergeCollection(listToMerge.toCollection());
        listToMerge.erasingList();       
    }
    //Метод, при помощи которого текущий список поглощает список listToMerge с добавлением значений в конец первого списка; после поглощения список listToMerge очищается;
    public void mergeListsBack(ArrayLinkedList <T> listToMerge) {
        
        mergeCollectionTail(listToMerge.toCollection());
        listToMerge.erasingList();
    }
     
// вложенный класс Node  в сущностях которого хранятся данные и ссылка на следующий узел.
    class Node <T> {

        private T[] data;
        private Node toNext;

        private Node() {
           data = (T[])new Object[5];
        }
        public void printNodeData() {
            System.out.print("[");
            for(int i = 0; i < 5; i++)
                if(data[i] != null)
                System.out.print(i != 4? data[i] + "," : data[i]);
            System.out.print("]");
        }
        public List<T> toList() {
            List<T> list = Arrays.asList(data);
           return list;
        }
    }    
}
