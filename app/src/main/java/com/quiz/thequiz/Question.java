package com.quiz.thequiz;

public class Question {

    private String question1;
    private String option1;
    private String option2;
    private String option3;
    private int answerNr;


    public Question(String who_is_founder_of_pakistan, String a, String b, String c, int i) {
    }

    public Question() {
        this.question1 = question1;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.answerNr = answerNr;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr( int answerNr) {
        this.answerNr = answerNr;
    }
}
