package test201902;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTest {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(10, 20, 30);
        for (Integer integer : integerList) {
            integer = 20;
        }
        for (Integer integer : integerList) {
            System.out.println(integer);
        }

        People zs = new People("zs", 20);
        People ls = new People("ls", 30);
        People ww = new People("ww", 40);
        List<People> peopleList = new ArrayList<>();
        peopleList.add(zs);
        peopleList.add(ls);
        for (People people : peopleList) {
//            people = ww;
//            people.setName(ww.getName());
            System.out.println(people.getName() + " " + people.getAge());
            peopleList.set(peopleList.indexOf(people), ww);
        }
        for (People people : peopleList) {
            System.out.println(people);
        }
    }
}

class People {
    private String name;

    private int age;

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

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + age;
    }
}
