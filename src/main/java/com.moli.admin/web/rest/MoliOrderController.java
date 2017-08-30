package com.moli.admin.web.rest;

import com.moli.admin.common.Result;
import com.moli.admin.service.MoliOrderService;
import com.moli.admin.utils.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gary on 17/8/26.
 */
@RestController
@RequestMapping("/moli/order")
public class MoliOrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoliOrderController.class);

    @Autowired
    private MoliOrderService moliOrderService;

    private static final String ssss = "18624463545,13252737051,13252737053,18512419261,13074161972,13019331240,15604059223,15640331541,18609887376,18624172170,18624588071,13104266631,13065320898,13029281802,18604126959,13130343441,13032463036,13188523538,13236780107,13079206818,13236881083,15524638126,13109867942,15542470299,15641464587,18641243663,18641169030,13238890241,18641944430,17640115432,18602415119";

    @GetMapping("do")
    public Result execute(){
        LOGGER.info(">>>>>>>>my logger");
        String filePaht = "/Users/gary/Desktop/result_ftp.txt";
        String outFilePath = "/Users/gary/Desktop/result_ftp_tx.txt";
        findDiff(filePaht, outFilePath);

        String filePaht1 = "/Users/gary/Desktop/result_logs.txt";
        String outFilePath1 = "/Users/gary/Desktop/result_log_tx.txt";
        findDiff(filePaht1, outFilePath1);
        return Result.SUCCESS;
    }


    private void findDiff(String filePaht, String outFilePath){

        //String fileLogPaht = "/Users/gary/Desktop/result_logs.txt";
        File inFile = new File(filePaht);
        //File inFile = new File(fileLogPaht);
        //String outFilenNullPath = "/Users/gary/Desktop/result_ftp_final_null.txt";
        Map<String, String> map = new HashMap<>();
        if (inFile.isFile()) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(inFile));
                String tempString;
                int line = 1;
                int line22 = 0;
                // 一次读入一行，直到读入null为文件结束
                while ((tempString = reader.readLine()) != null) {
                    // 显示行号
                    //System.out.println("line " + line + ": " + tempString);
                    line++;
                    if (StringUtils.isBlank(tempString)) continue;
                    String[] ss = tempString.split("\t");
                    //String[] ss = tempString.split(",");
                    String se = ss[0].trim();
                    String mobile = ss[2].trim().substring(2,13);
                    //String mobile = ss[2].trim();
                    String con = ss[10].trim();
                    //System.out.println(">>>>>> " + mobile);
//                    String tdCon = "";
//                    if (ss.length >= 15) {
//                        tdCon = ss[14].trim();
//                    }
//                    SmsOrderUnicom order = moliOrderService.queryByMobile(mobile);
                    StringBuffer sb = new StringBuffer();
                    sb.append(tempString);
//                    if (null == order) {
////                        if (!con.startsWith("TD")) {
////                            FileUtil.writeFile(outFilenNotTDPaht, sb.toString());
////                        }
//                        //FileUtil.writeFile(outFilenNullPath, sb.toString());
//                        //map.put(mobile, sb.toString());
//                        continue;
//                    }
//                    if (con.toLowerCase().startsWith("td")) {
//                        Date time = order.getUnsubscribeTime();
//                        if (null == time || !order.getContent().equals(tdCon)) {
//                            map.put(mobile, sb.append("\n").toString());
//                        }
////                        String ssssss = map.get(mobile);
////                        if (StringUtils.isNoneBlank(ssssss)) {
////                            String content = ssssss.split("\t")[10];
////                            sb.append(" ").append(content);
////                        }
//                    } else if (!order.getContent().equals(con)){
//                        map.put(mobile, sb.append("\n").toString());
//                    }
                    //map.put(mobile, sb.append("\n").toString());

//                    if (!order.getContent().trim().equals(con)){
////                        FileUtil.writeFile(outFilePaht, sb.toString());
//                        map.put(mobile, sb.toString());
//                    } else {
//                        map.remove(mobile);
//                    }
                    if (ssss.contains(mobile)) {
                        line22++;
//                        map.put(mobile, sb.toString());
                        FileUtil.writeFile(outFilePath, sb.append("\n").toString());
                    }
                }
                System.out.println(">>>>>>line 22 is " + line22);
                System.out.println(">>>>>>line count is " + line);
//                for (Map.Entry entry : map.entrySet()) {
//                    FileUtil.writeFile(outFilePath, entry.getValue().toString());
//                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e1) {
                    }
                }
            }
        }
    }
}
