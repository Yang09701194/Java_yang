package DS;

import java.util.*;

//https://www.geeksforgeeks.org/priority-queue-class-in-java-2/

//就是 MinHeap   最小值會一直維持在最頂端
//Some member functions of priority queues are:
//empty(): Returns true if the priority queue is empty and false if the priority queue has at least one element. Its time complexity is O(1).
//pop(): Removes the largest element from the priority queue. Its time complexity is O(logN) where N is the size of the priority queue.
//push(): Inserts a new element in the priority queue. Its time complexity is O(logN) where N is the size of the priority queue.
//size(): Returns the number of element in the priority queue. Its time complexity is O(1).
//top(): Returns a reference to the largest element in the priority queue. Its time complexity is O(1).
public class PriorityQueueExample {

    // Main Method
    public static void main(String args[])
    {
        // Creating empty priority queue
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(9);
        pQueue.add(18);
        pQueue.add(15);
        pQueue.add(21);

        // Printing the top element of PriorityQueue
        System.out.println(pQueue.peek());

        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(pQueue.poll());

        // Printing the top element again
        System.out.println(pQueue.peek());
    }


}
