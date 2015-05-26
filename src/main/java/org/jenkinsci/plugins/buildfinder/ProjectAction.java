package org.jenkinsci.plugins.buildfinder;

import hudson.model.AbstractProject;
import hudson.model.Action;
import hudson.model.ParametersDefinitionProperty;
import java.util.ArrayList;
import java.util.List;
import org.kohsuke.stapler.export.ExportedBean;

@ExportedBean(defaultVisibility = -1)
class ProjectAction implements Action {
    private final AbstractProject parentProject;

    public ProjectAction(AbstractProject parent) {
        parentProject = parent;
    }

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
    
    public AbstractProject getProject() {
        return parentProject;
    }
    
    public List<String> getParameterNames()
    {
        ParametersDefinitionProperty property = (ParametersDefinitionProperty)parentProject.getProperty(ParametersDefinitionProperty.class);
        if(property == null) {
            return new ArrayList<String>();
        }
        else {
            return property.getParameterDefinitionNames();
        }
    }

}
