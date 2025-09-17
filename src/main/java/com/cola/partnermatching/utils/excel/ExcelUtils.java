package com.cola.partnermatching.utils.excel;

import com.alibaba.excel.EasyExcel;
import com.cola.partnermatching.common.ErrorCode;
import com.cola.partnermatching.exception.BusinessException;
import com.cola.partnermatching.model.entity.User;
import com.cola.partnermatching.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Maobohe
 * @createData 2025/9/15 20:24
 *
 *
 */
@Slf4j
public class ExcelUtils {

    /**
     * 系统excel导入文件 目录
     */
    private static final String EXCEL_INPUT_DIR = "excel/input/";

    /**
     * 系统excel导出文件 目录
     */
    private static final String EXCEL_OUTPUT_DIR = "excel/output/";

    /**
     * 监听器读取
     * @param fileName
     * @param userService
     */
    public static void readUserByListener(String fileName, UserService userService) {
        String resourcePath = EXCEL_INPUT_DIR + fileName + ".xlsx";
        Resource resource = new ClassPathResource(resourcePath);
        if (!resource.exists()) {
            log.info("{} 文件不存在", resourcePath);
            return;
        }
        try {
            String filePath = resource.getFile().getAbsolutePath();
            EasyExcel.read(filePath, User.class, new ExcelDataListenerUtils(userService)).sheet().doRead();
        } catch (IOException e) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "读取文件失败");
        }
    }


    /**
     * 写 excel文件
     * 实际文件路径需要修改
     * @param users
     */
    public static void writeUserByListener(List<User> users) {
        if (CollectionUtils.isEmpty(users)) {
            return;
        }
        String fileName = users.get(0).getClass().getName();
        Path filePath = Paths.get("src", fileName + "-" + System.currentTimeMillis() + ".xlsx");
        Path parentDir = filePath.getParent();
        if (parentDir != null && !Files.exists(parentDir)) {
            try {
                Files.createDirectories(parentDir);
            } catch (IOException e) {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, "创建目录失败");
            }
        }
        EasyExcel.write(filePath.toString(), User.class).sheet(fileName).doWrite(users);
    }

}
