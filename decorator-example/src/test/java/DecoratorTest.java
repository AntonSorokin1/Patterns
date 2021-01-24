import api.BaseDecorator;
import api.CommonNotifier;
import api.Notifier;
import api.decoratos.FacebookDecorator;
import api.decoratos.SMSDecorator;
import api.decoratos.VKDecorator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class DecoratorTest {
    private static final String COMMON_NOTIFIER_MESSAGE = "You was notified!\n";
    private static final String VK_NOTIFIER_MESSAGE = "It's VK notify!\n";
    private static final String SMS_NOTIFIER_MESSAGE = "It's SMS notify!\n";
    private static final String FACEBOOK_NOTIFIER_MESSAGE = "It's facebook notify!\n";

    @Test
    void commonNotifyCheck() {
        Notifier notifier = new CommonNotifier();
        Assertions.assertEquals(COMMON_NOTIFIER_MESSAGE, notifier.notifyMe());
    }

    @ParameterizedTest
    @MethodSource("decoratorNotifyCheckData")
    void decoratorNotifyCheck(List<Class<? extends BaseDecorator>> decorators, String expected)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Notifier notifier = new CommonNotifier();
        expected = COMMON_NOTIFIER_MESSAGE + ((expected == null) ? "" : expected);
        if (decorators != null) {
            for (Class<? extends BaseDecorator> decorator : decorators) {
                if (decorator == null) continue;
                notifier = decorator.getConstructor(Notifier.class).newInstance(notifier);
            }
        }
        Assertions.assertEquals(expected, notifier.notifyMe());
    }

    public static Stream<Arguments> decoratorNotifyCheckData() {
        return Stream.of(
                Arguments.arguments(
                        Arrays.asList(VKDecorator.class, SMSDecorator.class),
                        VK_NOTIFIER_MESSAGE + SMS_NOTIFIER_MESSAGE
                ),
                Arguments.arguments(Collections.singletonList(FacebookDecorator.class), FACEBOOK_NOTIFIER_MESSAGE),
                Arguments.arguments(null, null),
                Arguments.arguments(Arrays.asList(null, null), null)
        );
    }
}
