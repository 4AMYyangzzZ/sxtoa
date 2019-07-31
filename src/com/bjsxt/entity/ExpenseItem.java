package com.bjsxt.entity;

public class ExpenseItem {
    private int itemId;
    private int expId;
    private String type;
    private double amount;
    private String itemDesc;

    public ExpenseItem() {
    }

    public ExpenseItem(String type, double amount, String itemDesc) {
        this.type = type;
        this.amount = amount;
        this.itemDesc = itemDesc;
    }

    public ExpenseItem(int itemId, int expId, String type, double amount, String itemDesc) {
        this.itemId = itemId;
        this.expId = expId;
        this.type = type;
        this.amount = amount;
        this.itemDesc = itemDesc;
    }

    public ExpenseItem(int expId, String type, double amount, String itemDesc) {
        this.expId = expId;
        this.type = type;
        this.amount = amount;
        this.itemDesc = itemDesc;
    }

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
