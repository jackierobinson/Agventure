package tff.agventure;

import java.io.Serializable;
import java.math.BigDecimal;

public class Price implements Serializable{
    private String mCategory;
    private BigDecimal mAmount;

    public Price(String category, BigDecimal amount){
        mCategory = category;
        mAmount = amount;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
    }

    public BigDecimal getAmount() {
        return mAmount;
    }

    public void setAmount(BigDecimal amount) {
        mAmount = amount;
    }
}
