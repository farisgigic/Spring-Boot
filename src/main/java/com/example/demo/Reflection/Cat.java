package com.example.demo.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Cat {
    private final String name ;
    private int age;

    public Cat(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public String toString(){
        return this.name + " " + this.age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public static void thisIsPublicAndStaticMethod(){
        System.out.println("This is a public and static method!");
    }
    public void meow(){
        System.out.println("Meow");
    }
    public void saySomething(String something){
        System.out.println("I said something ".concat(something));
    }
    private void thisIsPrivateMethod(){
        System.out.println("How did you call this? ");
    }

}

class Main{
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Cat macka  = new Cat("Mustafa", 9);

        Field[] fields = macka.getClass().getDeclaredFields();  // For accessing all fields that are declared in our Car class
        for(Field f : fields){
            System.out.println(f.getName());
        }

        for(Field f : fields){
            if(f.getName().equals("name")){
                f.setAccessible(true);
                f.set(macka, "Mustafaa");
            }
        }

        Method[] methods = macka.getClass().getDeclaredMethods();
        for(Method m : methods){
            if(m.getName().equals("thisIsPublicAndStaticMethod")){
                m.invoke(null);
            }
            else if(m.getName().equals("meow")){
                m.invoke(macka);
            }
            else if(m.getName().equals("saySomething")){
                m.invoke(macka, "IBU");
            }
            else if(m.getName().equals("thisIsPrivateMethod")){
                m.setAccessible(true);
                m.invoke(macka);
            }
        }
        System.out.println(macka);
    }
}
