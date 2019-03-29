/*
package com.mongodb.mongodb.sys.controller;

import com.mongodb.mongodb.sys.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

*/
/**
 * mongoDB
 *
 * @author eriz
 * @date 2019年3月28日
 *//*


public class MongoDb {

    @Autowired
    MongoTemplate mongoTemplate;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public void save() {
        Student student = new Student();
        student.setName("张三");
        student.setAge(18);
        student.setSex("男");
        student.set_id(UUID.randomUUID().toString());

        mongoTemplate.save(student);
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public void del() {
        // 删除name = 张三的数据
        Criteria criteria = Criteria.where("name").is("张三");
//    删除年龄 > 17
//    Criteria.where("age").gt(17);
//    删除年龄 <= 19
//    Criteria.where("age").lte(19)
        Query query = Query.query(criteria);

        mongoTemplate.remove(query, Student.class);
//    一样的效果
//    mongoTemplate.remove(query, "student");
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public void update() {
        // 匹配条件name = 张三
        Criteria criteria = Criteria.where("name").is("张三");
        Query query = Query.query(criteria);
        // 修改年龄 = 20
        Update update = new Update();
        update.set("age", 20);

        // updateFirst 修改匹配到的第一个学生
        mongoTemplate.updateFirst(query, update, Student.class);
//    mongoTemplate.updateFirst(query, update, "student");
        // updateMulti 修改所有 name = 张三 的学生
        mongoTemplate.updateMulti(query, update, Student.class);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public void query() {
        // 匹配条件sex = 男
        Criteria criteria = Criteria.where("sex").is("男");
        Query query = Query.query(criteria);

        // 查询名字为张三的所有学生
        List<Student> students = mongoTemplate.find(query, Student.class);

        // 类似的 查询年龄 > 18的学生
        Criteria criteria1 = Criteria.where("age").lt(18);
        Query query1 = Query.query(criteria);
        List<Student> students1 = mongoTemplate.find(query1, Student.class);
    }


}
*/
