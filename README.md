# vmf-parser

Java Parser for the VMF files

## Setup

This parser is tested under Java 7. Dependency and build management is handled using ``Gradle`` 2.2.

### Building vmf-parser

From the project root, run:

    $ gradle build
    
This task will compile all classes, assemble the JAR and run the unit tests. If any test fails, the build will fail.

The resultant JAR is found at ``build/libs/vmf-parser-#.#.#.jar``

### Testing vmf-parser

From the project root, run:

    $ gradle test

A test result report can be found at ``build/reports/tests/index.html``
    
### Cleaning the Build

Gradle produces all artifacts in a directory called ``build`` within the project root. To remove this directory, run:

    $ gradle clean
    
### Generating Javadoc

Javadoc is provided on all packages, classes, and method. To generate the Javadoc, run:

    $ gradle javadoc
    
The resultant Javadoc is found at ``build/docs/javadoc/index.html``
    
### Generating a Test Coverage Report

Jacoco is used for determining test coverage. To produce a test coverage report, run:

    $ gradle jacocoTestReport
    
The resultant test coverage report is found in ``build/jacocoHtml/index.html``

## Usage

To use the parser, an instance of ``VMFParser`` must be instantiated with a ``File`` instance pointing to the VMF file
as a parameter.

    VMFParser parser = new VMFParser(new File(vmfURI));

With this ``VMFParser`` instance initialized, the VMF file can be parsed as follows:

    VectorMusic music = parser.parse();
    
The ``parse()`` method of the ``VMFParser`` class will return a ``VectorMusic`` instance which is the root class of
the object model representing the VMF file. The API for this object model can be found in the [Javadoc](http://project-schumann.github.io/vmf-parser/).