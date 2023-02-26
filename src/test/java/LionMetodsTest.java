import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionMetodsTest {
    @Mock
    Feline feline;

    @Test
    public void getKittensReturnCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualResult = lion.getKittens();
        int expectedResult = 1;
        Assert.assertEquals("Некорректный результат вызова метода",expectedResult, actualResult);
    }

    @Test
    public void doesHaveManeReturnCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean actualResult = lion.doesHaveMane();
        boolean expectedResult = true;
        Assert.assertEquals("Некорректный результат вызова метода", expectedResult, actualResult);
    }

    @Test
    public void getFoodReturnCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные","Птицы","Рыба"));
        List<String> actualResult = lion.getFood();
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals("Некорректный результат вызова метода", expectedResult, actualResult);
    }
}
