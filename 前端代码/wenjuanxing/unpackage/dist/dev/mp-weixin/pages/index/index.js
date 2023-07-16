"use strict";
const common_vendor = require("../../common/vendor.js");
const common_buffer = require("../../common/buffer.js");
const _sfc_main = {
  data() {
    return {
      searchValue: "",
      listArr: [],
      selectedId: -1,
      selectedIndex: -1
    };
  },
  onLoad() {
    this.getData();
  },
  methods: {
    changePage() {
      common_vendor.index.navigateTo({
        url: "../Create/Create"
      });
    },
    getData() {
      common_vendor.index.showLoading({
        title: "数据加载中",
        mask: true
      });
      common_vendor.index.request({
        url: common_buffer.buffer.serverIp + "/questionnaires/logindisplay",
        method: "POST",
        data: {
          user_id: common_buffer.buffer.userId
        },
        success: (res) => {
          console.log(res);
          for (let i = 0; i < res.data.data.length; i++) {
            this.listArr.push({
              title: res.data.data[i].title,
              introduce: res.data.data[i].description,
              questionnaireId: res.data.data[i].questionnaire_id,
              released: res.data.data[i].published
            });
          }
          common_buffer.buffer.questionnaireList = this.listArr;
          console.log(common_buffer.buffer.questionnaireList);
          console.log(this.listArr);
        },
        complete: () => {
          common_vendor.index.hideLoading();
        },
        fail: (res) => {
          console.log(res);
        }
      });
    },
    intoAnalysis(e) {
      common_vendor.index.navigateTo({
        url: "/pages/analysis/analysis?id=" + e
      });
    },
    toggle(id, index) {
      console.log(index);
      this.selectedId = id;
      this.selectedIndex = index;
      console.log(this.selectedIndex);
      this.$refs.popup.open("bottom");
    },
    actionsClick1(id, index) {
      console.log(id);
      console.log(index);
      console.log(this.listArr[index].released);
      if (!this.listArr[index].released) {
        console.log("this.listArr[index].released");
        common_vendor.index.request({
          url: common_buffer.buffer.serverIp + "/questionnaires/publish",
          method: "POST",
          data: {
            questionnaire_id: id
          },
          success: (res) => {
            console.log(res.data);
            if (res.data.status === 200) {
              common_vendor.index.setClipboardData({
                data: "http://www.wenjuanxing.one/#/?id=" + id
              });
              common_vendor.index.showToast({
                title: "发布成功！！",
                icon: "none"
              });
              setTimeout(() => {
                common_vendor.index.redirectTo({
                  url: "/pages/index/index"
                });
              }, 1e3);
            }
          },
          fail: (res) => {
            console.log(res);
          }
        });
      } else {
        common_vendor.index.request({
          url: common_buffer.buffer.serverIp + "/questionnaires/unpublish",
          method: "POST",
          data: {
            questionnaire_id: id
          },
          success: (res) => {
            if (res.data.status === 200) {
              common_vendor.index.showToast({
                title: "停止发布",
                icon: "none"
              });
              setTimeout(() => {
                common_vendor.index.redirectTo({
                  url: "/pages/index/index"
                });
              }, 1e3);
            }
          }
        });
      }
    },
    actionsClick2(id) {
      common_vendor.index.request({
        url: common_buffer.buffer.serverIp + "/questionnaires/delete",
        method: "POST",
        data: {
          questionnaire_id: id
        },
        success: (res) => {
          if (res.data.status === 200) {
            common_vendor.index.reLaunch({
              url: "/pages/index/index"
            });
          }
        }
      });
    },
    actionsClick3(id) {
      common_vendor.index.navigateTo({
        url: "/pages/analysis/analysis?id=" + id
      });
    }
  }
};
if (!Array) {
  const _easycom_uni_card2 = common_vendor.resolveComponent("uni-card");
  const _easycom_uni_icons2 = common_vendor.resolveComponent("uni-icons");
  const _easycom_uni_popup2 = common_vendor.resolveComponent("uni-popup");
  const _easycom_uni_fab2 = common_vendor.resolveComponent("uni-fab");
  (_easycom_uni_card2 + _easycom_uni_icons2 + _easycom_uni_popup2 + _easycom_uni_fab2)();
}
const _easycom_uni_card = () => "../../uni_modules/uni-card/components/uni-card/uni-card.js";
const _easycom_uni_icons = () => "../../uni_modules/uni-icons/components/uni-icons/uni-icons.js";
const _easycom_uni_popup = () => "../../uni_modules/uni-popup/components/uni-popup/uni-popup.js";
const _easycom_uni_fab = () => "../../uni_modules/uni-fab/components/uni-fab/uni-fab.js";
if (!Math) {
  (_easycom_uni_card + _easycom_uni_icons + _easycom_uni_popup + _easycom_uni_fab)();
}
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: common_vendor.f($data.listArr, (item, index, i0) => {
      return {
        a: common_vendor.t(item.introduce),
        b: common_vendor.o(($event) => $options.toggle(item.questionnaireId, index), index),
        c: "1cf27b2a-0-" + i0,
        d: common_vendor.p({
          title: item.title,
          extra: item.released ? "已发布" : "未发布"
        }),
        e: index,
        f: index
      };
    }),
    b: common_vendor.p({
      ["custom-prefix"]: "iconfont",
      type: "icon-fabu",
      size: "20",
      color: "#999"
    }),
    c: common_vendor.o(($event) => $options.actionsClick1($data.selectedId, $data.selectedIndex)),
    d: common_vendor.p({
      ["custom-prefix"]: "iconfont",
      type: "icon-shanchu",
      size: "20",
      color: "#999"
    }),
    e: common_vendor.o(($event) => $options.actionsClick2($data.selectedId)),
    f: common_vendor.p({
      ["custom-prefix"]: "iconfont",
      type: "icon-tongjijieguo",
      size: "20",
      color: "#999"
    }),
    g: common_vendor.o(($event) => $options.actionsClick3($data.selectedId)),
    h: common_vendor.sr("popup", "1cf27b2a-1"),
    i: common_vendor.p({
      ["background-color"]: "#fff"
    }),
    j: common_vendor.o(($event) => $options.changePage()),
    k: common_vendor.p({
      horizontal: "left",
      vertical: "bottom"
    })
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render], ["__scopeId", "data-v-1cf27b2a"], ["__file", "E:/XXQ/wenjuanxing/pages/index/index.vue"]]);
wx.createPage(MiniProgramPage);
