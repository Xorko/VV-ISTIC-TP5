# Random Wikipedia walker

Using Selenium, create a small program that, starting from the main page https://www.wikipedia.org/, walks trough a sequence of random links and takes a snapshot of the last page.
The process is as follows:

 1. Navigate to the main page https://www.wikipedia.org/
 2. Select a random link in the page
 3. Navigate to the link
 4. Repeat steps 2 to 3 until you have visited 10 different pages
 5. Take a snapshot of the current page and save it

Include the code of the walker and the snapshot in this document.

## Answer

The code of the walker is available in the file [WikipediaWalker.java](../code/exercise1/src/test/java/fr/istic/vv/tp5/WikipediaWalkerTest.java).
To run it requires a jdk 17.

We can see in the following snapshot that the walker has visited 10 different pages :

![execution.png](../code/exercise1/execution.png)

The snapshot is of the last page :
![snapshot.png](../code/exercise1/snapshot.png).