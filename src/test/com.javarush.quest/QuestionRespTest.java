import com.javarush.quest.Answer;
import org.junit.jupiter.api.Test;
import response.AnswerResp;
import response.QuestionResp;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionRespTest {
    @Test
    public void setMessage(){
        QuestionResp questionResp = new QuestionResp();
        questionResp.setMessage("Test message");

        Field privateField = null;
        try {
            privateField = questionResp.getClass().getDeclaredField("message");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        privateField.setAccessible(true);
        try {
            assertEquals("Test message",privateField.get(questionResp));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void setResult(){
        QuestionResp questionResp = new QuestionResp();
        questionResp.setResult("win");

        Field privateField = null;
        try {
            privateField = questionResp.getClass().getDeclaredField("result");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        privateField.setAccessible(true);
        try {
            assertEquals("win",privateField.get(questionResp));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void setAnswerList(){

        ArrayList<AnswerResp> answerList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            answerList.add(new AnswerResp());
        }

        QuestionResp questionResp = new QuestionResp();
        questionResp.setAnswerList(answerList);

        Field privateField = null;
        try {
            privateField = questionResp.getClass().getDeclaredField("answerList");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        privateField.setAccessible(true);
        try {
            assertEquals(answerList,privateField.get(questionResp));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
