/*
Name: Marc Chan
Date: 02/05/2024
Class: CSCI 271 - Data Structures
Instructor: Dr. Jeff Gao
Pledge: I, Marc Chan, did not receive any inappropriate help for this programming assignment. This code is derived from
the example given in class.
 */

public class Bag {
    private int[] data;
    private int top;

    public Bag() {
        this(1);
    }
    public Bag(int n) {
        top = 0;
        data = new int[n];
    }
    private boolean isFull() {
        return top == data.length;
    }
    private void resize() {
        int[] temp = new int[2 * data.length];
        for (int i = 0; i < top; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
    public void insert(int entry) {
        if (isFull()) {
            resize();
        }
        data[top++] = entry;
    }
    public void remove(int target) {
        int index = 0;
        while (index < top && data[index] != target) {
            index++;
        }
        if (index < top) {
            data[index] = data[--top];
        }
    }
    public int occurrence(int target) {
        int occurrence = 0;
        for (int i = 0; i < top; i++) {
            if (data[i] == target) {
                occurrence++;
            }
        }
        return occurrence;
    }
    public int size() {
        return top;
    }
}
