/**
 * Created by Gavin on 2015/8/30 0030.
 * Mail: GavinChangCN@163.com
 */
function add_menu() {
    var title = $('#mtitle').val();
    if (title == 'undefined' || title == ''){
        alert('请先输入一个分类标题！');
    } else {
        $.ajax({
            url      : './addMenu',
            type     : 'post',
            data     : {title:title},
            dataType : 'json',
            success  : function(data) {
                if (data.id == -1) {
                    alert('您输入的分类已经存在！')
                } else {
                    $('#addMenuBody').modal('hide');
                    location.reload(true);
                }
            },
            error: function (data, status, e) {
                alert(e + '\n\n系统错误！');
            }
        });
    }
}
