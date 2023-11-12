import com.javarush.quest.Answer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class AnswerTest {


    @Test
    public void getMessage()  {
        Answer answer = new Answer();

        Field privateField;
        try {
            privateField = answer.getClass().getDeclaredField("message");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        privateField.setAccessible(true);
        try {
            privateField.set(answer, "Test message");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("Test message", answer.getMessage());
    }

    @Test
    public void getId()  {
        Answer answer = new Answer();

        Field privateField;
        try {
            privateField = answer.getClass().getDeclaredField("id");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        privateField.setAccessible(true);
        try {
            privateField.set(answer, 1);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(1, answer.getId());
    }

    @Test
    public void getStepTo()  {
        Answer answer = new Answer();

        Field privateField;
        try {
            privateField = answer.getClass().getDeclaredField("stepTo");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        privateField.setAccessible(true);
        try {
            privateField.set(answer, 2);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(2, answer.getStepTo());
    }
}
