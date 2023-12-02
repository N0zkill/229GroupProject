//Performing Testing
public class StackPerformanceTest {
    public static void main(String[] args) {
        // 1,000,000 operations that we will be dealing with
        int operations = 1000000; 
        
        //Creating two types of stacks with an Array and LinkedList
        //Array Stack will be a generic class and will take in the amount of operations to be done

        //linkedListStack will not be a generic class
        ArrayStack<Integer> arrayStack = new ArrayStack<>(operations);
        LinkedListStack linkedListStack = new LinkedListStack();

        //Since we're dealing with huge numbers, we will be using *Long* variables
        //When the operations start, startingTimer will initiate the beginning timer until the end of the operation
        
        //EndingTimer will grab the intial timer and will be used to substract (endingTimer - startingTimer).
        //This way we will be able to test the speed it took to complete the whole operations.
        //All of this will be in nanoseconds to calculate the operations
        long startingTimer; 
        long endingTimer;


        
        // Testing ArrayStack
        startingTimer = System.nanoTime();

        //We will be pushing each operations into the array stack.
        for (int i = 0; i < operations; i++) {
            arrayStack.push(i);
        }

        //Once we pushed each operation into the stack, we will remove each operation.
        for (int i = 0; i < operations; i++) {
            arrayStack.pop();
        }

        endingTimer = System.nanoTime();

        //Once we have both startingTimer and endingTimer, we will subtract (endingTimer - startingTimer)
        //to calculate how long the operation took.
        System.out.println("ArrayStack Time: " + (endingTimer - startingTimer) + " ns");




        // Testing LinkedListStack
        startingTimer = System.nanoTime(); //startingTimer will begin the timer in nanoseconds

        //Pushing each operation into the LinkedList Stack
        for (int i = 0; i < operations; i++) {
            linkedListStack.push(i);
        }

        //Removing each operation out of the LinkedList Stack
        for (int i = 0; i < operations; i++) {
            linkedListStack.pop();
        }
        endingTimer = System.nanoTime(); //Grabbing the final time

        
        //subtracting (endingTimer - startingTimer) to calculate how long the operation took.
        System.out.println("LinkedListStack Time: " + (endingTimer - startingTimer) + " ns");
        
        //Overall, Array Stack is faster than a LinkedList Stack
    }
}
