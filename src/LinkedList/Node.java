package LinkedList;

import java.io.Serializable;

public class Node<T> implements Serializable {
    T data;
    public Node<T> next = null;

    public void setData(T data) {
        this.data = data;
    }


    public T getData() {
        return data;
    }

}
