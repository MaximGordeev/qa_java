import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionConstructorParametrerizedTest {
    private final String sex;
    private boolean expectedResult;

    public LionConstructorParametrerizedTest(String sex, boolean expectedResult) {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "{index} - sex: {0}, expectedResult: {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void lionHasManeWithParameters() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(expectedResult, lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void lionHasManeException() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Некорректное значение", feline);
    }
}
