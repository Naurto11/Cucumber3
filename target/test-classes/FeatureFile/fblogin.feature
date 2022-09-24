Feature: To validate the login Functionality of Facebook Application


Background:
Given user has to launch the chrome browser and pass the url

Scenario Outline:
To validate the invalid username and invalid password

When  user has to enter the values in "<username>" and "<password>" field

And user has to click the login button

Then  user has to navigate the error page

Examples:

|username|password|
|greens  |gres@123|
|dinesh  |dinesh@1|
|sureshsatz2000@gmail.com   |9384646016|   


 


