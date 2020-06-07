package com.gourddoll.service.impl;

import com.gourddoll.entity.Tag;
import com.gourddoll.mapper.TagMapper;
import com.gourddoll.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
