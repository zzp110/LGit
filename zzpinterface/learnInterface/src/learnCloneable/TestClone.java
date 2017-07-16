package learnCloneable;

class TestClone implements Cloneable {
    int a;
    double b;

    TestClone cloneTest() {
        try {
            return (TestClone) super.clone();
        }
        catch(CloneNotSupportedException e) {
            System.out.println("Cloning not allowed.");
            return this;
        }
    }
}