OAuth2 Battle.net using Spring (Security / Boot / MVC )
===================

This project is an example on how to setup a Java/Spring project to consume BattleNet API OAuth2.

This was made using spring tutorial  [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/) and doc from [Battle.net](https://dev.battle.net)


----------
[TOC]

----------

Step 1 - Battle.net Developer Portal
-------------

First off, You want to sign up with Mashery on the Battle.net Developer Portal.

Then you want to register your futur app.

![Edit Application on Battle.net dev portal](https://github.com/Shask/Battle.net-OAuth2-SpringBoot/blob/master/README/battlenetedit.png?raw=true)

> **Note:**

> - The website, the name of the app can always be changed afterwards

Step 2 - Enable https in spring boot
-------------
You must follow these easy steps following [This tutorial](https://www.drissamri.be/blog/java/enable-https-in-spring-boot/) (Only the first 2 steps are usefull here)

> **Summary of the tutorial:**

>- Generate a self-signed certificate 
><code>keytool -genkey -alias tomcat
	 -storetype PKCS12 -keyalg RSA -keysize 2048
	 -keystore keystore.p12 -validity 3650 </code>
>- Enable HTTPS in Spring boot but putting those lines in the <code> application.properties</code>
<code>server.port: 8443
	server.ssl.key-store: keystore.p12
	server.ssl.key-store-password: mypassword
	server.ssl.keyStoreType: PKCS12
	server.ssl.keyAlias: tomcat</code>


Step 3 - Setup application.properties to use Battle.net OAuth2 
-------------
Enter your own public and secret key in the application.properties file.
Enter as well all the URLs (acces Token, Authorization, ...) [Here for more details](https://dev.battle.net/docs/read/oauth)

![enter image description here](https://github.com/Shask/Battle.net-OAuth2-SpringBoot/blob/master/README/application%20prop%20setup.png?raw=true)


### All you have to do now is run your SpringBoot, and let the magic happen !

You can login to your app by clicking the link

![login image](https://github.com/Shask/Battle.net-OAuth2-SpringBoot/blob/master/README/login.png?raw=true)

You're redirected to battle.net portal to make sure you authorize your new web-app to access informations like BattleTag, World of Warcraft Characters and/or Starcraft profile.

![login battleNet](https://github.com/Shask/Battle.net-OAuth2-SpringBoot/blob/master/README/loginBnet.png?raw=true)

You can access infos like your battletag or your id with "https://eu.api.battle.net/account/user?access_token=..."
You can access more info on World of Warcraft account or Starcraft account with another API call (All listed on battle net developer portal)

Front information access : 

![enter image description here](https://github.com/Shask/Battle.net-OAuth2-SpringBoot/blob/master/README/loggedin.png?raw=true)

You can also get those information on your back end (if you want to save users and their alts for example)

![Back end example](https://github.com/Shask/Battle.net-OAuth2-SpringBoot/blob/master/README/backInfo.png?raw=true)
>**note:** This is for example purpose only, do not mind the unchecked casting :)

![back end log](https://github.com/Shask/Battle.net-OAuth2-SpringBoot/blob/master/README/consolelog.png?raw=true)







