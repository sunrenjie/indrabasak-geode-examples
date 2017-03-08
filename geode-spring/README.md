[![Build Status][travis-badge]][travis-badge-url]

Apache Geode Examples
=========================================
This is a [**Spring Cloud**](http://projects.spring.io/spring-cloud/) based microservices examples backed by
[**Apache Geode**](http://geode.apache.org/) data management platform.
 
# Install Apache Geode
You can find detailed Geode installation [here](http://geode.apache.org/docs/guide/11/getting_started/installation/install_standalone.html#concept_0129F6A1D0EB42C4A3D24861AF2C5425).
Below are are the main steps for installation.

1. Make sure `JAVA_HOME` environment variable ia set up in your computer.
2. Download the `.zip` or `.tar` file from [here](http://geode.apache.org/releases/).
3. Uncompress the file to a folder of your choice.
4. Open a console/terminal and navigate to `bin` directory under the newly installed folder.
5. Geode provides a command line tool (shell) called `gfsh` (pronounced “jee-fish”). 
Verify Geode installation by typing the `gfsh version` command on your terminal:
```
$ gfsh version
1.1.0
```

#### Start gfsh (Geode shell)
Start `gfsh` by typing the following on your terminal:
```
$ gfsh
    _________________________     __
   / _____/ ______/ ______/ /____/ /
  / /  __/ /___  /_____  / _____  / 
 / /__/ / ____/  _____/ / /    / /  
/______/_/      /______/_/    /_/    1.1.0

Monitor and Manage Apache Geode
gfsh>
```

#### Start a Geode Locator
A Geode locator provides location service and load balacing functionalities. It tells the connecting members where 
the running members are located.  
To start a locator named `locator`, execute the following command at the`gfsh` prompt: 
```
gfsh>start locator --name=locator
Starting a Geode Locator in /Users/indra.basak/Software/apache-geode-1.1.0/bin/locator...
.......................
Locator in /Users/indra.basak/Software/apache-geode-1.1.0/bin/locator on ibasa-mb-20824.ib.com[10334] as locator is currently online.
Process ID: 55991
Uptime: 12 seconds
Geode Version: 1.1.0
Java Version: 1.8.0_92
Log File: /Users/indra.basak/Software/apache-geode-1.1.0/bin/locator/locator.log
JVM Arguments: -Dgemfire.enable-cluster-configuration=true -Dgemfire.load-cluster-configuration-from-dir=false 
 -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true 
 -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-core-1.1.0.jar
  :/Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-dependencies.jar

Successfully connected to: JMX Manager [host=ibasa-mb-20824.ib.com, port=1099]

Cluster configuration service is up and running.
```
The locator starts up at the default port `1099`

#### Start a Geode Server
A Geode server is a long running configurable process (member of a cluster).
To start a server named `server`, execute the following command at the`gfsh` prompt: 
```
gfsh>start server --name=server
Starting a Geode Server in /Users/indra.basak/Software/apache-geode-1.1.0/bin/server...
.......
Server in /Users/indra.basak/Software/apache-geode-1.1.0/bin/server on ibasa-mb-20824.ib.com[40404] as server 
  is currently online.
Process ID: 56298
Uptime: 3 seconds
Geode Version: 1.1.0
Java Version: 1.8.0_92
Log File: /Users/indra.basak/Software/apache-geode-1.1.0/bin/server/server.log
JVM Arguments: -Dgemfire.default.locators=10.16.32.57[10334] -Dgemfire.use-cluster-configuration=true 
  -Dgemfire.start-dev-rest-api=false -XX:OnOutOfMemoryError=kill -KILL %p -Dgemfire.launcher.registerSignalHandlers=true 
  -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-core-1.1.0.jar
  :/Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-dependencies.jar
```
The server starts up at the default port `40404`


# Modules
The project consist of multiple modules and can be classified into following categories:

1. **Services**
    1. `geode-spring-model` - contains all the models used in our examples
    2. `geode-spring-service` - example Spring cloud project which uses Spring Boot and Spring Data to connect to Geode


# Build
Execute the following command from the parent directory:
```
mvn clean install
```

[travis-badge]: https://travis-ci.org/indrabasak/spring-cloud-example.svg?branch=master
[travis-badge-url]: https://travis-ci.org/indrabasak/spring-cloud-example/


start locator --name=locator

start server --name=server

create region --name=Book --type=REPLICATE
quit;

gfsh>list regions
List of regions
---------------
Book

gfsh>query --query='SELECT * FROM /Book'

Result     : true
startCount : 0
endCount   : 20
Rows       : 0

gfsh>query --query='SELECT * FROM /Book'

Result     : false
startCount : 0
endCount   : 20
Message    : Could not create an instance of a  class Book

NEXT_STEP_NAME : END

gfsh>describe region --name=Book

gfsh>stop server --name=server
Stopping Cache Server running in /Users/indra.basak/Software/apache-geode-1.1.0/bin/server on 192.168.1.6[40404] as server...
Process ID: 5244
Log File: /Users/indra.basak/Software/apache-geode-1.1.0/bin/server/server.log
...

gfsh>stop locator --name=locator
Stopping Locator running in /Users/indra.basak/Software/apache-geode-1.1.0/bin/locator on 192.168.1.6[10334] as locator...
Process ID: 5196
Log File: /Users/indra.basak/Software/apache-geode-1.1.0/bin/locator/locator.log
....

gfsh>deploy --jar=/tmp/geode-example-1.0-SNAPSHOT.jar

gfsh>start locator --name=locator
Starting a Geode Locator in /Users/indra.basak/Software/apache-geode-1.1.0/bin/locator...
.......................
Locator in /Users/indra.basak/Software/apache-geode-1.1.0/bin/locator on ibasa-mb-20318.iovation.com[10334] as locator is currently online.
Process ID: 2077
Uptime: 12 seconds
Geode Version: 1.1.0
Java Version: 1.8.0_92
Log File: /Users/indra.basak/Software/apache-geode-1.1.0/bin/locator/locator.log
JVM Arguments: -Dgemfire.enable-cluster-configuration=true -Dgemfire.load-cluster-configuration-from-dir=false -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-core-1.1.0.jar:/Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-dependencies.jar

Successfully connected to: JMX Manager [host=ibasa-mb-20318.iovation.com, port=1099]

Cluster configuration service is up and running.

gfsh>start server --name=server
Starting a Geode Server in /Users/indra.basak/Software/apache-geode-1.1.0/bin/server...
.......
Server in /Users/indra.basak/Software/apache-geode-1.1.0/bin/server on ibasa-mb-20318.iovation.com[40404] as server is currently online.
Process ID: 2094
Uptime: 3 seconds
Geode Version: 1.1.0
Java Version: 1.8.0_92
Log File: /Users/indra.basak/Software/apache-geode-1.1.0/bin/server/server.log
JVM Arguments: -Dgemfire.default.locators=10.16.32.57[10334] -Dgemfire.use-cluster-configuration=true -Dgemfire.start-dev-rest-api=false -XX:OnOutOfMemoryError=kill -KILL %p -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-core-1.1.0.jar:/Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-dependencies.jar

gfsh>deploy --jar=/tmp/geode-spring-model-1.0.jar
Member |        Deployed JAR        | Deployed JAR Location
------ | -------------------------- | ------------------------------------------
server | geode-spring-model-1.0.jar | /Users/indra.basak/Software/apache-geode..

gfsh>query --query='SELECT * FROM /Book'

Result     : false
startCount : 0
endCount   : 20
Message    : Could not deserialize pdx because a PdxSerializer does not exist.

NEXT_STEP_NAME : END

gfsh>deploy --jar=/tmp/geode-core-1.1.0.jar
Member |     Deployed JAR     | Deployed JAR Location
------ | -------------------- | ---------------------
server | geode-core-1.1.0.jar | Already deployed

gfsh>start locator --name=locator
Starting a Geode Locator in /Users/indra.basak/Software/apache-geode-1.1.0/bin/locator...
.....
Locator in /Users/indra.basak/Software/apache-geode-1.1.0/bin/locator on 192.168.1.6[10334] as locator is currently online.
Process ID: 6500
Uptime: 2 seconds
Geode Version: 1.1.0
Java Version: 1.8.0_92
Log File: /Users/indra.basak/Software/apache-geode-1.1.0/bin/locator/locator.log
JVM Arguments: -Dgemfire.enable-cluster-configuration=true -Dgemfire.load-cluster-configuration-from-dir=false -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-core-1.1.0.jar:/Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-dependencies.jar

Successfully connected to: JMX Manager [host=192.168.1.6, port=1099]

Cluster configuration service is up and running.

***
gfsh>start server --name=server
Starting a Geode Server in /Users/indra.basak/Software/apache-geode-1.1.0/bin/server...
......
Server in /Users/indra.basak/Software/apache-geode-1.1.0/bin/server on 192.168.1.6[40404] as server is currently online.
Process ID: 6511
Uptime: 3 seconds
Geode Version: 1.1.0
Java Version: 1.8.0_92
Log File: /Users/indra.basak/Software/apache-geode-1.1.0/bin/server/server.log
JVM Arguments: -Dgemfire.default.locators=192.168.1.6[10334] -Dgemfire.use-cluster-configuration=true -Dgemfire.start-dev-rest-api=false -XX:OnOutOfMemoryError=kill -KILL %p -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-core-1.1.0.jar:/Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-dependencies.jar

***
gfsh>create region --name=Book --type=REPLICATE
Member | Status
------ | ----------------------------------
server | Region "/Book" created on "server"

gfsh>
***
gfsh>query --query='SELECT * FROM /Book'

Result     : true
startCount : 0
endCount   : 20
Rows       : 0


NEXT_STEP_NAME : END

gfsh>
***
gfsh>query --query='SELECT * FROM /Book'

Result     : false
startCount : 0
endCount   : 20
Message    : Could not create an instance of a class com.basaki.example.geode.spring.model.Book

NEXT_STEP_NAME : END

gfsh>
****
deploy --jar=/tmp/geode-spring-model-1.0-with-dependencies.jar

configure pdx --auto-serializable-classes=com\.basaki\.example\.geode\.spring\.model..*

gfsh>configure pdx --auto-serializable-classes=com\.basaki\.example\.geode\.spring\.model..*
The command would only take effect on new data members joining the distributed system. It won't affect the existing data members
persistent = false
read-serialized = false
ignore-unread-fields = false
PDX Serializer : org.apache.geode.pdx.ReflectionBasedAutoSerializer
Non portable classes :[com\.basaki\.example\.geode\.spring\.model..*]

gfsh>query --query='SELECT * FROM /Book'

Result     : true
startCount : 0
endCount   : 20
Rows       : 0


NEXT_STEP_NAME : END

gfsh>

deploy --jar=/tmp/geode-spring-model-1.0.jar

configure pdx --portable-auto-serializable-classes=com\.basaki\.example\.geode\.spring\.model..*


ibasa-mb-20405:bin indra.basak$ export JAVA_ARGS="-Dgeode.cache-xml-file=gfsh-cache.xml"
ibasa-mb-20405:bin indra.basak$ ./gfsh
    _________________________     __
   / _____/ ______/ ______/ /____/ /
  / /  __/ /___  /_____  / _____  / 
 / /__/ / ____/  _____/ / /    / /  
/______/_/      /______/_/    /_/    1.1.0

Monitor and Manage Apache Geode
gfsh>start locator --name=locator
Starting a Geode Locator in /Users/indra.basak/Software/apache-geode-1.1.0/bin/locator...
.....
Locator in /Users/indra.basak/Software/apache-geode-1.1.0/bin/locator on 192.168.1.6[10334] as locator is currently online.
Process ID: 5036
Uptime: 2 seconds
Geode Version: 1.1.0
Java Version: 1.8.0_92
Log File: /Users/indra.basak/Software/apache-geode-1.1.0/bin/locator/locator.log
JVM Arguments: -Dgemfire.enable-cluster-configuration=true -Dgemfire.load-cluster-configuration-from-dir=false -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-core-1.1.0.jar:/Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-dependencies.jar

Successfully connected to: JMX Manager [host=192.168.1.6, port=1099]

Cluster configuration service is up and running.

gfsh>start server --name=server
Starting a Geode Server in /Users/indra.basak/Software/apache-geode-1.1.0/bin/server...
......
Server in /Users/indra.basak/Software/apache-geode-1.1.0/bin/server on 192.168.1.6[40404] as server is currently online.
Process ID: 5055
Uptime: 3 seconds
Geode Version: 1.1.0
Java Version: 1.8.0_92
Log File: /Users/indra.basak/Software/apache-geode-1.1.0/bin/server/server.log
JVM Arguments: -Dgemfire.default.locators=192.168.1.6[10334] -Dgemfire.use-cluster-configuration=true -Dgemfire.start-dev-rest-api=false -XX:OnOutOfMemoryError=kill -KILL %p -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-core-1.1.0.jar:/Users/indra.basak/Software/apache-geode-1.1.0/lib/geode-dependencies.jar

gfsh>query --query='SELECT * FROM /Book'

Result     : true
startCount : 0
endCount   : 20
Rows       : 0


NEXT_STEP_NAME : END

gfsh>query --query='SELECT * FROM /Book'

Result     : true
startCount : 0
endCount   : 20
Rows       : 1

                 id                  | title | author
------------------------------------ | ----- | ------
709ea0f6-ed04-477f-8732-e5cce264b715 | TEST  | INDRA

NEXT_STEP_NAME : END

gfsh>

gfsh>query --query='SELECT * FROM /Book'

Result     : true
startCount : 0
endCount   : 20
Rows       : 1

                 id                  | title | author
------------------------------------ | ----- | ------
709ea0f6-ed04-477f-8732-e5cce264b715 | TEST  | INDRA

NEXT_STEP_NAME : END

gfsh>query --query='SELECT * FROM /Book'

Result     : true
startCount : 0
endCount   : 20
Rows       : 2

                                     Value                                      |                  id                  | title | author
------------------------------------------------------------------------------- | ------------------------------------ | ----- | ------
Error getting bean properties Expected a ',' or '}' at 60 [character 61 line 1] | 709ea0f6-ed04-477f-8732-e5cce264b715 | TEST  | INDRA
null                                                                            | null                                 | null  | null

NEXT_STEP_NAME : END

gfsh>query --query='SELECT * FROM /Book'

Result     : true
startCount : 0
endCount   : 20
Rows       : 2

                                     Value                                      |                  id                  | title | author
------------------------------------------------------------------------------- | ------------------------------------ | ----- | ------
Error getting bean properties Expected a ',' or '}' at 60 [character 61 line 1] | 709ea0f6-ed04-477f-8732-e5cce264b715 | TEST  | INDRA
null                                                                            | null                                 | null  | null

NEXT_STEP_NAME : END

gfsh>query --query='SELECT * FROM /Book'

Result     : true
startCount : 0
endCount   : 20
Rows       : 3

                 id                  | title | author | Value
------------------------------------ | ----- | ------ | -------------------------------------------------------------------------------
53920511-62d8-4464-931c-4b539467eab5 | YO YO | SARAH  | Error getting bean properties Expected a ',' or '}' at 60 [character 61 line 1]
709ea0f6-ed04-477f-8732-e5cce264b715 | TEST  | INDRA  | null
null                                 | null  | null   | null

NEXT_STEP_NAME : END