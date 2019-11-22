package cn.dzy.manage.boss.manage.utils;

import net.sf.json.JSONObject;

import java.io.*;

public class ReadJsonFile {
    /**
     * 读取json文件，返回json串
     * @param fileName
     * @return
     */
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
        }
        fileReader.close();
        reader.close();
        jsonStr = sb.toString();
        return jsonStr;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
        }
    }

    public static void main(String[] args) {
        String path = "area.json";
        String s = readJsonFile(path);
        JSONObject jsonObject = JSONObject.fromObject(s);
        System.out.println("jsonObject = " + jsonObject);
    }

}
