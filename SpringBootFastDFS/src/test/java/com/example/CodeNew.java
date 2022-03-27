package com.example;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeNew {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://120.77.255.179:3306/fast?serverTimezone=GMT%2B8&useSSL=true",
                "root",
                "1234")
                .globalConfig(builder -> {
                    builder.author("shyheng") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\TestFastDFS\\SpringBootFastDFS\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example") // 设置父包名
                            .moduleName("fast"); // 设置父包模块名
                })
                .strategyConfig(builder -> {
                    builder.addInclude("fast"); // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
