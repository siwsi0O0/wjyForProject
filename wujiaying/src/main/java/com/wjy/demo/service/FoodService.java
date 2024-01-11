package com.wjy.demo.Services;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujiaying
 * @date 2024年01月10日 10:43
 */

@Service
public class FoodService {

    /***
     * @author wujiaying
     * @date 2024年01月10日 10:43
     * @return date list
     * @throws IOException
     */

    public List<List<String>> getFoodList() throws IOException {
        List<List<String>> data=new ArrayList<>();

        File file = ResourceUtils.getFile("classpath:static\\Mobile_Food_Facility_Permit.csv");
        String path = file.getAbsolutePath();

        FileReader fr=new FileReader(path);

        CSVParser parser = new CSVParser(fr, CSVFormat.DEFAULT);
        for(CSVRecord record:parser){
            List<String> lineData=new ArrayList<>();
            for(int i=0;i<record.size();i++){
                lineData.add(record.get(i));
            }
            data.add(lineData);
        }

        return data;
    }

}
