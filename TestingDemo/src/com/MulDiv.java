package com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MulDiv {

    @Test
    void mul() {
        Call1 c = new Call1();
        assertEquals(200, c.mul(10, 20));
    }

    @Test
    void div() {
        Call1 c = new Call1();
        assertEquals(2, c.div(200, 100));
    }
}
