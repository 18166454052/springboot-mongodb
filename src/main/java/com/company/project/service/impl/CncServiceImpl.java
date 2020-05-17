package com.company.project.service.impl;

import com.company.project.model.Cnc;
import com.company.project.service.CncService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.lang.reflect.Field;


/**
 * Created by CodeGenerator on 2020/05/14.
 */
@Service
@Transactional
public class CncServiceImpl extends AbstractService<Cnc> implements CncService {

       @Resource
       private MongoTemplate mongoTemplate;


       private Cnc cnc;

       @Override
       public void deleteById(String id) {
            /**
             * mongoTemplate.remove  没有 _id 报错
             * mongoTemplate.findAllAndRemove();对应的实体类的就需要有_id属性
             * mongoTemplate.findAndRemove();对应的实体类的不是必须有_id属性
             **/
             Query query = new Query(Criteria.where("cncId").is(id));
             mongoTemplate.findAndRemove(query,Cnc.class);
       }

       @Override
       public void update(Cnc cnc) {
              Query query = new Query(Criteria.where("cncId").is(cnc.getCncId()));
              Update update = new Update();
              for (Field field : cnc.getClass().getDeclaredFields()){
                    //设置可以获取私人属性
                    field.setAccessible(true);
                    try {
                    //属性名
                        String key =field.getName();
                        //属性值
                        Object value=  field.get(cnc);
                        update.set(key,value);
                    } catch (IllegalAccessException e) {
                         e.printStackTrace();
                    }
              }
              mongoTemplate.updateFirst(query,update,Cnc.class);
       }

       @Override
       public Cnc findById(String id) {
            Query query = new Query(Criteria.where("cncId").is(id));
            return mongoTemplate.findOne(query,Cnc.class);
       }

}
