# Grandmaster
![crown logo](./crown.svg)
Cross-platform (Windows, Mac, Linux) Chess in Java

## Running 🏃💨
You will need Java with JDK >= 11.

### Windows
1. Download the .jar file and double-click on it to run.
### Mac
1. Download the .jar file from releases and navigate to it in Finder.
2. Right-click the file and click "Open"
3. It will give a warning, but open it anyway
4. The next time you want to run it, you can just double-click on it

To install it, just drag it into your Applications folder.
### Linux
1. `java -jar grandmaster.jar`

This command also works on Windows and Mac.

You may optionally install the Grandmaster.desktop file to make it a desktop application by moving it to `~/.local/share/applications`

Don't forget to change the .desktop file to point to the correct .jar location and  to save the application icon somewhere and update that as well.

## Building 👷🔧
You will need Maven and Java with JDK >= 11.

1. `git clone ...`
2. `mvn compile package`
3. `java -jar shade/grandmaster.jar`

---

or, you can build and run in one step with `mvn clean javafx:run`

## Testing 🔬🧪

I don't know how to do this yet, more to come.



