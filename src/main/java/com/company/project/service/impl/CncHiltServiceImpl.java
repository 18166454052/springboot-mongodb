package com.company.project.service.impl;

import com.company.project.model.CncHilt;
import com.company.project.service.CncHiltService;
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
 * Created by CodeGenerator on 2020/05/15.
 */
@Service
@Transactional
public class CncHiltServiceImpl extends AbstractService<CncHilt> implements CncHiltService {

       @Resource
       private MongoTemplate mongoTemplate;


       private CncHilt cncHilt;

       @Override
       public void deleteById(String id) {
            /**
             * mongoTemplate.remove  没有 _id 报错
             * mongoTemplate.findAllAndRemove();对应的实体类的就需要有_id属性
             * mongoTemplate.findAndRemove();对应的实体类的不是必须有_id属性
             **/
             Query query = new Query(Criteria.where("hiltId").is(id));
             mongoTemplate.findAndRemove(query,CncHilt.class);
       }

       @Override
       public void update(CncHilt cncHilt) {
              Query query = new Query(Criteria.where("hiltId").is(cncHilt.getHiltId()));
              Update update = new Update();
              for (Field field : cncHilt.getClass().getDeclaredFields()){
                    //设置可以获取私人属性
                    field.setAccessible(true);
                    try {
                    //属性名
                        String key =field.getName();
                        //属性值
                        Object value=  field.get(cncHilt);
                        update.set(key,value);
                    } catch (IllegalAccessException e) {
                         e.printStackTrace();
                    }
              }
              mongoTemplate.updateFirst(query,update,CncHilt.class);
       }

        @Override
        public CncHilt findById(String id) {
                   Query query = new Query(Criteria.where("hiltId").is(id));
                   return mongoTemplate.findOne(query,CncHilt.class);
        }
}
