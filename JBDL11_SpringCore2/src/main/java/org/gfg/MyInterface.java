package org.gfg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component("myInterface")
public interface MyInterface {

    void someTask();
}
