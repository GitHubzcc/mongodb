package com.mongodb.mongodb.sys.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * student class
 *
 * @author eriz
 * @date 2019年3月28日
 */
@Document(collection = "student")
public class Student {
    @Id
    String _id;
    String name;
    String class_id;
    String sex;
    Integer age;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", class_id='" + class_id + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
