package com.cola.partnermatching.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cola.partnermatching.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.cola.partnermatching.contant.UserConstant.ADMIN_ROLE;
import static com.cola.partnermatching.contant.UserConstant.USER_LOGIN_STATE;

/**
 * 用户服务
 *
 * @author cola
 * @createDate 2024-01-23 19:49:52
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账号
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    /**
     * 用户登录
     *
     * @param userAccount  用户账号
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    User doLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    int userLogout(HttpServletRequest request);

    /**
     * 根据标签搜索用户
     *
     * @param tagNameList
     * @return
     */
    List<User> searchUserByTags(List<String> tagNameList);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(User user, User loginUser);

    /**
     * 获取当前登录用户信息
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 判断是否为管理员
     * @param request
     * @return
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 判断是否为管理员
     * @param user
     * @return
     */
    boolean isAdmin(User user);

    /**
     * 获取推荐用户信息
     * @param pageSize
     * @param pageNum
     * @param loginUserId
     * @return
     */
    Page<User> recommend(long pageSize, long pageNum, long loginUserId);
}
