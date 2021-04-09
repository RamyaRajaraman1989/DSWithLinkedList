package com.ds.ll;

public class LinkedListImpl {

    Node head;

    //Normal add , adds to the start of the list
    public static LinkedListImpl add(LinkedListImpl linkedList,int data){
        Node newLLNode= new Node(data);
        newLLNode.next=null;

        if(linkedList.head==null){
            linkedList.head=newLLNode;
        }else{
            Node head= linkedList.head;
            newLLNode.next=head;
            linkedList.head=newLLNode;
        }
        return linkedList;
    }


    // Normal append to the end of the list
    public static LinkedListImpl append(LinkedListImpl linkedList,int data){
        Node newLLNode= new Node(data);
        newLLNode.next=null;

        if(linkedList.head==null){
            linkedList.head=newLLNode;
        }else{
            Node last= linkedList.head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=newLLNode;
        }
        return linkedList;
    }

    public static void insert(LinkedListImpl linkedList, int currNodeDate, int newData) {
        Node headNode = linkedList.head;

        //Create a new node
        Node newLLNode = new Node(newData);
        newLLNode.next = null;

        if (headNode.data == currNodeDate) {
            if (headNode.next == null) {
                headNode.next = newLLNode;
                return;
            }
            else{
                Node headNextNode = headNode.next;
                headNode.next = newLLNode;
                newLLNode.next = headNextNode;
                return;
            }
        } else {
                while (headNode.next!=null){
                    headNode=headNode.next;
                    if (headNode.data == currNodeDate) {
                        Node headNextNode = headNode.next;
                        headNode.next = newLLNode;
                        newLLNode.next = headNextNode;
                        return;
                    }
                }
            System.out.println("No matching node found for insertion");
        }

    }

    public static Node search(LinkedListImpl linkedList,int data){
        Node headNode=linkedList.head;
        if(headNode.data==data)
            return headNode;
        else{
            while(headNode.next!=null){
                if(headNode.data==data)
                    return headNode;
                else
                    headNode=headNode.next;
            }
        }
        return headNode;
    }

    public static void deleteNode(LinkedListImpl linkedList,int dataToBeDeleted){

        Node headNode=linkedList.head;
        if(headNode.data==dataToBeDeleted){
            linkedList.head=headNode.next;
        }
        else{
            Node currNode=headNode;
            while(headNode.next!=null){
                if(headNode.next.data==dataToBeDeleted){
                    Node dataNode=headNode.next;
                    headNode.next=dataNode.next;
                }
                else {
                    currNode=headNode;
                    headNode = headNode.next;
                }
            }
        }
    }

    public static void pop(LinkedListImpl linkedList){
        Node headNode=linkedList.head;
        Node headNextNode=headNode.next;
        linkedList.head=headNextNode;
    }

    public static void popLast(LinkedListImpl linkedList){
        Node headNode=linkedList.head;
        Node secondLastNode=headNode;


        while (headNode.next!=null) {
            secondLastNode=headNode;
            headNode = headNode.next;
        }
        secondLastNode.next=null;
    }

    public static void print(LinkedListImpl linkedList){

        Node currentNode=linkedList.head;

        System.out.println("LinkedList values are :");
        while(currentNode!=null){
            System.out.print(currentNode.data + " ");
            currentNode=currentNode.next;
        }
        System.out.println("");
    }

    public static void createSortedList(LinkedListImpl linkedList, int data){
        Node newLLNode= new Node(data);
        newLLNode.next=null;

        if(linkedList.head==null){
            linkedList.head=newLLNode;
        }else{
            Node head= linkedList.head;
            Node currNode=head;

            while(head.next!=null){
                if(head.next.data>data){
                    Node dataNode=head.next;
                    head.next=newLLNode;
                    newLLNode.next=dataNode;
                    return;
                }
                else {
                    currNode=head;
                    head = head.next;
                }
            }
            if(head.next==null){
                if(head.data<data){
                    head.next=newLLNode;
                }
                else {
                    newLLNode.next = head;
                    linkedList.head = newLLNode;
                }
            }
        }

    }


    public static void push(LinkedListImpl linkedList, int data) {
        linkedList.add(linkedList,data);
    }

    public static void peek(LinkedListImpl linkedList, int data){
        System.out.println("Peek "+ linkedList.head.data);
    }

    public static void popStack(LinkedListImpl linkedList){
        System.out.println("Pop "+ linkedList.head.data);
        Node nextHead=linkedList.head.next;
        linkedList.head=nextHead;
    }

    public static void enqueue(LinkedListImpl linkedList,int data){
        append(linkedList,data);
    }

    public static void dequeue(LinkedListImpl linkedList){
        System.out.println("Dequeued element "+ linkedList.head.data);
        Node nextHead=linkedList.head.next;
        linkedList.head=nextHead;
    }

    public static void main(String[] args) {
        System.out.println("***********UC 1 and UC3 ***********");
        LinkedListImpl linkList= new LinkedListImpl();
        append(linkList,56);
        append(linkList,30);
        append(linkList,70);

        print(linkList);

        System.out.println("***********UC 2 ***********");
        linkList= new LinkedListImpl();
        add(linkList,70);
        add(linkList,30);
        add(linkList,56);

        print(linkList);

        System.out.println("***********UC 4 ***********");
        linkList= new LinkedListImpl();
        append(linkList,56);
        append(linkList,70);
        System.out.println("Before insert");
        print(linkList);
        insert(linkList,56,30);
        System.out.println("After insert");
        print(linkList);

        System.out.println("***********UC 5 ***********");
        pop(linkList);
        print(linkList);

        System.out.println("***********UC 6 ***********");
        linkList= new LinkedListImpl();
        append(linkList,56);
        append(linkList,30);
        append(linkList,70);
        popLast(linkList);
        print(linkList);


        System.out.println("*****Stack Implementation****");
        linkList=new LinkedListImpl();
        push(linkList,70);
        push(linkList,30);
        push(linkList,56);
        print(linkList);

        System.out.println("***Stack pop*****");
        popStack(linkList);
        print(linkList);

        System.out.println("****Enqueue***");
        linkList=new LinkedListImpl();
        enqueue(linkList,56);
        enqueue(linkList,30);
        enqueue(linkList,70);
        print(linkList);

        dequeue(linkList);
        System.out.println("****Linked list after dequeue***");
        print(linkList);
    }


}
