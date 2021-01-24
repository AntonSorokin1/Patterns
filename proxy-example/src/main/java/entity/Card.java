package entity;

public class Card implements PaymentSource {
    private final PaymentSource wallet;

    public Card(PaymentSource wallet) {
        this.wallet = wallet;
    }

    public PaymentSource getWallet() {
        return wallet;
    }

    @Override
    public Integer getMoney() {
        return wallet.getMoney();
    }

    @Override
    public void setMoney(Integer value) {
        wallet.setMoney(value);
    }

    @Override
    public boolean isEnoughMoney(Integer value) {
        return wallet.getMoney() >= value;
    }

    @Override
    public String pay(Integer value) {
        if (isEnoughMoney(value)) {
            wallet.setMoney(wallet.getMoney() - value);
            return "Purchase of " + value + " paid by card";
        }
        return "Not enough money!";
    }
}
