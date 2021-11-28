||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
||   ________  ________  ________        ________  ___       _______      ___    ___ ________  ________   ________  ________  ___  ________       ||
||   \   __  \|\   __  \|\   __  \      |\   __  \|\  \     |\  ___ \    |\  \  /  /|\   __  \|\   ___  \|\   ___ \|\   __  \|\  \|\   __  \      || 
||  \ \  \|\  \ \  \|\  \ \  \|\  \     \ \  \|\  \ \  \    \ \   __/|   \ \  \/  / | \  \|\  \ \  \\ \  \ \  \_|\ \ \  \|\  \ \  \ \  \|\  \     || 
||   \ \   __  \ \   ____\ \   ____\     \ \   __  \ \  \    \ \  \_|/__  \ \    / / \ \   __  \ \  \\ \  \ \  \ \\ \ \   _  _\ \  \ \   __  \    || 
||    \ \  \ \  \ \  \___|\ \  \___|      \ \  \ \  \ \  \____\ \  \_|\ \  /     \/   \ \  \ \  \ \  \\ \  \ \  \_\\ \ \  \\  \\ \  \ \  \ \  \   || 
||     \ \__\ \__\ \__\    \ \__\          \ \__\ \__\ \_______\ \_______\/  /\   \    \ \__\ \__\ \__\\ \__\ \_______\ \__\\ _\\ \__\ \__\ \__\  || 
||      \|__|\|__|\|__|     \|__|           \|__|\|__|\|_______|\|_______/__/ /\ __\    \|__|\|__|\|__| \|__|\|_______|\|__|\|__|\|__|\|__|\|__|  ||
||                                                                                                                                                ||
||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

An app-library program created by The Ptolemarchs in association with Patricia Lennon 


************************************************ Installation/Compilation


To run App Alexandria, first be sure the file is used in a Java IDE (we used Eclipse). Going forward, open and run the "Login.java" file to access
the program at a user/admin level; opening other classes first can cause program-breaking issues and is not recommended in the case of general use.


************************************************ Class Breakdown


For any potential App Alexandria developers, first off, welcome to the team! So to speak at least...
Listed below you will find basic descriptions for each class and their purposes within the program.



* AppDisplay: The core of the program. AppDisplay's purpose is to Display App Alexandria's registered apps to users and to allow access 
to the app-submission page (SubmissionPage). Admin-level users also have the ability to visit the app-approval page through this class (RequestPage). 
Reading in apps from the Application database (Applicationdatab.txt) is handled via the "loadApps" method, sorting and filtering is handled via the
"sortByPlatform" method called by an ActionListener component, and searching apps' names is handled by the "searchBarString" method also called by an
ActionListener.

* MyDialog: A class that displays information for an app selected in the AppDisplay GUI. Through the use of ActionListener components, users can "like"
or "dislike" the app they are viewing through My Dialog. Using the "loadApps" and "refreshApps" methods, MyDialog keeps any changes to like-count updated 
within the app database (Applicationdatab.txt).

* Login: The first page users see when accessing the program. From here, new users have the ability to sign up for an account or login to an existing
one. The method "loadUserBeans" is used to access the User database (UserBeans.txt) and add these user account objects into the class for login. Login
itself is handled by the "logIn" method while "signUp" is the method used to create new User objects out of accoutn information. If a user logs in with
an admin account, the method "getAdmin" is used to verify this information.

* RequestPage: The Admin-exclusive app submission portal. From here, admins are able to access the database for submitted app requests (Requests.txt)
via the UI and select which will be added to the Application database (Applicationdatab.txt) while also choosing which platforms it will be available on.
Loading in the request database is handled by the method "loadRequests," while actually verifying an add request is handled by the "commitapp" method
which makes use of the "loadRequests" and "loadApps" methods to both update the UI and the respective databases.

* SubmissionPage: The common User app submission portal. From here, users can submit any app of their choosing to be verified by admins and potentially
added to the App Alexandria database. The method "requestW" is used to verify that a valid app has been submitted and makes use of the "loadRequests"
method to submit the app data into the request database (Requests.txt).

* FAQ: The Frequently Asked Questions page of the program. FAQ simply displays a list of frequently asked user questions stored via separate text file
(FAQ.txt) and can be reached from the Login page.

* Application: The object class for applications. Application quite simply stores app data and allows for getting and setting the properties that
make up said apps. Name, description, origin/developer, version number, store hotlinks, price, like count, and available platforms for an app are stored here.

* UserBean: The "bean" which stores all User information. UserBean simply stores users' account information and allows for getting and setting of
the relevant properties. Username, password, and admin status are stored here. 


************************************************ JUnit Testers


* Application_JUnit: Tests the Application class' general functionality using JUnit/White-box testing.

* UserBean_JUnit: Tests the UserBean class' general functionality using JUnit/White-box testing.

* SubmissionPage_JUnit: Tests the SubmissionPage class' general functionality using JUnit/White-box testing.