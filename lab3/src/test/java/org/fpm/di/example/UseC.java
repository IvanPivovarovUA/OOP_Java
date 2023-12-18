package org.fpm.di.example;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UseC {
    private final A A_dependency;
    private final B B_dependency;

    @Inject
    public UseC(A a, B b) {
        this.A_dependency = a;
        this.B_dependency = b;
    }

    public A getA_Dependency() {
        return A_dependency;
    }
    public A getB_Dependency() {
        return B_dependency;
    }
}
