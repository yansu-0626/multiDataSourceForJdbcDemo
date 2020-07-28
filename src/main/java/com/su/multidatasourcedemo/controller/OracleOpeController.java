package com.su.multidatasourcedemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName OracleOpeController
 * @Description TODO
 * @Author yansu
 * @Date 2020/7/21 下午 4:08
 * @Version 1.0
 **/
@RequestMapping("/oracle")
@RestController
public class OracleOpeController {

    @Autowired
    private JdbcTemplate secondaryJdbcTemplate;

    @GetMapping("/query")
    public Map<String, Object> query() {
        String sql = "SELECT b.trandate, sum( b.tranamt ) AS 票据业务发生额 FROM cms.b_wf_voumng b WHERE b.vousource = '028' AND b.trandate >= '2020-07-18' AND b.trandate <= '2020-07-18' AND b.transtatus = '09' AND b.busicode <> '288' GROUP BY b.trandate";
        System.out.println(secondaryJdbcTemplate);
        //       执行sql语句
//        Map<String, Object> maps = jdbcTemplate.queryForList(sql);
        Map<String, Object> map = secondaryJdbcTemplate.queryForMap(sql);
        System.out.println("执行完成");
        return map;
    }
}
