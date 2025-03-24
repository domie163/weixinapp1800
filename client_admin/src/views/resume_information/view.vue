<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','user_information') || $check_field('add','user_information') || $check_field('set','user_information')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户信息" prop="user_information">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_user_information(form['user_information']) }}
							<!--<el-input id="business_name" v-model="form['user_information']" placeholder="请输入用户信息"-->
							<!--v-if="user_group === '管理员' || (form['resume_information_id'] && $check_field('set','user_information')) || (!form['resume_information_id'] && $check_field('add','user_information'))" :disabled="disabledObj['user_information_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','user_information')">{{form['user_information']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['resume_information_id'] && $check_field('set','user_information')) || (!form['resume_information_id'] && $check_field('add','user_information'))" id="user_information" v-model="form['user_information']" :disabled="disabledObj['user_information_isDisabled']">
								<el-option v-for="o in list_user_user_information" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','user_information')" id="user_information" v-model="form['user_information']" :disabled="true">
								<el-option v-for="o in list_user_user_information" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="user_information" v-model="form['user_information']" :disabled="disabledObj['user_information_isDisabled']">
							<el-option v-for="o in list_user_user_information" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_name') || $check_field('add','user_name') || $check_field('set','user_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户姓名" prop="user_name">
												<el-input id="user_name" v-model="form['user_name']" placeholder="请输入用户姓名"
							  v-if="user_group === '管理员' || (form['resume_information_id'] && $check_field('set','user_name')) || (!form['resume_information_id'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','user_name')">{{form['user_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_gender') || $check_field('add','user_gender') || $check_field('set','user_gender')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户性别" prop="user_gender">
								<el-select id="user_gender" v-model="form['user_gender']"
						v-if="user_group === '管理员' || (form['resume_information_id'] && $check_field('set','user_gender')) || (!form['resume_information_id'] && $check_field('add','user_gender'))">
						<el-option v-for="o in list_user_gender" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','user_gender')">{{form['user_gender']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','user_age') || $check_field('add','user_age') || $check_field('set','user_age')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户年龄" prop="user_age">
												<el-input id="user_age" v-model="form['user_age']" placeholder="请输入用户年龄"
							  v-if="user_group === '管理员' || (form['resume_information_id'] && $check_field('set','user_age')) || (!form['resume_information_id'] && $check_field('add','user_age'))" :disabled="disabledObj['user_age_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','user_age')">{{form['user_age']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','personal_education') || $check_field('add','personal_education') || $check_field('set','personal_education')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="个人学历" prop="personal_education">
								<el-select id="personal_education" v-model="form['personal_education']"
						v-if="user_group === '管理员' || (form['resume_information_id'] && $check_field('set','personal_education')) || (!form['resume_information_id'] && $check_field('add','personal_education'))">
						<el-option v-for="o in list_personal_education" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','personal_education')">{{form['personal_education']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','contact_information') || $check_field('add','contact_information') || $check_field('set','contact_information')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="联系方式" prop="contact_information">
												<el-input id="contact_information" v-model="form['contact_information']" placeholder="请输入联系方式"
							  v-if="user_group === '管理员' || (form['resume_information_id'] && $check_field('set','contact_information')) || (!form['resume_information_id'] && $check_field('add','contact_information'))" :disabled="disabledObj['contact_information_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','contact_information')">{{form['contact_information']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','enterprise_information') || $check_field('add','enterprise_information') || $check_field('set','enterprise_information')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="企业信息" prop="enterprise_information">
													<el-select v-if="user_group === '管理员' || (form['resume_information_id'] && $check_field('set','enterprise_information')) || (!form['resume_information_id'] && $check_field('add','enterprise_information'))" id="enterprise_information" v-model="form['enterprise_information']" :disabled="disabledObj['enterprise_information_isDisabled']">
							<el-option v-for="o in list_user_enterprise_information" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','enterprise_information')" id="enterprise_information" v-model="form['enterprise_information']" :disabled="true">
							<el-option v-for="o in list_user_enterprise_information" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','enterprise_name') || $check_field('add','enterprise_name') || $check_field('set','enterprise_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="企业名称" prop="enterprise_name">
												<el-input id="enterprise_name" v-model="form['enterprise_name']" placeholder="请输入企业名称"
							  v-if="user_group === '管理员' || (form['resume_information_id'] && $check_field('set','enterprise_name')) || (!form['resume_information_id'] && $check_field('add','enterprise_name'))" :disabled="disabledObj['enterprise_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','enterprise_name')">{{form['enterprise_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','recruitment_position') || $check_field('add','recruitment_position') || $check_field('set','recruitment_position')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="招聘岗位" prop="recruitment_position">
												<el-input id="recruitment_position" v-model="form['recruitment_position']" placeholder="请输入招聘岗位"
							  v-if="user_group === '管理员' || (form['resume_information_id'] && $check_field('set','recruitment_position')) || (!form['resume_information_id'] && $check_field('add','recruitment_position'))" :disabled="disabledObj['recruitment_position_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','recruitment_position')">{{form['recruitment_position']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','curriculum_vitae') || $check_field('add','curriculum_vitae') || $check_field('set','curriculum_vitae')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="个人简历" prop="curriculum_vitae">
								<el-upload :disabled="disabledObj['curriculum_vitae_isDisabled']" id="curriculum_vitae" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_curriculum_vitae"
						:show-file-list="false" v-if="user_group === '管理员' || (form['resume_information_id'] && $check_field('set','curriculum_vitae')) || (!form['resume_information_id'] && $check_field('add','curriculum_vitae'))">
						<img v-if="form['curriculum_vitae']" :src="$fullUrl(form['curriculum_vitae'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','curriculum_vitae')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['curriculum_vitae'])" :preview-src-list="[$fullUrl(form['curriculum_vitae'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "resume_information_id",
				url_add: "~/api/resume_information/add?",
				url_set: "~/api/resume_information/set?",
				url_get_obj: "~/api/resume_information/get_obj?",
				url_upload: "~/api/resume_information/upload?",

				query: {
					"resume_information_id": 0,
				},

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
											"resume_information_id": 0, // ID
						
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
						// 用户组
				group_user_user_information: "",
				
						// 用户性别选项列表
				list_user_gender: ['男','女'],
	
		
						// 个人学历选项列表
				list_personal_education: ['高中','专科','本科','其他'],
	
		
		
					// 用户列表
				list_user_enterprise_information: [],
				
		
		
	
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
                    this.list_user_user_information = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取个人用户用户组
			 */
			async get_group_user_user_information() {
							this.form["user_information"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=个人用户");
				if(json.result && json.result.obj){
					this.group_user_user_information = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_user_information(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_user_information.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["user_information"] = id
									_this.disabledObj['user_information' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "user_information") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
			},
					get_user_user_information(id){
				var obj = this.list_user_user_information.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
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
                    this.list_user_enterprise_information = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_enterprise_information(id){
				var obj = this.list_user_enterprise_information.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
						/**
			 * 上传个人简历
			 * @param {Object} param 图片参数
			 */
			upload_curriculum_vitae(param){
						this.uploadFile(param.file, "curriculum_vitae");
					},
	
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
									// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
									
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
																								$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																														

			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																																				return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/resume_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/resume_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/resume_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/resume_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/resume_information/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
					this.get_list_user_user_information();
					this.get_group_user_user_information();
																		this.get_list_user_enterprise_information();
											},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
