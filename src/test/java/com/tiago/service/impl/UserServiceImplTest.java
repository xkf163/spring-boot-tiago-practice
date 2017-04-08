package com.tiago.service.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.tiago.domain.QUser;
import com.tiago.domain.User;
import com.tiago.repository.UserRepository;
import com.tiago.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by F on 2017/4/8.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private JPAQueryFactory jpaQueryFactory;


    @PostConstruct
    public void init(){
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Test
    public void findByNameAndAddress() throws Exception {

        List<User> users = userService.findByNameAndAddress("tiago","朝晖九区");
        System.out.println("找到的user的数量"+users.size());

    }

    @Test
    public void findDistinctByAddress() throws Exception {
        List<User> users = userService.findDistinctByAddress("朝晖九区");
        System.out.println("找到的user的数量"+users.size());
    }

    @Test
    public void findByNameIgnoreCase() throws Exception {
//        List<User> users = userService.findByNameIgnoreCase("Tiago");
          QUser user = QUser.user;
//        Object users = userRepository.findAll(user.name.eq("tiago"));
//        System.out.println("找到的user的数量"+users.toString());
//

        List<User> users = jpaQueryFactory.selectFrom(user).where(user.name.eq("tiago")).fetch();
        System.out.println("找到的user的数量"+users.get(0).getAddress());

    }

    @Test
    public void findByNameAndAddressAllIgnoreCase() throws Exception {
    }

    @Test
    public void findByNameOrderByIdDesc() throws Exception {
    }

    @Test
    public void findByName() throws Exception {
    }

}