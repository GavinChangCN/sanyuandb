/**
 * Created by Gavin on 2015/9/5 0005.
 * Mail: GavinChangCN@163.com
 */
function signin() {
    var account = $("#account").val();
    var pwd = $("#password").val();

    if (account == "" || account == "undefined") {
        alert("请输入用户名！");
        $("#account").focus();
    } else if (pwd == "" || pwd == "undefined") {
        alert("请先输入密码！");
        $("#pwd").focus();
    } else {
        $.ajax({
            url: './login',
            type: 'post',
            data: {
                account: account,
                pwd: pwd,
            },
            dataType: 'json',
            success: function (data, status) {
                if (data.id == -1) {
                    alert('您输入的分类已经存在！')
                } else {
                    location.reload(true);
                }
            },
            error: function (data, status, e) {
                alert(e + '\n\n系统错误！');
            }
        });
    }
}
