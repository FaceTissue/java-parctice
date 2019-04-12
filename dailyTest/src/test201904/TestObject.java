package test201904;

import java.util.ArrayList;
import java.util.List;

public class TestObject {
    public static void main(String[] args) {
        List<People> peopleList = new ArrayList<>();
        People people = new People("zs", 1);
        for (int i = 0; i < 10; i++) {
            people.setName(people.getName() + (char) ('A' + i));
            people.setAge(people.getAge() + i);
            peopleList.add(people);
        }
        for (int i = 0; i < peopleList.size(); i++) {
            System.out.println(peopleList.get(0));
        }
    }
}
class People {
    private String name;

    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + age;
    }
}
