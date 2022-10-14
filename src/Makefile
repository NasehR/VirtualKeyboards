JFLAGS = -g
JC = javac

.SUFFIXES: .java .class

.java.class:
		$(JC) $(JFLAGS) $*.java


CLASSES = \
			keyMeUp.java \
			modes.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) *.class
		$(RM) dependencies/*.class
		$(RM) output.csv
