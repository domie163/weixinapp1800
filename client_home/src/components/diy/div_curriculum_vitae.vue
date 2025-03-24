<template>
	<view class="diy_details diy_div_curriculum_vitae">
		<view v-if="Object.keys(obj).length!==0" class="warp">
			<view class="container">
				<view class="row">
					<view v-if="$check_field('get','user_information')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>用户信息:</span>
						</view>
							<view class="diy_field diy_uid">
							<text>
								{{ get_user_user_information(obj['user_information']) }}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','user_name')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>用户姓名:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["user_name"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','user_gender')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>用户性别:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["user_gender"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','user_age')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>用户年龄:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["user_age"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','personal_education')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>个人学历:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["personal_education"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','graduation_college')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>毕业学院:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["graduation_college"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','personal_specialty')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>个人特长:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["personal_specialty"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','contact_information')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>联系方式:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["contact_information"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','job_position')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>求职岗位:</span>
						</view>
							<view class="diy_field diy_text">
							<text>
								{{obj["job_position"]}}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','work_experience')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>工作经历:</span>
						</view>
							<view class="diy_field diy_desc">
							<text>
								{{ obj["work_experience"] }}
							</text>
						</view>
						</view>
					<view v-if="$check_field('get','curriculum_vitae')" class="col-12 col-md-6">
						<view class="diy_title">
							<span>个人简历:</span>
						</view>
							<view class="diy_field diy_img">
							<image style="width:100%;height:auto;" :src="$fullUrl(obj['curriculum_vitae'])" mode="widthFix"></image>
						</view>
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
						curriculum_vitae_id: 0
					}
				}
			}
		},
		data() {
			return {
				obj_goods_type: {},
				obj: {},
					// 用户列表
				list_user_user_information: [],
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
				var res = await this.$get("~/api/curriculum_vitae/get_obj", {
					curriculum_vitae_id:this.query.curriculum_vitae_id
				})

				if (res.result && res.result.obj) {
					this.obj = res.result.obj
				} else {
					console.log("没有请求到商品分类");
				}
			},
				/**
			 * 获取个人用户用户列表
			 */
			async get_list_user_user_information() {
				var json = await this.$get("~/api/user/get_list?user_group=个人用户");
				if(json.result && json.result.list){
					this.list_user_user_information = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_user_information(id){
				let obj = this.list_user_user_information;
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
				this.get_list_user_user_information();
													},
		async onLoad(){
			if (Object.keys(this.obj_goods).length !== 0) {
				await this.get_obj_goods_type();
				await this.get_obj_by_goods();
			} else if (this.query["curriculum_vitae_id"] !==0) {
				await this.get_obj_by_id();
			}
		}
	}
</script>

<style scoped>
	.div_curriculum_vitae_details {}

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
