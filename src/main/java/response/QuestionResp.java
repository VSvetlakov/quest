package response;

import java.util.ArrayList;

public class QuestionResp {

    private String message;
    private String result;
    private ArrayList<AnswerResp> answerList = new ArrayList<>();

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setAnswerList(ArrayList<AnswerResp> answerList) {
        this.answerList = answerList;
    }
}
