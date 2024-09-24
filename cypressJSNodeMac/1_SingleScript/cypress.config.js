const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    env: {
      //commandDelay: 10,
    },
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
  },
});
