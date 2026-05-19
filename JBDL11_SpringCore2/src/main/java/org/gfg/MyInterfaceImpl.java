package org.gfg;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
public class MyInterfaceImpl implements MyInterface{
    @Override
    public void someTask() {
        System.out.println("some task");
    }
}
