package org.fpm.di.example;


import org.fpm.di.Container;
import org.fpm.di.Configuration;
// import javax.inject.Singleton;
// // import java.lang.reflect.Field;
// import java.lang.annotation.Annotation;
import org.fpm.di.Binder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

import javax.inject.Singleton;
import javax.inject.Inject;
import java.lang.annotation.Annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;


public class DummyContainer implements Container {

    private DummyBinder dummyBinder = new DummyBinder();

    // private final Set<Object> objectsInstances = new HashSet<>();
    public DummyContainer(Configuration configuration) {
        configuration.configure(dummyBinder);
        // objectsInstances.add();
    }

    @Override
    public <T> T getComponent(Class<T> clazz) {


        HashMap<Class, Object> BIND = dummyBinder.getObjectsInstances();

        if (BIND.containsKey(clazz)) {

            if (BIND.get(clazz) != null) {
                return (T) BIND.get(clazz);
            } else {
                try {
                    T come_back_object = null;

                    Constructor<?>[] constructors = clazz.getConstructors();
                    for (Constructor<?> constructor : constructors) {
                        if (null != constructor.getAnnotation(Inject.class)) {
                            Parameter[] parameters = constructor.getParameters();
                            Object[] list_of_param = new Object[parameters.length]; 
                            for (int i = 0; i < parameters.length; i++) {
                                
                                Class class_name = parameters[i].getType();

                                if (BIND.containsKey(class_name)) {
                                    list_of_param[i] = BIND.get(class_name);
                                } else {
                                    list_of_param[i] = class_name.newInstance();
                                }

                            }
                            come_back_object = (T) constructor.newInstance(
                                list_of_param
                            );
                        }
                    }
                    if (come_back_object == null) {
                        come_back_object = (T) clazz.newInstance();
                    }

                    return come_back_object;

                } catch (Exception ie) {
                    System.out.println("!!error");
                    return null;
                }
            }
            
        } else {
            return null;
        }
        
    }
}
