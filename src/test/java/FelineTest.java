import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    Feline feline;

    @Test
    public void eatMeatReturnCorrectValues() throws Exception {
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        Mockito.doReturn(expectedResult).when(feline).getFood("Хищник");
        List<String> actualResult = feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
        Assert.assertEquals("Некорректный результат возврата List<>", expectedResult, actualResult);
    }

    @Test
    public void getFamilyReturnFeline() {
        Feline feline = new Feline();
        String actualResult = feline.getFamily();
        String expectedResult = "Кошачьи";
        Assert.assertEquals("Некорректный результат вызова метода", expectedResult, actualResult);
    }

    @Test
    public void getKittensWithGivenParameter() {
        Feline feline = new Feline();
        int actualResult = feline.getKittens(2);
        int expectedResult = 2;
        Assert.assertEquals("Получено некорректное значение", expectedResult, actualResult);
    }

    @Test
    public void getKittensWithOutParameter() {
        Feline feline = new Feline();
        int actualResult = feline.getKittens();
        int expectedResult = 1;
        Assert.assertEquals("Получено некорректное значение", expectedResult, actualResult);
    }
}
