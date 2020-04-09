package com.gourddoll.blog.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {
//    Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);
//    @Autowired
//    private WebsiteAccessService websiteAccessService;
//    @Autowired
//    private TagService tagService;
//    @Autowired
//    private LinkService linkService;
//    @Autowired
//    private WebsiteConfigService websiteConfigService;
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//                           ModelAndView modelAndView) throws Exception {
//        if (modelAndView != null) {
//            ModelMap modelMap = modelAndView.getModelMap();
//            logger.info("正在更新网站访问次数。");
//            WebsiteAccess websiteAccess = websiteAccessService.getByAccessDateIs(new Date());
//            websiteAccess.setAccessCount(websiteAccess.getAccessCount() + 1);
//            websiteAccessService.save(websiteAccess);
//            logger.info("加入底部数据。");
//            //标签列表
//            modelMap.addAttribute("tagList", tagService.findAll());
//            //友情链接列表
//            modelMap.addAttribute("linkList", linkService.findAllByIsEnable());
//            //友情链接列表
//            modelMap.addAttribute("websiteConfig", websiteConfigService.findWebsiteConfig());
//        }
//    }
}
