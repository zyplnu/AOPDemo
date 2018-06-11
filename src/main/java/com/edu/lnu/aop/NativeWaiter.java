package com.edu.lnu.aop;

public class NativeWaiter implements Waiter {
    public void greetTo(String name) {
        System.out.println("greet to " + name + "...");
    }

    public void saveTo(String name) {
        System.out.println("serve to " + name + "...");
    }
}
