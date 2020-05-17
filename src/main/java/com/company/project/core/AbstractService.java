package com.company.project.core;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 基于通用MyBatis Mapper插件的Service接口的实现
 */
public abstract class AbstractService<T> implements Service<T> {

//    @Autowired
//    protected Mapper<T> mapper;
    @Resource
    private MongoTemplate mongoTemplate;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

    public AbstractService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public void save(T model) {
        mongoTemplate.save(model);
    }

    public void save(List<T> models) {
        mongoTemplate.save(models);
    }

//    public void deleteById(Integer id) {
//        /**
//         * mongoTemplate.remove  没有 _id 报错
//         * mongoTemplate.findAllAndRemove();对应的实体类的就需要有_id属性
//         * mongoTemplate.findAndRemove();对应的实体类的不是必须有_id属性
//        **/
//
//    }

//    public T findById(String id) {
//        Query query = new Query(Criteria.where("id").is(id));
//        return mongoTemplate.findOne(query,modelClass);
//    }

    public void update(T model) {
//        Query query = new Query(Criteria.where("id").is("11"));
//        Set<String> set = model.keySet();
//        Update update = new Update();
//        for (String key : set) {
//            String value = model.getString(key);
//            update.set(key,value);
//        }
//        try {
//            mongoTemplate.updateFirst(query, update, DemoCollection.class);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        mongoTemplate.updateFirst(query,update,DemoCollection.class);

    }


//
//    public void deleteByIds(String ids) {
//        mapper.deleteByIds(ids);
//    }
//
//    public void update(T model) {
//        mapper.updateByPrimaryKeySelective(model);
//    }
//
//    public T findById(Integer id) {
//        return mapper.selectByPrimaryKey(id);
//    }
//
//    @Override
//    public T findBy(String fieldName, Object value) throws TooManyResultsException {
//        try {
//            T model = modelClass.newInstance();
//            Field field = modelClass.getDeclaredField(fieldName);
//            field.setAccessible(true);
//            field.set(model, value);
//            return mapper.selectOne(model);
//        } catch (ReflectiveOperationException e) {
//            throw new ServiceException(e.getMessage(), e);
//        }
//    }
//
//    public List<T> findByIds(String ids) {
//        return mapper.selectByIds(ids);
//    }
//
//    public List<T> findByCondition(Condition condition) {
//        return mapper.selectByCondition(condition);
//    }
//
    public List<T> findAll() {
        return mongoTemplate.findAll(modelClass);
    }
}
