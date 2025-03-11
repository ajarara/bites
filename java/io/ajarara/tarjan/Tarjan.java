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
    Map<Integer, List<Integer>> adjacencyMap;
    Integer idx = 0;
    List<Set<Integer>> sccs = new ArrayList<>();
    Map<Integer, Integer> indices = new HashMap<>();
    Map<Integer, Integer> lowlinks = new HashMap<>();
    LinkedHashSet<Integer> stack = new LinkedHashSet<>();

    Tarjan(final Map<Integer, List<Integer>> adjacencyMap) {
        this.adjacencyMap = adjacencyMap;
    }

    // returns a topo sort of strongly connected components given an adjacency list
    private static List<Set<Integer>> tarjan(Map<Integer, List<Integer>> adjacencyMap) {
        final var tarjan = new Tarjan(adjacencyMap);
        for (var vertex : adjacencyMap.keySet()) {
            if (!tarjan.indices.containsKey(vertex)) {
                tarjan.strongConnect(vertex);
            }
        }

        return tarjan.sccs;
    }

    private void strongConnect(final Integer vertex) {
        indices.put(vertex, idx);
        lowlinks.put(vertex, idx);
        idx++;
        stack.add(vertex);

        for (var adjacent : adjacencyMap.get(vertex)) {
            if (!indices.containsKey(adjacent)) {
                strongConnect(adjacent);
            }
            if (stack.contains(adjacent)) {
                lowlinks.put(vertex,
                             Math.min(lowlinks.get(vertex), lowlinks.get(adjacent)));
            }
        }

        if (lowlinks.get(vertex).equals(indices.get(vertex))) {
            final var scc = new HashSet<Integer>();
            var v = stack.removeLast();
            scc.add(v);
            while (v != vertex && !stack.isEmpty()) {
                v = stack.removeLast();
                scc.add(v);
            }
            sccs.add(scc);
        }
    }
                          
    

    public static void main(String[] args) {
        final var adjA = new HashMap<Integer, List<Integer>>();
        adjA.put(1, Arrays.asList(2));
        adjA.put(2, Arrays.asList(3));
        adjA.put(3, Arrays.asList(1, 4));
        adjA.put(4, Arrays.asList(5, 4));  // add a self link after you get it working
        adjA.put(5, Arrays.asList(6));
        adjA.put(6, Arrays.asList(5));
        
        testCase("adjA", tarjan(adjA), Arrays.asList(new HashSet<>(Arrays.asList(6, 5)),
                                                     new HashSet<>(Arrays.asList(4)),
                                                     new HashSet<>(Arrays.asList(3, 2, 1))));

        final var adjB = new HashMap<Integer, List<Integer>>();
        testCase("adjB", tarjan(adjB), new ArrayList<>());

        final var adjC = new HashMap<Integer, List<Integer>>();
        adjC.put(1, Arrays.asList(2));
        adjC.put(2, Arrays.asList(3));
        adjC.put(3, Arrays.asList(4));
        adjC.put(4, Arrays.asList(5));
        adjC.put(5, Arrays.asList(6));
        adjC.put(6, Arrays.asList(1));

        testCase("adjC", tarjan(adjC), Arrays.asList(new HashSet<>(Arrays.asList(6, 5, 4, 3, 2, 1))));
        
    }

    private static <T> void testCase(String name,
                                     List<Set<T>> actual,
                                     List<Set<T>> expected) {
        if (!expected.equals(actual)) {
            System.out.println("Test case " + name + " failed!\nExpected: " + expected + "\nActual: " + actual);
        }
    }
}

