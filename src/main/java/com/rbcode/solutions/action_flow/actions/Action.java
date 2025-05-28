package com.rbcode.solutions.action_flow.actions;

import com.rbcode.solutions.action_flow.model.Transaction;

public interface Action {

    Action nextAction = null;

    void perform(final Transaction transaction);

    default Action then(Action nextAction) {
        nextAction = nextAction;
        return nextAction;
    }

}
