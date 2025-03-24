<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','enterprise_information') || $check_field('add','enterprise_information') || $check_field('set','enterprise_information')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="企业信息" prop="enterprise_information">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_enterprise_information(form['enterprise_information']) }}
							<!--<el-input id="business_name" v-model="form['enterprise_information']" placeholder="请输入企业信息"-->
							<!--v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','enterprise_information')) || (!form['recruitment_information_id'] && $check_field('add','enterprise_information'))" :disabled="disabledObj['enterprise_information_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','enterprise_information')">{{form['enterprise_information']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','enterprise_information')) || (!form['recruitment_information_id'] && $check_field('add','enterprise_information'))" id="enterprise_information" v-model="form['enterprise_information']" :disabled="disabledObj['enterprise_information_isDisabled']">
								<el-option v-for="o in list_user_enterprise_information" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','enterprise_information')" id="enterprise_information" v-model="form['enterprise_information']" :disabled="true">
								<el-option v-for="o in list_user_enterprise_information" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="enterprise_information" v-model="form['enterprise_information']" :disabled="disabledObj['enterprise_information_isDisabled']">
							<el-option v-for="o in list_user_enterprise_information" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','enterprise_name') || $check_field('add','enterprise_name') || $check_field('set','enterprise_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="企业名称" prop="enterprise_name">
												<el-input id="enterprise_name" v-model="form['enterprise_name']" placeholder="请输入企业名称"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','enterprise_name')) || (!form['recruitment_information_id'] && $check_field('add','enterprise_name'))" :disabled="disabledObj['enterprise_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','enterprise_name')">{{form['enterprise_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','recruitment_position') || $check_field('add','recruitment_position') || $check_field('set','recruitment_position')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="招聘岗位" prop="recruitment_position">
												<el-input id="recruitment_position" v-model="form['recruitment_position']" placeholder="请输入招聘岗位"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','recruitment_position')) || (!form['recruitment_information_id'] && $check_field('add','recruitment_position'))" :disabled="disabledObj['recruitment_position_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','recruitment_position')">{{form['recruitment_position']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','number_of_recruiters') || $check_field('add','number_of_recruiters') || $check_field('set','number_of_recruiters')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="招聘人数" prop="number_of_recruiters">
												<el-input id="number_of_recruiters" v-model="form['number_of_recruiters']" placeholder="请输入招聘人数"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','number_of_recruiters')) || (!form['recruitment_information_id'] && $check_field('add','number_of_recruiters'))" :disabled="disabledObj['number_of_recruiters_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','number_of_recruiters')">{{form['number_of_recruiters']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','office_location') || $check_field('add','office_location') || $check_field('set','office_location')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="办公地点" prop="office_location">
												<el-input id="office_location" v-model="form['office_location']" placeholder="请输入办公地点"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','office_location')) || (!form['recruitment_information_id'] && $check_field('add','office_location'))" :disabled="disabledObj['office_location_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','office_location')">{{form['office_location']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','salary_range') || $check_field('add','salary_range') || $check_field('set','salary_range')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="薪资范围" prop="salary_range">
												<el-input id="salary_range" v-model="form['salary_range']" placeholder="请输入薪资范围"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','salary_range')) || (!form['recruitment_information_id'] && $check_field('add','salary_range'))" :disabled="disabledObj['salary_range_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','salary_range')">{{form['salary_range']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','job_requirements') || $check_field('add','job_requirements') || $check_field('set','job_requirements')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="岗位要求" prop="job_requirements">
								<el-input type="textarea" id="job_requirements" v-model="form['job_requirements']" placeholder="请输入岗位要求"
						v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','job_requirements')) || (!form['recruitment_information_id'] && $check_field('add','job_requirements'))" :disabled="disabledObj['job_requirements_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','job_requirements')">{{form['job_requirements']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','enterprise_cover') || $check_field('add','enterprise_cover') || $check_field('set','enterprise_cover')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="企业封面" prop="enterprise_cover">
								<el-upload :disabled="disabledObj['enterprise_cover_isDisabled']" id="enterprise_cover" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_enterprise_cover"
						:show-file-list="false" v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','enterprise_cover')) || (!form['recruitment_information_id'] && $check_field('add','enterprise_cover'))">
						<img v-if="form['enterprise_cover']" :src="$fullUrl(form['enterprise_cover'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','enterprise_cover')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['enterprise_cover'])" :preview-src-list="[$fullUrl(form['enterprise_cover'])]">
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
				field: "recruitment_information_id",
				url_add: "~/api/recruitment_information/add?",
				url_set: "~/api/recruitment_information/set?",
				url_get_obj: "~/api/recruitment_information/get_obj?",
				url_upload: "~/api/recruitment_information/upload?",

				query: {
					"recruitment_information_id": 0,
				},

				form: {
								"enterprise_information": 0, // 企业信息
										"enterprise_name":  '', // 企业名称
										"recruitment_position":  '', // 招聘岗位
										"number_of_recruiters":  '', // 招聘人数
										"office_location":  '', // 办公地点
										"salary_range":  '', // 薪资范围
										"job_requirements":  '', // 岗位要求
										"enterprise_cover":  '', // 企业封面
											"recruitment_information_id": 0, // ID
						
				},
				disabledObj:{
								"enterprise_information_isDisabled": false,
										"enterprise_name_isDisabled": false,
										"recruitment_position_isDisabled": false,
										"number_of_recruiters_isDisabled": false,
										"office_location_isDisabled": false,
										"salary_range_isDisabled": false,
										"job_requirements_isDisabled": false,
										"enterprise_cover_isDisabled": false,
										},

	
					// 用户列表
				list_user_enterprise_information: [],
						// 用户组
				group_user_enterprise_information: "",
				
		
		
		
		
		
		
	
			}
		},
		methods: {


	
	
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
					/**
			 * 获取企业用户用户组
			 */
			async get_group_user_enterprise_information() {
							this.form["enterprise_information"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=企业用户");
				if(json.result && json.result.obj){
					this.group_user_enterprise_information = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_enterprise_information(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_enterprise_information.source_table+"/get_obj?"
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
												_this.form["enterprise_information"] = id
									_this.disabledObj['enterprise_information' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "enterprise_information") {
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
			 * 上传企业封面
			 * @param {Object} param 图片参数
			 */
			upload_enterprise_cover(param){
						this.uploadFile(param.file, "enterprise_cover");
					},
	
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
									
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
					bl = this.$check_action('/recruitment_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/recruitment_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/recruitment_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/recruitment_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/recruitment_information/view','get');
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
					this.get_list_user_enterprise_information();
					this.get_group_user_enterprise_information();
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
