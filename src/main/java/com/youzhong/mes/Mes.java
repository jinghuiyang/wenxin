package com.youzhong.mes;

import java.io.Serializable;
import java.math.BigDecimal;

public class Mes  implements Serializable{
    private String openid;
    private Integer sum;
    private BigDecimal price;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mes{" +
                "openid='" + openid + '\'' +
                ", sum=" + sum +
                ", price=" + price +
                '}';
    }
}
