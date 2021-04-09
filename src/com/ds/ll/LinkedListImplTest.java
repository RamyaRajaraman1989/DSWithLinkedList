package com.ds.ll;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class LinkedListImplTest {

    @Test
     public void searchTest() {
        LinkedListImpl linkList= new LinkedListImpl();
        LinkedListImpl.append(linkList,56);
        LinkedListImpl.append(linkList,30);
        LinkedListImpl.append(linkList,70);
        Node returnedNode=LinkedListImpl.search(linkList,30);
        if(returnedNode==null){
            System.out.println("No node found");
        }
        else{
            System.out.println("Node found with data ::"+ returnedNode.data);
            Assertions.assertEquals(30,returnedNode.data);
        }

        returnedNode=LinkedListImpl.search(linkList,90);
        Assertions.assertFalse(90==returnedNode.data);
    }

    @Test
    public void insertNodeTest(){

        LinkedListImpl linkList= new LinkedListImpl();
        LinkedListImpl.append(linkList,56);
        LinkedListImpl.append(linkList,30);
        LinkedListImpl.append(linkList,70);
        System.out.println("Before insert");
        LinkedListImpl.print(linkList);
        LinkedListImpl.insert(linkList,30,40);
        System.out.println("After insert");
        LinkedListImpl.print(linkList);
    }

    @Test
    public void deleteNodeTest(){
        LinkedListImpl linkList= new LinkedListImpl();
        LinkedListImpl.append(linkList,56);
        LinkedListImpl.append(linkList,30);
        LinkedListImpl.append(linkList,40);
        LinkedListImpl.append(linkList,70);
        System.out.println("Before delete");
        LinkedListImpl.print(linkList);
        LinkedListImpl.deleteNode(linkList,40);
        System.out.println("After delete");
        LinkedListImpl.print(linkList);
    }

    @Test
    public void sortedListTest(){
        LinkedListImpl linkList= new LinkedListImpl();
        LinkedListImpl.createSortedList(linkList,56);
        LinkedListImpl.print(linkList);
        LinkedListImpl.createSortedList(linkList,30);
        LinkedListImpl.print(linkList);
        LinkedListImpl.createSortedList(linkList,40);
        LinkedListImpl.print(linkList);
        LinkedListImpl.createSortedList(linkList,70);
        LinkedListImpl.print(linkList);
    }
}