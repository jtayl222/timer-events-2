Repository Init Content
=======================

<pre>
I can't import https://github.com/diego-torres/timer-events
git@github.com:diego-torres/timer-events.git
https://github.com/diego-torres/timer-events/blob/main/pom.xml

1. When I start with a "standard" RHPAM 7.8 and settings.xml
    (https://github.com/jtayl222/settings/blob/master/settings/redhat-ga-repository/settings.xml)
    There are no projects available to import. Check the URL, the credentials, and if there's a master branch in the repository.

2. I can clone it, but can't build it with maven:
    Unresolveable build extension: Plugin org.kie:kie-maven-plugin:7.42.0-SNAPSHOT or one of its dependencies could not be resolved: Could not find artifact org.kie:kie-maven-plugin:jar:7.42.0-SNAPSHOT

3. Change settings.xml to
    https://github.com/jtayl222/settings/blob/master/settings/jboss-public-repository-group/settings.xml
    The mvn build is now OK, but I still can't import the project

4. Create a new BC project timer-events-2
    Clone .niogit
    cd

mkdir timer-events-2/global/
cp timer-events/global/WorkDefinitions.wid timer-events-2/global/
cp timer-events/src/main/resources/com/myspace/timer_events/*bpmn timer-events-2/src/main/resources/com/myspace/timer_events_2/
cp timer-events/src/main/java/com/myspace/timer_events/LogWorkitemHandler.java timer-events-2/src/main/java/com/myspace/timer_events_2/
cp timer-events/src/main/resources/META-INF/kie-deployment-descriptor.xml timer-events-2/src/main/resources/META-INF/
git add, commit, push
change: LogWorkitemHandler.java: package com.myspace.timer_events_2;
modify name and artifactId in pom.xml (timer-events-2)

$ diff timer-events/src/main/resources/META-INF/kie-deployment-descriptor.xml timer-events-2/src/main/resources/META-INF/kie-deployment-descriptor.xml
7c7
&lt;     &lt;runtime-strategy&gt;PER_PROCESS_INSTANCE&lt;/runtime-strategy&gt;
---
&gt;     &lt;runtime-strategy&gt;SINGLETON&lt;/runtime-strategy&gt;
12,19c12
&lt;     &lt;work-item-handlers&gt;
&lt;         &lt;work-item-handler&gt;
&lt;             &lt;resolver&gt;mvel&lt;/resolver&gt;
&lt;             &lt;identifier&gt;new com.myspace.timer_events.LogWorkitemHandler()&lt;/identifier&gt;
&lt;             &lt;parameters/&gt;
&lt;             &lt;name&gt;Log&lt;/name&gt;
&lt;         &lt;/work-item-handler&gt;
&lt;     &lt;/work-item-handlers&gt;
---
&gt;     &lt;work-item-handlers/&gt;



Build: OK
Deploy: OK
Start: OK
</pre>
