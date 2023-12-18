package org.fpm.di.example;

import javax.inject.Inject;

public class UseA {
    private final A dependency;

    @Inject
    public UseA(A a, B b) {
        this.dependency = a;
    }

    public A getDependency() {
        return dependency;
    }
}
