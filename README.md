AtScale Query Hello World
=================

1. clone repo: `$ git clone git@github.com:AtScaleInc/query-hello-world.git`
2. move to directory: `$ cd query-hellow-world`
3. install maven: `$ brew install maven` on mac
4. run command: 

  ```bash
  $ mvn clean compile exec:java\
    -Dexec.mainClass="com.atscale.engine.examples.helloworld.HelloWorld"\
    -Dexec.args="<atscale engine host> <export table prefix>"
  ```

Mac OS X
========
If you are missing JAVA_HOME, set it in your terminal
```bash
export JAVA_HOME=$(/usr/libexec/java_home)
```
or put it in your .bash_profile
