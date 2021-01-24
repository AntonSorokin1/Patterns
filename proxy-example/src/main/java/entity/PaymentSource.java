package entity;

public interface PaymentSource {
    String pay(Integer value);

    Integer getMoney();

    void setMoney(Integer value);

    boolean isEnoughMoney(Integer value);
}
