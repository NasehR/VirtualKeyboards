JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
		$(JC) $(JFLAGS) $*.java


CLASSES = \
			keyMeUp.java \

TESTCLASSES = \
			UnitTestLinkedList.java \
			UnitTestLinkedListIterator.java \
			UnitTestStack.java \
			UnitTestQueue.java \
			UnitTestGraph.java \

CLASSESLINKEDLIST = \
			UnitTestLinkedList.java \
			UnitTestLinkedListIterator.java \

CLASSESSTACK = \
			UnitTestStack.java \

CLASSESQUEUE = \
			UnitTestQueue.java \

CLASSESGRAPH = \
			UnitTestGraph.java \

default: classes

test: testclasses

linkedlist: linkedlistclasses

stack: stackclasses

queue: queueclasses

graph: graphclasses

classes: $(CLASSES:.java=.class)

testclasses: $(TESTCLASSES:.java=.class)

linkedlistclasses: $(CLASSESLINKEDLIST:.java=.class)

stackclasses: $(CLASSESSTACK:.java=.class)

queueclasses: $(CLASSESQUEUE:.java=.class)

graphclasses: $(CLASSESGRAPH:.java=.class)

clean:
		$(RM) *.class
		$(RM) dependencies/*.class
		$(RM) output.csv
