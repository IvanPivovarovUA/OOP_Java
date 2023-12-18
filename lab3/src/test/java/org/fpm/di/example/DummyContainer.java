package org.fpm.di.example;


import org.fpm.di.Container;
import org.fpm.di.Configuration;
// import javax.inject.Singleton;
// // import java.lang.reflect.Field;
// import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DummyContainer implements Container {

    private DummyBinder dummyBinder = new DummyBinder();

    // private final Set<Object> objectsInstances = new HashSet<>();
    public DummyContainer(Configuration configuration) {
        configuration.configure(dummyBinder);
        // objectsInstances.add();
    }

    @Override
    public <T> T getComponent(Class<T> clazz) {

        // for (Object i : dummyBinder.getobjectsInstances()) {
        //     if (clazz.equals(i.getClass())) {
        //         return (T) i;
        //     }
        // }
        
        HashMap<Class, Class> CHAN  = dummyBinder.getChangedDependencies();
        if (CHAN.containsKey(clazz)) {
            clazz = CHAN.get(clazz);
        }


        HashMap<Class, Object> BIND = dummyBinder.getObjectsInstances();

        if (BIND.containsKey(clazz)) {

            if (BIND.get(clazz) != null) {
                return (T) BIND.get(clazz);
            } else {
                try {
                    T come_back_object = (T) clazz.newInstance();
                    return come_back_object;
                } catch (Exception ie) {
                    System.out.println("!!SHiiiiittt");
                    return null;
                }
            }
            
        } else {
            return null;

        }
        


  

        // try {
        //     T come_back_object = (T) clazz.newInstance();
        //     for(Annotation annotation : clazz.getDeclaredAnnotations() ) {
                
        //         if(annotation.annotationType() == Singleton.class) {
                    
        //             dummyBinder.add_in_objectsInstances(come_back_object);
                    
        //         }
        //     }  


        //     System.out.println("!!!!!!!!!!!!!!YeESS");
        //     return (T) come_back_object;  
        // }
        // catch (Exception ie) {
        //     System.out.println("!!SHiiiiittt");
        //     return null;
        // }
        
      
        


        // if (clazz.equals(A.class)) {
        //     return (T) new A();
        // }
        // if (clazz.equals(B.class)) {
        //     return (T) new B();
        // }
       
        // return null;
    }
}
