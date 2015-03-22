package org.jenkinsci.plugins.buildfinder;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ProjectActionTest {
    
    ProjectAction action;
    
    public ProjectActionTest() {
         action = new ProjectAction();
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
    
}
