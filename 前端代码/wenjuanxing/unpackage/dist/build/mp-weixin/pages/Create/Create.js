"use strict";const e=require("../../common/vendor.js"),o=require("../../common/buffer.js"),n={data:()=>({formData:{name:"",introduce:""}}),onShow(){o.buffer.questionnaire=[],o.buffer.questionnaireTitle={title:"",introduce:""}},methods:{submitForm(){""!==this.formData.name?e.index.navigateTo({url:"/pages/Questionnaire/Questionnaire?name="+this.formData.name+"&introduce="+this.formData.introduce}):e.index.showToast({title:"问卷名字必须填写！！！",icon:"none"})}}};if(!Array){(e.resolveComponent("uni-easyinput")+e.resolveComponent("uni-forms-item")+e.resolveComponent("uni-forms"))()}Math||((()=>"../../uni_modules/uni-easyinput/components/uni-easyinput/uni-easyinput.js")+(()=>"../../uni_modules/uni-forms/components/uni-forms-item/uni-forms-item.js")+(()=>"../../uni_modules/uni-forms/components/uni-forms/uni-forms.js"))();const t=e._export_sfc(n,[["render",function(o,n,t,a,i,r){return{a:e.o((e=>i.formData.name=e)),b:e.p({type:"text",placeholder:"请输入调查名称",modelValue:i.formData.name}),c:e.p({label:"调查名称",name:"name",required:"true"}),d:e.o((e=>i.formData.introduce=e)),e:e.p({type:"textarea",placeholder:"请输入调查简介",modelValue:i.formData.introduce}),f:e.p({label:"调查简介",name:"introduce"}),g:e.p({modelValue:i.formData,"label-position":"top"}),h:e.o(((...e)=>r.submitForm&&r.submitForm(...e)))}}],["__scopeId","data-v-3becbb76"]]);wx.createPage(t);
