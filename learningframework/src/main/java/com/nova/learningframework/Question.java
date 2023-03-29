package com.nova.learningframework;

public class Question{
    public String courseContextKey;
    public String morse;
    public String normal;

    public Question(String morse, String normal,String courseContextKey) {
        this.morse = morse;
        this.normal = normal;
        this.courseContextKey = courseContextKey;
    }
}
