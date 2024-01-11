package com.wjy.demo.controller;

import com.wjy.demo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

/**
 * @author wujiaying
 * @date 2024年01月10日 10:43
 */

@RestController
public class FoodController {

    @Autowired
    private FoodService service;

    /***
     * @author wujiaying
     * @date 2024年01月10日 10:43
     * @param params
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/api/food",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public List<Map<String,Object>> test1(@RequestBody  String params) throws IOException {

        List<List<String>> data=new ArrayList<>();
        data= service.getFoodList();

        List<Map<String,Object>> list=new ArrayList<>();
        for(int i=1;i<data.size();i++){
            Map<String,Object> map= new HashMap<>();
            List<String> key= (List<String>) data.get(0);
            List<String> values= (List<String>) data.get(i);

            for(int j=0;j<key.size()&& j<values.size();j++){
                map.put(key.get(j),values.get(j));
            }

            list.add(map);
        }

        return list;

    }
}
