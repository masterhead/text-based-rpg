package mad.rpg.characters.conditions;

import mad.rpg.game.conditions.Condition;
import mad.rpg.game.context.Context;
import mad.rpg.game.events.EventType;

public class CharacterCreationBeginCondition implements Condition {

    @Override
    public Boolean test(Context context) {
        return context.getLastEvent().equals(EventType.CHARACTER_CREATION_REQUEST);
    }

}
