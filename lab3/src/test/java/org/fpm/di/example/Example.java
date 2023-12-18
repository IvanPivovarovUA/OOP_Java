package org.fpm.di.example;

import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class Example {

    private Container container;

    @Before
    public void setUp() {
        Environment env = new DummyEnvironment();
        container = env.configure(new MyConfiguration());
        
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(B.class),container.getComponent(B.class));
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        // System.out.println(container.getComponent(MyPrototype.class));
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        final B bAsSingleton = container.getComponent(B.class);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }

    @Test
    public void myOwnTest() {
        final UseA test1 = container.getComponent(UseA.class);
        assertNotSame(test1,container.getComponent(UseA.class));

        final UseC test2 = container.getComponent(UseC.class);
        assertSame(test2,container.getComponent(UseC.class));

        assertSame(test2.getA_Dependency(), container.getComponent(B.class));
        assertSame(test2.getB_Dependency(), container.getComponent(B.class));
    }
}
