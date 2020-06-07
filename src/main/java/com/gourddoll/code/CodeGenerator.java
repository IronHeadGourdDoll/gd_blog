package com.gourddoll.code;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    // 当前项目路径
    private static final String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        GlobalConfig gc = initGlobalConfig();
        DataSourceConfig dsc = initDataSourceConfig();
        PackageConfig pc = initPackageConfig();
        InjectionConfig cfg = initInjectionConfig(pc);
        TemplateConfig templateConfig = initTemplateConfig();
        StrategyConfig strategy = initStrategyConfig();

        mpg.setGlobalConfig(gc);
        mpg.setDataSource(dsc);
        mpg.setPackageInfo(pc);
        mpg.setCfg(cfg);
        mpg.setTemplate(templateConfig);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.setStrategy(strategy);

        // todo
        // gc.setFileOverride(false);
        // gc.setAuthor("Jack");
        // c.setParent("com.catt.mybatis.plus.generator");
        // pc.setModuleName("sample");
        //strategy.setInclude("t_province", "t_city");

        mpg.execute();
    }

    // 全局配置
    private static GlobalConfig initGlobalConfig() {
        GlobalConfig gc = new GlobalConfig();
        // 生成文件的输出目录【默认 D 盘根目录】
        gc.setOutputDir(PROJECT_PATH + "/src/main/java/");
        // 是否覆盖已有文件
        gc.setFileOverride(true);
        // 开发人员
        gc.setAuthor("wuliang");
        // 是否打开输出目录
        gc.setOpen(false);
        // 开启 swagger2 模式
        gc.setSwagger2(true);
        // 开启 ActiveRecord 模式 : ActiveRecord 同时负责把自己持久化，在 ActiveRecord 中封装了对数据库的访问，即 CURD
        gc.setActiveRecord(true);
        // 开启 通用查询映射结果
        gc.setBaseResultMap(true);
        // 开启 通用查询结果列
        // gc.setBaseColumnList(true);
        // 各层文件名称方式，例如： %sAction 生成 UserAction
        gc.setServiceName("%sService");
        return gc;
    }

    // todo 数据源配置
    private static DataSourceConfig initDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/gd_blog?characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        return dsc;
    }

    // todo 包配置,生成的代码存放路径
    private static PackageConfig initPackageConfig() {
        PackageConfig pc = new PackageConfig();
        // 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setParent("com.gourddoll");
        return pc;
    }

    // 自定义配置
    private static InjectionConfig initInjectionConfig(PackageConfig pc) {
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 自定义输出配置，自定义配置会被优先输出
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义xml文件输出路径 eg： /src/main/resources/mapper/CityMapper.xml
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                StringBuilder xmlPath = new StringBuilder();
                xmlPath.append(PROJECT_PATH).append("/src/main/resources/mybatisPlus/mapper/");
                if (ObjectUtils.isNotEmpty(pc.getModuleName())) {
                    xmlPath.append(pc.getModuleName()).append("/");
                }
                xmlPath.append(tableInfo.getEntityName()).append("Mapper").append(StringPool.DOT_XML);
                return xmlPath.toString();
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    // 模板配置
    private static TemplateConfig initTemplateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setEntity("templates/entity.java");
        templateConfig.setMapper("templates/mapper.java");
        // %sMapper.xml 文件默认会生成在 %sMapper.java 文件所在目录下的 xml目录里，这里为了自定义输出路径，屏蔽xml模板
        templateConfig.setXml(null);
        return templateConfig;
    }

    // todo 策略配置
    private static StrategyConfig initStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        // 数据库表映射到实体的命名策略 : 下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 数据库表映射到实体的命名策略,未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 表前缀
        strategy.setTablePrefix("T_,V_".split(","));
        // 字段前缀
        strategy.setFieldPrefix("I_,S_,D_".split(","));
        // 是否生成字段常量
        strategy.setEntityColumnConstant(true);
        // 是否为lombok模型
        strategy.setEntityLombokModel(true);
        // 生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        // 是否生成实体时，生成字段注解
        strategy.setEntityTableFieldAnnotationEnable(true);
        return strategy;
    }
}
