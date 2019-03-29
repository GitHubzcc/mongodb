package com.mongodb.mongodb;

import com.mongodb.mongodb.sys.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void save() {
        Student student = new Student();
        student.setName("张三");
        student.setAge(18);
        student.setSex("男");
        student.set_id(UUID.randomUUID().toString());
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "============");
            student.setAge(i);
            mongoTemplate.save(student);
        }

    }

    @Test
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

    @Test
    public void update() {
        // 匹配条件name = 张三
        Criteria criteria = Criteria.where("name").is("张三");
        Query query = Query.query(criteria);
        // 修改年龄 = 20
        Update update = new Update();
        update.set("age", 200);

        // updateFirst 修改匹配到的第一个学生
        mongoTemplate.updateFirst(query, update, Student.class);
//    mongoTemplate.updateFirst(query, update, "student");
        // updateMulti 修改所有 name = 张三 的学生
        mongoTemplate.updateMulti(query, update, Student.class);
    }

    @Test
    public void query() {
        // 匹配条件sex = 男
        Criteria criteria = Criteria.where("sex").is("男");
        Query query = Query.query(criteria);

        // 查询名字为张三的所有学生
        List<Student> students = mongoTemplate.find(query, Student.class);

        students.forEach(k -> System.out.println(k.toString()));
        System.out.println("====分割线================");
        // 类似的 查询年龄 > 18的学生
        Criteria criteria1 = Criteria.where("age").lt(18);
        Query query1 = Query.query(criteria1);
        List<Student> students1 = mongoTemplate.find(query1, Student.class);
        students1.forEach(k -> System.out.println(k.toString()));
    }

}
