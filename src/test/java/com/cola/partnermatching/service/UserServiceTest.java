package com.cola.partnermatching.service;

import com.cola.partnermatching.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


/**
 * 用户服务测试
 *
 * @author Maobohe
 * @createData 2024/1/29 20:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testSearchUserByTags() {
        List<String> list = Arrays.asList("java", "python");
        List<User> userList = userService.searchUserByTags(list);
        Assert.assertNotNull(userList);
        System.out.println(userList);
    }
}