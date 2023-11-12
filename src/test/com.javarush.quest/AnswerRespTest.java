import org.junit.jupiter.api.Test;
import response.AnswerResp;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnswerRespTest {

    @Test
    public void setMessage(){
        AnswerResp answerResp = new AnswerResp();
        answerResp.setMessage("Test message");

        Field privateField;
        try {
            privateField = answerResp.getClass().getDeclaredField("message");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        privateField.setAccessible(true);
        try {
            assertEquals("Test message",privateField.get(answerResp));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void setId(){
        AnswerResp answerResp = new AnswerResp();
        answerResp.setId(2);

        Field privateField;
        try {
            privateField = answerResp.getClass().getDeclaredField("id");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        privateField.setAccessible(true);
        try {
            assertEquals(2,privateField.get(answerResp));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
