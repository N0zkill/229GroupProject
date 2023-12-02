//we will be using a generic class
public class ArrayStack<E> {
    private E[] array;
    private int top;

    //For ArrayStack, the capacity will take in the amount of operations to be done
    public ArrayStack(int capacity) {
        array = (E[]) new Object[capacity];
        top = -1; //top will be set to empty by using "-1" as an indicator
    }


    
    //This method will push each operation into the Stack Array
    public void push(E item) {
        //if stack is full, a message will show that states "Stack is full".
        if (top == array.length - 1) {
            throw new IllegalStateException("Stack is full");
        }
        array[++top] = item; //If the stack isn't full, it will add onto the stack.
    }



    //This method will remove each operation out of the stack array
    public E pop() {
        //if stack is empty, a message will be thrown saying that "Stack is empty".
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        //if the stack isn't empty, it will remove the top.
        return array[top--];
    }

    //If the stack is empty , it will return a -1
    public boolean isEmpty() {
        return top == -1;
    }
}
