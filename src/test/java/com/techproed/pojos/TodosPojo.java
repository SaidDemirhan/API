package com.techproed.pojos;

public class TodosPojo {

    /*
    {
                  "userId": 21,
                  "id": 201,
                  "title": "Tidy your room",
                  "completed": false
                }
     */

    //Bu class ta encapsulation yaptik...


    //Biz encapsulation u API testi yaparken pojo class larda kullandik.

    //Inheritance i ise API testi yaparken TestBase class larda kullandik (extends).

    //1- degiskenleri private yapiyoruz

    private int userId;
    private int id;
    private String title;
    private boolean completed;

    //2 bu degerlereulasabilmek icin getter ve setter methodlar olusturalim.


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    //3- parametreli ve parametresiz constructor olusturalim


    public TodosPojo() {
    }

    public TodosPojo(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    //4- toString methodu olusturalim.


    @Override
    public String toString() {
        return "TodosPojo{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
