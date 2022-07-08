package life.majiang.community.controller;


import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.User;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;      //注入userMapper

    @Autowired
    private QuestionService QuestionService;
    @GetMapping("/")
    public  String index(HttpServletRequest request,        //引入request
                         Model model){
        Cookie[] cookies = request.getCookies();        //从request中获取cookie
        if(cookies==null){                              //处理空指针异常
            return "index" ;
        }
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);      //初建时对findByToken用alt+insert在usermapper中创建方法
                if (user !=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        List<QuestionDTO> questionList = QuestionService.list();
        model.addAttribute("question",questionList);
        return "index";
    }
}
