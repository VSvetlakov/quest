package com.javarush.quest;

import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "quest")
@XmlAccessorType(XmlAccessType.FIELD)
public class Quest {
    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "id")
    private int id;
    @XmlElement(name="question")
    private ArrayList<Question> questionList = new ArrayList<>();

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }
}
