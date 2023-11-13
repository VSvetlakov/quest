package controllers;

import com.javarush.quest.Answer;
import com.javarush.quest.Quest;
import com.javarush.quest.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class QuestController {

    private static final Logger log = LoggerFactory.getLogger(QuestController.class);
    private Quest quest;

    private String questId;

    public QuestController(String questId) {
        this.questId = questId;
    }

    public Question getNextQuestion(Question curQuestion, String answerId, String user){

        quest = loadQuest();

        if (quest == null)
            return null;

        ArrayList<Question> questions = quest.getQuestionList();

        if (questions.isEmpty())
            return null;

        int nextQuestionId;
        if (answerId == null){
            log.info("Пользователь {} начал квест {}", user, questId);
            return questions.get(0);
        }else {

            nextQuestionId = getNextQuestionId(curQuestion, answerId);

            return getQuestionById(nextQuestionId);
        }
    }

    private Question getQuestionById(int questionId) {

        for (Question q : quest.getQuestionList()) {
            if (q.getId() == questionId) {
                return q;
            }
        }
        return null;
    }

    private int getNextQuestionId(Question curQuestion, String answerId){
        for (Answer a : curQuestion.getAnswerList()) {
            if (a.getId() == Integer.parseInt(answerId)) {
                return a.getStepTo();
            }
        }
        return 0;
    }

    private Quest loadQuest(){

        String fileName = "/quests/" + questId + ".xml";

        String content;

        try {
            content = readTextResource(fileName);
        } catch (Exception e) {
            return null;
        }

        try {
            StringReader reader = new StringReader(content);
            JAXBContext context = JAXBContext.newInstance(Quest.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return  (Quest) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            return null;
        }
    }

    private String readTextResource(String filename) throws Exception {
        var uri = getClass().getResource(String.format("%s", filename)).toURI();
        return Files.readString(Paths.get(uri));
    }
}
