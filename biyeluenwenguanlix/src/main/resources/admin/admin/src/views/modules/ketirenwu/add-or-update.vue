<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='zhidaojiaoshi'">
                    <el-form-item class="select" v-if="type!='info' && role != '用户'"  label="指导教师" prop="zhidaojiaoshiId">
                        <el-select v-model="ruleForm.zhidaojiaoshiId" :disabled="ro.zhidaojiaoshiId" filterable placeholder="请选择指导教师" @change="zhidaojiaoshiChange">
                            <el-option
                                    v-for="(item,index) in zhidaojiaoshiOptions"
                                    v-bind:key="item.id"
                                    :label="item.zhidaojiaoshiName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='zhidaojiaoshi' ">
                    <el-form-item class="input" v-if="type!='info' && role != '用户'"  label="指导教师姓名" prop="zhidaojiaoshiName">
                        <el-input v-model="zhidaojiaoshiForm.zhidaojiaoshiName"
                                  placeholder="指导教师姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="指导教师姓名" prop="zhidaojiaoshiName">
                            <el-input v-model="ruleForm.zhidaojiaoshiName"
                                      placeholder="指导教师姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhidaojiaoshi' ">
                    <el-form-item class="input" v-if="type!='info' && role != '用户'"  label="手机号" prop="zhidaojiaoshiPhone">
                        <el-input v-model="zhidaojiaoshiForm.zhidaojiaoshiPhone"
                                  placeholder="手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="手机号" prop="zhidaojiaoshiPhone">
                            <el-input v-model="ruleForm.zhidaojiaoshiPhone"
                                      placeholder="手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xuantishenqing'">
                    <el-form-item class="select" v-if="type!='info' && role != '用户'"  label="选题申请" prop="xuantishenqingId">
                        <el-select v-model="ruleForm.xuantishenqingId" :disabled="ro.xuantishenqingId" filterable placeholder="请选择选题申请" @change="xuantishenqingChange">
                            <el-option
                                    v-for="(item,index) in xuantishenqingOptions"
                                    v-bind:key="item.id"
                                    :label="item.xuantishenqingUuidNumber"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='xuantishenqing' ">
                    <el-form-item class="input" v-if="type!='info' && role != '用户'"  label="课题编号" prop="xuantishenqingUuidNumber">
                        <el-input v-model="xuantishenqingForm.xuantishenqingUuidNumber"
                                  placeholder="课题编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="课题编号" prop="xuantishenqingUuidNumber">
                            <el-input v-model="ruleForm.xuantishenqingUuidNumber"
                                      placeholder="课题编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="zhidaojiaoshiId" name="zhidaojiaoshiId" type="hidden">
            <input id="xuantishenqingId" name="xuantishenqingId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info' && role != '用户'"  label="课题任务" prop="ketirenwuName">
                       <el-input v-model="ruleForm.ketirenwuName"
                                 placeholder="课题任务" clearable  :readonly="ro.ketirenwuName"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="课题任务" prop="ketirenwuName">
                           <el-input v-model="ruleForm.ketirenwuName"
                                     placeholder="课题任务" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info' && role != '用户'"  label="任务类型" prop="ketirenwuTypes">
                        <el-select v-model="ruleForm.ketirenwuTypes" :disabled="ro.ketirenwuTypes" placeholder="请选择任务类型">
                            <el-option
                                v-for="(item,index) in ketirenwuTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="任务类型" prop="ketirenwuValue">
                        <el-input v-model="ruleForm.ketirenwuValue"
                            placeholder="任务类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' && !ro.ketirenwuFile && role != '用户'" label="参考文献" prop="ketirenwuFile">
                        <file-upload
                                tip="点击上传参考文献"
                                action="file/upload"
                                :limit="3"
                                :multiple="true"
                                :fileUrls="ruleForm.ketirenwuFile?ruleForm.ketirenwuFile:''"
                                @change="ketirenwuFileUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.ketirenwuFile" label="参考文献" prop="ketirenwuFile">
                            <a type="text" style="text-decoration:none" class="el-button" :href="ruleForm.ketirenwuFile"  >参考文献下载</a>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="(role=='指导教师' && type=='info') || role == '管理员' || role == '用户'">
                    <el-form-item class="upload" v-if="type!='info' && !ro.ketirenwuHuidaFile" label="阶段文档" prop="ketirenwuHuidaFile">
                        <file-upload
                                tip="点击上传阶段文档"
                                action="file/upload"
                                :limit="3"
                                :multiple="true"
                                :fileUrls="ruleForm.ketirenwuHuidaFile?ruleForm.ketirenwuHuidaFile:''"
                                @change="ketirenwuHuidaFileUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.ketirenwuHuidaFile" label="阶段文档" prop="ketirenwuHuidaFile">
                            <a type="text" style="text-decoration:none" class="el-button" :href="ruleForm.ketirenwuHuidaFile"  >阶段文档下载</a>
                        </el-form-item>
                    </div>
                </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.ketirenwuYesnoTypes" label="审核结果" prop="ketirenwuYesnoTypes">
                        <el-input v-model="ruleForm.ketirenwuYesnoValue" placeholder="审核结果" readonly></el-input>
                    </el-form-item>
                </div>
            </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.ketirenwuYesnoText" label="指导教师打分" prop="ketirenwuYesnoText">
                        <span v-html="ruleForm.ketirenwuYesnoText"></span>
                    </el-form-item>
                </div>
            </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                zhidaojiaoshiForm: {},
                xuantishenqingForm: {},
                ro:{
                    zhidaojiaoshiId: false,
                    xuantishenqingId: false,
                    ketirenwuName: false,
                    ketirenwuTypes: false,
                    ketirenwuFile: false,
                    ketirenwuHuidaFile: false,
                    ketirenwuYesnoTypes: false,
                    ketirenwuYesnoText: false,
                    insertTime: false,
                },
                ruleForm: {
                    zhidaojiaoshiId: '',
                    xuantishenqingId: '',
                    ketirenwuName: '',
                    ketirenwuTypes: '',
                    ketirenwuFile: '',
                    ketirenwuHuidaFile: '',
                    ketirenwuYesnoTypes: '',
                    ketirenwuYesnoText: '',
                    insertTime: '',
                },
                ketirenwuTypesOptions : [],
                ketirenwuYesnoTypesOptions : [],
                zhidaojiaoshiOptions : [],
                xuantishenqingOptions : [],
                rules: {
                   zhidaojiaoshiId: [
                              { required: true, message: '指导教师不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   xuantishenqingId: [
                              { required: true, message: '选题申请不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   ketirenwuName: [
                              { required: true, message: '课题任务不能为空', trigger: 'blur' },
                          ],
                   ketirenwuTypes: [
                              { required: true, message: '任务类型不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   ketirenwuFile: [
                              { required: true, message: '参考文献不能为空', trigger: 'blur' },
                          ],
                   ketirenwuHuidaFile: [
                              { required: true, message: '阶段文档不能为空', trigger: 'blur' },
                          ],
                   ketirenwuYesnoTypes: [
                              { required: true, message: '审核结果不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   ketirenwuYesnoText: [
                              { required: true, message: '指导教师打分不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '添加时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=ketirenwu_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.ketirenwuTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=ketirenwu_yesno_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.ketirenwuYesnoTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `zhidaojiaoshi/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.zhidaojiaoshiOptions = data.data.list;
            }
         });
         this.$http({
             url: `xuantishenqing/page?page=1&limit=100&xuantishenqingYesnoTypes= 2`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.xuantishenqingOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            zhidaojiaoshiChange(id){
                this.$http({
                    url: `zhidaojiaoshi/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zhidaojiaoshiForm = data.data;
                    }
                });
            },
            xuantishenqingChange(id){
                this.$http({
                    url: `xuantishenqing/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xuantishenqingForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `ketirenwu/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.zhidaojiaoshiChange(data.data.zhidaojiaoshiId)
                        _this.xuantishenqingChange(data.data.xuantishenqingId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`ketirenwu/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.ketirenwuCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.ketirenwuCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            ketirenwuFileUploadChange(fileUrls){
                this.ruleForm.ketirenwuFile = fileUrls;
                this.addEditUploadStyleChange()
            },
            ketirenwuHuidaFileUploadChange(fileUrls){
                this.ruleForm.ketirenwuHuidaFile = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
        height: 500px;

    & /deep/ .ql-container {
          height: 310px;
      }
    }
    .amap-wrapper {
        width: 100%;
        height: 500px;
    }
    .search-box {
        position: absolute;
    }
    .addEdit-block {
        margin: -10px;
    }
    .detail-form-content {
        padding: 12px;
    }
    .btn .el-button {
        padding: 0;
    }</style>

