package com.javarush.quest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Answer {
    @XmlAttribute(name = "message")
    private String message;
    @XmlAttribute(name = "id")
    private int id;
    @XmlAttribute(name = "stepTo")
    private int stepTo;

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    public int getStepTo() {
        return stepTo;
    }
}
