package com.company.project.service.impl;

import com.company.project.model.CncProduct;
import com.company.project.service.CncProductService;
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
public class CncProductServiceImpl extends AbstractService<CncProduct> implements CncProductService {

       @Resource
       private MongoTemplate mongoTemplate;


       private CncProduct cncProduct;

       @Override
       public void deleteById(String id) {
            /**
             * mongoTemplate.remove  没有 _id 报错
             * mongoTemplate.findAllAndRemove();对应的实体类的就需要有_id属性
             * mongoTemplate.findAndRemove();对应的实体类的不是必须有_id属性
             **/
             Query query = new Query(Criteria.where("productId").is(id));
             mongoTemplate.findAndRemove(query,CncProduct.class);
       }

       @Override
       public void update(CncProduct cncProduct) {
              Query query = new Query(Criteria.where("productId").is(cncProduct.getProductId()));
              Update update = new Update();
              for (Field field : cncProduct.getClass().getDeclaredFields()){
                    //设置可以获取私人属性
                    field.setAccessible(true);
                    try {
                    //属性名
                        String key =field.getName();
                        //属性值
                        Object value=  field.get(cncProduct);
                        update.set(key,value);
                    } catch (IllegalAccessException e) {
                         e.printStackTrace();
                    }
              }
              mongoTemplate.updateFirst(query,update,CncProduct.class);
       }

        @Override
        public CncProduct findById(String id) {
                   Query query = new Query(Criteria.where("productId").is(id));
                   return mongoTemplate.findOne(query,CncProduct.class);
        }
}
