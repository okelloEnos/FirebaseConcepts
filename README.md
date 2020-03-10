# FirebaseConcepts
Just to implement trial on FireBase services

1. If you are a begginer i will recommend using the android studio IDE to easily add Firebase services to your app functionality inorder to obtain all all dependencies correct or Use the Firebase console setup workflow. from the Docs https://firebase.google.com/docs/android/setup
2. This will be a guide through for the first option.
3. Go to Tools -> Firebase then a side assistant window would be open and click on the service u want to implement

# 1. Email and Password Auth
 
 1. On the open window select the Authentication and select Email and Password Authentication.
 
 2. Press Connect to Firebase Button and you will be prompted either to create a project on firebase or use an already existing project, The choice is users to make.
 
 3. After the Project syncing is done check to see if the the google-services.json is present by going to check Under Project -> ['Project Name '] -> app folder.
 
 4. Next make sure to add apply plugin: 'com.google.gms.google-services' on the app level gradle file at the bottom and at the project level gradle make sure the classpath for google srvice is set under dependecies i.e  classpath 'com.google.gms:google-services:4.3.2' NB if not done the app would surely crash but u can change the version number to the latest.
 
 5. With that we need to add permission for internet Acess in the Manifest File i.e uses-permission      android:name="android.permission.INTERNET"
 
 6.Go to console.firebase.google.com/u/0/ and select the Project u connected to then Click on Authentication then change to sign in method and enable Email/Password then Press Ok.

7. With That set u can copy and paste the code from the Main Activity and Base class :
    
    Overview of the Code
    
    1. The MainActivity checks if the user is known in on Start method and Logs him Automatically to the Base Activity by            Displaying the Text that a user is automatically logged In.
    
    2. If the user is unknown to the App MainActivity has A Button for log In or Sign Up 
    
    3. Log In is straight Forward but when Signin Up make sure while setting up a password you use a strong password i.e 8 characters and above.
# 2. FireBase UI Library


# 3. Linking Email and Password to RealTime Database
