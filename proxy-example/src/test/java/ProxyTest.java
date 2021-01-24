import api.PaymentManager;
import entity.Card;
import entity.PaymentSource;
import entity.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProxyTest {
    @Test
    void checkPaymentSpeed() {
        PaymentSource wallet = new Wallet(100);
        PaymentSource card = new Card(wallet);

        PaymentManager walletManager = new PaymentManager(wallet);
        PaymentManager cardManager = new PaymentManager(card);

        long startTime = System.currentTimeMillis();
        walletManager.buySomething(10);
        long walletTime = System.currentTimeMillis() - startTime;

        startTime = System.currentTimeMillis();
        cardManager.buySomething(10);
        long cardTime = System.currentTimeMillis() - startTime;

        Assertions.assertTrue(walletTime > cardTime);
    }
}
