package org.gfg;

import org.springframework.stereotype.Component;

@Component
public class MyImpl2 implements MyInterface{
    @Override
    public void someTask() {
        System.out.println("another impl");
    }
}
