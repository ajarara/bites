package io.ajarara.tarjan;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;

class Tarjan {

    public static void main(String[] args) {
        final Map<Integer, List<Integer>> adjA = new HashMap<Integer, List<Integer>>();
        adjA.put(1, Arrays.asList(2));
        
        testCase("adjA", tarjan(adjA), Arrays.asList(new HashSet<>()));
        
    }

    private static <T> void testCase(String name,
                                     List<Set<T>> expected,
                                     List<Set<T>> actual) {
        if (!expected.equals(actual)) {
            System.out.println("Test case " + name + " failed!\nExpected: " + expected + "\nActual: " + actual);
        }
    }

    // returns a topo sort of strongly connected components given an adjacency list
    private static List<Set<Integer>> tarjan(Map<Integer, List<Integer>> adjacencyMap) {
        return new ArrayList<>();
    }

    // returns an integer index that should be used for recursive calls, otherwise mutates the lowlink, index mappings, and the stack
    private static int strongConnect(Integer vertex, 
                                     Map<Integer, List<Integer>> adjacencyMap,
                                     Map<Integer, Integer> indices,
                                     Map<Integer, Integer> lowlinks,
                                     LinkedHashSet<Integer> stack) {
        return 0;

    }
}
