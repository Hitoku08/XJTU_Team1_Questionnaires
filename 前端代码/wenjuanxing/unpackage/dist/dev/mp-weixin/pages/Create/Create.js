"use strict";
const common_vendor = require("../../common/vendor.js");
const common_buffer = require("../../common/buffer.js");
const _sfc_main = {
  data() {
    return {
      // 表单数据
      formData: {
        name: "",
        introduce: ""
      }
    };
  },
  onShow() {
    common_buffer.buffer.questionnaire = [];
    common_buffer.buffer.questionnaireTitle = {
      title: "",
      introduce: ""
    };
  },
  methods: {
    /**
     * 复写 binddata 方法，如果只是为了校验，无复杂自定义操作，可忽略此方法
     * @param {String} name 字段名称
     * @param {String} value 表单域的值
     */
    // binddata(name,value){
    // 通过 input 事件设置表单指定 name 的值
    //   this.$refs.form.setValue(name, value)
    // },
    // 触发提交表单
    submitForm() {
      if (this.formData.name === "") {
        common_vendor.index.showToast({
          title: "问卷名字必须填写！！！",
          icon: "none"
        });
        return;
      }
      common_vendor.index.navigateTo({
        url: "/pages/Questionnaire/Questionnaire?name=" + this.formData.name + "&introduce=" + this.formData.introduce
      });
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
    a: common_vendor.o(($event) => $data.formData.name = $event),
    b: common_vendor.p({
      type: "text",
      placeholder: "请输入调查名称",
      modelValue: $data.formData.name
    }),
    c: common_vendor.p({
      label: "调查名称",
      name: "name",
      required: "true"
    }),
    d: common_vendor.o(($event) => $data.formData.introduce = $event),
    e: common_vendor.p({
      type: "textarea",
      placeholder: "请输入调查简介",
      modelValue: $data.formData.introduce
    }),
    f: common_vendor.p({
      label: "调查简介",
      name: "introduce"
    }),
    g: common_vendor.p({
      modelValue: $data.formData,
      ["label-position"]: "top"
    }),
    h: common_vendor.o((...args) => $options.submitForm && $options.submitForm(...args))
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render], ["__scopeId", "data-v-0b1420d1"], ["__file", "E:/XXQ/wenjuanxing/pages/Create/Create.vue"]]);
wx.createPage(MiniProgramPage);
