package es.urjccode.mastercloudapps.adcs.draughts;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
    es.urjccode.mastercloudapps.adcs.draughts.models.AllTest.class,
    es.urjccode.mastercloudapps.adcs.draughts.controllers.AllTest.class,
    es.urjccode.mastercloudapps.adcs.draughts.views.AllTest.class,
})

public class AllTest{

    public AllTest(){}

}