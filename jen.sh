#!/usr/bin/env bash

cd /Users/doringber/githubProjects/stuff/AutomationProject/updatePro
echo "Go to the Project place"

java -cp "/Users/doringber/githubProjects/stuff/AutomationProject/updatePro/libs/org.testng_6.12.0.r201709030044.jar:/Users/doringber/githubProjects/stuff/AutomationProject/updatePro/libs/jcommander-1.7.jar:/Users/doringber/githubProjects/stuff/AutomationProject/updatePro/libs/*:/Users/doringber/githubProjects/stuff/AutomationProject/updatePro/bin" org.testng.TestNG suiteTests.xml
echo "Finish running"

