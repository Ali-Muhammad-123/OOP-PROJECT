package LinkedList;

import Classes.Person;

import java.io.Serializable;

public class SinglyList<T> implements Serializable {
    Node<T> first;



    public boolean isEmpty(){
        return first ==null;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void sortList(){
        Person temp1,temp2;
        Node<T> node ,node2, tempnode  ;

        node2 = first;

        while (node2.next != null){
            node = first;
        while (node.next != null) {
            temp1 = (Person)node.getData();
            temp2 = (Person)node.next.getData();
            if (temp1.getID() > temp2.getID()){
                node.data = node.next.data;
                node.next.data = (T)temp1;
            }
            node = node.next;
        }
        node2 =node2.next;}

    }
    public void insertFirst(T Object1){
        Node<T> newNode = new Node<T>();
        newNode.next = first;
        newNode.data = Object1;
        first = newNode;
    }
    void DeleteLast(){
        Node<T> node = first;
        while (node.next!=null){
            node = node.next;
        }
        node = null;
    }

    public int listLength(){
        int count = 0;
        Node<T> node = first;
        while (node !=null){
            node = node.next;
            count++;
        }
        return count;
    }

    void PrintList(){
        Node<T> node = first;
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }

    public void Delete(int ID){
        Node<T> node = first;
        Person person = (Person)node.getData();
        if (person.getID() == ID){
            first = node.next;
        }
        else {
        while (node.next != null){
            person= (Person)node.next.getData();
            if (person.getID() == ID){
                System.out.println(person.getID());
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        }
        PrintList();
    }



    void InsertAtMiddle(T Object1){
        Node<T> node = first;
        Node<T> newnode =new Node<T>();
        newnode.data = Object1;

        if (listLength() % 2 == 0){
            for (int i= 0; i < (listLength() /2) -1; i++){
                node = node.next;
            }
            newnode.next = node.next;
            node.next = newnode;
        }
        else {
            for (int i= 0; i < Math.round(listLength() /2)-1 ; i++){
                node = node.next;
            }
            newnode.next = node.next;
            node.next = newnode;
        } node.next = newnode;
    }

}