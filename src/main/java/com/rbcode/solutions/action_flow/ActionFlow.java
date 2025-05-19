package com.rbcode.solutions.action_flow;

import com.rbcode.solutions.action_flow.actions.Action;
import com.rbcode.solutions.action_flow.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ActionFlow {

    private final List<Action> actions;

    private ActionFlow(final Action action) {
        actions = new ArrayList<>();
        addAction(action);
    }

    public static ActionFlow first(final Action action) {
        return new ActionFlow(action);
    }

    public ActionFlow then(final Action action) {
        addAction(action);
        return this;
    }

    private void addAction(final Action action) {
        actions.add(action);
    }

    public void execute(final Transaction transaction) {
        actions.forEach((Action action) -> action.perform(transaction));
    }
}
