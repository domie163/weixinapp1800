<template>
	<view class="diy_edit page_resume_information" id="resume_information_edit">
		<view class='warp'>
			<view class='container'>
				<view class='row'>
						<view v-if="$check_field('set','user_information') || $check_field('add','user_information') || $check_field('get','user_information')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								用户信息:
							</text>
						</view>
						<view class="diy_field diy_down diy_text_row diy_select_flex">
							<uni-data-select
									id="form_user_information"
									v-model="form['user_information']"
									:localdata="list_user_user_information"
									:clear="!disabledObj['user_information_isDisabled']"
									:disabled="disabledObj['user_information_isDisabled']"
									v-if="(form['user_information'] && $check_field('set','user_information')) || (!form['user_information'] && $check_field('add','user_information'))"
							></uni-data-select>
							<text v-else-if="$check_field('get','user_information')">{{ form['user_information'] }}</text>
						</view>
					</view>
							<view v-if="$check_field('set','user_name') || $check_field('add','user_name') || $check_field('get','user_name')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								用户姓名:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_user_name" v-model="form['user_name']" placeholder="请输入用户姓名" v-if="(form['user_name'] && $check_field('set','user_name')) || (!form['user_name'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']" />
							<text v-else-if="$check_field('get','user_name')">{{ form['user_name'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','user_gender') || $check_field('add','user_gender') || $check_field('get','user_gender')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								用户性别:
							</text>
						</view>
								<!-- 选项 -->
						<view class="diy_field diy_down diy_text_row diy_select_flex">
							<uni-data-select
									id="form_user_gender"
									v-model="form['user_gender']"
									:localdata="list_user_gender"
									v-if="(form['user_gender'] && $check_field('set','user_gender')) || (!form['user_gender'] && $check_field('add','user_gender'))"
							></uni-data-select>
							<text v-else-if="$check_field('get','user_gender')">{{ form['user_gender'] }}</text>
						</view>
							</view>
							<view v-if="$check_field('set','user_age') || $check_field('add','user_age') || $check_field('get','user_age')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								用户年龄:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_user_age" v-model="form['user_age']" placeholder="请输入用户年龄" v-if="(form['user_age'] && $check_field('set','user_age')) || (!form['user_age'] && $check_field('add','user_age'))" :disabled="disabledObj['user_age_isDisabled']" />
							<text v-else-if="$check_field('get','user_age')">{{ form['user_age'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','personal_education') || $check_field('add','personal_education') || $check_field('get','personal_education')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								个人学历:
							</text>
						</view>
								<!-- 选项 -->
						<view class="diy_field diy_down diy_text_row diy_select_flex">
							<uni-data-select
									id="form_personal_education"
									v-model="form['personal_education']"
									:localdata="list_personal_education"
									v-if="(form['personal_education'] && $check_field('set','personal_education')) || (!form['personal_education'] && $check_field('add','personal_education'))"
							></uni-data-select>
							<text v-else-if="$check_field('get','personal_education')">{{ form['personal_education'] }}</text>
						</view>
							</view>
							<view v-if="$check_field('set','contact_information') || $check_field('add','contact_information') || $check_field('get','contact_information')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								联系方式:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_contact_information" v-model="form['contact_information']" placeholder="请输入联系方式" v-if="(form['contact_information'] && $check_field('set','contact_information')) || (!form['contact_information'] && $check_field('add','contact_information'))" :disabled="disabledObj['contact_information_isDisabled']" />
							<text v-else-if="$check_field('get','contact_information')">{{ form['contact_information'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','enterprise_information') || $check_field('add','enterprise_information') || $check_field('get','enterprise_information')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								企业信息:
							</text>
						</view>
						<view class="diy_field diy_down diy_text_row diy_select_flex">
							<uni-data-select
									id="form_enterprise_information"
									v-model="form['enterprise_information']"
									:localdata="list_user_enterprise_information"
									:clear="!disabledObj['enterprise_information_isDisabled']"
									:disabled="disabledObj['enterprise_information_isDisabled']"
									v-if="(form['enterprise_information'] && $check_field('set','enterprise_information')) || (!form['enterprise_information'] && $check_field('add','enterprise_information'))"
							></uni-data-select>
							<text v-else-if="$check_field('get','enterprise_information')">{{ form['enterprise_information'] }}</text>
						</view>
					</view>
							<view v-if="$check_field('set','enterprise_name') || $check_field('add','enterprise_name') || $check_field('get','enterprise_name')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								企业名称:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_enterprise_name" v-model="form['enterprise_name']" placeholder="请输入企业名称" v-if="(form['enterprise_name'] && $check_field('set','enterprise_name')) || (!form['enterprise_name'] && $check_field('add','enterprise_name'))" :disabled="disabledObj['enterprise_name_isDisabled']" />
							<text v-else-if="$check_field('get','enterprise_name')">{{ form['enterprise_name'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','recruitment_position') || $check_field('add','recruitment_position') || $check_field('get','recruitment_position')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								招聘岗位:
							</text>
						</view>
								<!-- 文本 -->
									<view class="diy_field diy_text diy_text_row">
							<input type="text" id="form_recruitment_position" v-model="form['recruitment_position']" placeholder="请输入招聘岗位" v-if="(form['recruitment_position'] && $check_field('set','recruitment_position')) || (!form['recruitment_position'] && $check_field('add','recruitment_position'))" :disabled="disabledObj['recruitment_position_isDisabled']" />
							<text v-else-if="$check_field('get','recruitment_position')">{{ form['recruitment_position'] }}</text>
						</view>
										</view>
							<view v-if="$check_field('set','curriculum_vitae') || $check_field('add','curriculum_vitae') || $check_field('get','curriculum_vitae')" class="col-12 col-md-6 row-item">
						<view class="diy_title diy_text_row">
							<text>
								个人简历:
							</text>
						</view>
								<!-- 图片 -->
						<!-- 修改权限 -->
						<view class="diy_field diy_img diy_text_row" v-if="form['curriculum_vitae'] && $check_field('set','curriculum_vitae')">
							<image v-if="disabledObj['curriculum_vitae_isDisabled']" :src="$fullUrl(form['curriculum_vitae'])" />
							<image v-if="!disabledObj['curriculum_vitae_isDisabled']" :src="$fullUrl(form['curriculum_vitae'])" @click="change_img('curriculum_vitae')" />
						</view>
						<!-- 添加权限 -->
						<view class="diy_field diy_img diy_text_row" v-else-if="!form['curriculum_vitae'] && $check_field('add','curriculum_vitae')">
							<view v-if="disabledObj['curriculum_vitae_isDisabled']" class="btn_add_img">
								<text>+</text>
							</view>
							<view v-if="!disabledObj['curriculum_vitae_isDisabled']" class="btn_add_img diy_text_row" @click="change_img('curriculum_vitae')">
								<text>+</text>
							</view>
						</view>
						<!-- 查询权限 -->
						<view class="diy_field diy_img diy_text_row" v-else-if="$check_field('get','curriculum_vitae')">
							<image :src="$fullUrl(form['curriculum_vitae'])" />
						</view>
						<uni-icons style="display: none;" class="forward" type="forward" id="form_img_curriculum_vitae"></uni-icons>
							</view>
	
				</view>
				<view class="row">
					<view class="col-12">
						<view class="btn_box">
							<button class="btn_submit primary_btn" @click="submit()">提交</button>
						</view>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
import mixin from "@/libs/mixins/page.js";
export default {
	mixins:[mixin],
	components:{},
	data(){
		return{
			url_get_obj:"~/api/resume_information/get_obj?",
			url_add:"~/api/resume_information/add?",
			url_set:"~/api/resume_information/set?",

			// 登录权限
			oauth: {
				"signIn": true,
				"user_group": []
			},

			// 查询条件
			query: {
					"user_information": 0,
						"user_name": "",
						"user_gender": "",
						"user_age": "",
						"personal_education": "",
						"contact_information": "",
						"enterprise_information": 0,
						"enterprise_name": "",
						"recruitment_position": "",
						"curriculum_vitae": "",
					"resume_information_id": 0
			},

			obj: {
					"user_information": 0, // 用户信息
						"user_name":  '', // 用户姓名
						"user_gender":  '', // 用户性别
						"user_age":  '', // 用户年龄
						"personal_education":  '', // 个人学历
						"contact_information":  '', // 联系方式
						"enterprise_information": 0, // 企业信息
						"enterprise_name":  '', // 企业名称
						"recruitment_position":  '', // 招聘岗位
						"curriculum_vitae":  '', // 个人简历
					"resume_information_id": 0,

			},

			// 表单字段
			form: {
					"user_information": 0, // 用户信息
						"user_name":  '', // 用户姓名
						"user_gender":  '', // 用户性别
						"user_age":  '', // 用户年龄
						"personal_education":  '', // 个人学历
						"contact_information":  '', // 联系方式
						"enterprise_information": 0, // 企业信息
						"enterprise_name":  '', // 企业名称
						"recruitment_position":  '', // 招聘岗位
						"curriculum_vitae":  '', // 个人简历
					"resume_information_id": 0,
			},
			disabledObj:{
					"user_information_isDisabled": false,
						"user_name_isDisabled": false,
						"user_gender_isDisabled": false,
						"user_age_isDisabled": false,
						"personal_education_isDisabled": false,
						"contact_information_isDisabled": false,
						"enterprise_information_isDisabled": false,
						"enterprise_name_isDisabled": false,
						"recruitment_position_isDisabled": false,
						"curriculum_vitae_isDisabled": false,
				},

					// 用户列表
			list_user_user_information: [],
							list_user_gender: [],
								list_personal_education: [],
									// 用户列表
			list_user_enterprise_information: [],
							
			field:"resume_information_id",
			table_key:"resume_information",

		}
	},
	methods: {
				/**
		 * 获取个人用户用户列表
		 */
		async get_list_user_user_information() {
			// if(this.user_group !== "管理员" && this.form["user_information"] === 0) {
			//     this.form["user_information"] = this.user.user_id;
			// }
			var json = await this.$get("~/api/user/get_list?user_group=个人用户");
			if(json.result && json.result.list){
				json.result.list.map((o) => this.list_user_user_information.push({value:o.user_id,text:o.nickname + '-' + o.username}));
			}
			else if(json.error){
				console.error(json.error);
			}
		},
				async get_user_session_user_information(){
			var _this = this;
			var json = await this.$get("~/api/user_group/get_obj?name=个人用户");
			if(json.result && json.result.obj){
				var source_table = json.result.obj.source_table;
				var user_id = _this.$store.state.user.user_id;
				if (user_id){
					var url = "~/api/"+source_table+"/get_obj?"
					this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
						if (res.result && res.result.obj) {
							var arr = []
							for (let key in res.result.obj) {
								arr.push(key)
							}
							var arrForm = []
							for (let key in _this.form) {
								arrForm.push(key)
							}
							_this.form["user_information"] = user_id
							_this.disabledObj['user_information' + '_isDisabled'] = true
							for (var i=0;i<arr.length;i++){
                if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                  for (var j = 0; j < arrForm.length; j++) {
                    if (arr[i] === arrForm[j]) {
                      if (arr[i] !== "user_information") {
                        _this.form[arrForm[j]] = res.result.obj[arr[i]]
                        _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                        break;
                      }
                    }
                  }
                }
							}
						}
					});
				}
			}
			else if(json.error){
				console.error(json.error);
			}
		},
	
	
				
	
				/**
		 * 获取用户性别列表
		 */
		async get_list_user_gender() {
					['男','女'].map((o) => this.list_user_gender.push({value:o,text:o}));
						},
			
	
				
	
				/**
		 * 获取个人学历列表
		 */
		async get_list_personal_education() {
					['高中','专科','本科','其他'].map((o) => this.list_personal_education.push({value:o,text:o}));
						},
			
	
				
	
					/**
		 * 获取企业用户用户列表
		 */
		async get_list_user_enterprise_information() {
			// if(this.user_group !== "管理员" && this.form["enterprise_information"] === 0) {
			//     this.form["enterprise_information"] = this.user.user_id;
			// }
			var json = await this.$get("~/api/user/get_list?user_group=企业用户");
			if(json.result && json.result.list){
				json.result.list.map((o) => this.list_user_enterprise_information.push({value:o.user_id,text:o.nickname + '-' + o.username}));
			}
			else if(json.error){
				console.error(json.error);
			}
		},
		
	
				
	
				
	
				
	
			change_file(key_name){
			var _self = this;
				this.$chooseFile().then(res=>{
					console.log(res)

						const uploadTask = uni.uploadFile({
							url: _self.$fullUrl("/api/feedback/upload?"),
							filePath: res[0].path,
							name: "file",
							formData: {
								i_want_to_customize: "test",
							},
							header: {
								"x-auth-token": _self.$store.state.user.token,
							},
							success: function(uploadFileRes) {
								console.log(uploadFileRes)
								var filename = JSON.parse(uploadFileRes.data).result.url;
								_self.form[key_name] = filename;
							},
						});

						uploadTask.onProgressUpdate(function(res) {
							_self.percent = res.progress;
							console.log("上传进度" + res.progress);
							console.log("已经上传的数据长度" + res.totalBytesSent);
							console.log(
								"预期需要上传的数据总长度" + res.totalBytesExpectedToSend
							);
						});

				})
		},
		change_img(key_name) {
			var _self = this;
			_self.upload_img_flag = false
			// 选择图像方法
			uni.chooseImage({
				count: 1,
				sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
				sourceType: ['album'], //从相册选择
				success: function(res) {
					const tempFilePaths = res.tempFilePaths;
					const uploadTask = uni.uploadFile({
						url: _self.$fullUrl('/api/resume_information/upload?'),
						filePath: tempFilePaths[0],
						name: 'file',
						formData: {
							'resume_information': 'test'
						},
						header: {
							'x-auth-token': _self.$store.state.user.token
						},
						success: function(uploadFileRes) {
							var filename = JSON.parse(uploadFileRes.data).result.url
							var img_url = filename
							_self.form[key_name] = img_url
						}
					});

					uploadTask.onProgressUpdate(function(res) {
						_self.percent = res.progress;
						console.log('上传进度' + res.progress);
						console.log('已经上传的数据长度' + res.totalBytesSent);
						console.log('预期需要上传的数据总长度' + res.totalBytesExpectedToSend);
					});
				},
				error: function(e) {
					console.log(e);
				}
			});
		},

		/**
		 * 获取对象后获取缓存表单
		 * @param {Object} json
		 * @param {Object} func
		 */
		get_obj_before(param){
			var form = uni.db.get("form");
			if (form) {
        delete(form.examine_state)
        delete(form.examine_reply)
				this.obj = uni.push(this.obj ,form);
				this.form = uni.push(this.form ,form);
			}
			var arr = []
			for (let key in form) {
				arr.push(key)
			}
			for (var i=0;i<arr.length;i++){
				this.disabledObj[arr[i] + '_isDisabled'] = true
			}
																							uni.db.del("form");
			return param;
		},

		/**
		 * 获取对象后获取缓存表单
		 * @param {Object} json
		 * @param {Object} func
		 */
		get_obj_after(json ,func){
			var form = uni.db.get("form");
			var obj = Object.assign({} ,form ,this.obj);
			if (form) {
				this.obj = uni.push(this.obj ,obj);
			}
			if (form) {
				this.form = uni.push(this.form ,form);
			}
			if(func){
				func(json);
			}
		},

	},
	onLoad(){
				this.get_user_session_user_information();
				this.get_list_user_user_information();
							this.get_list_user_gender();
									this.get_list_personal_education();
											this.get_list_user_enterprise_information();
											},
}
</script>

<style scoped>
	input{
		font-size: 10px;
	}

	.form_edit {
		background-color: #fff;
		margin-bottom: 0.5rem;
		padding: 1rem;
		font-size: 10px;
	}

	.item {
		display: flex;
		padding: 0.2rem 0;
	}

	.left_text {
		flex: 0 0 25%;
		display: flex;
		align-items: center;
	}

	.right_text {
		flex: 0 0 75%;
		border-bottom: 1px solid #eee;
	}
	.right_text.btn_warp{
		border-bottom: 0;
	}

	.btn_submit {
		text-align: center;
		background-color: #fff;
		padding: 0.3rem;
		margin: 0.1rem 1rem;
		border: 1px solid #eee;
		border-radius: 0.5rem;
	}

	.btn_submit:hover {
		opacity: 0.5;
	}
	.btn_add_img{
		color: #D3D3D3;
		text-align: center;
		border: 1px solid #eee;
		height: 5rem;
		width: 5rem;
		position: relative;
	}
	.btn_add_img text{
		font-size: 35px;
		position: absolute;
		left: 50%;
		top: 50%;
		transform: translate(-50%,-50%);
	}




</style>
<style scoped>
/*新样式*/
.diy_text_row {
  display: inline-block;
}
.container {
	margin-top:1rem ;
	padding: 1rem;
    -webkit-box-shadow: 0px 0px 0px #888888;
    box-shadow: 0px 0px 0px #888888;
}
.primary_btn{
		background-color: #22B8B8;
		color: #FFFFFF;
	}
	.btn_submit{
		padding: 0;
		margin-top:1rem ;
	}
	.row-item {
		padding: 10px 10px;
	    background: #f8f6fc;
		margin-bottom: 1rem;
	}
	.diy_field{
		padding-left: 1rem;
	}
	.diy_title{
		align-items: center;
        font-size: 14px;
        color: #333;
	}

	.row-item{
		display: flex !important;
		align-items: baseline;
	}
	.diy_select_flex{
		flex: 1;
	}
	.query_select{
		flex: 1;
		border-color: rgb(229, 229, 229);
		background-color: rgb(255, 255, 255);
		border-radius: 4px;
		box-sizing: border-box;
		flex: 1;
		width: 100%;
		line-height: 2;
		font-size: 14px;
		height: 2.4em;
		min-height: 2.4em;
		display: block;
		outline:none;
	}
</style>

