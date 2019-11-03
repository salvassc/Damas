package es.urjccode.mastercloudapps.adcs.draughts.models;

public class State{

    public StateValue stateValue;

    public State(){
        this.stateValue = stateValue.INITIAL;
    }

    public void next(){
        this.stateValue = StateValue.values()[this.stateValue.ordinal()+1];
    }

    public void reset(){
        this.stateValue = StateValue.INITIAL;
    }

    public StateValue getStateValue(){
        return this.stateValue;
    }
}