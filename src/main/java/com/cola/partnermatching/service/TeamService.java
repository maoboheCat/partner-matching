package com.cola.partnermatching.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cola.partnermatching.model.dto.TeamQuery;
import com.cola.partnermatching.model.entity.Team;
import com.cola.partnermatching.model.entity.User;
import com.cola.partnermatching.model.request.team.TeamDeleteRequest;
import com.cola.partnermatching.model.request.team.TeamJoinRequest;
import com.cola.partnermatching.model.request.team.TeamQuitRequest;
import com.cola.partnermatching.model.request.team.TeamUpdateRequest;
import com.cola.partnermatching.model.vo.TeamUserVO;

import java.util.List;


/**
* @author cola
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2024-02-16 17:49:21
*/
public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍
     * @param teamUpdateRequest
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @param loginUser
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    /**
     * 退出队伍
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 解散队伍
     * @param teamDeleteRequest
     * @param loginUser
     * @return
     */
    boolean deleteTeam(TeamDeleteRequest teamDeleteRequest, User loginUser);
}
