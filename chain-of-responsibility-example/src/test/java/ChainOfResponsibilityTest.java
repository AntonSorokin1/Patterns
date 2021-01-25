import entity.Component;
import entity.impl.Button;
import entity.impl.Dialog;
import entity.impl.Panel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class ChainOfResponsibilityTest {
    private static Dialog dialog;
    private static Panel panel;
    private static Button vkButton;
    private static Button facebookButton;

    @BeforeAll
    static void before() {
        dialog = new Dialog();
        dialog.setAnotherHelpText("This is dialog frame");
        panel = new Panel();
        vkButton = new Button();
        vkButton.setSomeURL("https://vk.com");
        facebookButton = new Button();
        facebookButton.setSomeURL("https://facebook.com");

        panel.addChild(vkButton);
        panel.addChild(facebookButton);
        dialog.addChild(panel);
    }

    @ParameterizedTest
    @MethodSource("uiClickCheckData")
    void uiClickCheck(Component component, String expected) {
        Assertions.assertEquals(expected, component.getHelp());
    }

    public static Stream<Arguments> uiClickCheckData() {
        return Stream.of(
                Arguments.arguments(dialog, "This is dialog frame"),
                Arguments.arguments(panel, "This is dialog frame"),
                Arguments.arguments(vkButton, "https://vk.com"),
                Arguments.arguments(facebookButton, "https://facebook.com")
        );
    }
}
