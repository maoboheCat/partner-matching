package com.cola.partnermatching.contant;

/**
 * @author Maobohe
 * @createData 2024/2/16 13:20
 */
public interface RedisConstant {

    /**
     * 系统名
     */
    String REDIS_SYSTEM_NAME = "partnerMatching";

    /**
     *  用户推荐功能一次性缓存任务 -- 任务锁
     */
    String REDIS_JOB_DOCACHE = String.format("%s:precahcejob:docache:lock", REDIS_SYSTEM_NAME);

    /**
     * 推荐用户功能 -- 业务锁
     */
    String REDIS_USER_RECOMMEND = String.format( "%s:user:recommend", REDIS_SYSTEM_NAME);

    /**
     * 添加队伍功能 -- 业务锁
     */
    String REDIS_USER_ADDTEAM = String.format("%s:user:addTeam", REDIS_SYSTEM_NAME);

    /**
     * 加入队伍功能 -- 业务锁
     */
    String REDIS_USER_JOINTEAM = String.format("%s:user:joinTeam", REDIS_SYSTEM_NAME);
}
