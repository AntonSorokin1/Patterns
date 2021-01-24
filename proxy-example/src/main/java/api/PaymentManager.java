package api;

import entity.PaymentSource;

public class PaymentManager {
    private final PaymentSource paymentSource;

    public PaymentManager(PaymentSource paymentSource) {
        this.paymentSource = paymentSource;
    }

    public PaymentSource getPaymentSource() {
        return paymentSource;
    }

    public String buySomething(Integer price) {
        return paymentSource.pay(price);
    }
}
