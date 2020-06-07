package com.gourddoll.service.impl;

import com.gourddoll.entity.Menu;
import com.gourddoll.mapper.MenuMapper;
import com.gourddoll.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限菜单表 服务实现类
 * </p>
 *
 * @author wuliang
 * @since 2020-06-05
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
