package chapter9;

import java.util.ArrayList;

public class SortedArrayListPriorityQueue<T> implements PriorityQueue<T> {

    private static class Entry<T> implements Comparable<Entry<T>> {
        final int priority;
        final T data;
        Entry(int priority, T data) {
            this.priority = priority;
            this.data = data;
        }

        @Override
        public int compareTo(Entry<T> o) {
            return o.priority - this.priority;
        }
    }

    private final ArrayList<Entry<T>> list;

    public SortedArrayListPriorityQueue() {
        list = new ArrayList<>();
    }

    @Override
    public void enqueue(int priority, T data) {
        Entry<T> newEntry = new Entry<>(priority, data);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).priority <= priority) {
                list.add(i, newEntry);
                return;
            }
        }
        list.add(newEntry);
    }

    @Override
    public T dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("PriorityQueue is empty");
        }
        return list.remove(list.size() - 1).data;
    }

    @Override
    public T front() throws Exception {
        if (isEmpty()) {
            throw new Exception("PriorityQueue is empty");
        }
        return list.get(list.size() - 1).data;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
