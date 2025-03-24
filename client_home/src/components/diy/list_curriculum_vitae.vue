<template>
	<view class="list_curriculum_vitae list_com--new" style="background-color: #fff;">
		<!-- 视图 -->
		<view class="curriculum_vitae_block box_wrap" >
			<navigator class="item_curriculum_vitae box_style" v-for="(o, i) in list"  :key="i" :url="'/pages/curriculum_vitae/details?curriculum_vitae_id=' + o['curriculum_vitae_id']">
					<view class="view" v-if="0 && $check_index_field('get','user_information','/curriculum_vitae/list')">
					<view class="title" v-if="true">
						<span>用户信息</span>
					</view>
							<view class="diy_field time" >
						<span>{{ get_user_user_information(o['user_information']) }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','user_name','/curriculum_vitae/list')">
					<view class="title" v-if="true">
						<span>用户姓名</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["user_name"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','user_gender','/curriculum_vitae/list')">
					<view class="title" v-if="true">
						<span>用户性别</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["user_gender"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','user_age','/curriculum_vitae/list')">
					<view class="title" v-if="true">
						<span>用户年龄</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["user_age"] }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','personal_education','/curriculum_vitae/list')">
					<view class="title" v-if="true">
						<span>个人学历</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["personal_education"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','graduation_college','/curriculum_vitae/list')">
					<view class="title" v-if="true">
						<span>毕业学院</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["graduation_college"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','personal_specialty','/curriculum_vitae/list')">
					<view class="title" v-if="true">
						<span>个人特长</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["personal_specialty"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','contact_information','/curriculum_vitae/list')">
					<view class="title" v-if="true">
						<span>联系方式</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["contact_information"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','job_position','/curriculum_vitae/list')">
					<view class="title" v-if="true">
						<span>求职岗位</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["job_position"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','work_experience','/curriculum_vitae/list')">
					<view class="title" v-if="true">
						<span>工作经历</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["work_experience"] }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','curriculum_vitae','/curriculum_vitae/list')">
					<view class="title" v-if=" false">
						<span>个人简历</span>
					</view>
							<view class="diy_field image" >
						<image style="width:100%;height: 5rem;" :src="$fullUrl(o['curriculum_vitae']) || '/static/img/default.png'" mode="scaleToFill" />
					</view>
						</view>
					<view class="bottom-view">
				</view>
				<view class="view">
					<view class="create_time_block diy_field number">
						<span>{{ $toTime(o["create_time"],"yyyy-MM-dd hh:mm:ss") }}</span>
					</view>
				</view>
			</navigator>
		</view>
		<!-- /视图 -->
	</view>
</template>

<script>
	export default {
		props: {
			list: {
				type: Array,
				default: function() {
					return [];
				}
			}
		},
		data() {
			return {
					// 用户列表
				list_user_user_information: [],
														}
		},
		methods: {
			/**
			 *  跳转链接
			 *  @param {Object} id
			 */
			to_nav(id) {
				this.$nav('/pages/curriculum_vitae/details?curriculum_vitae_id=' + id)
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
													}
	}
</script>

<style scoped>
	.list_curriculum_vitae {
		/* padding: 0 1rem; */
		margin-bottom: 1rem;
	}

	.list_curriculum_vitae .list_curriculum_vitae_table {
		width: 100%;
		padding: 5px 0;
	}

	.list_curriculum_vitae .list_curriculum_vitae_table .btn_change_table {
		margin-left: auto;
		font-weight: bold;
		padding: 0.5rem 0;
		width: 100px;
		text-align: center;
		font-size: 0.875rem;
		border: 1px solid #CCCCCC;
		border-radius: 1rem;
		margin-bottom: 0.25rem;
	}

	.list_curriculum_vitae .list_curriculum_vitae_table .curriculum_vitae_table_block .uni-table-td{
		padding: 8px;
	}

	.list_curriculum_vitae .list_curriculum_vitae_table .curriculum_vitae_table_block .image {
		width: 10%;
	}

	.list_curriculum_vitae .list_curriculum_vitae_table .curriculum_vitae_table_block .text {
		overflow: hidden;
		width: 30%;
		font-size: 0.5rem;
	}

	.list_curriculum_vitae .list_curriculum_vitae_table .curriculum_vitae_table_block .hits {
		width: 12%;
		font-size: 0.5rem;
	}

	.list_curriculum_vitae .list_curriculum_vitae_table .curriculum_vitae_table_block .praise {
		width: 12%;
		font-size: 0.5rem;
	}

	.list_curriculum_vitae .list_curriculum_vitae_table .curriculum_vitae_table_block .create_time {
		width: 26%;
		font-size: 0.5rem;
	}
	.list_curriculum_vitae .item_curriculum_vitae {
		display: flex;
		justify-content: space-between;
		align-items: stretch;
		padding: 0.75rem 1rem;

	}
	.list_curriculum_vitae .item_curriculum_vitae+.item_curriculum_vitae{
		border-top: 1px solid #dbdbdb;
	}
	.list_curriculum_vitae .item_curriculum_vitae .left>image {
		position: relative;
		top: 50%;
		transform: translate(0, -50%);
		border-radius: 0.5rem;
	}

	.list_curriculum_vitae .item_curriculum_vitae .right_block {
		width: calc(100% - 5rem);
		display: flex;
		flex-direction: column;
		justify-content: space-between;
	}

	.list_curriculum_vitae .top {
		font-size: 0.9rem;
	}


	.list_curriculum_vitae .time {
		font-size: 0.6rem;
		color: var(--color_grey)
	}

	.list_curriculum_vitae .bottom {
		display: flex;
		justify-content: space-between;
		align-items: baseline;
		font-size: 0.5rem;
		color: var(--color_grey)
	}

	.list_curriculum_vitae .see {
		margin-left: 1rem;
	}
	.box_wrap{
		padding: 0.75rem;
	}
	.box_style{
		margin-bottom: 0.75rem;
		padding: 0.375rem;
		display: inline-block !important;
		border: 0.075rem solid #ccc;
		border-radius: 0.375rem;
		overflow: hidden;
	}
	.box_style:nth-child(even){
		margin-left: 0.60rem;
	}
	.box_style:nth-child(even){
		margin-left: 0.60rem;
	}
	.bottom-view,.create_time_block{
		font-size: 12px;
		color: #666666;
	}
	.bottom-view view{
		display: inline-block;
	}
	.bottom-view span{
		margin-left: 5px;
		margin-right: 10px;
	}
/* new style start */
	.list_com--new .box_wrap{
		display: flex;
		flex-wrap: wrap;
		padding-left: 0 !important;
		padding-right: 0 !important;
		justify-content: space-between;
	}
	.list_com--new .box_style:nth-child(even) {
    	margin-left: 0 !important;
	}
    .list_com--new .box_wrap .box_style{
		display: inline-block !important;
		width: 48%;
		max-width: 48%;
		overflow: hidden;
		border-color: var(--color_primary);
		box-sizing: border-box;
		padding:8px!important;
    }
    .list_com--new .view{
        display: flex;
        overflow: hidden;
		width:100%;
    }

    .list_com--new .view .title span{
       white-space: nowrap;
    }
    .list_com--new .view .text{
        display: flex;
        color: var(--color_primary);
        margin-left: 10px;
        border-bottom: 1px solid #ccc;
        white-space: nowrap;
    }
     .list_com--new .view .text span{
        max-width: 100px;
        overflow: hidden;
        text-overflow: ellipsis;
    }

     .list_com--new .view .number{
        color: var(--color_primary);
    }

    .list_com--new .view .image{
        width: 100%;
        border-bottom: 1px solid #ccc;
		margin-top:5px;
    }

	.list_com--new .diy_field.text{
		overflow: hidden;
		margin-right: -8px;
	}

/* new style start */

</style>

