package test201903;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ListObjectGroup {
    public static void main(String[] args) {
        List<People> peopleList = new ArrayList<>();
        peopleList.add(new People(10, true));
        peopleList.add(new People(12, false));

        long count = peopleList.stream().filter(People::isMail).count();
        Predicate<Long> predicate = aLong -> aLong == 0 || aLong == peopleList.size();
        predicate.test(count);
    }
}

class People {
    private int age;

    private boolean isMail;

    People(int age, boolean isMail) {
        this.age = age;
        this.isMail = isMail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMail() {
        return isMail;
    }

    public void setMail(boolean mail) {
        isMail = mail;
    }
}
