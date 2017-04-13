package ua.kiev.prog.week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReferenceVSValueExample {


    static class Person {

        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }


    }

    interface MyConverter<E> {
        E convert(E input);
    }

    static MyConverter<String> converter = input -> input.toUpperCase();


    public static String doSmth(String parameter, MyConverter<String> converter) {
        return converter.convert(parameter);
    }



    public static void main(String[] args) {

        System.out.println(doSmth("hi",converter));

        // int , short , long ,byte
        // float , double
        // char
        //boolean
        // null
        String string;
        //Object

        int number = 5;
        int number2 = number;

        System.out.println(number);
        System.out.println(number2);

        number2++;

        System.out.println("after incrementing the number2");
        System.out.println(number);
        System.out.println(number2);

        // person1 \   reference
        // person2 /
        // heap , stack(frame)

        Person person1 = new Person("Ivan");
        Person person2 = person1;
        Person person3 = new Person("Jack");

        // println - > String.valueOf -> obj.toString();

        System.out.println(person1);
        System.out.println(person2);

        person2.setName("John");

        System.out.println("******");
        System.out.println(person1);
        System.out.println(person2);


        WebDriver driver = new ChromeDriver();


    }
}
