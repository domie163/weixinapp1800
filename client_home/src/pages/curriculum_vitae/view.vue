<template>
  <view>
    <view class="container diy_view">
      <view>
        <view>
          <view class="">
            <uni-forms :modelValue="form"  v-if="is_view()">

              <uni-forms-item v-if="$check_field('get','user_information') || $check_field('add','user_information') || $check_field('set','user_information')" label="用户信息" name="user_information">
                        <uni-data-select
                  id="form_user_information"
                  v-model="form['user_information']"
                  :localdata="list_user_user_information"
                  :clear="!disabledObj['user_information_isDisabled']"
                  :disabled="disabledObj['user_information_isDisabled']"
                  v-if="user_group === '管理员' || (form['curriculum_vitae_id'] && $check_field('set','user_information')) || (!form['curriculum_vitae_id'] && $check_field('add','user_information'))"
                ></uni-data-select>
                <uni-data-select
                  v-model="form['user_information']"
                  :localdata="list_user_user_information"
                  :clear="false"
                  :disabled="true"
                  v-else-if="$check_field('get','user_information')" id="user_information"
                ></uni-data-select>
                    </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','user_name') || $check_field('add','user_name') || $check_field('set','user_name')" label="用户姓名" name="user_name">
                                <uni-easyinput type="text" v-model="form['user_name']" v-if="user_group === '管理员' || (form['curriculum_vitae_id'] && $check_field('set','user_name')) || (!form['curriculum_vitae_id'] && $check_field('add','user_name'))" :disabled="disabledObj['user_name_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','user_name')">
                  {{ form['user_name'] }}
                </text>
                            </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','user_gender') || $check_field('add','user_gender') || $check_field('set','user_gender')" label="用户性别" name="user_gender">
                        <uni-data-select
                  v-model="form.user_gender"
                  :localdata="list_user_gender"
                  :clear="!disabledObj['user_gender_isDisabled']"
                  :disabled="disabledObj['user_gender_isDisabled']"
                  v-if="user_group === '管理员' || (form['curriculum_vitae_id'] && $check_field('set','user_gender')) || (!form['curriculum_vitae_id'] && $check_field('add','user_gender'))"
                ></uni-data-select>
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','user_gender')">
                  {{ form['user_gender'] }}
                </text>
                    </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','user_age') || $check_field('add','user_age') || $check_field('set','user_age')" label="用户年龄" name="user_age">
                                <uni-easyinput type="text" v-model="form['user_age']" v-if="user_group === '管理员' || (form['curriculum_vitae_id'] && $check_field('set','user_age')) || (!form['curriculum_vitae_id'] && $check_field('add','user_age'))" :disabled="disabledObj['user_age_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','user_age')">
                  {{ form['user_age'] }}
                </text>
                            </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','personal_education') || $check_field('add','personal_education') || $check_field('set','personal_education')" label="个人学历" name="personal_education">
                        <uni-data-select
                  v-model="form.personal_education"
                  :localdata="list_personal_education"
                  :clear="!disabledObj['personal_education_isDisabled']"
                  :disabled="disabledObj['personal_education_isDisabled']"
                  v-if="user_group === '管理员' || (form['curriculum_vitae_id'] && $check_field('set','personal_education')) || (!form['curriculum_vitae_id'] && $check_field('add','personal_education'))"
                ></uni-data-select>
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','personal_education')">
                  {{ form['personal_education'] }}
                </text>
                    </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','graduation_college') || $check_field('add','graduation_college') || $check_field('set','graduation_college')" label="毕业学院" name="graduation_college">
                                <uni-easyinput type="text" v-model="form['graduation_college']" v-if="user_group === '管理员' || (form['curriculum_vitae_id'] && $check_field('set','graduation_college')) || (!form['curriculum_vitae_id'] && $check_field('add','graduation_college'))" :disabled="disabledObj['graduation_college_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','graduation_college')">
                  {{ form['graduation_college'] }}
                </text>
                            </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','personal_specialty') || $check_field('add','personal_specialty') || $check_field('set','personal_specialty')" label="个人特长" name="personal_specialty">
                                <uni-easyinput type="text" v-model="form['personal_specialty']" v-if="user_group === '管理员' || (form['curriculum_vitae_id'] && $check_field('set','personal_specialty')) || (!form['curriculum_vitae_id'] && $check_field('add','personal_specialty'))" :disabled="disabledObj['personal_specialty_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','personal_specialty')">
                  {{ form['personal_specialty'] }}
                </text>
                            </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','contact_information') || $check_field('add','contact_information') || $check_field('set','contact_information')" label="联系方式" name="contact_information">
                                <uni-easyinput type="text" v-model="form['contact_information']" v-if="user_group === '管理员' || (form['curriculum_vitae_id'] && $check_field('set','contact_information')) || (!form['curriculum_vitae_id'] && $check_field('add','contact_information'))" :disabled="disabledObj['contact_information_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','contact_information')">
                  {{ form['contact_information'] }}
                </text>
                            </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','job_position') || $check_field('add','job_position') || $check_field('set','job_position')" label="求职岗位" name="job_position">
                                <uni-easyinput type="text" v-model="form['job_position']" v-if="user_group === '管理员' || (form['curriculum_vitae_id'] && $check_field('set','job_position')) || (!form['curriculum_vitae_id'] && $check_field('add','job_position'))" :disabled="disabledObj['job_position_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','job_position')">
                  {{ form['job_position'] }}
                </text>
                            </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','work_experience') || $check_field('add','work_experience') || $check_field('set','work_experience')" label="工作经历" name="work_experience">
                        <uni-easyinput type="textarea" v-model="form['work_experience']" v-if="user_group === '管理员' || (form['curriculum_vitae_id'] && $check_field('set','work_experience')) || (!form['curriculum_vitae_id'] && $check_field('add','work_experience'))" :disabled="disabledObj['work_experience_isDisabled']" />
                <!-- 仅查看 -->
                <text v-else-if="$check_field('get','work_experience')">
                  {{ form['work_experience'] }}
                </text>
                    </uni-forms-item>
              <uni-forms-item v-if="$check_field('get','curriculum_vitae') || $check_field('add','curriculum_vitae') || $check_field('set','curriculum_vitae')" label="个人简历" name="curriculum_vitae">
                        <!-- 修改权限 -->
                <view class="diy_field diy_img" v-if="form['curriculum_vitae'] && $check_field('set','curriculum_vitae')">
                  <image v-if="disabledObj['curriculum_vitae_isDisabled']" :src="$fullUrl(form['curriculum_vitae'])" />
                  <image v-if="!disabledObj['curriculum_vitae_isDisabled']" :src="$fullUrl(form['curriculum_vitae'])" @click="change_img('curriculum_vitae')" />
                </view>
                <!-- 添加权限 -->
                <view class="diy_field diy_img" v-else-if="!form['curriculum_vitae'] && $check_field('add','curriculum_vitae')">
                  <view v-if="disabledObj['curriculum_vitae_isDisabled']" class="btn_add_img">
                    <text>+</text>
                  </view>
                  <view v-if="!disabledObj['curriculum_vitae_isDisabled']" class="btn_add_img" @click="change_img('curriculum_vitae')">
                    <text>+</text>
                  </view>
                </view>
                <!-- 查询权限 -->
                <view class="diy_field diy_img" v-else-if="$check_field('get','curriculum_vitae')">
                  <image :src="$fullUrl(form['curriculum_vitae'])" />
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
      field: "curriculum_vitae_id",
      url_add: "~/api/curriculum_vitae/add?",
      url_set: "~/api/curriculum_vitae/set?",
      url_get_obj: "~/api/curriculum_vitae/get_obj?",
      url_upload: "~/api/curriculum_vitae/upload?",

      query: {
        "curriculum_vitae_id": 0,
      },

      form: {
            "user_information": 0, // 用户信息
                    "user_name":  '', // 用户姓名
                    "user_gender":  '', // 用户性别
                    "user_age":  '', // 用户年龄
                    "personal_education":  '', // 个人学历
                    "graduation_college":  '', // 毕业学院
                    "personal_specialty":  '', // 个人特长
                    "contact_information":  '', // 联系方式
                    "job_position":  '', // 求职岗位
                    "work_experience":  '', // 工作经历
                    "curriculum_vitae":  '', // 个人简历
                                "curriculum_vitae_id": 0, // ID
                
              },
          disabledObj:{
                        "user_information_isDisabled": false,
                                "user_name_isDisabled": false,
                                "user_gender_isDisabled": false,
                                "user_age_isDisabled": false,
                                "personal_education_isDisabled": false,
                                "graduation_college_isDisabled": false,
                                "personal_specialty_isDisabled": false,
                                "contact_information_isDisabled": false,
                                "job_position_isDisabled": false,
                                "work_experience_isDisabled": false,
                                "curriculum_vitae_isDisabled": false,
                                  },
                                // 用户列表
            list_user_user_information: [],
                        // 用户组
            group_user_user_information: "",
                                                              // 用户性别选项列表
          list_user_gender: [],
                                                          // 个人学历选项列表
          list_personal_education: [],
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
            url: _self.$fullUrl('/api/curriculum_vitae/upload?'),
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
            url: _self.$fullUrl('/api/curriculum_vitae/upload?'),
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
            /**
     * 获取个人用户用户组
     */
    async get_group_user_user_information() {
      this.form["user_information"] = this.user.user_id;
      var json = await this.$get("~/api/user_group/get_obj?name=个人用户");
      if(json.result && json.result.obj){
        this.group_user_user_information = json.result.obj;
        this.get_user_session_user_information(this.form['user_information'])
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
     * 获取对象之后
     * @param {Object} json
     * @param {Object} func
     */
    get_obj_after(json, func){
                                                                                            },

    is_view(){
      var bl = this.user_group == "管理员";

      if(!bl){
        bl = this.$check_action('/curriculum_vitae/table','add');
        console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
      }
      if(!bl){
        bl = this.$check_action('/curriculum_vitae/table','set');
        console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
      }
      if(!bl){
        bl = this.$check_action('/curriculum_vitae/view','add');
        console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
      }
      if(!bl){
        bl = this.$check_action('/curriculum_vitae/view','set');
        console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
      }
      if(!bl){
        bl = this.$check_action('/curriculum_vitae/view','get');
        console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
      }

      console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

      return bl;
    },

  },
  created() {
            this.get_list_user_user_information();
            this.get_group_user_user_information();
                            this.get_list_user_gender();
                        this.get_list_personal_education();
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
