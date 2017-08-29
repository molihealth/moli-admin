package com.moli.admin.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gary on 17/8/26.
 */
public class FileUtil {
    //private static final String ss = "8613082439536,8613188628530,8613052784059,8613032485392,8613190453060,8613130006541,8613147852341,8613002403945,8613080717776,8613066696371,8613190024947,8613042462796,8613124271191,8613188285207,8618512493156,8613080899663,8613081307468,8613130201811,8613052628086,8613274224613,8613164533233,8618640412548,8613166799091,8613236962699,8615641287789,8613032474150,8613020317315,8613166723998,8613008213609,8615642915136,8613081303720,8613125581285,8618641337873,8613066596420,8613019887677,8613284200809,8618624621341,8613066673450,8613065394026,8613052679911,8613130235542,8615541289235,8613130250537,8613019848907,8613234067840,8613009342969,8615541255403,8613234066747,8613009307198,8613236966844,8613029431599,8613130036468,8613050381620,8613204103587,8613029240878,8613032487817,8613009263163,8613188483426,8613130891215,8613052626764,8613194141175,8613190127310,8613204202139,8613224281126,8613134240407,8613079891771,8615642136734,8613104248802,8613188255231,8613080859827,8613052621541,8613194299697,8613238938949,8613166712471,8613065355775,8613130839135,8613224204549,8613042485205,8615566257713,8613022454621,8613130969731,8613124277750,8613190113126,8613082491552,8613284231755,8618540017127,8613008256644,8613125624000,8613238038273,8613124235049,8613274106168,8613080828237,8615642113576,8615524413412,8613166797112,8613130407551,8613190032581,8613188473037,8613050872848,8613050416449,8613194209968,8613019675589,8613130663768,8615641359942,8613190089671,8618641321945,8615566539356,8615542470299,8613252737051,8613252737053,8618641243663,8618641944430,8615566131573,8613130324173,8613072437045,8613234174642,8615541304447,8618512419261,8618640349366,8613109867942,8613234077674,8613020327526,8613238802911,8613124238430,8613050940976,8613252790781,8613082222874,8613065303987,8613074161972,8613066579949,8618641169030,8613238890241,8613019331240,8615604059223,8613104227695,8613238938517,8615641464587,8613019919917,8617612498873,8613125507385,8613130218321,8613274201856,8615541253285,8613130567913,8613190340846,8615542124647,8618524731912,8613125647075,8613028202697,8613238893876,8615641212529,8613149771739,8613236757159,8613104220691,8613188077052,8613188459626,8613082416487,8613284212697,8613234117419,8613284162729,8615640768212,8613020328062,8613065226168,8615641201656";

    public static void main(String[] args) {
//        String filePaht = "/Users/gary/Desktop/FTP文件夹";
//        File file = new File(filePaht);
//        if (file.isDirectory()) {
//            String[] fileList = file.list();
//            System.out.println(fileList.length);
//            String outFilePaht = "/Users/gary/Desktop/result.txt";
//            File inFile;
//            String fileName;
//            String content;
//            for (int i = 0; i<fileList.length; i++) {
//                if (!fileList[i].contains(".req")) continue;
//                fileName = filePaht + "/" + fileList[i];
//                System.out.println("file count is : " + i + ", file name is " + fileName);
//                inFile = new File(fileName);
//                if (inFile.isFile()) {
//                    content = readFileByLines(inFile, null);
//                    if (StringUtils.isBlank(content)) continue;
//                    writeFile(outFilePaht, content);
//                }
//            }
//        }
        Map map = new HashMap();
        map.put("233", 233);
        System.out.println(map.get("233"));

        map.put("233", 234434);

        System.out.println(map.get("233"));
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static String readFileByLines(File file, String separator) {
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer("");
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);

                if (line > 1) {

//                    String[] tmp = tempString.split("\t");
//                    String mobile = tmp[2];
//                    if (ss.contains(mobile)) {
                        sb.append(tempString).append(StringUtils.isBlank(separator) ? "\n" : separator);
//                    }
                }
                line++;
            }
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
        return sb.toString();
    }


    //    private static void writeFile(File outFile, String content){
//        BufferedOutputStream Buff=null;
//        try {
//            Buff=new BufferedOutputStream(new FileOutputStream(outFile));
//            Buff.write(content.getBytes());
//            Buff.flush();
//            Buff.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                Buff.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
    public static void writeFile(String outFile, String coutent){
        FileWriter writer = null;
        try {
            writer = new FileWriter(outFile, true);
            writer.write(coutent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
