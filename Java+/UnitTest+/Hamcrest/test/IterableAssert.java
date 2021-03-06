import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.emptyIterableOf;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

/**
 * Проверка объектов, реализующих Iterable.
 */
public class IterableAssert {

    @Test
    public void hasSizeTest() {
        final Iterable<String> iter = asList("Piter_", "SPB_", "Leningrad_", "Saint-Petersburg_");
        assertThat(iter, hasItem("SPB_"));
        assertThat(iter, hasItems("SPB_", "Leningrad_"));
        assertThat(iter, everyItem(endsWith("_")));
        assertThat(iter, contains("Piter_", "SPB_", "Leningrad_", "Saint-Petersburg_"));//все элементы
        assertThat(iter, containsInAnyOrder("Saint-Petersburg_", "Piter_", "SPB_", "Leningrad_"));//все элементы
        assertThat(new ArrayList<>(), emptyIterable());
        assertThat(new ArrayList<Random>(), emptyIterableOf(Random.class));
    }
}