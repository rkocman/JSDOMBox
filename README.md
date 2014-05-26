JSDOMBox
========
JSDOMBox is an experimental extension for the CSSBox.

It adds the ability to execute JavaScript and dynamically manipulate with the DOM content.

**Project status:** DOM Level 2 HTML Supported (Experimental JavaScript execution)

**Integrated development environment (IDE):** Eclipse (Kepler Service Release 2)

**Origin:** Master's thesis


### Dependencies
- CSSBox - See the project page for more information: [http://cssbox.sourceforge.net/](http://cssbox.sourceforge.net/)
- jStyleParser - See the project page for more information: [http://cssbox.sourceforge.net/jstyleparser](http://cssbox.sourceforge.net/jstyleparser)


### Basic installation guide
1. Install [JDK 1.7](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or newer
2. Install [Eclipse IDE](http://www.eclipse.org/downloads/) (with [Git](http://eclipse.org/egit/) and [Maven](http://www.eclipse.org/m2e/) plugins)
3. Create a new workspace
4. Clone and build [jStyleParser](https://github.com/radkovo/jStyleParser)
5. Clone and build [CSSBox](https://github.com/radkovo/CSSBox)
6. Clone and build JSDOMBox

### Demos
This package contains two GUI applications:
- `org.fit.vutbr.jsdombox.demo.SimpleExample` - Basic usage example  
- `test.JSDOMBoxTestSuite` - Test suite application for the JSDOMBox (Use arrow keys for easier navigation)

## License
All the source code of the JSDOMBox itself is licensed under the GNU Lesser General Public License (LGPL), version 3. A copy of the LGPL can be found in the LICENSE file.