package io.ajarara.utils;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ListsTest {

    @Test
    public void testFromIterator() {
        List<Integer> expected = Arrays.asList(1, 2, 3);
        ArrayList<Integer> arrayList = new ArrayList<>(expected);

        List<Integer> actual = Lists.from(arrayList.iterator());

        assertEquals(expected, actual);


    }

    @Test
    public void testFromIterator_empty() {

        ArrayList<Integer> arrayList = new ArrayList<>();

        List<Integer> actual = Lists.from(arrayList.iterator());

        assertTrue(actual.isEmpty());
    }


    @Test
    public void testFromIterator_withNullElement(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(null);
        arrayList.add(2);
        assertThrows(NullPointerException.class, () -> Lists.from(arrayList.iterator()));
    }
}
