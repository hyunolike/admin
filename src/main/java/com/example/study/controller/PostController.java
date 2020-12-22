package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //주소가 겹치는건 method 단위 이다. 클래스는 2가지 겹쳐도 상관이 없다.
public class PostController {

//    HTML <Form>
//    ajax 검색(검색 파라미터가 많다는 의미)
//    http post body -> data
//    json, xml, multipart-form/ text-plain

//    @RequestMapping(method = RequestMethod.POST, path = "postMethod") 아래와 동일하다
    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {
        return searchParam;
    }

//    REST API 에서는 아래처럼 PUT,PATCH에다 주소를 할당하지 않는다
//    @PutMapping("/putMethod")
//    public void put(){
//
//    }
//    @PatchMapping("/patchMethod")
//    public void patch(){
//
//    }
}
