import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

public class AnimalGetFamilyTest {
    Animal animal = new Animal();

    @Test
    public void getFamilyReturnSpecificString() {
        String actualResult = animal.getFamily();
        String expectedResult = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Assert.assertEquals("Получена некорректная строка", expectedResult, actualResult);
    }
}
