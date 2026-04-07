package com.fsad.springbootbackendproject.entity;

import jakarta.persistence.*;

@Entity
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private int score;
    private String improvementSuggestion;

    public Mark() {}

    public Long getId() 
    {
    	return id; 
    	}

    public String getSubject() 
    { 
    	return subject; 
    }
    public void setSubject(String subject) 
    {
    	this.subject = subject;
    }

    public int getScore() 
    {
    	return score;
    }
    public void setScore(int score) 
    {
    	this.score = score;
    }

    public String getImprovementSuggestion() 
    {
    	return improvementSuggestion;
    }
    public void setImprovementSuggestion(String improvementSuggestion) 
    {
        this.improvementSuggestion = improvementSuggestion;
    }
}