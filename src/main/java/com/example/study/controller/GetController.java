package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api") //Localhost:8080/api
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod") //Localhost:8080/api/getMethod
    public String getRequest(){

        return "Hi getMethod";
    }

    @GetMapping("getParameter") //Localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd){
        String password = "bbbb";

        System.out.println("id: "+id);
        System.out.println("pwd: "+pwd);

        return id + pwd;
    }

    //Localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    // 여러가지 파라미터를 받을 때는
    // 객체로 받을수 있다
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // public (string -> SearchParam) 으로 바꾸어준다
        // {"account":"", "email":"","page":0} json형태 데이터통신
        // 기본적으로 json 라이브러리 이용해서 자동적으로 변환된다
        return searchParam;
    }

}
