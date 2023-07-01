package ua.en.kosse.oksana.hillel.hw19;

import ua.en.kosse.oksana.hillel.hw19.annotations.AfterSuite;
import ua.en.kosse.oksana.hillel.hw19.annotations.BeforeSuite;
import ua.en.kosse.oksana.hillel.hw19.annotations.Test;
import ua.en.kosse.oksana.hillel.hw19.exception.NumberOfAnnotationException;


import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class TestRunner {

    public static void start(Object myClassObj) throws InvocationTargetException, IllegalAccessException {
        int numOfBeforeAnnotation = 0;
        int numOfAfterAnnotation = 0;
        Method beforeMethod = null;
        Method afterMethod = null;
        boolean isDoubledAnnotation = false;

        List<Method> testMethods = new ArrayList<>();

        Method[] methodsArray = myClassObj.getClass().getDeclaredMethods();

        for (Method method : methodsArray) {
            try {
                if (method.isAnnotationPresent(Test.class)) {
                    testMethods.add(method);
                }
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    numOfBeforeAnnotation++;
                    if (numOfBeforeAnnotation > 1) {
                        throw new NumberOfAnnotationException();
                    }
                    beforeMethod = method;
                }
                if (method.isAnnotationPresent(AfterSuite.class)) {
                    numOfAfterAnnotation++;
                    if (numOfAfterAnnotation > 1) {
                        throw new NumberOfAnnotationException();
                    }
                    afterMethod = method;
                }
            } catch (NumberOfAnnotationException e) {
                e.printStackTrace();
                isDoubledAnnotation = true;
                break;
            }
        }

        if (!isDoubledAnnotation) {
            startBefAndAftMethods(beforeMethod, myClassObj);
            testMethods = sortTestMethods(testMethods);
            startTestMethods(testMethods, myClassObj);
            startBefAndAftMethods(afterMethod, myClassObj);
            System.out.println();
        }

    }


    private static void startBefAndAftMethods(Method method, Object obj) throws InvocationTargetException, IllegalAccessException {
        if (method != null) {
            method.invoke(obj);
        }
    }

    private static List<Method> sortTestMethods(List<Method> testMethods) {
        testMethods.sort(new Comparator<>() {
            @Override
            public int compare(Method method1, Method method2) {
                return method1.getAnnotation(Test.class).numberInQueue() - method2.getAnnotation(Test.class).numberInQueue();
            }
        });
        return testMethods;
    }

    private static void startTestMethods(List<Method> testMethods, Object obj) throws InvocationTargetException, IllegalAccessException {
        for (Method method : testMethods) {
            if (method != null) {
                method.invoke(obj);
            }
        }
    }


    static void readAnnotation(AnnotatedElement element) {
        try {
            System.out.println("Поиск аннотаций в " + element.getClass().getName());
            Annotation[] annotations = element.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Test) {
                    final Test fileBeforeSuite = (Test) annotation;
                    System.out.println("Test ");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

