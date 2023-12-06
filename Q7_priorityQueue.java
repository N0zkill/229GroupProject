import java.util.LinkedList;



    //recursive structure for clients
class Client {
    String name;
    int priority;

    public Client(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}



class OrderProcessingSystem {
    LinkedList<Client> orderList;
    //list for all the orders
    public OrderProcessingSystem() {
        orderList = new LinkedList<>();
    }
    //adding client to list and there priority level
    public void placeOrder(Client client) {
        orderList.add(client);
        System.out.println(client.name + " placed an order with priority " + client.priority);
    }
    //final processing of the order and ends if there is no order
    public void processOrders() {
        while (!orderList.isEmpty()) {
        Client currentOrder = getOrderWithHighestPriority();
        orderList.remove(currentOrder);
        System.out.println("Processing order for " + currentOrder.name + " with priority " + currentOrder.priority);
        }
    }
    
    
    
    
    
    // comparing the priority levels of each client
    private Client getOrderWithHighestPriority() {
        Client highestPriorityOrder = null;
        int maxPriority = Integer.MAX_VALUE;

        for (Client order : orderList) {
            if (order.priority < maxPriority) {
            maxPriority = order.priority;
            highestPriorityOrder = order;
            }
        }

        return highestPriorityOrder;
    }
}






public class OrderProcessingSimulation {
    public static void main(String[] args) {
        OrderProcessingSystem processingSystem = new OrderProcessingSystem();

        // Simulate random orders with different priorities
        processingSystem.placeOrder(new Client("Client1", 3));
        processingSystem.placeOrder(new Client("Client2", 2));
        processingSystem.placeOrder(new Client("Client3", 1));
        processingSystem.placeOrder(new Client("Client4", 3));
        processingSystem.placeOrder(new Client("Client5", 2));
        processingSystem.placeOrder(new Client("Client6", 1));
        processingSystem.placeOrder(new Client("Client7", 0));
        // Start processing orders
        processingSystem.processOrders();
    }
}


