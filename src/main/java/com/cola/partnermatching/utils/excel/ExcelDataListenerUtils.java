package com.cola.partnermatching.utils.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.cola.partnermatching.model.entity.User;
import com.cola.partnermatching.service.UserService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Maobohe
 * @createData 2025/9/15 19:57
 *
 *
 */
@Slf4j
public class ExcelDataListenerUtils implements ReadListener<User> {

    private static final int BATCH_COUNT = 1000;

    private List<User> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

    private final UserService userService;

    public ExcelDataListenerUtils(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void invoke(User user, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", user.toString());
        cachedDataList.add(user);
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.info("所有数据解析完成！");
    }

    private void saveData() {
        if (cachedDataList.isEmpty()) {
            return;
        }
        log.info("{}条数据，开始存储数据库！", cachedDataList.size());
        userService.saveBatch(cachedDataList, BATCH_COUNT);
        log.info("存储数据库成功！");
        cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
//        log.info(cachedDataList.toString());
    }
}
