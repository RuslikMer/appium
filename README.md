
Program Language : Java
Toolkit : Appium
Framework : TestNG 
Report : Browserstack
Build Toolkit : Gradle

 //to upload new build to browserstack
 curl -u "user_name:pass" \
 -X POST "https://api-cloud.browserstack.com/app-automate/upload" \
 -F "file=@/path/to/file"