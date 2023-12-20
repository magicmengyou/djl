/**
 * Created by Administrator on 2023/12/12.
 */
// 加载数据
var name, type,currentID;
function Myfileload() {
    $('#table').bootstrapTable({
        method: "get",
        striped: true,
        singleSelect: false,
        dataType: "json",
        pagination: true, //分页
        pageSize: 10,
        pageNumber: 1,
        search: false, //显示搜索框
        contentType: "application/x-www-form-urlencoded",
        queryParams: null,
        columns: [

            {
                checkbox:"true",
                field: 'ID',
                align: 'center',
                valign: 'middle'
            },
            {
                title: "文件名称",
                field: 'class',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '文件类型',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '上传时间',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '文件大小',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },
            {
                title: '文件格式',
                field: 'sex',
                align: 'center',
                valign: 'middle'
            },
           
            {
                title: '操作',
                field: '',
                align: 'center',
                formatter: function (value, row) {
                    var e = '<button button="#" mce_href="#" onclick="del(\'' + row.WORKRECORDID + '\')">删除</button> '
                    var d = '<button button="#" mce_href="#" onclick="down(\'' + row.WORKRECORDID + '\')">下载</button> ';

                    return e + d;
                }
            }
        ]
    });
    getData();
    getType();

}
// 查询数据
function getData() {
        name = $("#name").val();
        type= $("#type").val();
    $.ajax({
        type: "GET",
        // url: "../OAWorkLog/Query",
        url: "../web/images/",

        data: { "Title": name, "PulishTime": type },
        success: function (result) {
            if (result.data) {
                var TableData = result.data;
                $('#table').bootstrapTable("load", TableData);
            }
        }
    })
}
//初始化类型下拉菜单
function getType() {
    var arr = [".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".pdf", ".txt", ".jpg", ".png", ".gif", ".mp3", ".mp4", ".avi", ".wmv", ".mov", ".rar", ".zip", ".7z", ".iso"];
    $.ajax({
        type: "post",
        url: "ArchivesSevlet",  //查询所有文件
        // document.querySelector("#name")
        data: {flag: "selectAllFile", filename: $("#name").text()},
        dataType: "json",
        timeout: 3000,
        success: function (data) {
            if (data) {
                var arrdata = Array.from(data);
                console.log(arrdata);
                // alter(data)
                // $.cookie("username")
                // window.location.href = 'LoginServlet?flag=跳转';
            } else {
                console.log("ng")
                alter("密码错误");
            }
        }

    });
    // $.ajax({
    //     url: '../Common/GetTaskTypeList',
    //     // url: '../Common/GetTaskTypeList',
    //     type: 'GET',
    //     dataType: 'json',
    //     success: function (data) {
    //         var TYPEValue = data.data;
    //         var TYPEItem = "<Option value = " + "-1" + ">" + "全部" + "</Option>";
    //         $("#type").append(TYPEItem);
    //         for (var i = 0; i < TYPEValue.length; i++) {
    //             var html = "<Option value = '" + TYPEValue[i].ID + "'>" + TYPEValue[i].NAME + "</Option>";
    //             $("#type").append(html);
    //         }
    //     },
    //     error: function (err) {
    //     }
    //
    // })
}
// 添加操作
function add(id) {
    openlayer()
    currentID = "";
}
// 编辑操作
function edit(id) {
    openlayer()
    currentID = id;
}
// 删除操作
function del(id) {
    alert(id)
    var NId = id;
    $.ajax({
        url: '../WorkRecord/DeleteWork?workId=' + NId,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            if (data.data) {
                alert("删除成功！")
                getData();
            } else {
                alert("删除失败")
            }
        },
        error: function (err) {
        }
    });
}
// 下载操作
function down(id) {
    alert(id)
    var NId = id;
    $.ajax({
        url: '../WorkRecord/DeleteWork?workId=' + NId,
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            if (data.data) {
                alert("下载成功！")

            } else {
                alert("下载失败")
            }
        },
        error: function (err) {
        }
    });
}
function getCurrentID(id) {
    return currentID;
}
// 弹出框
var lyrId;
function openlayer(id){
   lyrId=  layer.open({
        type: 2,
        title: '添加信息',
        shadeClose: true,
        shade: 0.5,
        skin: 'layui-layer-rim',
//            maxmin: true,
        closeBtn:2,
        area: ['80%', '90%'],
        shadeClose: true,
        closeBtn: 2,
        content: 'safe_tail01.html'
        //iframe的url
    });
}

// 关闭弹出框
function closeLayer(){
    layer.close(lyrId);
}




