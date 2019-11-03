package es.urjccode.mastercloudapps.adcs.draughts.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    PieceTest.class,
    SquareTest.class,
    TurnTest.class,
    CoordinateTest.class,
    BoardTest.class,
    GameTest.class,
})

public class AllTest{

    public AllTest(){}

}