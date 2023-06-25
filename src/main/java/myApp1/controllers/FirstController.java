package myApp1.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

//    @GetMapping("/hello")
//    public String helloPage(HttpServletRequest request){
//        String name= request.getParameter("name");
//        String surname= request.getParameter("surname");
//        System.out.println("hello "+name+" "+ surname);
//
//        return "first/hello";
        @GetMapping("/hello")
        public String helloPage(@RequestParam(value="name", required=false) String name,
                                @RequestParam(value="surname",required=false) String surname,
                                Model model){

            model.addAttribute("message","hello "+name+" "+ surname);

            //System.out.println("hello "+name+" "+ surname);

            return "first/hello";

    }

    @GetMapping("/calculator")
    public String helloPage(@RequestParam(value="a", required=false) int a,
                            @RequestParam(value="b",required=false) int  b,
                            @RequestParam(value="action",required=false) String action,
                            Model model) {
            int c=0;
            if(action.equals("multiplication")){
                c=a*b;
            }
            else if (action.equals("addition")){
                c=a+b;
            }
        else if(action.equals("subtraction")){
            c=a-b;
        }
       else if (action.equals("division")){
            c=a/b;
        }


        model.addAttribute("calculate", String.valueOf(c));

        //System.out.println("hello "+name+" "+ surname);

        return "first/calculator";
    }
    @GetMapping("/goodbye")
    public String goodByePage(){
     return  "first/goodbye";

    }
}
