<template>
	<view class="list_recruitment_information list_com--new" style="background-color: #fff;">
		<!-- 视图 -->
		<view class="recruitment_information_block box_wrap" >
			<navigator class="item_recruitment_information box_style" v-for="(o, i) in list"  :key="i" :url="'/pages/recruitment_information/details?recruitment_information_id=' + o['recruitment_information_id']">
					<view class="view" v-if="0 && $check_index_field('get','enterprise_information','/recruitment_information/list')">
					<view class="title" v-if="true">
						<span>企业信息</span>
					</view>
							<view class="diy_field time" >
						<span>{{ get_user_enterprise_information(o['enterprise_information']) }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','enterprise_name','/recruitment_information/list')">
					<view class="title" v-if="true">
						<span>企业名称</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["enterprise_name"] }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','recruitment_position','/recruitment_information/list')">
					<view class="title" v-if="true">
						<span>招聘岗位</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["recruitment_position"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','number_of_recruiters','/recruitment_information/list')">
					<view class="title" v-if="true">
						<span>招聘人数</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["number_of_recruiters"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','office_location','/recruitment_information/list')">
					<view class="title" v-if="true">
						<span>办公地点</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["office_location"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','salary_range','/recruitment_information/list')">
					<view class="title" v-if="true">
						<span>薪资范围</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["salary_range"] }}</span>
					</view>
						</view>
						<view class="view" v-if="0 && $check_index_field('get','job_requirements','/recruitment_information/list')">
					<view class="title" v-if="true">
						<span>岗位要求</span>
					</view>
							<view class="diy_field text" >
						<span>{{ o["job_requirements"] }}</span>
					</view>
						</view>
						<view class="view" v-if="1 && $check_index_field('get','enterprise_cover','/recruitment_information/list')">
					<view class="title" v-if=" false">
						<span>企业封面</span>
					</view>
							<view class="diy_field image" >
						<image style="width:100%;height: 5rem;" :src="$fullUrl(o['enterprise_cover']) || '/static/img/default.png'" mode="scaleToFill" />
					</view>
						</view>
					<view class="bottom-view">
					<view class="hits-title">点击数<span>{{ o["hits"] }}</span></view>
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
				list_user_enterprise_information: [],
											}
		},
		methods: {
			/**
			 *  跳转链接
			 *  @param {Object} id
			 */
			to_nav(id) {
				this.$nav('/pages/recruitment_information/details?recruitment_information_id=' + id)
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
										}
	}
</script>

<style scoped>
	.list_recruitment_information {
		/* padding: 0 1rem; */
		margin-bottom: 1rem;
	}

	.list_recruitment_information .list_recruitment_information_table {
		width: 100%;
		padding: 5px 0;
	}

	.list_recruitment_information .list_recruitment_information_table .btn_change_table {
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

	.list_recruitment_information .list_recruitment_information_table .recruitment_information_table_block .uni-table-td{
		padding: 8px;
	}

	.list_recruitment_information .list_recruitment_information_table .recruitment_information_table_block .image {
		width: 10%;
	}

	.list_recruitment_information .list_recruitment_information_table .recruitment_information_table_block .text {
		overflow: hidden;
		width: 30%;
		font-size: 0.5rem;
	}

	.list_recruitment_information .list_recruitment_information_table .recruitment_information_table_block .hits {
		width: 12%;
		font-size: 0.5rem;
	}

	.list_recruitment_information .list_recruitment_information_table .recruitment_information_table_block .praise {
		width: 12%;
		font-size: 0.5rem;
	}

	.list_recruitment_information .list_recruitment_information_table .recruitment_information_table_block .create_time {
		width: 26%;
		font-size: 0.5rem;
	}
	.list_recruitment_information .item_recruitment_information {
		display: flex;
		justify-content: space-between;
		align-items: stretch;
		padding: 0.75rem 1rem;

	}
	.list_recruitment_information .item_recruitment_information+.item_recruitment_information{
		border-top: 1px solid #dbdbdb;
	}
	.list_recruitment_information .item_recruitment_information .left>image {
		position: relative;
		top: 50%;
		transform: translate(0, -50%);
		border-radius: 0.5rem;
	}

	.list_recruitment_information .item_recruitment_information .right_block {
		width: calc(100% - 5rem);
		display: flex;
		flex-direction: column;
		justify-content: space-between;
	}

	.list_recruitment_information .top {
		font-size: 0.9rem;
	}


	.list_recruitment_information .time {
		font-size: 0.6rem;
		color: var(--color_grey)
	}

	.list_recruitment_information .bottom {
		display: flex;
		justify-content: space-between;
		align-items: baseline;
		font-size: 0.5rem;
		color: var(--color_grey)
	}

	.list_recruitment_information .see {
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

