import entity.impl.Button;
import entity.impl.Dialog;
import entity.impl.TextFrame;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MediatorTest {
    private static Button okButton;
    private static Button clearButton;
    private static TextFrame textFrame;

    @BeforeEach
    public void before() {
        Dialog mediator = new Dialog();
        okButton = mediator.getOkButton();
        clearButton = mediator.getCleanButton();
        textFrame = mediator.getTextFrame();
    }

    @Test
    void checkOkButtonClick() {
        okButton.click();

        Assertions.assertEquals("Ok!", textFrame.getText());
    }

    @Test
    void checkOkButtonMultipleClick() {
        okButton.click();
        okButton.click();
        okButton.click();

        Assertions.assertEquals("Ok!", textFrame.getText());
    }

    @Test
    void checkClearButtonClick() {
        okButton.click();
        clearButton.click();

        Assertions.assertEquals("", textFrame.getText());
    }

    @Test
    void checkClearButtonMultipleClick() {
        okButton.click();
        clearButton.click();
        clearButton.click();
        clearButton.click();

        Assertions.assertEquals("", textFrame.getText());
    }
}
