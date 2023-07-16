<template>
	<view class="display">
		<view class="title">
			<uni-title type="h1" :title="title" align="center"></uni-title>
			<view class="introduce"> {{introduce}} </view>
		</view>

		<view class="horizontal-line"></view>
		<uni-list class="content" v-for="(item,index) in dataArr" :index="index" :key="index">
			<uni-card v-if="item.type==='gap'">
				<uni-section :title="index+1 + '.' + item.title" type="circle">
					<uni-easyinput v-model="answerSheet[index].input"></uni-easyinput>
				</uni-section>
			</uni-card>
			<uni-card v-else-if="item.type==='single'">
				<uni-section :title="index+1 + '.' + item.title" type="circle">
					<view class="uni-px-5 uni-pb-5">
						<!-- <uni-data-checkbox :localdata="item.choices"></uni-data-checkbox> -->
						<uni-data-checkbox v-model="answerSheet[index].radio"
							:localdata="item.choices"></uni-data-checkbox>
					</view>
				</uni-section>
			</uni-card>
			<uni-card v-else-if="item.type==='multi'">
				<uni-section :title="index+1 + '.' + item.title" type="circle">
					<view v-if="answerSheet[index].checkbox" class="uni-px-5 uni-pb-5">
						<!-- <uni-data-checkbox multiple :localdata="item.choices"></uni-data-checkbox> -->
						<uni-data-checkbox v-model="answerSheet[index].checkbox" multiple
							:localdata="item.choices"></uni-data-checkbox>
					</view>
				</uni-section>
			</uni-card>
		</uni-list>
		<button @tap="submitForm">提交问卷</button>
	</view>
</template>

<script>
	import CryptoJS from '@/common/AES/AES.js';
	export default {
		data() {
			return {
				title: '',
				introduce: '',
				released: '',
				questionnaireId: -1,
				dataArr: [],
				answerSheet: [],
				key:'MyNameIsLiyan'
			}
		},
		onLoad(e) {
			this.questionnaireId=e.id;
			console.log(this.questionnaireId);
			
			this.getData();
			// console.log(this.dataArr.length);
			this.generateAnswerSheet();
		},
		methods: {
			
			getData() {
				uni.showLoading({
					title: "数据加载中",
					mask: true
				})
				uni.request({
					url: 'http://120.46.160.16:8088/questionnaires/display',
					method: 'POST',
					data: {
						questionnaire_id: this.questionnaireId
						// questionnaire_id: 6
					},
					success: res => {
						console.log(res);
						if(res.data.status===500){
							document.body.innerHTML = "问卷不存在";
						}
						else if (!res.data.data.published) {
							document.body.innerHTML = "问卷未发布";
						} else {
							this.title = res.data.data.title;
							this.introduce = res.data.data.description;
							// this.questionnaireId = res.data.data.questionnaire_id;
							uni.request({
								url: 'http://120.46.160.16:8088/questions/display',
								method: 'POST',
								data: {
									questionnaire_id: this.questionnaireId
								},
								success: (res) => {
									this.dataArr = res.data.data.quesoptns;
									console.log(res.data);
									for (let i = 0; i < this.dataArr.length; i++) {
										if (this.dataArr[i].type === 'single') {
											this.answerSheet.push({
												type: 'single',
												radio: -1
											})
										} else if (this.dataArr[i].type === 'multi') {
											this.answerSheet.push({
												type: 'multi',
												checkbox: []
											})
										} else {
											this.answerSheet.push({
												type: 'gap',
												input: ''
											})
										}
									}
								}
							})
						}
						// buffer.questionnaireList = this.listArr;
						// console.log(buffer.questionnaireList);
						console.log(res.data);
					},
					fail: (res) => {
						console.log(res)
					},
					complete: () => {
						uni.hideLoading()
					}
				})
			},
			submitForm() {
				console.log(this.dataArr);
				for (let i = 0; i < this.dataArr.length; i++) {
					if (this.dataArr[i].mustans) {
						console.log(this.dataArr[i].mustans)
						if ((this.answerSheet[i].type === 'single' && this.answerSheet[i].radio === -1) || (this
								.answerSheet[i].type === 'multi' && this.answerSheet[i].checkbox === []) || (this
								.answerSheet[i].type === 'gap' && this.answerSheet[i].input === '')) {
							uni.showToast({
								title: "第" + (i + 1) + "题必须回答",
								icon: 'error'
							})
							return;
						}
					}
				}
				uni.request({
					url: 'http://120.46.160.16:8088/response/product',
					method: 'POST',
					data: {
						id: this.questionnaireId,
						answer_json:this.answerSheet
					},
					success: (res) => {
						if (res.data.status === 200) {
							uni.redirectTo({
								url: '/pages/answersuccess/answersuccess'
							})
						}
					}
				})
				console.log(this.answerSheet)
			},
			generateAnswerSheet() {
				for (let i = 0; i < this.dataArr.length; i++) {
					if (this.dataArr[i].type === 'single') {
						this.answerSheet.push({
							type: 'single',
							radio: -1
						})
					} else if (this.dataArr[i].type === 'multi') {
						this.answerSheet.push({
							type: 'multi',
							checkbox: []
						})
					} else {
						this.answerSheet.push({
							type: 'gap',
							input: ''
						})
					}
				}
			}
		}
	}
</script>

<style lang="scss">
	.display {
		display: flex;
		flex-direction: column;
	}

	.title {
		padding: 20px 20px 0 20px;

		.introduce {
			font-size: 16px;
			color: #a1a1a1;
		}
	}

	.horizontal-line {
		border-top: 1px solid #dcdcdc;
		/* 设置上边框为实线，颜色为黑色 */
		margin: 20px 0;
		/* 设置上下间距，根据需要调整 */
	}
</style>