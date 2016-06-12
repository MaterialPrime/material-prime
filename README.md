# MaterialPrime: Material design with PrimeFaces. [![Build Status](https://travis-ci.org/MaterialPrime/material-prime.svg?branch=develop)](https://travis-ci.org/MaterialPrime/material-prime)

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
        <version>v0.0.2</version>
    </dependency>

To use MaterialPrime in a JSF page, just add the namespace on the top of the page


    <html xmlns="http://www.w3.org/1999/xhtml"
    	xmlns:mp="http://primefaces.org/ui/material"
    	xmlns:p="http://primefaces.org/ui">

If you're using Gradle just follow the guide [here](https://jitpack.io/#MaterialPrime/material-prime).

You can also download the last stable [jar file](https://jitpack.io/com/github/MaterialPrime/material-prime/v0.0.2/material-prime-v0.0.2.jar).

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
