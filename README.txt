Thank you for using m(icro)-URL.oc, or "mURLoc".

This software functions by first registrating users through terminal input. After the users are created, they are stored in a HashMap, where the key is generated from the entire String contents of the user object.
Because of lack of functionality, there are no functions for a user other than registering - as these features can be added at a later occation.

After registrating, the user will be stored in a text document users.txt, and is therefore included even if the program is shut down.

There are account-functionalities, but they are not completed. Some functionality is working, but not the complete thing...

How to use:
    1. First start the program. If there are no users, it will enter user registration automatically.
    2. You will then be prompted to make users. There are no symbol checks or other safety features on the string inputs. So please do not use special characters for name, password and link. These functionalities can be expanded in the future.
    3. The program will shut down after user registration. Simply run the program again to enter listen mode.
    4. While in listen mode, you can try to enter your link into a browser. The link is of the form "http://localhost:8080/574470512". If there is an ugly link registered in the database, corresponding to the key "574470512",
        you will be redirected to said link (Though probably empty, as there are no .html documents at this location.)