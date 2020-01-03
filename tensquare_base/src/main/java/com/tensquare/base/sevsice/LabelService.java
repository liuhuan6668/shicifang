package com.tensquare.base.sevsice;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuhuan
 * @date 2019-08-19
 */
@Service
@Transactional
public class LabelService {

    @Autowired
    private LabelDao labelDao;
    @Autowired
    public IdWorker idWorker;

    public List<Label> findAll(){
        return labelDao.findAll();
    }

    public  Label findById(String id){
        return labelDao.findById(id).get();
    }

    public void  save(Label label){
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    public void update(Label label){
        labelDao.save(label);
    }

    public void deleteById(String id){
       labelDao.deleteById(id);
    }


    public List<Label> findSearch(Label label) {
        //带条件的
       return labelDao.findAll(new Specification<Label>() {
           /**
            *
            * @param root 要把条件分装到那个对象中 where  类名=label.getid
            * @param query 分装的都是查询关键字,,group by orderby
            * @param cb 用来分装条件对象
            * @return
            */
           @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
               ArrayList<Predicate> list = new ArrayList<>();
               if(label.getLabelname() != null && !"".equals(label.getLabelname())){
                   Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                   list.add(predicate);
               }
               if(label.getState() != null && label.getState().equals("")){
                   Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState());
                   list.add(predicate);
               }
               //做为最终的返回值条件
               Predicate[] pre = new Predicate[list.size()];
               //集合转为数组
               pre = list.toArray(pre);

               return cb.and(pre);
            }
        });
    }

    public Page<Label> pageQuery(Label label, int page, int size) {
        //分页对象
        Pageable pageable = PageRequest.of(page-1,size);
        return labelDao.findAll(new Specification<Label>() {
            /**
             *
             * @param root 要把条件分装到那个对象中 where  类名=label.getid
             * @param query 分装的都是查询关键字,,group by orderby
             * @param cb 用来分装条件对象
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                ArrayList<Predicate> list = new ArrayList<>();
                if(label.getLabelname() != null && !"".equals(label.getLabelname())){
                    Predicate predicate = cb.like(root.get("labelname").as(String.class), "%" + label.getLabelname() + "%");
                    list.add(predicate);
                }
                if(label.getState() != null && label.getState().equals("")){
                    Predicate predicate = cb.equal(root.get("state").as(String.class), label.getState());
                    list.add(predicate);
                }
                //做为最终的返回值条件
                Predicate[] pre = new Predicate[list.size()];
                //集合转为数组
                pre = list.toArray(pre);

                return cb.and(pre);
            }
        },pageable);

    }
}
