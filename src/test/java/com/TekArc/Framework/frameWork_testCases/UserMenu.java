package com.TekArc.Framework.frameWork_testCases;

import com.TekArc.Framework.PO.PODevelopers_console;
import com.TekArc.Framework.PO.POHome;
import com.TekArc.Framework.PO.POLogin;
import com.TekArc.Framework.PO.POMySetting;
import com.TekArc.Framework.Utilities.TestBase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserMenu extends TestBase {
    POLogin Pologin;
    POHome poHome;
    POMySetting mySetting;
    PODevelopers_console poDevelopersconsole;

    @BeforeClass
    public void SetupEnvironment() throws Exception {
        poHome = new POHome(driver);
        Pologin = new POLogin(driver);
        mySetting = new POMySetting(driver);
        poDevelopersconsole = new PODevelopers_console(driver);

    }

    @Test
    public void salesforce_TC6() throws Exception {
        driver.get(oCons.getAppURL());
        Pologin.loginToApp();
        Pologin.loginTAcc();
        poHome.UserMenuDrodown();
        poHome.MyProfile();
        poHome.postLink();
        poHome.sharepost();
        poHome.fileLinkClick();

    }

    @Test
    public void salesforce_TC7() throws Exception {
        driver.get(oCons.getAppURL());
        Pologin.loginToApp();
        Pologin.loginTAcc();
        poHome.UserMenuDrodown();
        mySetting.My_setting();
        Pologin.logOutOfApp();

    }

    @Test
    public void salesforce_TC8() throws Exception {

        driver.get(oCons.getAppURL());
        Pologin.loginToApp();
        Pologin.loginTAcc();
        poHome.UserMenuDrodown();
        poDevelopersconsole.Developerconsol();
        Pologin.logOutOfApp();

    }

    @Test
    public void salesforce_TC9() throws Exception {
        // Note: Requirment for this test is to run in the firefox browser
        driver.get(oCons.getAppURL());
        Pologin.loginToApp();
        Pologin.loginTAcc();
        Pologin.logOutOfApp();

    }
}