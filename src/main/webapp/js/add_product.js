/**
 * Created by Gavin on 2015/8/31 0031.
 * Mail: GavinChangCN@163.com
 */
var iconpath = "";
var picpath = "";
$(function () {
    $("#icon").change(function () {
        $.ajaxFileUpload({
            url : "./uploadIcon",
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'icon', //文件上传域的ID
            dataType: 'json', //返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {
                iconpath = data.path ;
                $('#iconimg').attr('src',  '.' + iconpath) ;
                $('#iconimg').show() ;
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
                alert('上传失败,错误代码如下！\n' + e);
            }
        })
    });

    $("#pic").change(function () {
        $.ajaxFileUpload({
            url : "./uploadPic",
            secureuri: false, //是否需要安全协议，一般设置为false
            fileElementId: 'pic', //文件上传域的ID
            dataType: 'json', //返回值类型 一般设置为json
            success: function (data, status)  //服务器成功响应处理函数
            {
                picpath = data.path ;
                $('#picimg').attr('src', '.' + picpath) ;
                $('#picimg').show() ;
            },
            error: function (data, status, e)//服务器响应失败处理函数
            {
                alert('上传失败,错误代码如下！\n' + e);
            }
        })
    });
});

function saveProduct() {
    var midselect = 0;
    midselect = $("#midselect").val();
    var pdesc = $("#pdesc").val();
    var video = $("#video").val();
    if (midselect == "undefined" || midselect == 0){
        alert("请选择分类！");
        $("#midselect").focus();
    } else if (pdesc == "undefined" || pdesc == null){
        alert("请输入产品描述！");
        $("#pdesc").focus();
    } else if (iconpath == ""){
        alert("请上传产品展示小图！");
        $("#icon").focus();
    } else {
        $.ajax({
            url : "./addProductResult",
            type : "post",
            data : {midselect:midselect,
                    pdesc:pdesc,
                    icon:iconpath,
                    pic:picpath,
                    video:video
            },
            datatype : "json",
            success : function(data) {
                location.href = "./index" ;
            },
            error : function() {
                alert('系统错误！');
            }
        })
    }
}
