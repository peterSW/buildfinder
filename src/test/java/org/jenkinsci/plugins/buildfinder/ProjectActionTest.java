package org.jenkinsci.plugins.buildfinder;

import hudson.model.AbstractProject;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ProjectActionTest {
    
    AbstractProject project;
    ProjectAction action;
    
    public ProjectActionTest() {
        project = mock(AbstractProject.class);
        action = new ProjectAction(project);
    }
    
    @Test
    public void testGetDisplayName() {
        assertThat(action.getDisplayName(), is("Find Build"));
    }
    
    @Test
    public void testGetUrlName() {
        assertThat(action.getUrlName(), is("FindBuild"));
    }
    
    @Test
    public void testGetIconFileName() {
        assertThat(action.getIconFileName(), is("search.png"));
    }
    
    @Test
    public void testGetProjectGivesActionsProject() {
        assertThat(action.getProject(), is(project));
    }
    
}
