package com.lww.pattern.states;

public class StatesPattern {
    public static void main(String[] args) {

        StateManage stateManage = new StateManage();
        for (int i = 0; i < 100; i++) {
            stateManage.doSomeThing("emmm", i);
        }
    }
}

class StateManage {

    private State state = null;

    public void doSomeThing(String param, Integer step) {
        if (step % 3 == 0) {
            new StateA().doSomeThing(param);
        }
        if (step % 3 == 1) {
            new StateB().doSomeThing(param);
        }
        if (step % 3 == 2) {
            new StateC().doSomeThing(param);
        }
    }

}

interface State {
    void doSomeThing(String param);
}

class StateA implements State {

    @Override
    public void doSomeThing(String param) {
        System.out.println("StateA : " + param);
    }
}

class StateB implements State {

    @Override
    public void doSomeThing(String param) {
        System.out.println("StateB : " + param);
    }
}

class StateC implements State {

    @Override
    public void doSomeThing(String param) {
        System.out.println("StateC : " + param);
    }
}