package com.cola.partnermatching.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cola.partnermatching.model.entity.User;
import com.cola.partnermatching.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 缓存预热任务
 * @author Maobohe
 * @createData 2024/2/13 14:44
 */
@Component
@Slf4j
public class PreCacheJob {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private final List<Long> mianUserList = Arrays.asList(1L, 2L);

    @Scheduled(cron = "0 0 4 * * *")
    public void doCacheRecommendUser() {
        for (Long userId : mianUserList) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            Page<User> userPage = userService.page(new Page<>(1, 20), queryWrapper);
            List<User> results = userPage.getRecords().stream().map(user -> userService.getSafetyUser(user)).collect(Collectors.toList());
            userPage.setRecords(results);
            String redisKey = String.format("partnerMatching:user:recommend:%s", userId);
            ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
            try {
                valueOperations.set(redisKey, userPage, 1, TimeUnit.MINUTES);
            } catch (Exception e) {
                log.error("redis set key error", e);
            }
        }
    }
}
