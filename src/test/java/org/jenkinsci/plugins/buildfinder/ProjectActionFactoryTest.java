package org.jenkinsci.plugins.buildfinder;

import hudson.model.AbstractProject;
import hudson.model.Action;
import java.util.Collection;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import static org.junit.Assert.*;

public final class ProjectActionFactoryTest {

    private final AbstractProject mockProject = mock(AbstractProject.class);
    ProjectActionFactory factory;

    public ProjectActionFactoryTest() {
        factory = new ProjectActionFactory();
    }

    @Test
    public void testCreateForGivesOneAction() {
        Collection<? extends Action> result = factory.createFor(mockProject);

        assertEquals(1, result.size());
    }

}
