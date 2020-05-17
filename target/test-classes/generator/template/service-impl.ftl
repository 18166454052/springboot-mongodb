package ${basePackage}.service.impl;

import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import ${basePackage}.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.lang.reflect.Field;


/**
 * Created by ${author} on ${date}.
 */
@Service
@Transactional
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {

       @Resource
       private MongoTemplate mongoTemplate;


       private ${modelNameUpperCamel} ${modelNameLowerCamel};

       @Override
       public void deleteById(String id) {
            /**
             * mongoTemplate.remove  没有 _id 报错
             * mongoTemplate.findAllAndRemove();对应的实体类的就需要有_id属性
             * mongoTemplate.findAndRemove();对应的实体类的不是必须有_id属性
             **/
             Query query = new Query(Criteria.where("cncId").is(id));
             mongoTemplate.findAndRemove(query,${modelNameUpperCamel}.class);
       }

       @Override
       public void update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
              Query query = new Query(Criteria.where("cncId").is(${modelNameLowerCamel}.getId()));
              Update update = new Update();
              for (Field field : ${modelNameLowerCamel}.getClass().getDeclaredFields()){
                    //设置可以获取私人属性
                    field.setAccessible(true);
                    try {
                    //属性名
                        String key =field.getName();
                        //属性值
                        Object value=  field.get(${modelNameLowerCamel});
                        update.set(key,value);
                    } catch (IllegalAccessException e) {
                         e.printStackTrace();
                    }
              }
              mongoTemplate.updateFirst(query,update,${modelNameUpperCamel}.class);
       }

        @Override
        public ${modelNameUpperCamel} findById(String id) {
                   Query query = new Query(Criteria.where("cncId").is(id));
                   return mongoTemplate.findOne(query,${modelNameUpperCamel}.class);
        }
}
