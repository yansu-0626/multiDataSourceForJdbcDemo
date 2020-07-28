package com.su.multidatasourcedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName MysqlOpeController
 * @Description TODO
 * @Author yansu
 * @Date 2020/7/21 下午 4:08
 * @Version 1.0
 **/
@RequestMapping("/mysql")
@RestController
public class MysqlOpeController {

    @Autowired
    private JdbcTemplate primaryJdbcTemplate;

    @GetMapping("/query")
    public List<Map<String, Object>> queryAll() {
        String sql = "select * from test.user";
        System.out.println(primaryJdbcTemplate);
//       执行sql语句
        List<Map<String, Object>> maps = primaryJdbcTemplate.queryForList(sql);
        return maps;
    }

}
