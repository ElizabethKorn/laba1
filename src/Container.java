import java.util.Objects;

/**
 * Класс, который представляет собой контейнер для хранения объектов
 * @param <T> - тип элемнтов, которые будут храниться в контейнере
 */
public class Container<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data=data;
        }
    }

    /**
     * Метод, который возвращает текующий размер контейнера
     * @return текущий размер контейнера
     */
    public int size() {
        return size;
    }

    /**
     * Метод добавления элемента в контейнер
     * @param element - злемент, который нужно добавить
     */
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head==null)
            head=newNode;
        else {
            Node<T> temp=head;
            while (temp.next!=null)
                temp=temp.next;
            temp.next=newNode;
        }
        size++;
    }

    /**
     * Метод, возвращающий элемент по данному индексу
     * @param index - индекс эелемента
     * @return элемент по указанному индексу
     */
    public T get(int index) {
        if (index<0 || index>=size)
            System.out.println("Index out of bounds: " + index);

        Node<T> current=head;
        for (int i=0; i<index; i++)
            current=current.next;
        return current.data;
    }

    /**
     * Метод, удаляющий элемент по указанному индексу и возврвщвющий его значение
     * @param index - ндекс элемента, который нужно удалить
     * @return значение удалённого элемента
     */
    public T remove(int index) {
        if (index<0 || index>=size)
            System.out.println("Index out of bounds: " + index);

        T removedData;
        if (index==0) {
            removedData = head.data;
            head = head.next;
        }
            else {
               Node<T> previous=head;
               for (int i=0;i<index-1;i++)
                   previous=previous.next;
               removedData=previous.next.data;
               previous.next=previous.next.next;
        }
            size--;
            return removedData;
    }

    /**
     * Переопределение метода toString() для представления объекта в виде строки
     * @return Строковое представления объекта в виде "el, el2, ..."
     */
    @Override
    public String toString() {
        StringBuilder result=new StringBuilder();
        Node<T> current=head;
        while (current!=null) {
            result.append(current.data);
            if (current.next!=null)
              result.append(", ");
            current=current.next;
        }
        return result.toString();
    }

    /**
     * Переопределение метода equals() для сравнения объектов Container
     * Два эл-та считаются равными, если они имеют одинаковый размер и содержат элементы, равные по содержимому и расположенные в том же порядке
     * @param obj - Объект для сравнения
     * @return true, если объекты равны, false - иначе
     */
    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (obj==null || getClass()!=obj.getClass()) return false;

        Container<String> otherContainer=(Container<String>)  obj;
        if (size!=otherContainer.size) return false;

        Node<T> currentThis=head;
        Node<String> currentOther=otherContainer.head;

        while (currentThis!=null) {
            if (!Objects.equals(currentThis.data, currentOther.data))  return false;
            currentThis=currentThis.next;
            currentOther=currentOther.next;
        }
        return true;
    }

    /**
     * Переопределение метода hashCode() для вычисления хэш-кода объекта Container
     * @return Хэш-код объекта
     */
    @Override
    public int hashCode() {
        int hash=Objects.hash(size);
        Node<T> current = head;
        while (current!=null) {
            hash=11*hash+Objects.hashCode(current.data);
            current=current.next;
        }
        return hash;
    }

}
