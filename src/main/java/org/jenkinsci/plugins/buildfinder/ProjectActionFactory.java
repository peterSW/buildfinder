package org.jenkinsci.plugins.buildfinder;

import hudson.Extension;
import hudson.model.AbstractProject;
import hudson.model.Action;
import jenkins.model.TransientActionFactory;

import java.util.Collection;
import java.util.Collections;


@Extension
public final class ProjectActionFactory
    extends TransientActionFactory<AbstractProject> {

    @Override
    public Class<AbstractProject> type() {
        return AbstractProject.class;
    }

    @Override
    public Collection<? extends Action> createFor(final AbstractProject t) {
        return Collections.singleton(new ProjectAction(t));
    }

}
