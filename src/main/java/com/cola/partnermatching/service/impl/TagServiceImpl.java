package com.cola.partnermatching.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cola.partnermatching.model.entity.Tag;
import com.cola.partnermatching.service.TagService;
import com.cola.partnermatching.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author cola
* @description 针对表【tag(标签)】的数据库操作Service实现
* @createDate 2024-01-29 19:13:09
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




