package io.ajarara.tarjan;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.function.Consumer;

class Tarjan {

    // returns a topo sort of strongly connected components given an adjacency list
    private static List<Set<Integer>> tarjan(Map<Integer, List<Integer>> adjacencyMap) {
        final var sccs = new ArrayList<Set<Integer>>();
        final var indices = new HashMap<Integer, Integer>();
        final var lowlinks = new HashMap<Integer, Integer>();
        final var stack = new LinkedHashSet<Integer>();

        final var strongConnect = new Consumer<Integer>() {
                private Integer idx = 0;

                public void accept(Integer vertex) {
                    indices.put(vertex, idx);
                    lowlinks.put(vertex, idx);
                    idx++;
                    stack.add(vertex);

                    for (var adjacent : adjacencyMap.get(vertex)) {
                        if (!indices.containsKey(adjacent)) {
                            accept(adjacent);
                        }
                        // where we significantly deviate from the published algo:
                        // the wiki algo updates lowlinks unconditionally after the recursion
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
        };

        for (var vertex : adjacencyMap.keySet()) {
            if (!indices.containsKey(vertex)) {
                strongConnect.accept(vertex);
            }
        }

        return sccs;
    }


    public static void main(String[] args) {
        final var complex =
            Map.of(1, List.of(2),
                   2, List.of(3),
                   3, List.of(1, 4),
                   4, List.of(5, 4),
                   5, List.of(6),
                   6, List.of(5));

        testCase("complex", tarjan(complex),
                 List.of(Set.of(6, 5),
                         Set.of(4),
                         Set.of(3, 2, 1)));


        testCase("empty", tarjan(Map.of()), List.of());

        final var longCycle =
            Map.of(1, List.of(2),
                   2, List.of(3),
                   3, List.of(4),
                   4, List.of(5),
                   5, List.of(6),
                   6, List.of(1));

        testCase("longCycle", tarjan(longCycle), List.of(Set.of(6, 5, 4, 3, 2, 1)));

        final var hairline =
            Map.of(1, List.of(2),
                   2, List.of(3),
                   3, List.of(4),
                   4, List.of(5),
                   5, List.of(6),
                   6, new ArrayList<Integer>());

        testCase("hairline", tarjan(hairline), List.of(Set.of(6), Set.of(5), Set.of(4), Set.of(3), Set.of(2), Set.of(1)));

        final var outward =
            Map.of(1, List.of(2),
                   2, List.of(3, 4),
                   3, List.of(1),
                   4, List.of(5),
                   5, List.of(6),
                   6, List.of(4));

        testCase("outward", tarjan(outward), List.of(Set.of(6, 5, 4), Set.of(1, 2, 3)));
    }

    private static <T> void testCase(String name,
                                     List<Set<T>> actual,
                                     List<Set<T>> expected) {
        if (!expected.equals(actual)) {
            System.out.println("Test case " + name + " failed!\nExpected: " + expected + "\nActual: " + actual);
        }
    }
}

