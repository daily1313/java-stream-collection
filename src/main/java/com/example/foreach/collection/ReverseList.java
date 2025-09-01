package com.example.foreach.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReverseList extends ArrayList<String> {

    @Override
    public Iterator<String> iterator() {

        int startIndex = this.size() - 1;
        List<String> list = this;

        Iterator<String> it = new Iterator<String>() {

            private int currentIndex = startIndex;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0;
            }

            @Override
            public String next() {
                String next = list.get(currentIndex);
                currentIndex--;
                return next;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
