package org.maraz.component;

public class Payload {
    private String desc;
    private Double amount;

    public Payload(String desc, Double amount) {
        this.desc = desc;
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "desc='" + desc + '\'' +
                ", amount=" + amount +
                '}';
    }
}
