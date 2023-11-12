package controllers;


import com.javarush.quest.Question;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import response.ResponseController;

import java.io.*;

@WebServlet(name = "QuestServlet", value = "/questService")
public class QuestServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(QuestServlet.class);
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession currentSession = req.getSession();

        String user           = (String) currentSession.getAttribute("user");
        String sessionQuestId = (String) currentSession.getAttribute("questId");
        Question curQuestion  = (Question) currentSession.getAttribute("curQuestion");

        String questId     = req.getParameter("questId");
        String answerId    = req.getParameter("answerId");

        if (questId != null && !questId.equals(sessionQuestId))
            answerId = null;

        if (questId != null)
            currentSession.setAttribute("questId",questId);
        else if (sessionQuestId != null) {
            questId = sessionQuestId;
        }

        QuestController questController = new QuestController(questId);

        Question question = questController.getNextQuestion(curQuestion, answerId, user);

        if (question == null)
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);

        if (question.getResult() != null && question.getResult().equals("win")){
            Integer winCount = (Integer) currentSession.getAttribute("winCount");
            currentSession.setAttribute("winCount",++winCount);
            log.info("Пользователь {} победил в квесте {} ", user, questId);
        }

        if (question.getResult() != null && question.getResult().equals("game over")){
            Integer loseCount = (Integer) currentSession.getAttribute("loseCount");
            currentSession.setAttribute("loseCount",++loseCount);
            log.info("Пользователь {} проиграл в квесте {} ", user, questId);
        }

        currentSession.setAttribute("curQuestion", question);

        String json = new ResponseController().getJsonResponse(question);

        // Устанавливаем правильные заголовки для ответа
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Пишем JSON-ответ в выходной поток
        resp.getWriter().write(json);
    }
}