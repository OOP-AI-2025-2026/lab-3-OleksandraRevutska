package org.example.task2;

import java.util.Arrays;

public class Cart {

    private Item[] contents;
    private int index;

    public Cart(int capacity) {
        this.contents = new Item[capacity];
        this.index = 0;
    }

    public void add(Item item) {
        if (this.isFull()) {
            System.out.println("Cart is full. Cannot add item " + item.getName());
            return;
        }
        this.contents[this.index] = item;
        this.index++;
    }

    public void removeById(long itemId) {
        int foundIndex = findItemIndex(itemId);
        if (foundIndex == -1) {
            System.out.println("Item with id " + itemId + " not found in cart.");
            return;
        }
        shiftArray(foundIndex);
    }

    private int findItemIndex(long itemId) {
        for (int i = 0; i < this.index; i++) {
            if (this.contents[i].getId() == itemId) {
                return i;
            }
        }
        return -1;
    }

    private void shiftArray(int startIndex) {
        for (int i = startIndex; i < this.index - 1; i++) {
            this.contents[i] = this.contents[i + 1];
        }
        this.contents[this.index - 1] = null;
        this.index--;
    }

    public boolean isFull() {
        return this.index == this.contents.length;
    }

    public Item[] getContents() {
        // Повертаємо копію масиву до поточної кількості елементів
        return Arrays.copyOf(this.contents, this.index);
    }

    public int getItemCount() {
        return this.index;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "contents=" + Arrays.toString(getContents()) +
                '}';
    }
}

