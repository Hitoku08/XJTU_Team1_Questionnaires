"use strict";
Object.defineProperty(exports, Symbol.toStringTag, { value: "Module" });
const common_vendor = require("./common/vendor.js");
if (!Math) {
  "./pages/login/login.js";
  "./pages/analysis/analysis.js";
  "./pages/gapFilling/gapFilling.js";
  "./pages/singleChoice/singleChoice.js";
  "./pages/index/index.js";
  "./pages/Create/Create.js";
  "./pages/Questionnaire/Questionnaire.js";
  "./pages/multiChoice/multiChoice.js";
  "./pages/display/display.js";
  "./pages/register/register.js";
}
const _sfc_main = {
  onLaunch: function() {
    console.log("App Launch");
  },
  onShow: function() {
    console.log("App Show");
  },
  onHide: function() {
    console.log("App Hide");
  }
};
const App = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__file", "E:/XXQ/wenjuanxing/App.vue"]]);
function createApp() {
  const app = common_vendor.createSSRApp(App);
  return {
    app
  };
}
createApp().app.mount("#app");
exports.createApp = createApp;
