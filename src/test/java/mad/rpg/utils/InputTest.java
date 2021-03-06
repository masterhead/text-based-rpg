package mad.rpg.utils;

import mad.rpg.game.Commands;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {

    @Test
    public void should_returnInput_when_receiveInputCalledAndExitCommandTyped() throws Exception {
        System.setIn(new ByteArrayInputStream(Commands.EXIT.getBytes()));

        Input inputUtil = new Input();
        String input = inputUtil.receiveInput();

        assertThat(input).isEqualTo(Commands.EXIT);
    }

    @Test
    public void should_returnInput_when_waitsForValidInputAndValidatesEmptyInput() throws Exception {
        System.setIn(new ByteArrayInputStream(("\n\n" + Commands.EXIT).getBytes()));

        Input inputUtil = new Input();
        String input = inputUtil.receiveInput();

        assertThat(input).isEqualTo(Commands.EXIT);
    }

    @Test
    public void should_returnCreateCharacterInput_when_receiveInputCalledAndCreateCharacterCommandTyped() throws Exception {
        System.setIn(new ByteArrayInputStream(Commands.CREATE_CHARACTER.getBytes()));

        Input inputUtil = new Input();
        String input = inputUtil.receiveInput();

        assertThat(input).isEqualTo(Commands.CREATE_CHARACTER);
    }

    @Test
    public void should_returnIntegerValue_when_choiceCalledAndInputIsIntegerAndInRangeOfChoices() throws Exception {
        System.setIn(new ByteArrayInputStream("A\n11\n0".getBytes()));

        Input inputUtil = new Input();
        Integer input = inputUtil.choice(0, 10);

        assertThat(input).isEqualTo(0);
    }

    @Test
    public void should_returnStringValue_when_choiceCalledAndInputIsIntegerAndInRangeOfChoices() throws Exception {
        System.setIn(new ByteArrayInputStream("A\n11\n0".getBytes()));

        Input inputUtil = new Input();
        String input = inputUtil.choice(0, 9, new ArrayList<String>());

        assertThat(input).isEqualTo("0");
    }

    @Test
    public void should_returnExitValue_when_choiceCalledAndInputIsExit() throws Exception {
        System.setIn(new ByteArrayInputStream(Commands.EXIT.getBytes()));

        Input inputUtil = new Input();
        ArrayList<String> commands = new ArrayList<>();
        commands.add(Commands.EXIT);
        String input = inputUtil.choice(0, 9, commands);

        assertThat(input).isEqualTo(Commands.EXIT);
    }

    @Test
    public void should_returnTrue_whenPromptCalledAndYesEntered() throws Exception {
        System.setIn(new ByteArrayInputStream("b\n12\nyes".getBytes()));

        Input inputUtil = new Input();
        Boolean result = inputUtil.prompt();

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_returnTrue_whenPromptCalledAndYLetterEntered() throws Exception {
        System.setIn(new ByteArrayInputStream("c\n13\ny".getBytes()));

        Input inputUtil = new Input();
        Boolean result = inputUtil.prompt();

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_returnFalse_whenPromptCalledAndNoEntered() throws Exception {
        System.setIn(new ByteArrayInputStream("b\n12\nno".getBytes()));

        Input inputUtil = new Input();
        Boolean result = inputUtil.prompt();

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void should_returnFalse_whenPromptCalledAndNLetterEntered() throws Exception {
        System.setIn(new ByteArrayInputStream("c\n13\nn".getBytes()));

        Input inputUtil = new Input();
        Boolean result = inputUtil.prompt();

        assertThat(result).isEqualTo(false);
    }

    @Test
    public void should_returnInput_when_receiveInputWithValidations() throws Exception {
        System.setIn(new ByteArrayInputStream(("asd\neognajfnjaf\n" + Commands.EXIT).getBytes()));

        Input inputUtil = new Input();
        String input = inputUtil.receiveInput(Arrays.asList(new String[]{ Commands.EXIT }));

        assertThat(input).isEqualTo(Commands.EXIT);
    }
}
