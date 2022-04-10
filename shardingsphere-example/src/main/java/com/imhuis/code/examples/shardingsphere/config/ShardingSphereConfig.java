package com.imhuis.code.examples.shardingsphere.config;

import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.config.RuleConfiguration;
import org.apache.shardingsphere.infra.config.mode.ModeConfiguration;
import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;


/**
 * @author: imhuis
 * @date: 2022/4/10
 * @description:
 */
@Configuration
public class ShardingSphereConfig {

    @Autowired
    @Qualifier("oneDataSource")
    private DataSource ds1;

    @Autowired
    @Qualifier("twoDataSource")
    private DataSource ds2;

    DataSource shardingDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();

//        Collection<ShardingTableRuleConfiguration> tables = new ArrayList<>();
//        tables.add(getOrderTableRuleConfiguration());
        shardingRuleConfig.getTables().add(orderTableRuleConfiguration());

        Collection<RuleConfiguration> ruleConfigurations = new ArrayList<>();
        // 添加分表规则
        ruleConfigurations.add(shardingRuleConfig);

        ModeConfiguration modeConfiguration = new ModeConfiguration("Memory", null, false);
        return ShardingSphereDataSourceFactory
                .createDataSource(modeConfiguration, dataSourceMap(), ruleConfigurations, new Properties());
    }

    ShardingTableRuleConfiguration orderTableRuleConfiguration() {
        ShardingTableRuleConfiguration rule = new ShardingTableRuleConfiguration("t_order", "ds${0..1}.t_order${0..1}");
        return rule;
    }

    Map<String, DataSource> dataSourceMap() {
        Map<String, DataSource> result = new HashMap<>();
//        result.put("ds0", DataSourceUtil.createDataSource("ds0"));
//        result.put("ds1", DataSourceUtil.createDataSource("ds1"));
        result.put("ds0", ds1);
        result.put("ds1", ds2);
        return result;
    }

}
