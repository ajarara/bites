package io.ajarara.tarjan;

import static io.ajarara.tarjan.Tarjan.tarjan;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TarjanTest {

    @Test
    public void complex() {
        final var complex =
                Map.of(1, List.of(2),
                        2, List.of(3),
                        3, List.of(1, 4),
                        4, List.of(5, 4),
                        5, List.of(6),
                        6, List.of(5));

        assertEquals(List.of(Set.of(6, 5),
                        Set.of(4),
                        Set.of(3, 2, 1)),
                tarjan(complex));
    }

    @Test
    public void empty() {
        assertEquals(List.of(), tarjan(Map.of()));
    }

    @Test
    public void longCycle() {
        final var longCycle =
                Map.of(1, List.of(2),
                        2, List.of(3),
                        3, List.of(4),
                        4, List.of(5),
                        5, List.of(6),
                        6, List.of(1));

        assertEquals(List.of(Set.of(6, 5, 4, 3, 2, 1)), tarjan(longCycle));
    }

    @Test
    public void hairline() {
        final var hairline =
                Map.of(1, List.of(2),
                        2, List.of(3),
                        3, List.of(4),
                        4, List.of(5),
                        5, List.of(6),
                        6, List.<Integer>of());

        assertEquals(List.of(Set.of(6), Set.of(5), Set.of(4), Set.of(3), Set.of(2), Set.of(1)),
                tarjan(hairline));

    }


    @Test
    public void outward(){
        final var outward =
                Map.of(1, List.of(2),
                        2, List.of(3, 4),
                        3, List.of(1),
                        4, List.of(5),
                        5, List.of(6),
                        6, List.of(4));
        assertEquals(List.of(Set.of(6, 5, 4), Set.of(1, 2, 3)), tarjan(outward));
    }
}
