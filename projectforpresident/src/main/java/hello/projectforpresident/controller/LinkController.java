package hello.projectforpresident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkController {

    @GetMapping("redirect-to-sch")
    public String redirectToSch(){
        return "redirect:https://www.sch.ac.kr";
    }

    @GetMapping("redirect-to-portal")
    public String redirectToPortal(){

        return "redirect:https://portal.sch.ac.kr/p/index.jsp";
    }

    @GetMapping("redirect-to-study")
    public String redirectToStudy(){
        return "redirect:https://cyber.sch.ac.kr";
    }


    @GetMapping("redirect-to-zoom")
    public String redirectToZoom(){
        return "redirect:https://eclass.sch.ac.kr/pages/5e660d3cb2ab2411084ac8b3";
    }

    @GetMapping("redirect-to-lms")
    public String redirectToLms(){
        return "redirect:https://eclass.sch.ac.kr/boards/5e2110140584830a497a4895/posts";
    }
    @GetMapping("redirect-to-contents")
    public String redirectToContents(){
        return "redirect:https://eclass.sch.ac.kr/pages/5e660c357cf0cf6f83621104";
    }

}
