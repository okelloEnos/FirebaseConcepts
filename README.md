# FirebaseConcepts
To implement portion of FireBase services .
NB : Be Keen On the Activities Highlighted to be Used as Reference for each section and Everything would be fine.

1. If you are a begginer I will recommend using the Android Studio IDE to easily add Firebase services to your app functionality inorder to obtain all dependencies correct or You can Use the Firebase console setup workflow. from the Docs https://firebase.google.com/docs/android/setup to add the dependencies Manually .
2. This will be a guide through for the first option i.e Using IDE.
3. Go to Tools -> Firebase then a side assistant window would be open and click on the service you want to implement.

# 1. Email and Password Auth
NOTE : We will be using MainActivity and Base Activities.
 
 1. On the opened window select the Authentication and select Email and Password Authentication.
 
 2. Press Connect to Firebase Button and you will be prompted either to create a project on firebase or use an already existing project, The choice is users to make.
 
 3. After the Project syncing is done check to see if the the google-services.json file is present by going to check Under Project -> ['Project Name '] -> app folder.
 
 4. Next make sure to add apply plugin: '$''com.google.gms.google-services''$' on the app level gradle file at the bottom and at the project level gradle make sure the classpath for google service is set under dependecies i.e '$' classpath 'com.google.gms:google-services:4.3.2' '$'
 NB if not done the app would surely crash And you can change the version number to the latest.
 
 5. With that we need to add permission for internet Acess in the Manifest File i.e uses-permission      android:name="android.permission.INTERNET"
 
 6.Go to console.firebase.google.com/u/0/ and select the Project u connected to then Click on Authentication then change to sign in method and enable Email/Password then Press Ok.

7. With That set u can copy and paste the code from the Main Activity and Base class :
    
    Overview of the Code
    
    1. The MainActivity checks if the user is known in on Start method and Logs him Automatically to the Base Activity by            Displaying the Text that a user is automatically logged In.
    
    2. If the user is unknown i.e He has not registered Recently or its a new device .The App MainActivity has A Button for log In or Sign Up .
    
    3. Log In is straight Forward but when Signin Up make sure while setting up a password you use a strong password i.e 8 characters and above.
    
# 2. FireBase UI Library
NOTE : We will be using the FirebaseUI Activity and loadedClass Activity for this Section.
 1. Making the Story Short i would be using FirebaseUI docs https://firebase.google.com/docs/auth/android/firebaseui
 
 2. With the above Docs you would require to add dependencies on app level gradle depending on what you to implement for your users to use when signing Up i.e Twitter, Email, Facebook, Github etc inorder to use their sdks
 eg : dependencies {
 
     implementation 'com.firebaseui:firebase-ui-auth:6.2.0'
 }
 
 3. In the Firebase console, open the Authentication section and enable the sign-in methods you want to support. Some sign-in methods require additional information, usually available in the service's developer console. eg :Google Sign In and also add your email as support email and save.
 
 4. If you support Google Sign-in and haven't yet specified your app's SHA-1 fingerprint, do so from the Settings page of the Firebase console. See Authenticating Your Client for details on how to get your app's SHA-1 fingerprint. 

5. With all That Set you can follow down the code while copying and pasting .

# 3. Linking Email and Password to RealTime Database
