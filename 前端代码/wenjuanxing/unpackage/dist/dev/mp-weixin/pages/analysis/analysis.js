"use strict";
const common_vendor = require("../../common/vendor.js");
const common_buffer = require("../../common/buffer.js");
const _sfc_main = {
  data() {
    return {
      title: "",
      introduce: "",
      formData: [],
      // e.g.
      id: -1
    };
  },
  onLoad(e) {
    this.id = e.id;
    this.getAnalysis();
  },
  methods: {
    change(e) {
      console.log(e);
    },
    getAnalysis() {
      common_vendor.index.showLoading({
        title: "数据加载中",
        mask: true
      });
      common_vendor.index.request({
        url: common_buffer.buffer.serverIp + "/results/return",
        method: "POST",
        data: {
          // questionnaire_id: this.id,
          questionnaire_id: this.id
        },
        success: (res) => {
          console.log(res);
          this.title = res.data.data.title;
          console.log(this.title);
          this.introduce = res.data.data.description;
          console.log(this.introduce);
          for (let i = 0; i < res.data.data.info.length; i++) {
            console.log(i);
            console.log(res.data.data.info[i]);
            if (res.data.data.info[i].type === "single") {
              console.log(res.data.data.info[i].answer_opt);
              this.formData.push({
                type: "single",
                title: res.data.data.info[i].question_content,
                answer: res.data.data.info[i].answer_opt
              });
            } else if (res.data.data.info[i].type === "multi") {
              this.formData.push({
                type: "multi",
                title: res.data.data.info[i].question_content,
                answer: res.data.data.info[i].answer_opt
              });
            } else if (res.data.data.info[i].type === "gap") {
              this.formData.push({
                type: "gap",
                title: res.data.data.info[i].question_content,
                answer: res.data.data.info[i].answer_text
              });
            }
          }
        },
        complete: () => {
          common_vendor.index.hideLoading();
        }
      });
    }
  }
};
if (!Array) {
  const _easycom_uni_th2 = common_vendor.resolveComponent("uni-th");
  const _easycom_uni_tr2 = common_vendor.resolveComponent("uni-tr");
  const _easycom_uni_td2 = common_vendor.resolveComponent("uni-td");
  const _easycom_uni_table2 = common_vendor.resolveComponent("uni-table");
  const _easycom_uni_collapse_item2 = common_vendor.resolveComponent("uni-collapse-item");
  const _easycom_uni_collapse2 = common_vendor.resolveComponent("uni-collapse");
  const _easycom_uni_card2 = common_vendor.resolveComponent("uni-card");
  (_easycom_uni_th2 + _easycom_uni_tr2 + _easycom_uni_td2 + _easycom_uni_table2 + _easycom_uni_collapse_item2 + _easycom_uni_collapse2 + _easycom_uni_card2)();
}
const _easycom_uni_th = () => "../../uni_modules/uni-table/components/uni-th/uni-th.js";
const _easycom_uni_tr = () => "../../uni_modules/uni-table/components/uni-tr/uni-tr.js";
const _easycom_uni_td = () => "../../uni_modules/uni-table/components/uni-td/uni-td.js";
const _easycom_uni_table = () => "../../uni_modules/uni-table/components/uni-table/uni-table.js";
const _easycom_uni_collapse_item = () => "../../uni_modules/uni-collapse/components/uni-collapse-item/uni-collapse-item.js";
const _easycom_uni_collapse = () => "../../uni_modules/uni-collapse/components/uni-collapse/uni-collapse.js";
const _easycom_uni_card = () => "../../uni_modules/uni-card/components/uni-card/uni-card.js";
if (!Math) {
  (_easycom_uni_th + _easycom_uni_tr + _easycom_uni_td + _easycom_uni_table + _easycom_uni_collapse_item + _easycom_uni_collapse + _easycom_uni_card)();
}
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: common_vendor.t($data.title),
    b: common_vendor.t($data.introduce),
    c: common_vendor.f($data.formData, (item, index, i0) => {
      return common_vendor.e({
        a: item.type === "gap"
      }, item.type === "gap" ? {
        b: "0f4179ed-5-" + i0 + "," + ("0f4179ed-4-" + i0),
        c: common_vendor.p({
          align: "center"
        }),
        d: "0f4179ed-6-" + i0 + "," + ("0f4179ed-4-" + i0),
        e: common_vendor.p({
          align: "center"
        }),
        f: "0f4179ed-4-" + i0 + "," + ("0f4179ed-3-" + i0),
        g: common_vendor.f(item.answer, (item2, index2, i1) => {
          return {
            a: common_vendor.t(index2 + 1),
            b: "0f4179ed-8-" + i0 + "-" + i1 + "," + ("0f4179ed-7-" + i0 + "-" + i1),
            c: common_vendor.t(item2),
            d: "0f4179ed-9-" + i0 + "-" + i1 + "," + ("0f4179ed-7-" + i0 + "-" + i1),
            e: index2,
            f: "0f4179ed-7-" + i0 + "-" + i1 + "," + ("0f4179ed-3-" + i0),
            g: common_vendor.p({
              index: index2
            })
          };
        }),
        h: "0f4179ed-3-" + i0 + "," + ("0f4179ed-2-" + i0),
        i: common_vendor.p({
          border: true,
          stripe: true,
          emptyText: "暂无更多数据"
        }),
        j: "0f4179ed-2-" + i0 + "," + ("0f4179ed-1-" + i0),
        k: common_vendor.p({
          title: "点击展开详情"
        }),
        l: "0f4179ed-1-" + i0 + "," + ("0f4179ed-0-" + i0),
        m: "0f4179ed-0-" + i0,
        n: common_vendor.p({
          title: index + 1 + "." + item.title
        })
      } : {
        o: "0f4179ed-13-" + i0 + "," + ("0f4179ed-12-" + i0),
        p: common_vendor.p({
          align: "center"
        }),
        q: "0f4179ed-14-" + i0 + "," + ("0f4179ed-12-" + i0),
        r: common_vendor.p({
          align: "center"
        }),
        s: "0f4179ed-12-" + i0 + "," + ("0f4179ed-11-" + i0),
        t: common_vendor.f(item.answer, (item2, index2, i1) => {
          return {
            a: common_vendor.t(item2.text),
            b: "0f4179ed-16-" + i0 + "-" + i1 + "," + ("0f4179ed-15-" + i0 + "-" + i1),
            c: common_vendor.t(item2.counts),
            d: "0f4179ed-17-" + i0 + "-" + i1 + "," + ("0f4179ed-15-" + i0 + "-" + i1),
            e: index2,
            f: "0f4179ed-15-" + i0 + "-" + i1 + "," + ("0f4179ed-11-" + i0),
            g: common_vendor.p({
              index: index2
            })
          };
        }),
        v: "0f4179ed-11-" + i0 + "," + ("0f4179ed-10-" + i0),
        w: common_vendor.p({
          border: true,
          stripe: true,
          emptyText: "暂无更多数据"
        }),
        x: "0f4179ed-10-" + i0,
        y: common_vendor.p({
          title: index + 1 + "." + item.title
        })
      }, {
        z: index,
        A: index
      });
    })
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render], ["__file", "E:/XXQ/wenjuanxing/pages/analysis/analysis.vue"]]);
wx.createPage(MiniProgramPage);
