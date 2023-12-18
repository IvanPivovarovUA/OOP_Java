package org.fpm.di.example;

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

public class DummyBinder implements Binder {

    private final HashMap<Class, Object> objectsInstances = new HashMap<Class, Object>();
    private final HashMap<Class, Class> changedDependencies = new HashMap<Class, Class>();
    // private final Set<Object> objectsInstances = new HashSet<>();

    public HashMap<Class, Object> getObjectsInstances() {
        return objectsInstances;
    }
    
    public HashMap<Class, Class> getChangedDependencies() {
        return changedDependencies;
    }
    // public <T> void add_in_objectsInstances(T instance) {
    //     objectsInstances.add(
    //         instance
    //     );
    //     System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHH");
    //     System.out.println(objectsInstances);
    //     System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHH");
    // }

    @Override
    public <T> void bind(Class<T> clazz) {

        try {
            T set_in_list_object = null;

            boolean test_inject = false;
            Constructor<?>[] constructors = clazz.getConstructors();
            for (Constructor<?> constructor : constructors) {
                if (null != constructor.getAnnotation(Inject.class)) {
                    test_inject = true;

                    Parameter[] parameters = constructor.getParameters();
                    Object[] list_of_param = new Object[parameters.length]; 
                    for (int i = 0; i < parameters.length; i++) {
                        list_of_param[i] = parameters[i].getType().newInstance();
                    }
                    set_in_list_object = (T) constructor.newInstance(
                        list_of_param
                    );
                }
            }
            if (set_in_list_object == null) {
                set_in_list_object = (T) clazz.newInstance();
            }
            
            boolean test_singleton = false;
            for(Annotation annotation : clazz.getDeclaredAnnotations() ) {
                if(annotation.annotationType() == Singleton.class) {
                    test_singleton = true;
                }
            }
            
            if (test_singleton || test_inject) {
                objectsInstances.put(
                    clazz,
                    set_in_list_object
                );
            }else {
                objectsInstances.put(
                    clazz,
                    null
                );
            }

        }
        catch (Exception ie) {
            System.out.println(ie);
            System.out.println("!!SHiiiiittt_ 2222222222");
        }
    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {

        changedDependencies.put(
            clazz,
            implementation
        );

    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) {
        objectsInstances.put(
            clazz,
            instance
        );
    }
}
