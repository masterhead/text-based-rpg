package mad.rpg.game.conditions;

import mad.rpg.game.context.Context;
import mad.rpg.game.context.GameContext;
import mad.rpg.game.events.EventType;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameBuiltConditionTest {

    Condition gameBuiltCondition;

    Context context;

    @Before
    public void setUp() throws Exception {
        gameBuiltCondition = new GameBuiltCondition();
        context = new GameContext();
    }

    @Test
    public void should_returnTrue_when_gameBuiltEventConditionCalled() throws Exception {
        context.addEvent(EventType.GAME_BUILT);

        Boolean result = gameBuiltCondition.test(context);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void should_returnFalse_when_otherEventsCalled() throws Exception {
        context.addEvent(EventType.EXIT_REQUESTED);

        Boolean result = gameBuiltCondition.test(context);

        assertThat(result).isEqualTo(false);
    }
}
