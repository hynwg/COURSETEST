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

    <table id="simple-table" class="table  table-bordered table-hover">
      <thead>
      <tr>
        <th>id</th>
        <th>相对路径</th>
        <th>文件名</th>
        <th>后缀</th>
        <th>大小</th>
        <th>用途</th>
        <th>已上传分片</th>
        <th>分片大小</th>
        <th>分片总数</th>
        <th>文件标识</th>
        <th>vod</th>
        <th>操作</th>
      </tr>
      </thead>

      <tbody>
      <tr v-for="fileInfo in fileInfoList">

        <td>{{ fileInfo.id }}</td>
        <td>{{ fileInfo.path }}</td>
        <td>{{ fileInfo.name }}</td>
        <td>{{ fileInfo.suffix }}</td>
        <td>{{ fileInfo.size }}</td>
        <td>{{ $filters.optionKV(FILE_USE, fileInfo.purpose) }}</td>
        <td>{{ fileInfo.shardIndex }}</td>
        <td>{{ fileInfo.shardSize }}</td>
        <td>{{ fileInfo.shardTotal }}</td>
        <td>{{ fileInfo.key }}</td>
        <td>{{ fileInfo.vod }}</td>

        <td>
          <div class="hidden-sm hidden-xs btn-group">

            <button v-on:click="edit(fileInfo)" class="btn btn-xs btn-info">
              <i class="ace-icon fa fa-pencil bigger-120"></i>
            </button>
            <button v-on:click="del(fileInfo.id)" class="btn btn-xs btn-danger">
              <i class="ace-icon fa fa-trash-o bigger-120"></i>
            </button>
          </div>
        </td>
      </tr>

      </tbody>
    </table>

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
                <label class="col-sm-2 control-label">相对路径</label>
                <div class="col-sm-10">
                  <input v-model="fileInfo.path" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">文件名</label>
                <div class="col-sm-10">
                  <input v-model="fileInfo.name" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">后缀</label>
                <div class="col-sm-10">
                  <input v-model="fileInfo.suffix" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">大小</label>
                <div class="col-sm-10">
                  <input v-model="fileInfo.size" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">用途</label>
                <div class="col-sm-10">
                  <select v-model="fileInfo.purpose" class="form-control">
                    <option v-for="o in FILE_USE" v-bind:value="o.key">
                      {{ o.value }}
                    </option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">已上传分片</label>
                <div class="col-sm-10">
                  <input v-model="fileInfo.shardIndex" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">分片大小</label>
                <div class="col-sm-10">
                  <input v-model="fileInfo.shardSize" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">分片总数</label>
                <div class="col-sm-10">
                  <input v-model="fileInfo.shardTotal" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">文件标识</label>
                <div class="col-sm-10">
                  <input v-model="fileInfo.key" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">vod</label>
                <div class="col-sm-10">
                  <input v-model="fileInfo.vod" class="form-control">
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
  </div>
</template>
<script>
import Pagination from "../../components/pagination";
// import toast from "../../components/pagination";

export default {
  components: {Pagination},
  name: "file-fileInfo",
  processData: false,
  data: function () {
    return {
      fileInfo: {},
      fileInfoList: [],
      FILE_USE: FILE_USE
    }
  },
  mounted: function () {
    let _this = this;
    _this.$refs.pagination.size = 5;
    _this.query(1);
  },
  methods: {
    /**
     * 点击【新增】
     */
    add() {
      let _this = this;
      _this.fileInfo = {};
      $("#form-modal").modal("show");
    },
    edit(fileInfo) {
      let _this = this;
      _this.fileInfo = $.extend({}, fileInfo);
      $("#form-modal").modal("show");
    },
    /**
     * 列表查询
     */
    query(page) {
      let _this = this;
      _this.$axios.post(process.env.VUE_APP_SERVER + '/file/admin/fileInfo/query', {
        page: page,
        size: _this.$refs.pagination.size,
      }).then((response) => {
        Loading.hide();
        console.log("查询文件列表", response);
        let resp = response.data;
        _this.fileInfoList = resp.content.list;
        _this.$refs.pagination.render(page, resp.content.total)
      })
    },
    save() {
      let _this = this;
      // 保存校验
      if (1 != 1
          || !Validator.require(_this.fileInfo.path, "相对路径")
          || !Validator.length(_this.fileInfo.path, "相对路径", 1, 100)
          || !Validator.length(_this.fileInfo.name, "文件名", 1, 100)
          || !Validator.length(_this.fileInfo.suffix, "后缀", 1, 10)
          || !Validator.length(_this.fileInfo.key, "文件标识", 1, 32)
      ) {
        return;
      }
      Loading.show();
      _this.$axios.post(process.env.VUE_APP_SERVER + '/file/admin/fileInfo/save',
          _this.fileInfo
      ).then((response) => {
        Loading.hide();
        console.log("保存文件列表", response);
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
      Confirm.show("确认删除文件后不可恢复", function () {
        Loading.show();
        _this.$axios.delete(process.env.VUE_APP_SERVER + '/file/admin/fileInfo/delete/' + id).then((response) => {
          Loading.hide();
          console.log("删除文件列表 ", response);
          let resp = response.data;
          if (resp.success) {
            _this.query(1);
            Toast.success("删除成功！");
          }
        })
      });
    }
  }
}
</script>
