<template>
  <view>
    <view class="container diy_view">
      <view>
        <view>
          <view class="">
            <uni-forms :modelValue="form"  v-if="is_view()">

              <uni-forms-item v-if="$check_field('get','enterprise_information') || $check_field('add','enterprise_information') || $check_field('set','enterprise_information')" label="企业信息" name="enterprise_information">
                        <uni-data-select
                  id="form_enterprise_information"
                  v-model="form['enterprise_information']"
                  :localdata="list_user_enterprise_information"
                  :clear="!disabledObj['enterprise_information_isDisabled']"
                  :disabled="disabledObj['enterprise_information_isDisabled']"
                  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','enterprise_information')) || (!form['recruitment_information_id'] && $check_field('add','enterprise_information'))"
                ></uni-data-select>
                <uni-data-select
                  v-model="form['enterprise_information']"
                  :localdata="list_user_enterprise_information"
                  :clear="false"
                  :disabled="true"
                  v-else-if="$check_field('get','enterprise_information')" id="enterprise_information"
                ></uni-data-select>
                    </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','enterprise_name') || $check_field('add','enterprise_name') || $check_field('set','enterprise_name')" label="企业名称" name="enterprise_name">
                                <uni-easyinput type="text" v-model="form['enterprise_name']" v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','enterprise_name')) || (!form['recruitment_information_id'] && $check_field('add','enterprise_name'))" :disabled="disabledObj['enterprise_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','enterprise_name')">
                  {{ form['enterprise_name'] }}
                </text>
                            </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','recruitment_position') || $check_field('add','recruitment_position') || $check_field('set','recruitment_position')" label="招聘岗位" name="recruitment_position">
                                <uni-easyinput type="text" v-model="form['recruitment_position']" v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','recruitment_position')) || (!form['recruitment_information_id'] && $check_field('add','recruitment_position'))" :disabled="disabledObj['recruitment_position_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','recruitment_position')">
                  {{ form['recruitment_position'] }}
                </text>
                            </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','number_of_recruiters') || $check_field('add','number_of_recruiters') || $check_field('set','number_of_recruiters')" label="招聘人数" name="number_of_recruiters">
                                <uni-easyinput type="text" v-model="form['number_of_recruiters']" v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','number_of_recruiters')) || (!form['recruitment_information_id'] && $check_field('add','number_of_recruiters'))" :disabled="disabledObj['number_of_recruiters_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','number_of_recruiters')">
                  {{ form['number_of_recruiters'] }}
                </text>
                            </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','office_location') || $check_field('add','office_location') || $check_field('set','office_location')" label="办公地点" name="office_location">
                                <uni-easyinput type="text" v-model="form['office_location']" v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','office_location')) || (!form['recruitment_information_id'] && $check_field('add','office_location'))" :disabled="disabledObj['office_location_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','office_location')">
                  {{ form['office_location'] }}
                </text>
                            </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','salary_range') || $check_field('add','salary_range') || $check_field('set','salary_range')" label="薪资范围" name="salary_range">
                                <uni-easyinput type="text" v-model="form['salary_range']" v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','salary_range')) || (!form['recruitment_information_id'] && $check_field('add','salary_range'))" :disabled="disabledObj['salary_range_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','salary_range')">
                  {{ form['salary_range'] }}
                </text>
                            </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','job_requirements') || $check_field('add','job_requirements') || $check_field('set','job_requirements')" label="岗位要求" name="job_requirements">
                        <uni-easyinput type="textarea" v-model="form['job_requirements']" v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','job_requirements')) || (!form['recruitment_information_id'] && $check_field('add','job_requirements'))" :disabled="disabledObj['job_requirements_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','job_requirements')">
                  {{ form['job_requirements'] }}
                </text>
                    </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','enterprise_cover') || $check_field('add','enterprise_cover') || $check_field('set','enterprise_cover')" label="企业封面" name="enterprise_cover">
                        <!-- 修改权限 -->
                <view class="diy_field diy_img" v-if="form['enterprise_cover'] && $check_field('set','enterprise_cover')">
                  <image v-if="disabledObj['enterprise_cover_isDisabled']" :src="$fullUrl(form['enterprise_cover'])" />
                  <image v-if="!disabledObj['enterprise_cover_isDisabled']" :src="$fullUrl(form['enterprise_cover'])" @click="change_img('enterprise_cover')" />
                </view>
                <!-- 添加权限 -->
                <view class="diy_field diy_img" v-else-if="!form['enterprise_cover'] && $check_field('add','enterprise_cover')">
                  <view v-if="disabledObj['enterprise_cover_isDisabled']" class="btn_add_img">
                    <text>+</text>
                  </view>
                  <view v-if="!disabledObj['enterprise_cover_isDisabled']" class="btn_add_img" @click="change_img('enterprise_cover')">
                    <text>+</text>
                  </view>
                </view>
                <!-- 查询权限 -->
                <view class="diy_field diy_img" v-else-if="$check_field('get','enterprise_cover')">
                  <image :src="$fullUrl(form['enterprise_cover'])" />
                </view>
                    </uni-forms-item>


            </uni-forms>
            <view class="form_button">
              <button size="mini" type="primary" @click="submit()" class="primary_btn">提交</button>
              <button size="mini" @click="cancel()">取消</button>
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
    changeLog(v,value){
      this.form[value] = v
    },
    /**
     * 上传文件
     * @param {Object} param文件参数
     */
    change_file(key_name){
      var _self = this;
      // 选择图像方法
      uni.chooseFile({
        count: 1,
        sizeType: ['original', 'compressed'], //可以指定是原图还是压缩图，默认二者都有
        sourceType: ['album'], //从相册选择
        success: function(res) {
          const tempFilePaths = res.tempFilePaths;
          const uploadTask = uni.uploadFile({
            url: _self.$fullUrl('/api/recruitment_information/upload?'),
            filePath: tempFilePaths[0],
            name: 'file',
            formData: {
              'i_want_to_customize': 'test'
            },
            header: {
              'x-auth-token': _self.$store.state.user.token
            },
            success: function(uploadFileRes) {
              var filename = JSON.parse(uploadFileRes.data).result.url
              _self.form[key_name] = filename
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
     * 上传图片
     * @param {Object} param文件参数
     */
    change_img(key_name){
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
            url: _self.$fullUrl('/api/recruitment_information/upload?'),
            filePath: tempFilePaths[0],
            name: 'file',
            formData: {
              'i_want_to_customize': 'test'
            },
            header: {
              'x-auth-token': _self.$store.state.user.token
            },
            success: function(uploadFileRes) {
              var filename = JSON.parse(uploadFileRes.data).result.url
              _self.form[key_name] = filename
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
            /**
     * 获取企业用户用户组
     */
    async get_group_user_enterprise_information() {
      this.form["enterprise_information"] = this.user.user_id;
      var json = await this.$get("~/api/user_group/get_obj?name=企业用户");
      if(json.result && json.result.obj){
        this.group_user_enterprise_information = json.result.obj;
        this.get_user_session_enterprise_information(this.form['enterprise_information'])
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
            
            
            
            
            
            
            
            
    
    /**
     * 获取对象之后
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_after(json, func){
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

  },
  created() {
            this.get_list_user_enterprise_information();
            this.get_group_user_enterprise_information();
                                                                      },
}
</script>

<style scoped>
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

.form_button{
  padding-bottom: 15px;
  display: flex;
}
.form_button button{
  width: 40%;
}
.query_select{
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

.query_option{
  width: 100%;
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
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}

.form_button {
  padding-bottom: 15px;
  display: flex;
}
.form_button button {
  width: 40%;
}
.query_select {
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
  outline: none;
}

.query_option {
  width: 100%;
}

.btn_add_img {
  color: #d3d3d3;
  text-align: center;
  border: 1px solid #eee;
  height: 5rem;
  width: 5rem;
  position: relative;
}
.btn_add_img text {
  font-size: 35px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
/*新样式*/
.uni-forms{
padding-top:1rem;
}
.uni-forms-item {
	padding: 6px 10px;
    background: #f8f6fc;
}
.uni-forms .is-input-border{
	border: 0;
}
.container{
	    -webkit-box-shadow: 0px 0px 0px #888888;
	    box-shadow: 0px 0px 0px #888888;
}
.form_button .primary_btn{
		background-color: #22B8B8;
		color: #FFFFFF;
	}
</style>
