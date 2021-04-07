package com.company.carservice;

import java.io.Serializable;
import java.util.Objects;

public class ListingKey implements Serializable {

    private String dealerId;

    private String code;

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListingKey that = (ListingKey) o;
        return dealerId.equals(that.dealerId) && code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dealerId, code);
    }
}
