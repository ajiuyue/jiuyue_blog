package com.jiuyue.blog.controller;


import com.jiuyue.blog.constant.ResponseEnum;
import com.jiuyue.blog.constant.WebConst;
import com.jiuyue.blog.pojo.dto.CategoryDto;
import com.jiuyue.blog.pojo.dto.ContentDto;
import com.jiuyue.blog.pojo.model.Categories;
import com.jiuyue.blog.pojo.model.Contents;
import com.jiuyue.blog.pojo.vo.ContentVo;
import com.jiuyue.blog.pojo.vo.ResponseVO;
import com.jiuyue.blog.service.CategotiesService;
import com.jiuyue.blog.service.ContentsService;
import com.jiuyue.blog.utils.web.ResponseVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * article
 */
@Controller
@RequestMapping("/admin/article")
public class ArticleController{
    @Autowired
    private ContentsService contentsService;

    @Autowired
    private CategotiesService categotiesService;
    @RequestMapping("/publish")
    public String publishPage(Model model) {
        System.out.println("admin/article_edit");
        List<CategoryDto> categoryDtoList =  categotiesService.getCategoties();
        System.out.println("categoryDtoList:"+categoryDtoList);
        model.addAttribute("categoryDtoList",categoryDtoList);
        return "admin/article_edit";
    }

    @PostMapping(value = "/publish")
    @ResponseBody
    public ResponseVO publishArticle(ContentDto contentDto, HttpServletRequest request) {
        System.out.println("contentDto:"+contentDto);
        System.out.println("getCategoryId:"+contentDto.getCategoryId());
        String result = contentsService.publish(contentDto);
        if(!result.equals(WebConst.SUCCESS_RESULT)){
            return ResponseVOUtil.error(ResponseEnum.UNKNOWN_ERROR);
        }
        return ResponseVOUtil.success();
    }
      @RequestMapping("")
    public String articleList(Model model,
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
        List<ContentDto> contentDtoList = contentsService.getArticleByPage(paramMap);
        System.out.println("curPage:"+curPage);
        model.addAttribute("contentDtoList",contentDtoList);
        model.addAttribute("curPage",curPage);
        model.addAttribute("totalPages",totalPages);
        //跳转到模板页面
        return "admin/article_list";
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResponseVO delete(@RequestParam int cid) {
        String result = contentsService.deleteByCid(cid);
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return ResponseVOUtil.error(ResponseEnum.DELETE_FAILED);
        }
        return ResponseVOUtil.success();
    }

    @GetMapping(value = "/{cid}")
    public String editArticle(Model model,
             @PathVariable Integer cid) {
        Contents contentDtoList = contentsService.getContents(cid);
        Categories categoryDtoList =  categotiesService.getCategoty(contentDtoList.getCategoryId());
        model.addAttribute("contentDtoList",contentDtoList);
        model.addAttribute("categoryDtoList", categoryDtoList);
        return "admin/article_edit";
    }
    @PostMapping(value = "/modify")
    @ResponseBody
    public ResponseVO modifyArticle(ContentDto contentDto) {
        String result = contentsService.updateArticle(contentDto);
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return ResponseVOUtil.error(ResponseEnum.DELETE_FAILED);
        }
        return ResponseVOUtil.success();
    }

}
