package entity;

public class Wallet implements PaymentSource {
    private Integer money;

    public Wallet(Integer money) {
        this.money = money;
    }

    @Override
    public Integer getMoney() {
        return money;
    }

    @Override
    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public boolean isEnoughMoney(Integer value) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return money >= value;
    }

    @Override
    public String pay(Integer value) {
        if (isEnoughMoney(value)) {
            this.money -= value;
            return "Purchase of " + value + " paid";
        }
        return "Not enough money!";
    }
}
