package com.company.project.service.impl;

import com.company.project.model.CncTool;
import com.company.project.service.CncToolService;
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
public class CncToolServiceImpl extends AbstractService<CncTool> implements CncToolService {

       @Resource
       private MongoTemplate mongoTemplate;


       private CncTool cncTool;

       @Override
       public void deleteById(String id) {
            /**
             * mongoTemplate.remove  没有 _id 报错
             * mongoTemplate.findAllAndRemove();对应的实体类的就需要有_id属性
             * mongoTemplate.findAndRemove();对应的实体类的不是必须有_id属性
             **/
             Query query = new Query(Criteria.where("toolId").is(id));
             mongoTemplate.findAndRemove(query,CncTool.class);
       }

       @Override
       public void update(CncTool cncTool) {
              Query query = new Query(Criteria.where("toolId").is(cncTool.getToolId()));
              Update update = new Update();
              for (Field field : cncTool.getClass().getDeclaredFields()){
                    //设置可以获取私人属性
                    field.setAccessible(true);
                    try {
                    //属性名
                        String key =field.getName();
                        //属性值
                        Object value=  field.get(cncTool);
                        update.set(key,value);
                    } catch (IllegalAccessException e) {
                         e.printStackTrace();
                    }
              }
              mongoTemplate.updateFirst(query,update,CncTool.class);
       }

        @Override
        public CncTool findById(String id) {
                   Query query = new Query(Criteria.where("toolId").is(id));
                   return mongoTemplate.findOne(query,CncTool.class);
        }
}
