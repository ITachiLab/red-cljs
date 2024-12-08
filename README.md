# red-cljs
This is a template for Node-RED nodes implemented in ClojureScript. The example implementation living in `src/red_cljs/core.cljs` is the same implementation you can find in the [official tutorial](https://nodered.org/docs/creating-nodes/first-node), but written in ClojureScript.

## Building

### Prerequisites

- Node.js
- NPM
- Clojure

### Development build

In the project root run: `npx shadow-cljs compile node`, the output will be written to: **red-cljs.js**. Since this is a development build, the script will depend on lots of files from the **.shadow-cljs** directory.

Now, in order to install the node in Node-RED, inside the Node-RED's user directory execute: `npm install /path/to/red-cljs`.

### Release build

In the project root run: `npx shadow-cljs release node`. This will create a **release** directory with three files:

- red-cljs.js - a minified version of the script;
- package.json - this is basically a copy of the same file from the root directory;
- red-cljs.html - the node's HTML, also a literal copy from the project's root.

Now, in order to install the node in Node-RED, inside the Node-RED's user directory execute: `npm install /path/to/red-cljs/release`.
