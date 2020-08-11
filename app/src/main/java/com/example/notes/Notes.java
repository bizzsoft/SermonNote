package com.example.notes;

class Notes {
    private String Title;
    private String Preacher;
    private String Sermon;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    private String Id;

    Notes() {
    }

    public Notes(String title,String preacher, String sermon,  String id){
        Title = title;
        Sermon = sermon;
        Preacher = preacher;
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPreacher() {
        return Preacher;
    }

    public void setPreacher(String preacher) {
        Preacher = preacher;
    }

    public String getSermon() {
        return Sermon;
    }

    public void setSermon(String sermon) {
        Sermon = sermon;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "Title='" + Title + '\'' +
                ", Preacher='" + Preacher + '\'' +
                ", Sermon='" + Sermon + '\'' +
                '}';
    }
}
