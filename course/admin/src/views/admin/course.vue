<template>
  <div>
    <p>
      <button v-on:click="add()" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-edit"></i>
        新增
      </button>
      <button v-on:click="query(1)" class="btn btn-white btn-default btn-round">
        <i class="ace-icon fa fa-refresh"></i>
        刷新
      </button>
    </p>

    <pagination ref="pagination" v-bind:list="query" v-bind:itemCount="8"></pagination>
    <div class="row">
      <div v-for="course in courseList" class="col-md-4">
        <div class="thumbnail search-thumbnail">
          <img v-show="!course.image" class="media-object" src="/static/image/demo-course.jpg"/>
          <img v-show="course.image" class="media-object" v-bind:src="course.image"/>
          <div class="caption">
            <div class="clearfix">
              <span class="pull-right label label-primary info-label">
                {{ $filters.optionKV(COURSE_LEVEL, course.level) }}
              </span>
              <span class="pull-right label label-primary info-label">
                {{ $filters.optionKV(COURSE_CHARGE, course.charge) }}
              </span>
              <span class="pull-right label label-primary info-label">
                {{ $filters.optionKV(COURSE_STATUS, course.status) }}
              </span>
            </div>

            <h3 class="search-title">
              <a href="#" class="blue">{{ course.name }}</a>
            </h3>

            <div v-for="teacher in teacherList.filter(t=>{return t.id===course.teacherId})"
                 class="profile-activity clearfix">
              <div>
                <img v-show="!teacher.image" class="pull-left" src="/ace/assets/images/avatars/avatar5.png">
                <img v-show="teacher.image" class="pull-left" v-bind:src="teacher.image">
                <a class="user" href="#"> {{ teacher.name }} </a>
                <br>
                {{ teacher.position }}
              </div>
            </div>

            <p>
              <span class="blue bolder bigger-150">{{ course.price }}&nbsp;<i class="fa fa-rmb"></i></span>&nbsp;
            </p>
            <p>{{ course.summary }}</p>
            <p>
              <span class="badge badge-info">ID：{{ course.id }}</span>
              <span class="badge badge-info">排序：{{ course.sort }}</span>
              <span class="badge badge-info">时长：{{ $filters.formatSecond(course.time) }}</span>
            </p>
            <p>
              <button v-on:click="toChapter(course)" class="btn btn-white btn-xs btn-info btn-round">
                大章
              </button>&nbsp;
              <button v-on:click="toContent(course)" class="btn btn-white btn-xs btn-info btn-round">
                内容
              </button>&nbsp;
              <button v-on:click="openSortModal(course)" class="btn btn-white btn-xs btn-info btn-round">
                排序
              </button>&nbsp;
              <button v-on:click="edit(course)" class="btn btn-white btn-xs btn-info btn-round">
                编辑
              </button>&nbsp;
              <button v-on:click="del(course.id)" class="btn btn-white btn-xs btn-warning btn-round">
                删除
              </button>
            </p>
          </div>
        </div>
      </div>
    </div>

    <div id="form-modal" class="modal fade" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">表单</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
              <div class="form-group">
                <label class="col-sm-2 control-label">
                  分类
                </label>
                <div class="col-sm-10">
                  <ul id="tree" class="ztree"></ul>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">封面</label>
                <div class="col-sm-10">
                  <big-file v-bind:input-id="'image-upload'"
                            v-bind:text="'上传封面'"
                            v-bind:suffixs="['jpg', 'jpeg', 'png']"
                            v-bind:use="FILE_USE.COURSE.key"
                            v-bind:after-upload="afterUpload"></big-file>
                  <div v-show="course.image" class="row">
                    <div class="col-md-6">
                      <img v-bind:src="course.image" class="img-responsive">
                    </div>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">名称</label>
                <div class="col-sm-10">
                  <input v-model="course.name" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">讲师</label>
                <div class="col-sm-10">
                  <select v-model="course.teacherId" class="form-control">
                    <option v-for="o in teacherList" v-bind:value="o.id">{{ o.name }}</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">概述</label>
                <div class="col-sm-10">
                  <textarea v-model="course.summary" class="form-control"></textarea>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">时长</label>
                <div class="col-sm-10">
                  <input v-model="course.time" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">价格（元）</label>
                <div class="col-sm-10">
                  <input v-model="course.price" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">级别</label>
                <div class="col-sm-10">
                  <select v-model="course.level" class="form-control">
                    <option v-for="o in COURSE_LEVEL" v-bind:value="o.key">
                      {{ o.value }}
                    </option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">收费</label>
                <div class="col-sm-10">
                  <select v-model="course.charge" class="form-control">
                    <option v-for="o in COURSE_CHARGE" v-bind:value="o.key">
                      {{ o.value }}
                    </option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">状态</label>
                <div class="col-sm-10">
                  <select v-model="course.status" class="form-control">
                    <option v-for="o in COURSE_STATUS" v-bind:value="o.key">
                      {{ o.value }}
                    </option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">报名数</label>
                <div class="col-sm-10">
                  <input v-model="course.enroll" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">顺序</label>
                <div class="col-sm-10">
                  <input v-model="course.sort" class="form-control" disabled>
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button v-on:click="save()" type="button" class="btn btn-primary">保存</button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <div id="course-sort-modal" class="modal fade" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">排序</h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
              <div class="form-group">
                <label class="control-label col-lg-3">
                  当前排序
                </label>
                <div class="col-lg-9">
                  <input class="form-control" v-model="sort.oldSort" name="oldSort" disabled>
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-lg-3">
                  新排序
                </label>
                <div class="col-lg-9">
                  <input class="form-control" v-model="sort.newSort" name="newSort">
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-white btn-default btn-round" data-dismiss="modal">
              <i class="ace-icon fa fa-times"></i>
              取消
            </button>
            <button type="button" class="btn btn-white btn-info btn-round" v-on:click="updateSort()">
              <i class="ace-icon fa fa-plus blue"></i>
              更新排序
            </button>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
  </div>
</template>
<script>
import Pagination from "../../components/pagination";
import BigFile from "../../components/big-file";

export default {
  components: {Pagination, BigFile},
  name: "business-course",
  processData: false,
  //定义变量
  data: function () {
    return {
      course: {},
      courseList: [],
      COURSE_LEVEL: COURSE_LEVEL,
      COURSE_CHARGE: COURSE_CHARGE,
      COURSE_STATUS: COURSE_STATUS,
      FILE_USE: FILE_USE,
      tree: {},
      categoryList: [],
      saveContentLabel: "",
      sort: {
        id: "",
        oldSort: 0,
        newSort: 0
      },
      teacherList: [],

    }
  },
  //初始化方法
  mounted: function () {
    let _this = this;
    _this.$refs.pagination.size = 5;
    _this.allCategory();
    _this.allTeacher();
    _this.query(1);
  },
  methods: {
    /**
     * 点击【新增】
     */
    add() {
      let _this = this;
      _this.course = {
        sort: _this.$refs.pagination.total + 1
      };
      _this.tree.checkAllNodes(false);
      $("#form-modal").modal("show");
    },
    edit(course) {
      let _this = this;
      _this.course = $.extend({}, course);
      _this.listCategory(course.id);
      $("#form-modal").modal("show");
    },
    /**
     * 列表查询
     */
    query(page) {
      let _this = this;
      Loading.show();
      _this.$axios.post(process.env.VUE_APP_SERVER + '/business/admin/course/query', {
        page: page,
        size: _this.$refs.pagination.size,
      }).then((response) => {
        Loading.hide();
        console.log("查询课程列表", response);
        let resp = response.data;
        _this.courseList = resp.content.list;
        _this.$refs.pagination.render(page, resp.content.total)
      })
    },
    save() {
      let _this = this;
      // 保存校验
      if (1 != 1
          || !Validator.require(_this.course.name, "名称")
          || !Validator.length(_this.course.name, "名称", 1, 50)
          || !Validator.length(_this.course.summary, "概述", 1, 2000)
          || !Validator.length(_this.course.image, "封面", 1, 100)
      ) {
        return;
      }
      // 保存之前tree树型
      let categoryList = _this.tree.getCheckedNodes();
      if (Tool.isEmpty(categoryList)) {
        Toast.warning("请选择分类！");
        return;
      }
      _this.course.categoryList = categoryList;

      Loading.show();
      _this.$axios.post(process.env.VUE_APP_SERVER + '/business/admin/course/save',
          _this.course
      ).then((response) => {
        Loading.hide();
        console.log("保存课程列表", response);
        let resp = response.data;
        if (resp.success) {
          $("#form-modal").modal("hide");
          _this.query(1);
          Toast.success("保存成功！");
        } else {
          Toast.warning(resp.message);
        }
      })
    },
    del(id) {
      let _this = this;
      Confirm.show("确认删除课程后不可恢复", function () {
        Loading.show();
        _this.$axios.delete(process.env.VUE_APP_SERVER + '/business/admin/course/delete/' + id).then((response) => {
          Loading.hide();
          console.log("删除课程列表 ", response);
          let resp = response.data;
          if (resp.success) {
            _this.query(1);
            Toast.success("删除成功！");
          }
        })
      });
    },
    /**
     * 点击【大章】
     */
    toChapter(course) {
      let _this = this;
      SessionStorage.set(SESSION_KEY_COURSE, course);
      _this.$router.push("/business/chapter");
    },
    allCategory() {
      let _this = this;
      Loading.show();
      _this.$axios.post(process.env.VUE_APP_SERVER + '/business/admin/category/all').then((response) => {
        Loading.hide();
        let resp = response.data;
        _this.categoryList = resp.content;

        _this.initTree();
      })
    },
    initTree() {
      let _this = this;
      let setting = {
        check: {
          enable: true,
          autoCheckTrigger: true,   //true / false 分别表示 触发 / 不触发 事件回调函数
          chkStyle: "checkbox",   //勾选框类型(checkbox 或 radio）
          chkboxType: {"Y": "p", "N": "s"}   //勾选 checkbox 对于父子节点的关联关系
        },
        data: {
          simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "parent",
            rootPId: 0
          }
        }
      };

      let zNodes = _this.categoryList;
      // let zNodes =[
      //   { id:1, pId:0, name:"can check 1", open:true}
      // ];

      _this.tree = $.fn.zTree.init($("#tree"), setting, zNodes);

      // 展开所有的节点
      // _this.tree.expandAll(true);
    },
    /**
     * 查找课程下所有分类
     * @param courseId
     */
    listCategory(courseId) {
      let _this = this;
      Loading.show();
      _this.$axios.post(process.env.VUE_APP_SERVER + '/business/admin/course/list-category/' + courseId).then((res) => {
        Loading.hide();
        console.log("查找课程下所有分类结果：", res);
        let response = res.data;
        let categoryList = response.content;

        // 勾选查询到的分类
        _this.tree.checkAllNodes(false);
        for (let i = 0; i < categoryList.length; i++) {
          let node = _this.tree.getNodeByParam("id", categoryList[i].categoryId);
          _this.tree.checkNode(node, true);
        }
      })
    },
    /**
     * 点击【内容】
     */
    toContent(course) {
      let _this = this;
      SessionStorage.set(SESSION_KEY_COURSE, course);
      _this.$router.push("/business/content");
    },
    /**
     * 打开模态框
     * @param course
     */

    openSortModal(course) {
      let _this = this;
      _this.sort = {
        id: course.id,
        oldSort: course.sort,
        newSort: course.sort
      };
      $("#course-sort-modal").modal("show");
    },

    /**
     * 排序
     */
    updateSort() {
      let _this = this;
      if (_this.sort.newSort === _this.sort.oldSort) {
        Toast.warning("排序没有变化");
        return;
      }
      Loading.show();
      _this.$axios.post(process.env.VUE_APP_SERVER + "/business/admin/course/sort", _this.sort).then((res) => {
        let response = res.data;

        if (response.success) {
          Toast.success("更新排序成功");
          $("#course-sort-modal").modal("hide");
          _this.list(1);
        } else {
          Toast.error("更新排序失败");
        }
      });
    },

    allTeacher() {
      let _this = this;
      Loading.show();
      _this.$axios.post(process.env.VUE_APP_SERVER + '/business/admin/teacher/all').then((response) => {
        console.log("讲师列表", response);
        Loading.hide();
        let resp = response.data;
        _this.teacherList = resp.content;
      })
    },

    afterUpload(resp) {
      let _this = this;
      let image = resp.content.path;
      _this.course.image = image;
    },


  }
}
</script>
<style scoped>
.caption h3 {
  font-size: 20px;
}

@media (max-width: 1199px) {
  .caption h3 {
    font-size: 16px;
  }
}
</style>
