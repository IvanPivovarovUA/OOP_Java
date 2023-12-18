package org.fpm.di.example;

import org.fpm.di.Binder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
            // T set_in_list_object = (T) clazz.newInstance();
            Constructor<?>[] constructors = clazz.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("Constructor: " + constructor.getName());

                // Получение параметров конструктора
                Parameter[] parameters = constructor.getParameters();

                for (Parameter parameter : parameters) {
                    System.out.println("Parameter: " + parameter.getName());
                    System.out.println("Type: " + parameter.getType());
                    
                }
                // set_in_list_object = (T) parameter.getType().newInstance();
                System.out.println("-----");
            }

            // T set_in_list_object = (T) clazz.newInstance();

            boolean test_singleton = false;

            for(Annotation annotation : clazz.getDeclaredAnnotations() ) {
                if(annotation.annotationType() == Singleton.class) {
                    test_singleton = true;
                }
                // objectsInstances.put(
                //     clazz,
                //     set_in_list_object
                // );

            }
            

            if (test_singleton) {
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
