package com.ujiuye.core;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

/**
 * @Author 44213
 * @Date 2019/12/30 11:05
 * @Version 1.0
 */
public class TestFreemarker {
    public static void main(String[] args) throws Exception{
        // 1 创建模板引擎
        Configuration conf = new Configuration();

        //2 加载模板所在路径位置
        conf.setDirectoryForTemplateLoading(new File("E:\\ideaProject\\freemarkerDemo\\src\\main\\resources\\ftl"));
        //3加载模板对象
        Template template = conf.getTemplate("test.ftl");
        //4模拟假数据    将这些数据放入到模板中
        Map<String, Object> rootMap = new HashMap<String,Object>();
        rootMap.put("name","张三");
        rootMap.put("message","这是一个freemarker生成的静态页面");
        // 模拟List集合数据
        List<String> personList =  new ArrayList<String>();
        personList.add("青龙");
        personList.add("白虎");
        personList.add("老牛");
        personList.add("龙头");
        rootMap.put("personList",personList);


        //  模拟Map集合数据
        Map<String, String> personMap = new HashMap<>();
        personMap.put("001","韦小宝");
        personMap.put("002","双儿");
        personMap.put("003","阿珂");
        personMap.put("004","建宁");
        personMap.put("005","龙儿");
        personMap.put("006","曾柔");
        rootMap.put("personMap",personMap);

        rootMap.put("today",new Date());
        rootMap.put("point",882168988);
        // 5 创建io流 流中指定文件输出位置和文件名
        Writer out = new FileWriter(new File("E:\\ideaProject\\freemarkerDemo\\src\\main\\java\\admin\\hhh.html"));
        // 6生成
        template.process(rootMap,out);
        // 7关流
        out.close();
    }
}
