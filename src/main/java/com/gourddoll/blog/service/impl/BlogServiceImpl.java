package com.gourddoll.blog.service.impl;

import com.gourddoll.blog.constants.Constants;
import com.gourddoll.blog.entity.Blog;
import com.gourddoll.blog.repository.BlogRepository;
import com.gourddoll.blog.service.BlogService;
import com.gourddoll.blog.util.HtmlSpirit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    int pageNumber=1;
    int commend=Constants.YES;
    int status=Constants.YES;
    int page=(pageNumber - 1) * Constants.defaultPageSize;
    int size=Constants.defaultPageSize;
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
        newestBlogList.forEach(blog2 -> {
        });

        return newestBlogList;
    }

    //查找阅读量高的博客
    @Override
    public List<Blog> findBlogReadTop(int page, int size) {
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "readTimes");//通过阅读量降序排列
        Page<Blog> readTopBlogPage = blogRepository.findAllByStatus(status,pageable);
        List<Blog> readTopBlogList = readTopBlogPage.getContent();//每一页博客的数量
        readTopBlogList.forEach(blog3 -> {
        });
        return  readTopBlogList;

    }

    //查找推荐博客
    @Override
    public List<Blog> findCommendBlogList(int commend,int page ,int size) {
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createTime");//通过创建时间数降序排列
        Page<Blog> commendBlogPage= blogRepository.findAllByCommendAndStatus(commend,status,pageable);
        List<Blog> commendBlogList = commendBlogPage.getContent();//每一页博客的数量
        commendBlogList.forEach(blog -> {
            String BlogSummary = HtmlSpirit.delHTMLTag(blog.getContent());
            blog.setSummary(BlogSummary.length() > 100 ? BlogSummary.substring(0, 100) : BlogSummary);
        });
        return commendBlogList;
    }



    //***************************************************************根据username查找博客*************************************************

    //根据博客等级排序
    @Override
    public List<Blog> findTopBlogListByUsername(String username) {
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "grade");
        Page<Blog> readTopBlogPage = blogRepository.findAllByStatusAndAuthor(status,pageable,username);
        List<Blog> topBlogList = readTopBlogPage.getContent();//每一页博客的数量
        topBlogList.forEach(blog -> {
            String BlogSummary = HtmlSpirit.delHTMLTag(blog.getContent());
            blog.setSummary(BlogSummary.length() > 100 ? BlogSummary.substring(0, 100) : BlogSummary);
        });
        return  topBlogList;
    }


    @Override
    public List<Blog> findBlogListByUsername(int page, int size, String username) {
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createTime");
        Page<Blog> blogByUsernamePage= blogRepository.findAllByStatusAndAuthor(status,pageable,username);
        List<Blog> blogByUsernameList = blogByUsernamePage.getContent();//每一页博客的数量
        blogByUsernameList.forEach(blog -> {
            String BlogSummary = HtmlSpirit.delHTMLTag(blog.getContent());
            blog.setSummary(BlogSummary.length() > 100 ? BlogSummary.substring(0, 100) : BlogSummary);
        });
        return blogByUsernameList;
    }

    @Override
    public List<Blog> findBlogReadTopByUsername(int page, int size, String username) {
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "readTop");//通过阅读量降序排列
        Page<Blog> readTopBlogPage = blogRepository.findAllByStatusAndAuthor(status,pageable,username);
        List<Blog> readTopBlogList = readTopBlogPage.getContent();//每一页博客的数量
        readTopBlogList.forEach(blog -> {
            String BlogSummary = HtmlSpirit.delHTMLTag(blog.getContent());
            blog.setSummary(BlogSummary.length() > 100 ? BlogSummary.substring(0, 100) : BlogSummary);
        });
        return  readTopBlogList;
    }

    @Override
    public List<Blog> findCommendBlogListByUsername(int commend, int page, int size, String username) {
        pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createTime");//通过创建时间数降序排列
        Page<Blog> commendBlogByUsernamePage= blogRepository.findAllByCommendAndStatusAndAuthor(commend,status,pageable,username);
        List<Blog> commendBlogByUsernameList = commendBlogByUsernamePage.getContent();//每一页博客的数量
        commendBlogByUsernameList.forEach(blog -> {
            String BlogSummary = HtmlSpirit.delHTMLTag(blog.getContent());
            blog.setSummary(BlogSummary.length() > 100 ? BlogSummary.substring(0, 100) : BlogSummary);
        });
        return commendBlogByUsernameList;
    }

    @Override
    public Blog findBlogByBlogId(Long BlogId) {
        return null;
    }

    @Override
    public void saveBlog(Blog Blog) {

    }
}
