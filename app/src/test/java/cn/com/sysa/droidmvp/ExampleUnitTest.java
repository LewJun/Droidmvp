package cn.com.sysa.droidmvp;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
//        add(3, 4);
        List<String> temps = new ArrayList<>();
        temps.add("32.3");
        temps.add("22.3");
        temps.add("42.3");
        temps.add("53.3");
        temps.add("33d.3");
        System.out.println(temps);
        sort(temps);
    }

    private static void sort(List<String> temps) {
        List<Float> tempF = new ArrayList<>();
        for (String temp : temps) {
            try {
                Float t = Float.valueOf(temp);
                tempF.add(t);
            } catch (Exception ex) {
                continue;
            }
        }
        System.out.println(Collections.max(tempF));
    }
    private static <T> void add(T t1, T t2) {
        System.out.println(t1);
        System.out.println(t2);

        ParameterizedType type = (ParameterizedType) t1.getClass().getGenericSuperclass();
        System.out.println(type.getClass());
    }
}