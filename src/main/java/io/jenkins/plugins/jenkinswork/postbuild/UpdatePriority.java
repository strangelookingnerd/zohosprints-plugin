package io.jenkins.plugins.jenkinswork.postbuild;

import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.model.Result;
import hudson.tasks.BuildStepDescriptor;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Publisher;
import hudson.tasks.Recorder;
import hudson.util.FormValidation;
import io.jenkins.plugins.Messages;
import io.jenkins.plugins.sprints.SprintsWorkAction;
import io.jenkins.plugins.util.Util;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.QueryParameter;
import org.kohsuke.stapler.StaplerRequest;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.logging.Logger;
/**
 *@author selvavignesh.m
 * @version 1.0
 */
public class UpdatePriority extends Recorder {
    private static final Logger LOGGER = Logger.getLogger(UpdatePriority.class.getName());
    private String prefix;
    private String priority;

    /**
     *
     * @param prefix For Which Sprint Item priority to getupdate
     * @param priority priority to be updated
     */
    @DataBoundConstructor
    public UpdatePriority(String prefix, String priority) {
        this.prefix = prefix;
        this.priority = priority;
    }
    /**
     *
     * @return priority to be updated
     */
    public String getPriority() {
        return priority;
    }

    /**
     *
     * @return For Which Sprint Item priority to getupdate
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     *
     * @return Monitoring for Build Step
     */
    @Override
    public BuildStepMonitor getRequiredMonitorService() {
        return BuildStepMonitor.NONE;
    }

    /**
     *
     * @param build Build Object of Current build
     * @param launcher launcher is responsible for inheriting environment variables
     * @param listener Receives events that happen during a build
     * @return if build success then true, else false
     * @throws InterruptedException
     * @throws IOException
     */
    @Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) throws InterruptedException, IOException {
            return SprintsWorkAction.getInstanceForUpdatePriority(build, listener, SprintsWorkAction.POST_BUILD_TYPE, prefix, priority).updatePriority();
    }

    /**
     *
     * @return instance of DescriptorImpl
     */
    @Override
    public DescriptorImpl getDescriptor() {
        return (DescriptorImpl) super.getDescriptor();
    }
    /**
     *@author selvavignesh.m
     * @version 1.0
     */
    @Extension
    public static class DescriptorImpl extends BuildStepDescriptor<Publisher> {
        /**
         *
         * @param jobType
         * @return All jobs able to use this plugin
         */
        @Override
        public boolean isApplicable(Class<? extends AbstractProject> jobType) {
            return true;
        }

        /**
         *
         * @return Display Name of Action
         */
        @Nonnull
        @Override
        public String getDisplayName() {
            return Messages.update_priority();
        }

        /**
         *
         * @param prefix For Which Sprint Item priority to getupdate
         * @return if prefix matches the regex the OK else Error
         */
        public FormValidation doCheckPrefic(@QueryParameter final String prefix) {
            if (prefix.matches(Util.ITEM_REGEX)) {
                return FormValidation.ok();
            }
            return FormValidation.error(Messages.prefix_message());
        }

        /**
         *
         * @param priority  priority to be updated
         * @return if param is not null or empty then OK else Error
         */
        public FormValidation doCheckPriority(@QueryParameter final String priority) {
            if (!priority.isEmpty()) {
                return FormValidation.ok();
            }
            return FormValidation.error(Messages.priority_message());
        }

        /**
         *
         * @param req staplerrequest Object
         * @param json Contains value and key
         * @return true/false
         * @throws FormException
         */
        @Override
        public boolean configure(StaplerRequest req, JSONObject json) throws FormException {
            req.bindJSON(this, json);
            save();
            return super.configure(req, json);
        }
    }
}