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
                        <th>用户名称</th>
                        <th>用户ID</th>
                        <th>支付宝</th>
                        <th>微信</th>
                        <th>储蓄卡</th>
                        <th>借出</th>
                        <th>基金</th>
                        <th>涨乐富</th>
                        <th>股票</th>
                        <th>黄金</th>
                        <th>借入</th>
                        <th>债券</th>
                        <th>花呗</th>
                        <th>信用卡</th>
                        <th>备注</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
            <tr v-for="assetsInfo in assetsInfoList">

                            <td>{{assetsInfo.id}}</td>
                            <td>{{assetsInfo.userName}}</td>
                            <td>{{assetsInfo.userId}}</td>
                            <td>{{assetsInfo.alipayPrice}}</td>
                            <td>{{assetsInfo.wechatPrice}}</td>
                            <td>{{assetsInfo.depositCardPrice}}</td>
                            <td>{{assetsInfo.lendPrice}}</td>
                            <td>{{assetsInfo.fundPrice}}</td>
                            <td>{{assetsInfo.zlfPrice}}</td>
                            <td>{{assetsInfo.stocksPrice}}</td>
                            <td>{{assetsInfo.goldPrice}}</td>
                            <td>{{assetsInfo.bondsPrice}}</td>
                            <td>{{assetsInfo.borrowPrice}}</td>
                            <td>{{assetsInfo.flowersPrice}}</td>
                            <td>{{assetsInfo.creditPrice}}</td>
                            <td>{{assetsInfo.remarks}}</td>

                <td>
                    <div class="hidden-sm hidden-xs btn-group">

                        <button v-on:click="edit(assetsInfo)" class="btn btn-xs btn-info">
                            <i class="ace-icon fa fa-pencil bigger-120"></i>
                        </button>
                        <button v-on:click="del(assetsInfo.id)" class="btn btn-xs btn-danger">
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
                                            <label class="col-sm-2 control-label">用户名称</label>
                                            <div class="col-sm-10">
                                                <input v-model="assetsInfo.userName" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">用户ID</label>
                                            <div class="col-sm-10">
                                                <input v-model="assetsInfo.userId" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">支付宝</label>
                                            <div class="col-sm-10">
                                                <input v-model="assetsInfo.alipayPrice" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">微信</label>
                                            <div class="col-sm-10">
                                                <input v-model="assetsInfo.wechatPrice" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">储蓄卡</label>
                                            <div class="col-sm-10">
                                                <input v-model="assetsInfo.depositCardPrice" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">借出</label>
                                            <div class="col-sm-10">
                                                <input v-model="assetsInfo.lendPrice" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">基金</label>
                                            <div class="col-sm-10">
                                                <input v-model="assetsInfo.fundPrice" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">涨乐富</label>
                                            <div class="col-sm-10">
                                                <input v-model="assetsInfo.zlfPrice" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">股票</label>
                                            <div class="col-sm-10">
                                                <input v-model="assetsInfo.stocksPrice" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">黄金</label>
                                            <div class="col-sm-10">
                                                <input v-model="assetsInfo.goldPrice" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">借入</label>
                                            <div class="col-sm-10">
                                                <input v-model="assetsInfo.bondsPrice" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">债券</label>
                                            <div class="col-sm-10">
                                                <input v-model="assetsInfo.borrowPrice" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">花呗</label>
                                            <div class="col-sm-10">
                                                <input v-model="assetsInfo.flowersPrice" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">信用卡</label>
                                            <div class="col-sm-10">
                                                <input v-model="assetsInfo.creditPrice" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">备注</label>
                                            <div class="col-sm-10">
                                                <input v-model="assetsInfo.remarks" class="form-control">
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
        name: "business-assetsInfo",
        processData: false,
        data: function () {
            return {
                assetsInfo: {},
                assetsInfoList: [],
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
                _this.assetsInfo = {};
                $("#form-modal").modal("show");
            },
            edit(assetsInfo) {
                let _this = this;
                _this.assetsInfo = $.extend({}, assetsInfo);
                $("#form-modal").modal("show");
            },
            /**
             * 列表查询
             */
            query(page) {
                let _this = this;
                _this.$axios.post(process.env.VUE_APP_SERVER + '/business/admin/assetsInfo/query', {
                    page: page,
                    size: _this.$refs.pagination.size,
                }).then((response) => {
                    Loading.hide();
                    console.log("查询资产信息列表", response);
                    let resp = response.data;
                    _this.assetsInfoList = resp.content.list;
                    _this.$refs.pagination.render(page, resp.content.total)
                })
            },
            save() {
                let _this = this;
                // 保存校验
                if (1 != 1
                    || !Validator.length(_this.assetsInfo.userName, "用户名称", 1, 50)
                    || !Validator.require(_this.assetsInfo.userId, "用户ID")
                    || !Validator.require(_this.assetsInfo.remarks, "备注")
                    || !Validator.length(_this.assetsInfo.remarks, "备注", 1, 200)
                ) {
                    return;
                }
                Loading.show();
                _this.$axios.post(process.env.VUE_APP_SERVER + '/business/admin/assetsInfo/save',
                    _this.assetsInfo
                ).then((response) => {
                    Loading.hide();
                    console.log("保存资产信息列表", response);
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
                Confirm.show("确认删除资产信息后不可恢复", function () {
                    Loading.show();
                    _this.$axios.delete(process.env.VUE_APP_SERVER + '/business/admin/assetsInfo/delete/' + id).then((response) => {
                        Loading.hide();
                        console.log("删除资产信息列表 ", response);
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
