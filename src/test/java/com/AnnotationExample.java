package com;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {
    @Override
    @methodInfo(author = "kalyan", comments = "main", date = "24 june 2020", revision = 1)
    public String toString(){
        return "over ridden to string method";
    }
    @Deprecated
    @methodInfo(comments = "deprecated method", date = "24 June 2020")
    public static void oldMethod() {
        System.out.println("old method,don't use it");
    }

    public static void main(String[] args) {
        try {
            for (Method method : AnnotationExample.class.getMethods()) {
                //checks if MethodInfo annotation is present for the method
                if (method.isAnnotationPresent(methodInfo.class)) {
                    try {
                        //iterates all the annotations available in the method
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in method '" + method + "' : " + anno);
                        }
                        methodInfo methodInfo = method.getAnnotation(methodInfo.class);
                        if (methodInfo.revision() == 1) {
                            System.out.println("Method with revision no 1 = " + method);
                        }
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException ex) {
            ex.printStackTrace();
        }
    }
}
