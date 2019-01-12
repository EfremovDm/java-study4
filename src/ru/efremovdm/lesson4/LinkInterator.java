package ru.efremovdm.lesson4;

class LinkInterator{
    private Link current;
    private Link previous;
    private LinkedList list;

    LinkInterator(LinkedList list){
        this.list = list;
        current = null;
        previous = null;
        this.reset();
    }

    void reset(){
        current = list.getFirst();
        previous = null;
    }

    boolean atEnd(){
        return (current.next == null);
    }

    void nextLink(){
        previous = current;
        current = current.next;
    }

    Link getCurrent(){
        return current;
    }

    void insertAfter(String name, int age){
        Link newLink = new Link(name, age);
        if (list.isEmpty()){
            list.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    void insertBefore(String name, int age){
        Link newLink = new Link(name, age);
        if(previous == null){
            newLink.next = list.getFirst();
            list.setFirst(newLink);
            reset();
        }
        else{
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    String deleteCurrent(){
        String name = current.name;
        if (previous == null){
            list.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()){
                reset();
            } else {
                current = current.next;
            }
        }

        return name;
    }

}