import com.javarush.quest.Answer;
import com.javarush.quest.Quest;
import com.javarush.quest.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestTest {

    @Test
    public void getQuestionList(){

        List<Question> questionList = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            questionList.add(new Question());
        }

        Quest quest = new Quest();

        Field privateField = null;
        try {
            privateField = quest.getClass().getDeclaredField("questionList");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        privateField.setAccessible(true);
        try {
            privateField.set(quest, questionList);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        assertEquals(questionList,quest.getQuestionList());

    }

}
