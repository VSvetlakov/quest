import com.javarush.quest.Question;
import response.ResponseController;

public class ResponseControllerTest {

    public void getJsonResponse(){

        Question question = new Question();

        ResponseController responseController = new ResponseController();

        responseController.getJsonResponse(question);
    }
}
