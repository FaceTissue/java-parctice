package test201903;

import java.time.*;
import java.util.Date;

public class StringTest {
    public static void main(String[] args) {
        String group = "bigScreen47";
        String[] strings = group.split("bigScreen");
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            System.out.println(string + " " + i);
        }

        String systemTime = "12:12:12";
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.parse(systemTime));
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        Date date = Date.from(instant);
        LocalTime parse = LocalTime.parse(systemTime);
        System.out.println(parse);
        System.out.println(date);
    }
}
