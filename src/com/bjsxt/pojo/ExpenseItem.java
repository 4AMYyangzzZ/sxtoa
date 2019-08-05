package com.bjsxt.pojo;

/**
 *  `ITEMID` int(10) NOT NULL AUTO_INCREMENT,
 `EXPID` int(10) DEFAULT NULL,
 `TYPE` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
 `AMOUNT` double(7,2) DEFAULT NULL,
 `ITEMDESC` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
 */
public class ExpenseItem {
    private int itemId;
    private int expId;
    private String type;
    private double amount;
    private String itemDesc;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    @Override
    public String toString() {
        return "ExpenseItem{" +
                "itemId=" + itemId +
                ", expId=" + expId +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", itemDesc='" + itemDesc + '\'' +
                '}';
    }
}
