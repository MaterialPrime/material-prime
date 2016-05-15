# MaterialPrime: Material design with PrimeFaces.

**MaterialPrime** is new JSF project built with [PrimeFaces](http://www.primefaces.org/). It helps you create JSF applications that follows the **Google** [Material Design](http://www.google.com/design/spec/material-design/introduction.html) guidelines. It's based on [MaterializeCSS](http://materializecss.com/) library.

**The work on MaterialPrime is funded by the community. Just check the project page on [Patreon](https://www.patreon.com/material_prime).**

If you want to contribute to the project, just fork our [GitHub repository](https://github.com/MaterialPrime/), or simply contact me at [francesco.strazzullo86@gmail.com](mailto:francesco.strazzullo86@gmail.com)! :D

## Setup
### Stable Version

You can use Jitpack to use MaterialPrime. Just add this repository:

    <repositories>
    	<repository>
    	    <id>jitpack.io</id>
    	    <url>https://jitpack.io</url>
    	</repository>
    </repositories>

Now just add the dependency to the pom.xml file.

    <dependency>
        <groupId>com.github.MaterialPrime</groupId>
        <artifactId>material-prime</artifactId>
        <version>v0.0.1</version>
    </dependency>

If you're using Gradle just follow the guide [here](https://jitpack.io/#MaterialPrime/material-prime).

### Bleeding Edge

If you want the last unstable version of MaterialPrime, you need to change the dependency like this:

    <dependency>
        <groupId>com.github.MaterialPrime</groupId>
        <artifactId>material-prime</artifactId>
        <version>develop-SNAPSHOT</version>
    </dependency>
    
### Custom build

If you want to use a jar file of MaterialPrime you need maven to build it:

    git clone https://github.com/MaterialPrime/material-prime.git
    cd material-prime
    mvn package

Enjoy! :)
