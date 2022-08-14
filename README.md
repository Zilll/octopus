##About test project
This project is an example of a test environment for automation test runs and uses such tools like:
Jenkins, Docker, AWS, Java, TestNg, Allure, Maven e.t.c. .
###How it work`s
Each jenkins job is launched on separate jenkins node and each node is created on separate AWS unix instance with
docker container inside.
####Jenkins
Jenkins has three jobs ( :white_check_mark: ui, :white_check_mark: api,
mobile, desktop, regression), job launch is triggered by git action(push), schedule or by manual launch.

Jenkins components:
- Jenkins master;
- Jenkins slave for UI test suite;
- Jenkins slave for API test suite;
- Jenkins slave for regression test suite.

####AWS
  - JenkinsMaster (windows)
  - Jenkins slave api tests (unix)
  - Jenkins slave UI tests (unix)
  - Selenium hub for nodes (unix)
  - Selenium node FF (unix)
  - Selenium node Chrome (unix)
####Docker containers
  - Selenium hub
  - Selenium node FF
  - Selenium node Chrome
####Maven
####TestNg
####Allure
Allure generates reports after test run.
- link ui: http://18.216.186.143:8080/job/Octopuz_ui/allure/
- link api: http://18.216.186.143:8080/job/Octopuz_api/allure/
####noVnc
noVNC online preview of test run on web browser
- http://3.141.33.104:7900/
- http://13.58.43.136:7900/
###Possible problems
-Free AWS uses dynamic ip, so after power of or reboot it will be impossible to connect for some stations.