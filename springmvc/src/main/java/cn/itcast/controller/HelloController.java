package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/show1")
    public ModelAndView test1() {
        ModelAndView mv = new ModelAndView();
        //设置要显示的页面：视图
        //mv.setViewName("WEB-INF/views/hello.jsp");

        //设置视图名称：在配置文件中配置了视图的前缀和后缀，因此只要配置视图名称
        mv.setViewName("hello");

        //添加要显示的数据：数据是存在 request 域中
        mv.addObject("msg", "这是一个springmvc的第一个程序");
        return mv;
    }

    /**
     * show2?   ? 表示任意单个字符
     *
     * @return
     */
    @RequestMapping("/show2?")
    public ModelAndView test2() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "ant风格的映射：？的使用");
        return mv;
    }

    /**
     * show3*   *表示任意多个字符
     *
     * @return
     */
    @RequestMapping("/show3*")
    public ModelAndView test3() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "ant风格的映射：* 的使用");
        return mv;
    }

    @RequestMapping("**/show4")
    public ModelAndView test4() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "ant风格的映射：** 的使用");
        return mv;
    }

    @RequestMapping("show5/{name}/{userId}")
    public ModelAndView test5(@PathVariable("name") String name, @PathVariable("userId") Long userId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "Rest(占位符) 风格的映射 name = " + name + ",userId = " + userId);
        return mv;
    }

    @GetMapping("show13")
    public ModelAndView test13() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "注解限定请求参数的映射GetMapping");
        return mv;
    }

    @PostMapping("show14")
    public ModelAndView test14() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "注解限定请求参数的映射GetMapping");
        return mv;
    }

    @RequestMapping("show17")
    public String test17(Model model) {
        model.addAttribute("msg", "优化后的代码");
        return "hello";     //默认返回值为视图名称
    }
}
