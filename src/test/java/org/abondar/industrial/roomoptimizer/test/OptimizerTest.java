package org.abondar.industrial.roomoptimizer.test;

import org.abondar.industrial.roomoptimizer.Optimizer;
import org.abondar.industrial.roomoptimizer.model.Allocation;
import org.abondar.industrial.roomoptimizer.model.Resource;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptimizerTest {

    private Optimizer optimizer = new Optimizer();

    @Test
    public void optmizerTooBigStructTest() {

        Resource res = new Resource(Arrays.asList(new Integer[120]), 14, 6);
        List<Allocation> alloc = optimizer.optimize(res);

        assertEquals(0, alloc.size());

    }

    @Test
    public void optmizerTooManyRoomsTest() {

        Resource res = new Resource(Arrays.asList(new Integer[120]), 14, 6);
        List<Allocation> alloc = optimizer.optimize(res);

        assertEquals(0, alloc.size());

    }

    @Test
    public void optimizerFullSeniorTest() {
        Resource res = new Resource(Collections.singletonList(100), 14, 6);
        List<Allocation> alloc = optimizer.optimize(res);

        assertEquals(0, alloc.size());
    }

    @Test
    public void optimizerTest() {
        Resource res = new Resource(Arrays.asList(35, 21, 17), 10, 6);
        List<Allocation> alloc = optimizer.optimize(res);

        assertEquals(3, alloc.get(0).getSenior());
        assertEquals(1, alloc.get(0).getJunior());

        assertEquals(1, alloc.get(1).getSenior());
        assertEquals(2, alloc.get(1).getJunior());

        assertEquals(2, alloc.get(2).getSenior());
        assertEquals(0, alloc.get(2).getJunior());

    }

    @Test
    public void optimizerTest1() {
        Resource res = new Resource(Arrays.asList(24, 28), 11, 6);
        List<Allocation> alloc = optimizer.optimize(res);

        assertEquals(2, alloc.get(0).getSenior());
        assertEquals(1, alloc.get(0).getJunior());

        assertEquals(2, alloc.get(1).getSenior());
        assertEquals(1, alloc.get(1).getJunior());

    }

}
