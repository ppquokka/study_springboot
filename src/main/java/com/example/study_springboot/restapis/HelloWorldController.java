// 얘가 틀이다!!!
package com.example.study_springboot.restapis;


import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.study_springboot.service.HelloWorldService;

@Controller
public class HelloWorldController {
    @Autowired
    HelloWorldService helloWorldService;

    @GetMapping("/helloWorld") // 얘가 doGet이가. @cap을 씌우면 됨.
    public int helloWorld() {
        return 0;
    }

    // servlet이 던지는 방식: /helloWorldGetRequest?Name=yojulab&Id=U-01
    // 앱이 들어감: /helloWorldGetRequest/yojulab/U-01
    @GetMapping("/helloWorldGetRequest/{name}/{Id}")   // 한 class에 여러 method  
    public int helloWorldGetRequest(@PathVariable String name, @PathVariable String Id){
        return 0;
    }

    // ?serviceKey=J4Y5Bcj7mhszMW4MDyelTWhhul%2Fd%2BPZuzkXe7IcgX4UHTNa%2FzyEFPoH5MuuXsJRa2joCSvhgv%2BfVRCinUjFQEg%3D%3D&currentPage=1&perPage=10&SN=1
    // currentPage:1
    // perPage:10
    // SN:1
    @GetMapping("/helloWorldResponse/{currentPage}/{perPage}/{SN}")   // 한 class에 여러 method  
    public ResponseEntity<Object> helloWorldResponse(@PathVariable String currentPage
                        , @PathVariable String perPage, @PathVariable String SN){
        // "spm_row": 471,
        //     "SN": 1,
        //     "CMPNM": "로이유통",
        //     "RDNMADR": null                   
        HashMap resultMap = new HashMap<>();   //DB에서 가져오는 부분
        resultMap.put("spm_row", 471);
        resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");
        resultMap.put("RDNMADR", null);

        return ResponseEntity.ok().body(resultMap);   // 리턴이 된다는 소리는 ok. "2"는 정상이라는 의미.
    }

    //   /helloWorldResponseList/1/10/1
    @GetMapping("/helloWorldResponseList/{currentPage}/{perPage}/{SN}")   
    public ResponseEntity<Object> helloWorldResponseList(@PathVariable String currentPage
                        , @PathVariable String perPage, @PathVariable String SN){  
        // "spm_row": 471, "SN": 1, "CMPNM": "로이유통", "RDNMADR": null     line1
        // "spm_row": 571, "SN": 2, "CMPNM": "의료유통", "RDNMADR": 3        line2
        // 실제로는 어떻게 받아질까?
        ArrayList arrayList = new ArrayList<>();                       
        HashMap resultMap = new HashMap<>();  
        resultMap.put("spm_row", 471);            resultMap.put("SN", 1);
        resultMap.put("CMPNM", "로이유통");        resultMap.put("RDNMADR", null);
        arrayList.add(resultMap);

        resultMap = new HashMap<>();  
        resultMap.put("spm_row", 571);            resultMap.put("SN", 2);
        resultMap.put("CMPNM", "의료유통");        resultMap.put("RDNMADR", 3);
        arrayList.add(resultMap);

        return ResponseEntity.ok().body(arrayList);  
    }


    // controller를 단계별로 class를 옮겨보자!
    //  /helloWorldResponseWithService/1/10/1
    @GetMapping("/helloWorldResponseWithService/{currentPage}/{perPage}/{SN}")   
    public ResponseEntity<Object> helloWorldResponseWithService(@PathVariable String currentPage
                        , @PathVariable String perPage, @PathVariable String SN){  
        // "spm_row": 471, "SN": 1, "CMPNM": "로이유통", "RDNMADR": null     line1
        // "spm_row": 571, "SN": 2, "CMPNM": "의료유통", "RDNMADR": 3        line2
        // 실제로는 어떻게 받아질까?
        ArrayList arrayList = new ArrayList<>();                       
        // HelloWorldService helloWorldService = new HelloWorldService();
        arrayList = helloWorldService.fakeSelect(currentPage, perPage);   // 리턴값 받아내기 위해 arraylist넣어줌

        return ResponseEntity.ok().body(arrayList);  
    }

     //  /helloWorldResponseFake/C001
     @GetMapping("/helloWorldResponseFake/{companyId}")   
    public ResponseEntity<Object> helloWorldResponseFake(@PathVariable String companyId){  
        ArrayList arrayList = new ArrayList<>();          
        // arrayList = 
        helloWorldService.fakeSelect(companyId); 

        return ResponseEntity.ok().body(arrayList);  
    }
}

