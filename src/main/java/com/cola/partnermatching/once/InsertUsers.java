package com.cola.partnermatching.once;

import ch.qos.logback.core.util.FixedDelay;
import com.cola.partnermatching.mapper.UserMapper;
import com.cola.partnermatching.model.entity.User;
import com.cola.partnermatching.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author Maobohe
 * @createData 2024/2/9 15:36
 */
@Component
@Slf4j
public class InsertUsers {

    @Resource
    private UserService userService;

    /**
     * 批量插入用户
     */
//    @Scheduled(initialDelay = 5000, fixedRate = Long.MAX_VALUE)
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        int batchSize = 5000;
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < INSERT_NUM/batchSize; i++) {
            List<User> userList = new ArrayList<>();
            do {
                j++;
                User user = getUser();
                userList.add(user);
            } while (j % batchSize != 0);
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                log.info("threadName: "+Thread.currentThread().getName());
                userService.saveBatch(userList, batchSize);
            });
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        stopWatch.stop();
        log.info(String.valueOf(stopWatch.getTotalTimeMillis()));
    }

    @NotNull
    private static User getUser() {
        User user = new User();
        user.setUsername("假用户");
        user.setUserAccount("test_maobohe");
        user.setAvatarUrl("https://img2.baidu.com/it/u=2716851229,81878229&fm=253&fmt=auto&app=138&f=JPEG?w=300&h=300");
        user.setGender(0);
        user.setUserPassword("12345678");
        user.setTags("[]");
        user.setPhone("12345678");
        user.setEmail("12345678@qq.com");
        user.setUserStatus(0);
        user.setUserRole(0);
        user.setProfile("测试用户，不想写简介");
        user.setUserPassword("12362358");
        user.setUserRole(0);
        return user;
    }
}
