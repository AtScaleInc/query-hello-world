AtScale Query Hello World
=================

1. clone repo: `$ git clone git@github.com:AtScaleInc/query-hello-world.git`
2. move to directory: `$ cd query-hellow-world`
3. install maven: `$ brew install maven` on mac
4. run command: 
  ```bash
  $ mvn compile exec:java\
    -Dexec.mainClass="com.atscale.api.helloworld.HelloWorld"\
    -Dexec.args="<atscale engine host> <export table prefix>"
  ```
