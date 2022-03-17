package com.tonny.entity;

public class User {

    private String uname;
    private String id;
    private String age;

    public  User(){ }

    public User(String uname,String id,String age){

        this.uname =uname;
        this.id =id;
        this.age=age;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
