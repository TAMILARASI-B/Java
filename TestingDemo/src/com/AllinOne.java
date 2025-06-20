package com;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    AddSub.class,
    MulDiv.class
})
class AllinOne {
}
