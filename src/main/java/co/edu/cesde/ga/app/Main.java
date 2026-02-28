package co.edu.cesde.ga.app;

import co.edu.cesde.ga.models.Person;

public class Main {
    public static void main(String[]args){
        System.out.println("Hello world");
        Person person = new Person();
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();

        person.setFirstName("Jhon");
        person.getFirstName();
        person2.setFirstName("Juan");
        person2.getFirstName();
        person3.getFirstName("Erica");
        person3.getFirstName();





        Person person4 = new Person(1L,"1,2,3","256","15437","Luis","Goenaga", boolean)
        person4.getFirstName();

    }
}
