package io.ajarara.utils;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Lists {

    private Lists() {
        throw new RuntimeException("no instances allowed!");
    }

    public static <E> List<E> from(Iterator<E> iterator) {
        final var out = new ArrayList<E>();
        while(iterator.hasNext()) {
            var next = iterator.next();
            if (next == null) {
                throw new NullPointerException();
            }
            out.add(next);
        }
        return out;
    }

}
