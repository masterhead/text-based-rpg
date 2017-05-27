package mad.rpg.game.actions;

import mad.rpg.characters.actions.ChooseCharacterAction;
import mad.rpg.characters.actions.CreateCharacterAction;
import mad.rpg.game.Messages;
import mad.rpg.game.states.StateNotFoundException;
import mad.rpg.game.states.StateType;
import mad.rpg.world.actions.ExploreAction;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameActionFactoryTest {

    ActionFactory actionFactory;

    @Before
    public void setUp() throws Exception {
        actionFactory = new GameActionFactory();
    }

    @Test
    public void should_throwStateNotFoundException_when_createActionWithNullParameterCalled() throws Exception {
        assertThatThrownBy(() -> { actionFactory.createAction(null); })
                .isInstanceOf(StateNotFoundException.class)
                .withFailMessage(Messages.STATE_NOT_FOUND_EXCEPTION_MESSAGE);
    }

    @Test
    public void should_createBeginGameAction_when_createActionWithGameBeginningStateTypeCalled() throws Exception {
        Action beginGameAction = actionFactory.createAction(StateType.GAME_BEGINNING_STATE);
        assertThat(beginGameAction).isInstanceOf(BeginGameAction.class);
    }

    @Test
    public void should_createEndGameAction_when_createActionWithGameEndingStateTypeCalled() throws Exception {
        Action endGameAction = actionFactory.createAction(StateType.GAME_ENDING_STATE);
        assertThat(endGameAction).isInstanceOf(EndGameAction.class);
    }

    @Test
    public void should_createChooseCharacterAction_when_createActionWithCharacterListingStateTypeCalled() throws Exception {
        Action chooseCharacterAction = actionFactory.createAction(StateType.CHARACTER_LISTING_STATE);
        assertThat(chooseCharacterAction).isInstanceOf(ChooseCharacterAction.class);
    }

    @Test
    public void should_createCreateCharacterAction_when_createActionWithCharacterCreatingStateTypeCalled() throws Exception {
        Action createCharacterAction = actionFactory.createAction(StateType.CHARACTER_CREATING_STATE);
        assertThat(createCharacterAction).isInstanceOf(CreateCharacterAction.class);
    }

    @Test
    public void should_createBuildGameAction_when_createActionWithGameBuildingStateTypeCalled() throws Exception {
        Action buildGameAction = actionFactory.createAction(StateType.GAME_BUILDING_STATE);
        assertThat(buildGameAction).isInstanceOf(BuildGameAction.class);
    }

    @Test
    public void should_createExploreAction_when_createActionWithExplorationStateTypeCalled() throws Exception {
        Action exploreAction = actionFactory.createAction(StateType.EXPLORATION_STATE);
        assertThat(exploreAction).isInstanceOf(ExploreAction.class);
    }
}
