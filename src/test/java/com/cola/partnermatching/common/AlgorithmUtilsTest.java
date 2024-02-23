package com.cola.partnermatching.common;

import com.cola.partnermatching.model.entity.User;
import com.cola.partnermatching.service.UserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


/**
 * @author Maobohe
 * @createData 2024/2/22 17:28
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AlgorithmUtilsTest {

    @Resource
    private UserService userService;

    @Test
    public void test() {
        List<String> user1 = Arrays.asList("java", "c++", "大三", "男");
        List<String> user2 = Arrays.asList("java", "c++", "大一", "男");
        List<String> user3 = Arrays.asList("java", "python", "大一", "女");
        List<String> user4 = Arrays.asList();
        int result1 = AlgorithmUtils.minDistance(user1, user2);
        int result2 = AlgorithmUtils.minDistance(user1, user3);
        int result3 = AlgorithmUtils.minDistance(user1, user4);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
    @Test
    public void test2() {
        User user1 = userService.getById(2);
        User user2 = userService.getById(3);
        String tag1 = user1.getTags();
        String tag2 = user2.getTags();
        Gson gson = new Gson();
        List<String> tags1 = gson.fromJson(tag1, new TypeToken<List<String>>() {
        }.getType());
        List<String> tags2 = gson.fromJson(tag2, new TypeToken<List<String>>() {
        }.getType());
        int result1 = AlgorithmUtils.minDistance(tags1, tags2);
        System.out.println(tag1);
        System.out.println(tag2);
        System.out.println(result1);
    }
}