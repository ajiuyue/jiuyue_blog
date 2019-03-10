package com.jiuyue.blog.controller;
import com.jiuyue.blog.pojo.dto.ContentDto;
import com.jiuyue.blog.pojo.vo.ContentVo;
import com.jiuyue.blog.service.ContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 博客展示
 */
@Controller()
public class IndexController{

    @Autowired
    private ContentsService contentsService;
    @GetMapping(value ="")
    public String index(){
        return "themes/default/page";
    }

    @RequestMapping("/index")
    public String articleList2(Model model,
                              @RequestParam(value = "curPage",required = false,defaultValue ="1") Integer curPage){

        //每页展示10条数据
        int pageSize = 5;
        //总数
        int totalRows = contentsService.getArticleByTotal();
        //计算分页
        int totalPages = totalRows / pageSize;
        //可能有余页
        int left = totalRows % pageSize;
        if (left > 0){
            totalPages = totalPages + 1;
        }

        if (curPage < 1 ){
            curPage = 1;
        }

        if (curPage > totalPages ){
            curPage = totalPages;
        }
        //计算查询的开始行

        int startRow = (curPage - 1) * pageSize;
        Map<String,Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("startRow",startRow);
        paramMap.put("pageSize",pageSize);
        paramMap.put("curPage",curPage);//第几页
        List<ContentVo> contentDtoList = contentsService.getArticleByPageWithBlogsContainCategory(paramMap);

        model.addAttribute("contentDtoList",contentDtoList);
        model.addAttribute("curPage",curPage);
        model.addAttribute("totalPages",totalPages);
        return "themes/default/page";
    }

//    @RequestMapping("/index/test")
//    public String articleList(Model model,
//                              @RequestParam(value = "curPage",required = false,defaultValue ="1") Integer curPage){
//
//        //每页展示10条数据
//        int pageSize = 5;
//        //总数
//        int totalRows = contentsService.getArticleByTotal();
//        //计算分页
//        int totalPages = totalRows / pageSize;
//        //可能有余页
//        int left = totalRows % pageSize;
//        if (left > 0){
//            totalPages = totalPages + 1;
//        }
//
//        if (curPage < 1 ){
//            curPage = 1;
//        }
//
//        if (curPage > totalPages ){
//            curPage = totalPages;
//        }
//        //计算查询的开始行
//
//        int startRow = (curPage - 1) * pageSize;
//        Map<String,Object> paramMap = new ConcurrentHashMap<>();
//        paramMap.put("startRow",startRow);
//        paramMap.put("pageSize",pageSize);
//        paramMap.put("curPage",curPage);//第几页
//        List<ContentDto> contentDtoList = contentsService.getArticleByPageWithBlogs(paramMap);
//        model.addAttribute("contentDtoList",contentDtoList);
//        model.addAttribute("curPage",curPage);
//        model.addAttribute("totalPages",totalPages);
//        return "themes/default/page";
//    }
    @GetMapping("/article/{cid}/preview")
    public String articlePreview(Model model,
                                 @PathVariable("cid") Integer id) {
        System.out.println("preview");
        model.addAttribute("article",contentsService.getArticleByIdWithBlogsContainCategory(id));
        return "themes/default/post";


    }


}
