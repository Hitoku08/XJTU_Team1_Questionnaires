"use strict";
const common_vendor = require("../../common/vendor.js");
const common_buffer = require("../../common/buffer.js");
const _sfc_main = {
  data() {
    return {
      // 表单数据
      formData: {
        type: "gap",
        title: "",
        mustans: true
      },
      num: -1
    };
  },
  onLoad(e) {
    console.log(e.index);
    if (e.index !== void 0) {
      this.formData = common_buffer.buffer.questionnaire[e.index];
      this.num = e.index;
      console.log("有参的时候");
      return;
    }
    console.log("无参的时候");
  },
  methods: {
    submit() {
      if (this.formData.title === "") {
        common_vendor.index.showToast({
          title: "标题不能为空!",
          icon: "none"
        });
        return;
      }
      if (this.num === -1) {
        common_buffer.buffer.questionnaire.push(this.formData);
      }
      common_vendor.index.navigateBack({
        delta: 1,
        success() {
          common_vendor.index.redirectTo({
            url: "/pages/Questionnaire/Questionnaire?name=" + common_buffer.buffer.questionnaireTitle.title + "&introduce=" + common_buffer.buffer.questionnaireTitle.introduce
          });
        }
      });
    },
    change() {
      this.formData.mustans = !this.formData.mustans;
    }
  }
};
if (!Array) {
  const _easycom_uni_easyinput2 = common_vendor.resolveComponent("uni-easyinput");
  const _easycom_uni_forms_item2 = common_vendor.resolveComponent("uni-forms-item");
  const _easycom_uni_forms2 = common_vendor.resolveComponent("uni-forms");
  (_easycom_uni_easyinput2 + _easycom_uni_forms_item2 + _easycom_uni_forms2)();
}
const _easycom_uni_easyinput = () => "../../uni_modules/uni-easyinput/components/uni-easyinput/uni-easyinput.js";
const _easycom_uni_forms_item = () => "../../uni_modules/uni-forms/components/uni-forms-item/uni-forms-item.js";
const _easycom_uni_forms = () => "../../uni_modules/uni-forms/components/uni-forms/uni-forms.js";
if (!Math) {
  (_easycom_uni_easyinput + _easycom_uni_forms_item + _easycom_uni_forms)();
}
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: common_vendor.o(($event) => $data.formData.title = $event),
    b: common_vendor.p({
      type: "textarea",
      placeholder: "请输入标题",
      modelValue: $data.formData.title
    }),
    c: common_vendor.p({
      label: "标题",
      required: "true"
    }),
    d: common_vendor.p({
      modelValue: $data.formData,
      ["label-position"]: "top"
    }),
    e: common_vendor.o((...args) => $options.change && $options.change(...args)),
    f: common_vendor.o((...args) => $options.submit && $options.submit(...args))
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render], ["__file", "E:/XXQ/wenjuanxing/pages/gapFilling/gapFilling.vue"]]);
wx.createPage(MiniProgramPage);
