package org.jenkinsci.plugins.buildfinder;

import hudson.model.AbstractProject;
import hudson.model.ParameterDefinition;
import hudson.model.ParametersDefinitionProperty;
import hudson.model.StringParameterDefinition;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.jvnet.hudson.test.JenkinsRule;
import static org.mockito.Mockito.mock;

public class ProjectActionTest {
    @Rule public JenkinsRule j = new JenkinsRule();
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
    
    @Test
    public void testGetParameterNamesGivesEmptyWhenThereAreNoParameters() {
        assertThat(action.getParameterNames(), is(empty()));
    }

    @Test
    public void testGetParameterNamesGivesListOfParameterNames() throws IOException {
        project = j.createFreeStyleProject();
        action = new ProjectAction(project);
        addAParametersTo(project);
        assertThat(action.getParameterNames().get(0), equalTo("parameter"));
    }

    private void addAParametersTo(AbstractProject project) throws IOException {
        List<ParameterDefinition> paramsToAdd = new ArrayList<ParameterDefinition>();
        paramsToAdd.add(new StringParameterDefinition("parameter", "what ever"));
        project.addProperty(new ParametersDefinitionProperty(paramsToAdd));
    }
    
}
