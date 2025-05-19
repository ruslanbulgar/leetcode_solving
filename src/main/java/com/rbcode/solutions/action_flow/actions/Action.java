package com.rbcode.solutions.action_flow.actions;

import com.rbcode.solutions.action_flow.model.Transaction;

public interface Action {

    void perform(final Transaction transaction);

}
