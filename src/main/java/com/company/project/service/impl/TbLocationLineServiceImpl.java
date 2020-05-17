package com.company.project.service.impl;

import com.company.project.model.TbLocationLine;
import com.company.project.service.TbLocationLineService;
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
public class TbLocationLineServiceImpl extends AbstractService<TbLocationLine> implements TbLocationLineService {

       @Resource
       private MongoTemplate mongoTemplate;


       private TbLocationLine tbLocationLine;

       @Override
       public void deleteById(String id) {
            /**
             * mongoTemplate.remove  没有 _id 报错
             * mongoTemplate.findAllAndRemove();对应的实体类的就需要有_id属性
             * mongoTemplate.findAndRemove();对应的实体类的不是必须有_id属性
             **/
             Query query = new Query(Criteria.where("lineId").is(id));
             mongoTemplate.findAndRemove(query,TbLocationLine.class);
       }

       @Override
       public void update(TbLocationLine tbLocationLine) {
              Query query = new Query(Criteria.where("lineId").is(tbLocationLine.getLineId()));
              Update update = new Update();
              for (Field field : tbLocationLine.getClass().getDeclaredFields()){
                    //设置可以获取私人属性
                    field.setAccessible(true);
                    try {
                    //属性名
                        String key =field.getName();
                        //属性值
                        Object value=  field.get(tbLocationLine);
                        update.set(key,value);
                    } catch (IllegalAccessException e) {
                         e.printStackTrace();
                    }
              }
              mongoTemplate.updateFirst(query,update,TbLocationLine.class);
       }

        @Override
        public TbLocationLine findById(String id) {
                   Query query = new Query(Criteria.where("lineId").is(id));
                   return mongoTemplate.findOne(query,TbLocationLine.class);
        }
}
