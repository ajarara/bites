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

    private Tarjan() {
        throw new RuntimeException();
    }

    // returns a topo sort of strongly connected components given an adjacency list
    public static List<Set<Integer>> tarjan(Map<Integer, List<Integer>> adjacencyMap) {
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
}

