package com.gourddoll.blog.service.impl;

import com.gourddoll.blog.constants.Constants;
import com.gourddoll.blog.entity.Blog;
import com.gourddoll.blog.entity.Tag;
import com.gourddoll.blog.repository.BlogRepository;
import com.gourddoll.blog.service.BlogService;
import com.gourddoll.blog.service.TagService;
import com.gourddoll.blog.util.HtmlSpirit;
import com.gourddoll.blog.util.TimeUtil;
import com.gourddoll.blog.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @Description:
* @Author:  wuliang
* @Date:  2020/4/23   21:22
*/
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private TagService tagService;
    int pageNumber=1;
    int status=Constants.YES;
    //第一页的页码0
    int page=(pageNumber - 1) * Constants.defaultPageSize;
    //每页的数量
    //通过创建时间数降序排列
    Pageable pageable;



    //************************************************查找所有博客************************************************
    //
    @Override
    public List<Blog> findTopBlogList(int page, int size) {
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "grade");
        Page<Blog> readTopBlogPage = blogRepository.findAllByStatus(status,pageable);
        List<Blog> topBlogList = readTopBlogPage.getContent();
        topBlogList.forEach(blog -> {
            String BlogSummary = HtmlSpirit.delHTMLTag(blog.getContent());
            blog.setSummary(BlogSummary.length() > 100 ? BlogSummary.substring(0, 100) : BlogSummary);
        });
        return  topBlogList;
    }

    //查找最新博客
    @Override
    @Cacheable(value = "blog", key = "#page")
    public List<Blog> findBlogList(int page, int size) {
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createTime");
        Page<Blog> newestBlogPage = blogRepository.findAllByStatus(Constants.YES, pageable);
        List<Blog> newestBlogList = newestBlogPage.getContent();
        return newestBlogList;
    }

    //查找阅读量高的博客
    @Override
    public List<Blog> findBlogReadTop(int page, int size) {
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "readTimes");
        Page<Blog> readTopBlogPage = blogRepository.findAllByStatus(status,pageable);
        List<Blog> readTopBlogList = readTopBlogPage.getContent();
        return  readTopBlogList;

    }

    //查找推荐博客
    @Override
    public Page<Blog> findCommendBlogList(int commend, int page , int size) {
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createTime");
        Page<Blog> commendBlogPage= blogRepository.findAllByCommendAndStatus(commend,status,pageable);
        return commendBlogPage;
    }



    //***************************************************************根据username查找博客*************************************************

    //根据博客等级排序
    @Override
    public List<Blog> findTopBlogListByUsername(int start, int size,String username) {
        pageable = PageRequest.of(start, size, Sort.Direction.DESC, "grade");
        Page<Blog> readTopBlogPage = blogRepository.findAllByStatusAndAuthor(status,pageable,username);
        List<Blog> topBlogList = readTopBlogPage.getContent();
        return  topBlogList;
    }


    @Override
    public List<Blog> findBlogListByUsername(int start, int size, String username) {
        pageable = PageRequest.of(start, size, Sort.Direction.DESC, "createTime");
        Page<Blog> blogByUsernamePage= blogRepository.findAllByStatusAndAuthor(status,pageable,username);
        List<Blog> blogByUsernameList = blogByUsernamePage.getContent();
        return blogByUsernameList;
    }

    @Override
    public List<Blog> findBlogReadTopByUsername(int start, int size, String username) {
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "readTop");
        Page<Blog> readTopBlogPage = blogRepository.findAllByStatusAndAuthor(status,pageable,username);
        List<Blog> readTopBlogList = readTopBlogPage.getContent();
        return  readTopBlogList;
    }

    @Override
    public Page<Blog> findCommendBlogListByUsername(int commend, int start, int size, String username) {
        pageable = PageRequest.of(start, size, Sort.Direction.DESC, "createTime");
        Page<Blog> commendBlogByUsernamePage= blogRepository.findAllByCommendAndStatusAndAuthor(commend,status,pageable,username);
        return commendBlogByUsernamePage;
    }

    @Override
    public Blog findBlogByBlogId(Long BlogId) {
        return null;
    }

    @Override
    public Page<Blog> findBlogByUsernameAndCategoryName(String username, String categoryName, int start, int size) {
        //通过创建时间数降序排列
        pageable = PageRequest.of(start, size, Sort.Direction.DESC, "createTime");
        Page<Blog> blogPage=blogRepository.findAllByAuthorAndCategoryName(username,categoryName,pageable);
        return blogPage;
    }

    @Override
    public Page<Blog> findBlogByUsername(String username, int start, int size) {
        //通过创建时间数降序排列
        pageable = PageRequest.of(start, size, Sort.Direction.DESC, "createTime");
        Page<Blog> blogPage=blogRepository.findAllByAuthor(username,pageable);
        return blogPage;
    }

    @Override
    public void deleteBlog(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public void saveOrUpdateBlog(Blog blog) {
        List<String> tagNameList=blog.getTagNameList();
        List<Tag> tagList = new ArrayList<>();
        String summary;
        if (tagNameList!=null){
            for (int i=0;i<tagNameList.size();i++){
                Tag tag=tagService.findTagByTagName(tagNameList.get(i));
                tagList.add(tag);
            }
        }
        blog.setTagList(tagList);
        //截取summary
        if (blog.content.length()>20){
            summary=blog.content.substring(1,20);
        }else {
            summary=blog.content;
        }
        blog.setSummary(summary);
        //直接申明与new的区别?
        //TimeUtil timeUtil=new TimeUtil();通过类成员访问静态属性？
        String nowTime= TimeUtil.getTimestamp();
        //为null则是添加，初始化创建时间，否则不初始化
        if (blog.getBlogId()==null) {
            blog.setStatus(1);
            blog.setCreateTime(nowTime);
            blog.setUpdateTime(nowTime);
        }else {
            blog.setUpdateTime(nowTime);
            Blog olderBlog=blogRepository.findAllByBlogId(blog.getBlogId());
            System.out.println(blog.content);
            //将前端传来的不为空参数(也即是要修改值)copy覆盖原始对象属性值，1覆盖2的对应字段
            UpdateUtil.copyNullProperties(blog,olderBlog);
            blog=olderBlog;
            System.out.println(blog.content);
        }
        //不会自动忽略null的字段，自定义工具类，将null的字段用原来的值覆盖
        blogRepository.save(blog);
    }

}
