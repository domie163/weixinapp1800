<template>
	<view class="diy_details diy_div_recruitment_information">
		<view v-if="Object.keys(obj).length!==0" class="warp">
			<view class="container">
				<view class="row">
					<view v-if="$check_field('get','enterprise_information')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>企业信息:</span>
						</view>
							<view class="diy_field diy_uid">
							<text>
								{{ get_user_enterprise_information(obj['enterprise_information']) }}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','enterprise_name')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>企业名称:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["enterprise_name"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','recruitment_position')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>招聘岗位:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["recruitment_position"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','number_of_recruiters')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>招聘人数:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["number_of_recruiters"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','office_location')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>办公地点:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["office_location"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','salary_range')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>薪资范围:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["salary_range"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','job_requirements')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>岗位要求:</span>
						</view>
							<view class="diy_field diy_desc">
							<text>
								{{ obj["job_requirements"] }}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','enterprise_cover')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>企业封面:</span>
						</view>
							<view class="diy_field diy_img">
							<image style="width:100%;height:auto;" :src="$fullUrl(obj['enterprise_cover'])" mode="widthFix"></image>
						</view>
						</view>
				</view>
			</view>
		</view>

			<view class="warp">
			<view class="container">
				<view class="row">
					<view class="col">
						<button type="button" class="diy_btn" @click="to_form('/pages/resume_information/edit')" v-if="$check_action('/resume_information/edit','add') || $check_action('/resume_information/edit','set')" >投递简历</button>
					</view>
				</view>
			</view>
		</view>
		</view>
</template>

<script>
	import mixin from "@/libs/mixins/component.js";
	export default {
		mixins: [mixin],
		props: {
			obj_goods: {
				type: Object,
				default(){
					return {}
				}
			},
			query:{
				type: Object,
				default(){
					return {
						recruitment_information_id: 0
					}
				}
			}
		},
		data() {
			return {
				obj_goods_type: {},
				obj: {},
					// 用户列表
				list_user_enterprise_information: [],
											}
		},
		methods: {
			async get_obj_goods_type() {
				var res = await this.$get("~/api/goods_type/get_obj", {
					name: this.obj_goods.type
				})

				if (res.result.obj) {
					this.obj_goods_type = res.result.obj
				} else {
					console.log("没有请求到商品分类");
				}
			},
			async get_obj_by_goods() {
				var {
					source_table,
					source_field
				} = this.obj_goods_type
				var {
					source_id
				} = this.obj_goods
				var query = {}
				query[source_field] = source_id
				this.$get("~/api/" + source_table + "/get_obj", {}, (res) => {
					if (res.result.obj) {
						this.obj = res.result.obj
					} else {
						console.log("没有请求到商品分类");
					}
				})
			},
			async get_obj_by_id(){
				var res = await this.$get("~/api/recruitment_information/get_obj", {
					recruitment_information_id:this.query.recruitment_information_id
				})

				if (res.result && res.result.obj) {
					this.obj = res.result.obj
				} else {
					console.log("没有请求到商品分类");
				}
			},
				/**
			 * 获取企业用户用户列表
			 */
			async get_list_user_enterprise_information() {
				var json = await this.$get("~/api/user/get_list?user_group=企业用户");
				if(json.result && json.result.list){
					this.list_user_enterprise_information = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_enterprise_information(id){
				let obj = this.list_user_enterprise_information;
				let ret = "";
				for(let i=0;i<obj.length;i++){
					if(obj[i].user_id==id){
						ret = obj[i].nickname+"-"+obj[i].username;
					}
				}
				return ret;
			},
										},
		created() {
				this.get_list_user_enterprise_information();
										},
		async onLoad(){
			if (Object.keys(this.obj_goods).length !== 0) {
				await this.get_obj_goods_type();
				await this.get_obj_by_goods();
			} else if (this.query["recruitment_information_id"] !==0) {
				await this.get_obj_by_id();
			}
		}
	}
</script>

<style scoped>
	.div_recruitment_information_details {}

	.details {
		background-color: #fff;
		margin-bottom: 0.5rem;
		padding: 1rem;
		font-size: 10px;
	}

	.item {
		display: flex;
		padding: 0.2rem 0;
		border-bottom: 1px solid #eee;
	}

	.left_text {
		flex: 0 0 25%;
	}

	.right_text {
		flex: 0 0 75%;
	}
	.edit_nav{
		text-align: center;
		background-color: #fff;
		padding: 0.3rem;
		margin: 0.1rem 1rem;
		border: 1px solid #eee;
		border-radius: 0.5rem;
	}
</style>
