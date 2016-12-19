package example.spatch.act.delacourt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void userDir() throws Exception {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.dir") + "/src/main/res/raw/jamsil_20160513_lunch.json");
    }
}