/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.gitfx.ui.tests;

import io.github.gitfx.GitFxApp;
import org.junit.Before;
import org.junit.Test;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.util.WaitForAsyncUtils;

import java.io.File;

/**
 *
 * @author buddha
 */
public class CloneTest  extends FxRobot {
    File metaDataJSON;
    @Before
    public void before() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(GitFxApp.class);
    }
    
    @Test
    public void cloneRepositoryTest() throws Exception {
        WaitForAsyncUtils.waitForFxEvents();
        when:
        //Conditionally executing as the initial dialog box is shown only of
        //no repositories are linked with the application
        metaDataJSON = new File(io.github.gitfx.util.WorkbenchUtil.GITFX_WORKBENCH_RECENT_REPO_FILE);
        if(!metaDataJSON.exists())
          clickOn("OK");
        FxToolkit.showStage();
        then:
        //Temporarily these clickOn are also working as asserts for presence of
        //UI element. Need to add some more TestFX asserts.


        WaitForAsyncUtils.waitForFxEvents();
        clickOn("#gitclone");
        clickOn("Cancel");
    }
}
