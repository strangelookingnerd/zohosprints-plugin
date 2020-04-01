# zohosprints-jenkins-plugin
[![Build Status](https://ci.jenkins.io/job/Plugins/job/zohosprints-plugin/job/master/badge/icon)](https://ci.jenkins.io/job/Plugins/job/zohosprints-plugin/job/master/)
[![Jenkins Plugin Installs](https://img.shields.io/jenkins/plugin/i/zohosprints.svg?color=blue)](https://plugins.jenkins.io/zohosprints)
[![GitHub release](https://img.shields.io/github/v/release/jenkinsci/zohosprints.svg?label=changelog)](https://github.com/jenkinsci/zohosprints-plugin/releases/latest)

## Description

Integrating Jenkins with [Zoho Sprints](https://sprints.zoho.com) saves your time and effort by working with just one at a time. You can create the required actions in [Zoho Sprints](https://sprints.zoho.com) right while you update your build in Jenkins. You can also track all your build details and view the build performance report in Zoho Sprints.

 

## Configure [Zoho Sprints](https://sprints.zoho.com) team with Jenkins (Build actions in Jenkins

- Navigate to your Jenkins account.
- Select Manage Settings in the left panel.
- Click Configure System.
- Navigate to Sprints Connection.
- Enter the Connection Name, Sprints Team URL, Sprints Team Admin Mail ID, and select Sprints API Token (Sprints Client to connect).
- Click Add and select Jenkins.
- Select the Kind as Sprints API Token.
- Click Generate Authentication Token in Zoho Sprints to generate the refresh token.
- Copy and paste the Client ID, Client Secret, and Redirection URL from Zoho Sprints.
- Click Authenticate and Migrate.

> Note: Click Authenticate and Migrate to configure and to migrate the existing builds from Jenkins to Zoho Sprints.

# Build actions in Jenkins
## Update item status from Jenkins
1. Sign In to your Jenkins account.
2. Navigate to the Project.
3. Click **Configure** from the left menu.
4. Select Add build step under the Build section.
5. Click **[Zoho Sprints] Update Item Status**.
    - **Prefix:** Enter the relevant project and item ID here. 
          Example: P1#I10 (P1 - Project number, I10 - Item number). If there are multiple items to be updated, you can specify them like: P1#I10, P#I11, P#I12, P2#I136. 
    - **Move to Status:** You can enter the relevant status name.
6. Save and Apply your changes.

> Note: You can change the status of the work items only in the active sprint. 
 
## Update item priority
1. Navigate to the Project.
2. Click **Configure** from the left menu.
3.Select Add build step under the Build section.
4. Click **[Zoho Sprints] Update Item Priority**.
    - **Prefix:** Enter the relevant project and item ID here. 
      Example: P1#I10 (P1 - Project number, I10 - Item number). If there are multiple items to be updated, you can specify them like: P1#I10, P#I11, P#I12, P2#I13. 
    - **Move Priority To:** Enter the priority name as defined in Zoho Sprints. 
5. Save and Apply your changes.

## Add feed status

You can directly add a status on your project feed right from Jenkins. 

1. Navigate to the Project.
2. Click Configure from the left menu.
3. Select Add build step under the Build section.
4. Click **[Zoho Sprints] Add feed status**.
    - **Prefix:** Enter the project ID here. Example: P7. The status will be posted in the project's feed.
    - **Status:** Enter the content for your status in this section. Note: All the script related information will be automatically removed.
5. Save and Apply your changes.

## Add comments to item

You can add a comment to your sprint or work item from Jenkins. 

1. Navigate to the Project.
2. Click Configure from the left menu.
3. Select Add build step under the Build section.
4. Click **[Zoho Sprints] Add comments to item**. 
   - **Prefix:** Enter the relevant project ID along with the Item ID. Example: P7#I10.
   - **Add comment:** Enter your comment for the item here. 
   - **Add attachment:** If you would like to attach the log files of your build, you can choose Yes, add. The build log file will be attached to the relevant item's comment. 
5. Save and Apply your changes.

# Post build actions in Jenkins

You can perform the other actions like status and priority update, adding feed status and comment to work item in your post build actions

## Create new item

You can create a new work item to your backlog or sprint in your Post Build from Jenkins. 

1. Navigate to the Project.
2. Click Configure from the left menu.
3. Select Add post-build action under the Post-build Actions.
4. Choose **[Zoho Sprints] Create New Item**.
    - **Prefix:** Enter the prefix. Example: P8#S4 (P1 - Project ID, S2 - Sprint Number) or P8#S0 (P8 - Project ID, S0 - Backlog ID).
    - **Item Name:** Input your work item name.
    - **Item Description:** Enter description for your work item.
    - **Assign Item To:** Enter the email address of the portal user here. Note: The user should be in an active status. If the user hasn't confirmed his email address or is inactive, then the user will not be added as an assignee.
    - **Item Type:** Choose Task or Bug. Note: You can only add the item types: Task or bug.
    - **Add Attachment:** Choose Add Log File to add the build log file as an attachment to your item.
5. Save and Apply your changes.

> You can perform the other actions like status and priority update, adding feed status and comment to work item in your post build actions. 
  
## Create item on build failure
 
On build failure, you can automate and create a new work item. 

1. Navigate to the Project.
2. Click Configure from the left menu.
3. Select Build Environment.
4. Choose **[Zoho Sprints] Create Item on Failure**.
    - **Prefix:** Enter the prefix. Example: P8#S4 (P1 - Project ID, S2 - Sprint Number) or P8#S0 (P8 - Project ID, S0 - Backlog ID). 
    - **Item Name:** Input your work item name.
    - **Item Description:** Enter description for your work item.
   - **Assign Item To:** Enter the email address of the portal user here. Note: The user should be in an active status. If the user has not confirmed his email address or is inactive, then the user will not be added as an assignee.
   - **Item Type:** Choose Task or Bug. Note: You can only add the item types: Task or bug. 
   - **Add Attachment:** Choose Add Log File to add the build log file as an attachment to your item.
5. Save and Apply your changes.


> This action will not work for Matrix projects.
