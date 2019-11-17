package es.urjccode.mastercloudapps.adcs.draughts.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
    CoordinateTest.class, 
    MenPieceTest.class,
    GameWithKingTest.class,
    GameWithKingTestBuilder.class,
    GameTest.class, } )
public final class AllModelTest {
}
