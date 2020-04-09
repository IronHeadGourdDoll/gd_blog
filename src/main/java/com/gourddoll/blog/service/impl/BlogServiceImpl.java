package com.gourddoll.blog.service.impl;

import com.gourddoll.blog.constants.Constants;
import com.gourddoll.blog.entity.Blog;
import com.gourddoll.blog.entity.Tag;
import com.gourddoll.blog.repository.BlogRepository;
import com.gourddoll.blog.service.BlogService;
import com.gourddoll.blog.service.TagService;
import com.gourddoll.blog.util.HtmlSpirit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private TagService tagService;
    int pageNumber=1;
    int commend=Constants.YES;
    int status=Constants.YES;
    int page=(pageNumber - 1) * Constants.defaultPageSize;//第一页的页码0
    int size=Constants.defaultPageSize;//每页的数量
    Pageable pageable;//通过创建时间数降序排列

    //************************************************查找所有博客************************************************
    //
    @Override
    public List<Blog> findTopBlogList(int page, int size) {
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "grade");//通过阅读量降序排列
        Page<Blog> readTopBlogPage = blogRepository.findAllByStatus(status,pageable);
        List<Blog> topBlogList = readTopBlogPage.getContent();//每一页博客的数量
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
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createTime");//通过创建时间数降序排列
        Page<Blog> newestBlogPage = blogRepository.findAllByStatus(Constants.YES, pageable);
        List<Blog> newestBlogList = newestBlogPage.getContent();//每一页博客的数量
        return newestBlogList;
    }

    //查找阅读量高的博客
    @Override
    public List<Blog> findBlogReadTop(int page, int size) {
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "readTimes");//通过阅读量降序排列
        Page<Blog> readTopBlogPage = blogRepository.findAllByStatus(status,pageable);
        List<Blog> readTopBlogList = readTopBlogPage.getContent();//每一页博客的数量
        return  readTopBlogList;

    }

    //查找推荐博客
    @Override
    public Page<Blog> findCommendBlogList(int commend, int page , int size) {
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createTime");//通过创建时间数降序排列
        Page<Blog> commendBlogPage= blogRepository.findAllByCommendAndStatus(commend,status,pageable);
        return commendBlogPage;
    }



    //***************************************************************根据username查找博客*************************************************

    //根据博客等级排序
    @Override
    public List<Blog> findTopBlogListByUsername(int start, int size,String username) {
        pageable = PageRequest.of(start, size, Sort.Direction.DESC, "grade");
        Page<Blog> readTopBlogPage = blogRepository.findAllByStatusAndAuthor(status,pageable,username);
        List<Blog> topBlogList = readTopBlogPage.getContent();//每一页博客的数量
        return  topBlogList;
    }


    @Override
    public List<Blog> findBlogListByUsername(int start, int size, String username) {
        pageable = PageRequest.of(start, size, Sort.Direction.DESC, "createTime");
        Page<Blog> blogByUsernamePage= blogRepository.findAllByStatusAndAuthor(status,pageable,username);
        List<Blog> blogByUsernameList = blogByUsernamePage.getContent();//每一页博客的数量
        return blogByUsernameList;
    }

    @Override
    public List<Blog> findBlogReadTopByUsername(int start, int size, String username) {
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "readTop");//通过阅读量降序排列
        Page<Blog> readTopBlogPage = blogRepository.findAllByStatusAndAuthor(status,pageable,username);
        List<Blog> readTopBlogList = readTopBlogPage.getContent();//每一页博客的数量
        return  readTopBlogList;
    }

    @Override
    public Page<Blog> findCommendBlogListByUsername(int commend, int start, int size, String username) {
        pageable = PageRequest.of(start, size, Sort.Direction.DESC, "createTime");//通过创建时间数降序排列
        Page<Blog> commendBlogByUsernamePage= blogRepository.findAllByCommendAndStatusAndAuthor(commend,status,pageable,username);
        return commendBlogByUsernamePage;
    }

    @Override
    public Blog findBlogByBlogId(Long BlogId) {
        return null;
    }

    @Override
    public Page<Blog> findBlogByUsernameAndCategoryName(String username, String categoryName, int start, int size) {
        pageable = PageRequest.of(start, size, Sort.Direction.DESC, "createTime");//通过创建时间数降序排列
        Page<Blog> blogPage=blogRepository.findAllByAuthorAndCategoryName(username,categoryName,pageable);
        return blogPage;
    }

    @Override
    public Page<Blog> findBlogByUsername(String username, int start, int size) {
        pageable = PageRequest.of(start, size, Sort.Direction.DESC, "createTime");//通过创建时间数降序排列
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
        //为null则是添加，初始化创建时间，否则不初始化
        if (blog.getBlogId()==null) {
            blog.setCreateTime(new Date());
            blog.setHeaderImg("image");
        }
        blog.setStatus(1);
        if (blog.content.length()>20){
            summary=blog.content.substring(1,20);
        }else {
            summary=blog.content;
        }
        blog.setSummary(summary);
        blog.setUpdateTime(new Date());
        blogRepository.save(blog);
    }

}
