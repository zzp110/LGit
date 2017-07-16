package learnSerializable;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class Person implements Serializable{
    private static final long serialVersionUID = 1L;//默认
    private String name;
    private Person(String name) {
        this.name = name;
    };
    private static Person person = null;

    public static synchronized Person getInstance() {
        if (person == null)
            return person = new Person("cgl");
        return person;
    }

    private Object writeReplace() throws ObjectStreamException {
        System.out.println("1 write replace start");
        return this;//可修改为其他对象
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        System.out.println("2 write object start");
        out.defaultWriteObject();
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("3 read object start");
        in.defaultReadObject();
    }

    private Object readResolve() throws ObjectStreamException {
        System.out.println("4 read resolve start");
        return Person.getInstance();//不管序列化的操作是什么，返回的都是本地的单例对象
    }

}
