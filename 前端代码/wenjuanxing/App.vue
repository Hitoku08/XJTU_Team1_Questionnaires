<script>
	import buffer from '@/common/buffer.js';
	export default {
		onLaunch: function() {
			console.log('App Launch')
		},
		onShow: function() {
			console.log('App Show');
		},
		onHide: function() {
			console.log('App Hide');
			uni.reLaunch({
				url:'/pages/login/login',
				success: () => {
					console.log("yes");
					uni.request({
						url: buffer.serverIp + '/user/logout',
						method:'POST',
						data:{
							user_id:buffer.userId
						},
						success: (res) => {
							console.log(res.data)
						},
						fail: (res) => {
							console.log(res.data)
						}
					})
				}
			})
		},
		onUnload(){
			console.log("执行退出")
			uni.request({
				url: buffer.serverIp + '/user/logout',
				method:'POST',
				data:{
					user_id:buffer.userId
				},
				success: (res) => {
					console.log(res.data)
				},
				fail: (res) => {
					console.log(res.data)
				}
			})
		}
	}
</script>

<style>
	/*每个页面公共css */
	@import url('static/iconfont.css');
</style>
