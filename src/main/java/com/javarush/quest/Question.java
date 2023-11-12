package com.javarush.quest;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
public class Question {
    @XmlAttribute(name = "message")
    private String message;
    @XmlAttribute(name = "id")
    private int id;
    @XmlElement(name = "result")
    private String result;
    @XmlElement(name="answer")
    private ArrayList<Answer> answerList = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    public String getResult() {
        return result;
    }

    public ArrayList<Answer> getAnswerList() {
        return answerList;
    }
}
