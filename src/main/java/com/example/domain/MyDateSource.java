package com.example.domain;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

//  定义数据模型封装ymal对应的数据
// 定义为spring管控的bean
@Component
// 指定加载数据
// 也可以直接使用在第三方bean绑定数据上
@ConfigurationProperties(prefix = "datasource")
// 开启对当前bean的属性注入校验
@Validated
public class MyDateSource {
    private String driver;
    private String url;
    private String username;
    private String password;

    @DurationUnit(ChronoUnit.MILLIS)
    private Duration duration;
    @DataSizeUnit(DataUnit.KILOBYTES)
    private DataSize dataSize;
    // 设置具体的规则
    @Max(value = 8888, message = "最大值不能超过8888")
    @Min(value = 202, message = "最小值不能小于202")
    private int port;

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public DataSize getDataSize() {
        return dataSize;
    }

    public void setDataSize(DataSize dataSize) {
        this.dataSize = dataSize;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DateSource{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
