package learnComparable;

class Student implements Comparable{
    private String name;
    private int ranking;

    public Student(String name, int ranking){
        this.name = name;
        this.ranking = ranking;
    }

    @Override
    public String toString(){
        return this.name + ":" + this.ranking;
    }

    @Override
    public int compareTo(Object o){
        Student s = (Student)(o);
        return this.ranking - s.ranking;
    }
}
