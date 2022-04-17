package Dev_J110;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
/*
       Развернутый односвязный список ArrayLinkedList <T> может хранить различные типы
    данных. В каждом узле списка для хранения данных используется массив, имеющий длину 5.
       Для опытов создано три списка:
     - stringList - список с типом данных "String";
     - intList - список с типом данных "Integer";
     - dateList - список с типом данных "LocalDate". 
       Списки заполнены из трех массивов с соответствующими типами данных: 
        - String[] stringData;
        - Integer[] intData;
        - LocalDate[] localDates;        
*/
        
        String[] stringData = new String[]{"мышь", "крот", "собака", "бык", "овца", "козел", "гусь", "утка"}; 
        Integer[] intData = new Integer[]{100, 200, 300, 400, 500, 600};
        LocalDate[] localDates = new LocalDate[]{LocalDate.MAX, LocalDate.MIN, 
                                     LocalDate.of(1970, Month.DECEMBER, 21), LocalDate.of(1976, Month.FEBRUARY, 10), 
                                     LocalDate.of(2005, Month.OCTOBER, 18), LocalDate.now()};
        
        ArrayLinkedList <String> stringList = new ArrayLinkedList<>();
        stringList.addFromArray(stringData); 
        
        ArrayLinkedList <Integer> intList = new ArrayLinkedList<>();
        intList.addFromArray(intData);
               
        ArrayLinkedList <LocalDate> dateList = new ArrayLinkedList<>();
        dateList.addFromArray(localDates);
    
        /* метод printAll() выводит содержимое всех трех списков в консоль. Для наглядности 
        данные, содержащиеся в разных узлах списка, отделены друг от друга квадратными скобками.
         Пустые, незаполненные данными, элементы массива первых узлов списка, методом printAll()
        игнорируются и в консоль не выводятся. */
        stringList.printAll();
        intList.printAll();
        dateList.printAll();
        System.out.println();
        
        String[] stringNewData = new String[]{"крыса", "жук", "кот", "петух", "заяц", "кролик"};
        ArrayLinkedList<String> newMyList = new ArrayLinkedList<>();
        newMyList.addFromArray(stringNewData); 
        //Integer[] intData1 = new Integer[]{-100, -200, -300, -400, -500, -600};
        newMyList.printAll();
        
        stringList.mergeListsBack(newMyList);  
        stringList.printAll();
        newMyList.printAll();
        
        
        
/* Список доступных методов:
        - Метод addFirst(T dat) добавляет значения в начало списка;
        - Метод addFromArray(T[] dat) добавляет все значения заданного массива в начало списка с сохранением порядка;
        - Метод T extractFirst() извлекает и возвращает значение из начала списка без его удаления из списка;
        - Метод T extractFirstAndRemove() извлекает и возвращает значение из начала списка с удалением его из списка;
        - Метод addToTail(T data) добавляет значение в конец списка;
        - Метод T extractTailData() извлекает и возвращает значение из конца списка без его удаления;
        - Метод T extractTailAndRemove() извлекает и возвращает значение из конца списка с удалением его из списка;
        - Метод void addFromArrayTail(T[] dat) добавляет все значения заданного массива в конец списка с сохранением порядка;
        - Метод boolean isInList(T toEquals) определяет, содержит ли список переданное в метод значение toEquals, или нет. 
          Возвращает true, если содержит и false, если такого значение в списке нет;
        - Метод boolean isEmpty(), определяет, является ли список пустым, или нет. 
          Возвращает true, если список пустой и false, если не пустой;
        - Метод printAll() - осуществляет печать всех значений списка от первого элемента к последнему; 
          Если список пустой, выводит сообщение "Элементы списка отсутствуют, список пустой.";
        - *Метод removeIfHas(T toRemove) удаляет из списка, переданное в метод значение toRemove. 
          Если значения в списке нет, то ничего не происходит; 
        - Метод mergeLists(ArrayLinkedList <T> listToMerge). Список поглощает список listToMerge с добавлением значений в начало первого списка; после поглощения список listToMerge очищается;
        - Метод mergeListsBack(ArrayLinkedList <T> listToMerge). Список поглощает список listToMerge с добавлением значений в конец первого списка; после поглощения список listToMerge очищается;
        - Метод mergeCollection(Collection<T> coll) добавляет все значения заданной коллекции coll в начало списка с сохранением порядка.
          Коллекция — любой объект, реализующий интерфейс java.lang.Iterable;
        - Метод mergeCollectionTail(Collection<T> coll) добавляет все значения заданной коллекции collection в конец списка с сохранением порядка.
          Коллекция — любой объект, реализующий интерфейс java.lang.Iterable;
*/               
    }
}
