package response;

import com.google.gson.Gson;
import com.javarush.quest.Answer;
import com.javarush.quest.Question;

import java.util.ArrayList;

public class ResponseController {

    public String getJsonResponse(Question question){

        QuestionResp questionResp = new QuestionResp();

        questionResp.setMessage(question.getMessage());
        questionResp.setResult(question.getResult());

        ArrayList<AnswerResp> answerResps = new ArrayList<>();

        for (Answer answer : question.getAnswerList()) {

            AnswerResp answerResp = new AnswerResp();
            answerResp.setId(answer.getId());
            answerResp.setMessage(answer.getMessage());

            answerResps.add(answerResp);
        }

        questionResp.setAnswerList(answerResps);

        return new Gson().toJson(questionResp);
    }
}
