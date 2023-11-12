import com.javarush.quest.Answer;
import com.javarush.quest.Quest;
import com.javarush.quest.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {

    @Test
    public void getMessage(){
        Question question = new Question();

        Field privateField = null;
        try {
            privateField = question.getClass().getDeclaredField("message");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        privateField.setAccessible(true);
        try {
            privateField.set(question, "Test message");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals("Test message", question.getMessage());
    }

    @Test
    public void getId(){
        Question question = new Question();

        Field privateField = null;
        try {
            privateField = question.getClass().getDeclaredField("id");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        privateField.setAccessible(true);
        try {
            privateField.set(question, 1);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertEquals(1, question.getId());
    }

    @Test
    public void getResult(){
        Question question = new Question();

        Field privateField = null;
        try {
            privateField = question.getClass().getDeclaredField("result");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        privateField.setAccessible(true);
        try {
            privateField.set(question, "win");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        assertEquals("win", question.getResult());
    }

    @Test
    public void getAnswerList(){

        List<Answer> answerList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            answerList.add(new Answer());
        }

        Question question = new Question();

        Field privateField = null;
        try {
            privateField = question.getClass().getDeclaredField("answerList");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        privateField.setAccessible(true);
        try {
            privateField.set(question, answerList);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        assertEquals(answerList,question.getAnswerList());

    }

}
