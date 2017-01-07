package tff.agventure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Faqs implements Serializable{
    private List<String> mFaqsQuestions;
    private HashMap<String, List<String>> mFaqsAnswers;

    public Faqs() {
        mFaqsQuestions = new ArrayList<>();
        mFaqsAnswers = new HashMap<>();
    }

    public List<String> getFaqsQuestions() {
        return mFaqsQuestions;
    }

    public HashMap<String, List<String>> getFaqsAnswers() {
        return mFaqsAnswers;
    }

    public void addQuestion(String question){
        mFaqsQuestions.add(question);
    }

    public void addAnswer(String question, String answer){ //list can only have one answer per question
        List<String> answers = mFaqsAnswers.get(question);
        if(answers == null){
            answers = new ArrayList<>();
            answers.add(answer);
            mFaqsAnswers.put(question, answers);
        }
    }
}
