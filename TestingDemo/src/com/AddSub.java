package com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AddSub {

    @Test
    void add() {
        Call1 c = new Call1();
        assertEquals(300, c.add(100, 200));
    }

    @Test
    void sub() {
        Call1 c = new Call1();
        assertEquals(100, c.sub(200, 100));
    }
}
