# ScreenCapturer
Save a portion of the screen to the Clipboard! (Running the .jar)


Also avaible as a library to capture the screen into various formats for further processing (ScreenCapturer class)

## Option 1. Maven: 

 * **Option 1.1** You can download the .jar and add it to your Maven project as a system file by modifying **pom.xml**:

```
<dependency>
	<groupId>com.github.shephardmp</groupId>
	<artifactId>screencapturer</artifactId>
	<version>1.1</version>
	<scope>system</scope>
	<systemPath>
	"PATH/TO/JAR"
	</systemPath>
</dependency>
```
* **Option 1.2** Directly from this repository by using **jitpack**:
```
<repositories>
	<repository>
		<id>jitpack.io</id>
		<url>https://jitpack.io</url>
	</repository>
</repositories>
```
And adding the dependency:
```
<dependency>
	    <groupId>com.github.ShephardMP</groupId>
	    <artifactId>ScreenCapturer</artifactId>
	    <version>1.1</version>
</dependency>
```

**Note: also modifying pom.xml**


## Option 2. [As external lib](http://www.oxfordmathcenter.com/drupal7/node/44)
