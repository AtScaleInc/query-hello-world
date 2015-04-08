AtScale Query Hello World
=================

This straight forward example queries an existing table and exports it to a new table.

Prerequisites
==========
1. Java
   - Mac: https://www.java.com/en/download/help/mac_install.xml
   - Windows: https://www.java.com/en/download/help/windows_manual_download.xml
   - Linux: https://www.java.com/en/download/help/linux_x64_install.xml
2. Maven: https://maven.apache.org/download.cgi or `$ brew install maven` on Mac OSX

Running the Example
======

1. clone repo: `$ git clone git@github.com:AtScaleInc/query-hello-world.git`
2. move to directory: `$ cd query-hellow-world`
3. run command: 

  ```bash
  $ mvn clean compile exec:java\
    -Dexec.mainClass="com.atscale.engine.examples.helloworld.HelloWorld"\
    -Dexec.args="<atscale engine host> <export table prefix>"
  ```

<exported table prefix> can be any valid table name.

Mac OS X
========
If you are missing JAVA_HOME, set it in your terminal
```bash
export JAVA_HOME=$(/usr/libexec/java_home)
```
or put it in your .bash_profile
