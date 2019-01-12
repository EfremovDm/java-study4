package ru.efremovdm.lesson4;

class LinkedList{
    private Link first;


    LinkedList(){
        first = null;

    }

    Link getFirst() {
        return first;
    }

    void setFirst(Link first) {
        this.first = first;
    }

    LinkInterator getIterator(){
        return new LinkInterator(this);
    }

    boolean isEmpty(){
        return (first == null);
    }

    void display(){
        Link current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }
}

