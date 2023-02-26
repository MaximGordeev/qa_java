import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalGetFoodTest {
    private final String animalKind;
    private final List<String> expectedResult;

    Animal animal = new Animal();

    public AnimalGetFoodTest(String animalKind, List<String> expectedResult) {
        this.animalKind = animalKind;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "{index} - animal: {0}, expectedResult: {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getFoodReturnListOfFood() throws Exception {
        List<String> actualResult = animal.getFood(animalKind);
        Assert.assertEquals("Получен некорректный список", expectedResult, actualResult);
    }

    @Test(expected = Exception.class)
    public void getFoodWithException() throws Exception {
        List<String> actualResult = animal.getFood("Некорректное значение");
    }
}
