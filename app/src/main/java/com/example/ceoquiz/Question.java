package com.example.ceoquiz;

class Question {

    private int mTextResId;
    private boolean mAnswerTrue;

    public Question (int textResId, boolean answerTrue){

        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }


  public boolean getAnswerTrue() {
       return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
   }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }
}
