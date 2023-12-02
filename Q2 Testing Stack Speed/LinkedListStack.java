//Creating a LinkedList Stack
public class LinkedListStack {
    //Creating a node and what data a node will take in
    class Node {
        int data; 
        Node next;
    
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node top; //creating a top node that will keep track of what's on top



    //Creating a constructor with top being set to null.
    public LinkedListStack() {
        this.top = null;
    }



    //this method will push given data into the linked list stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top; //newNode.next will point to the top of the next data pushed in
        //the new node pushed on top will be assigned as the new top of the linkedlist
        top = newNode; 
    }



    //This method will remove the top of the list
    public int pop() {
        //if the top is empty, a message will be thrown saying that it's empty.
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }

        int data = top.data; //We'll grab the data that's on top, ready to be popped
        top = top.next; //top.next will assign the next new Top below it and remove the old top
        return data; //returning the data of the old top that was removed
    }



    //A method to check if the stack is empty by checking if the top is set to null
    public boolean isEmpty() {
        return top == null;
    }


    
    //A method if we want to see what's on the top and its data.
    public int peek() {
        //If the top is null, a message will be sent that the stack is empty.
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data; //returns a preview of what the Top contains.
    }
}



