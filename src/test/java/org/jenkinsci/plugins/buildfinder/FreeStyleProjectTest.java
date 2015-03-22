package org.jenkinsci.plugins.buildfinder;

import hudson.model.FreeStyleProject;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Rule;

import org.jvnet.hudson.test.JenkinsRule;


public class FreeStyleProjectTest {
    
    @Rule public JenkinsRule j = new JenkinsRule();
    
    
    @Test
    public void freeStyleProjectsHaveTheFindBuildAction() throws Exception {
        
        FreeStyleProject project = j.createFreeStyleProject();
        
        List<ProjectAction> actions = project.getActions(ProjectAction.class);
        
        assertThat(actions.size(), is(1));
       
    }

}
