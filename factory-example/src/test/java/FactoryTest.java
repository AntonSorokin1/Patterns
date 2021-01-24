import api.Dialog;
import api.impl.WebDialog;
import api.impl.WindowsDialog;
import entity.Button;
import entity.impl.WebButton;
import entity.impl.WindowsButton;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FactoryTest {
    @ParameterizedTest
    @MethodSource("buttonRenderData")
    void buttonRender(String expected, Button button) {
        Assertions.assertEquals(expected, button.render());
    }

    @ParameterizedTest
    @MethodSource("buttonClickData")
    void buttonClick(String expected, Button button) {
        Assertions.assertEquals(expected, button.click());
    }

    @ParameterizedTest
    @MethodSource("dialogButtonTypeEqualityData")
    void dialogButtonTypeEquality(Dialog dialog, Class<Button> buttonClass) {
        dialog.createButton();
        Assertions.assertEquals(buttonClass, dialog.getButton(0).getClass());
    }

    public static Arguments[] buttonRenderData() {
        return new Arguments[] {
                Arguments.arguments("Windows button was rendered!", new WindowsButton()),
                Arguments.arguments("Web button was rendered!", new WebButton())
        };
    }

    public static Arguments[] buttonClickData() {
        return new Arguments[] {
                Arguments.arguments("Windows button was clicked!", new WindowsButton()),
                Arguments.arguments("Web button was clicked!", new WebButton())
        };
    }

    public static Arguments[] dialogButtonTypeEqualityData() {
        return new Arguments[] {
                Arguments.arguments(new WindowsDialog(), WindowsButton.class),
                Arguments.arguments(new WebDialog(), WebButton.class)
        };
    }
}
