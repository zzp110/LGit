package learnSerializable;

import java.io.*;

public class SerializableClass {

    public static void main(String[] args) throws Exception {

        FileOutputStream out = new FileOutputStream(new File("C:\\Users\\zzp1\\IdeaProjects\\zzpinterface\\person.dat"));
        ObjectOutputStream op = new ObjectOutputStream(out);
        op.writeObject(Person.getInstance());
        op.close();

        FileInputStream in = new FileInputStream(new File("C:\\Users\\zzp1\\IdeaProjects\\zzpinterface\\person.dat"));
        ObjectInputStream oi = new ObjectInputStream(in);
        Object person = oi.readObject();
        in = new FileInputStream(new File("C:\\Users\\zzp1\\IdeaProjects\\zzpinterface\\person.dat"));
        oi = new ObjectInputStream(in);
        Person person1 = (Person) oi.readObject();

        System.out.println("sington person hashcode:" + person.hashCode());
        System.out.println("sington person1 hashcode:" + person1.hashCode());
        System.out.println("singleton getInstance hashcode:" + Person.getInstance().hashCode());
        System.out.println("singleton person equals:" + (person == Person.getInstance()));
        System.out.println("person equals1:" + (person1 == person));
    }
}
