package com.moli.admin.web.rest;

import com.moli.admin.common.Result;
import com.moli.admin.domain.moli.SmsOrderUnicom;
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

    private static final String ssss = "8615641001015,8618641034030,8615640060567,8618640394981,8613019359835,8618640444401,8613130229403,8615524511279,8613190239209,8613050320132,8618525532579,8615541170917,8618512416201,8615641285666,8618642162950,8618641201205,8613050421116,8618640121288,8618604158896,8613009278904,8613042436323,8613284193951,8618525440017,8615524589068,8613050812863,8613188483453,8615641693433,8618540140802,8618624051656,8618624493279,8618641092549,8618640996058,8615541146171,8613164526237,8613050812863,8615566230226,8617616663725,8613042650542,8615609845509,8615641409819,8613166764278,8613066559310,8613214259405,8615542103651,8613050908420,8615641366662,8613236628219,8615541651899,8615541430129,8615566875958,8613134198880,8615524104417,8613188337687,8618641605000,8615668976180,8618642663266,8618624425167,8615566194523,8613066527355,8613166776899,8613050218810,8613149841542,8615566055633,8615604272898,8613124103299,8613028244997,8613019310339,8613084175777,8613104257556,8613190024321,8613072417781,8613234036922,8613252796805,8617640210827,8613188293719,8615640456127,8615640643678,8615640123855,8615642156934,8613030781108,8617615000104,8615541431499,8615542302070,8613284185006,8615542302070,8613080760113,8615502416011,8613204222850,8613042665100,8613130829119,8615524402410,8615641331529,8615668912654,8615541627583,8615640595029,8615694228969,8615541342380,8615541599631,8613188552522,8615642898444,8618524509510,8613081700209,8613188017343,8615566054311,8615566050203,8613147822339,8618524721680,8615542465250,8613166613099,8618540036408,8613166771289,8615566564844,8615542190302,8613050405242,8615542993379,8615698877285,8613065440116,8617604146935,8613082269969,8613188080644,8613050832530,8613009369932,8615541244712,8613081280206,8613020360329,8613130419999,8618502450709,8615541300477,8613154219815,8617640094492,8615668973079,8615566048530,8613109871156,8613188311332,8615542703095,8615542143045,8618524464410,8613050398575,8613130575909,8613166601314,8613188648116,8613149851121,8615524943832,8615668590098,8615640643621,8613164547674,8618524639520,8615566377858,8615524254994,8615542122500,8617640212063,8613066521432,8613190328908,8617640640851,8613188373843,8613052793234,8618524669794,8618504261798,8613008200895,8613125411261,8615541512567,8615566082169,8613130829399,8613234023316,8617641520316,8613238296083,8615642439496,8613009390627,8613081201537,8615524485589,8618640396788";

    @GetMapping("do")
    public Result execute(){
        LOGGER.info(">>>>>>>>my logger");
        findDiff();
        return Result.SUCCESS;
    }


    private void findDiff(){

        //String filePaht = "/Users/gary/Desktop/result.txt";
        String fileLogPaht = "/Users/gary/Desktop/result_logs.txt";
        //File inFile = new File(filePaht);
        File inFile = new File(fileLogPaht);
        String outFilePath = "/Users/gary/Desktop/result_final.txt";
        String outFilenNullPath = "/Users/gary/Desktop/result_final_null.txt";
        String outFilenNotTDPath = "/Users/gary/Desktop/result_final_notTD.txt";
        String outFileConPath = "/Users/gary/Desktop/result_final_con.txt";
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
                    System.out.println("line " + line + ": " + tempString);
                    line++;
                    if (StringUtils.isBlank(tempString)) continue;
                    //String[] ss = tempString.split("\t");
                    String[] ss = tempString.split(",");
                    String mobile = ss[2].trim().substring(2,13);
                    String con = ss[10].trim();
                    SmsOrderUnicom order = moliOrderService.queryByMobile(mobile);
                    StringBuffer sb = new StringBuffer();
                    sb.append(tempString).append("\n");
//                    if (null == order) {
////                        if (!con.startsWith("TD")) {
////                            FileUtil.writeFile(outFilenNotTDPaht, sb.toString());
////                        }
//                        FileUtil.writeFile(outFilenNullPath, sb.toString());
//                        //map.put(mobile, sb.toString());
//                        continue;
//                    }
//                    if (!order.getContent().trim().equals(con)){
////                        FileUtil.writeFile(outFilePaht, sb.toString());
//                        map.put(mobile, sb.toString());
//                    } else {
//                        map.remove(mobile);
//                    }
                    if (ssss.contains(mobile)) {
                        line22++;
                        FileUtil.writeFile(outFileConPath, sb.toString());
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
