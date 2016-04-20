package com.ice.wenjuandiaocha.tool;

import com.ice.greendao.PersonInfo;
import com.ice.greendao.QuestionResult;
import com.ice.greendao.SimpleInfo;

import java.util.ArrayList;

/**
 * Created by ice on 2016/4/18.
 */
public class UpdateBean {

    PersonInfo personInfo;
    SimpleInfo simpleInfo;

    public SimpleInfo getSimpleInfo() {
        return simpleInfo;
    }

    public void setSimpleInfo(SimpleInfo simpleInfo) {
        this.simpleInfo = simpleInfo;
    }

    ArrayList<QuestionResult> questionResults = new ArrayList<>();

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }

    public ArrayList<QuestionResult> getQuestionResults() {
        return questionResults;
    }

    public void setQuestionResults(ArrayList<QuestionResult> questionResults) {
        this.questionResults = questionResults;
    }

    public void addQuestionResults(QuestionResult questionResult) {
        questionResults.add(questionResult);
    }

}
