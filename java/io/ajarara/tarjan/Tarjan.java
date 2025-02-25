package io.ajarara.tarjan;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Tarjan {

    public static void main(String[] args) {
        final Map<Integer, List<Integer>> adjA = new HashMap<>();
        
        testCase(tarjan(adjA), new ArrayList<Set<Integer>>());
        
    }

    private static <T> void testCase(
                                     List<Set<T>> expected,
                                     List<Set<T>> actual) {
        if (!expected.equals(actual)) {
            System.out.println(""
        }
    }

    // returns a topo sort of strongly connected components given an adjacency list
    private static List<Set<Integer>> tarjan() {
        return new ArrayList<>();
    }
}
