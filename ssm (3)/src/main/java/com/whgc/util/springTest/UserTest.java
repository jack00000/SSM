package com.whgc.util.springTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.whgc.mapper.PaperMapper;
import com.whgc.pojo.Paper;  
  
public class UserTest extends BaseJunit4Test{  
    @Autowired //自动注入  
    private  PaperMapper paperMapper;  
      
    @Test  
    @Transactional   //标明此方法需使用事务    
    @Rollback(false)  //标明使用完此方法后事务不回滚,true时为回滚   
    public  void main(){  
        System.out.println("测试Spring整合Junit4进行单元测试");  
        Paper user = paperMapper.get(1);
        System.out.println(user);
        System.out.println("------------"+user.getContent());
    }
}  