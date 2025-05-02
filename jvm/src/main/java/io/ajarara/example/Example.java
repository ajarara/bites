package io.ajarara.example;

import io.ajarara.dependency.Dependency;
import io.ajarara.dep2.Dep2;

public class Example {
    public static void main(String[] args) {
        new Dependency();
        new Dep2();
        // new io.ajarara.kotdep.Example();
        System.out.println("Hello world!");
    }
}
