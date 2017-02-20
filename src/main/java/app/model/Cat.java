package app.model;

import org.springframework.data.annotation.Id;

/**
 * Created by Иван on 20.02.2017.
 */
public class Cat {
    @Id
    private String id;
    private String name;
    private String sex;
    private String birthday;

    public Cat(){}

    public Cat(String name, String sex, String birthday){
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSex(){
        return sex;
    }

    public void setSex(String id){
        this.sex = sex;
    }

    public String getBirthday(){
        return birthday;
    }

    public void setBirthday(String birthday){
        this.birthday = birthday;
    }
}
