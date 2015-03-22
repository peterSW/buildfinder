package org.jenkinsci.plugins.buildfinder;

import hudson.model.Action;
import org.kohsuke.stapler.export.ExportedBean;


@ExportedBean(defaultVisibility = -1)
class ProjectAction implements Action{

    @Override
    public String getIconFileName() {
        return "search.png";
    }

    @Override
    public String getDisplayName() {
        return "Find Build";
    }

    @Override
    public String getUrlName() {
        return "FindBuild";
    }
    
}
