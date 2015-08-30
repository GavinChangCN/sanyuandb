/**
 * Created by Gavin on 2015/8/28 0028.
 * Mail: GavinChangCN@163.com
 */
$(function(){
    //$.ajax({
    //   type : 'POST',
    //   dataType : 'json',
    //   data : json,
    //   action : 'getMenus.html',
    //   success : function(data) {
    //       alert('成功！');
    //   },
    //   error : function(data) {
    //       alert('失败！');
    //   }
    //});
    var $menuselect = $('#menuselect');
    $menuselect.change(function(){
        smid = $(this).children('option:selected').val();
        location.href='./index.html?mid='+ smid + '&page=1';
    });
    var len = $('#menuselect option').length;
    $('#menuselect option').each(function(){
        if ($(this).val() == smid) {
            $(this).attr('selected', 'selected');
        }
    })
});

/**
 * 添加产品
 */
function add_product() {
    location.href='./add_product';
}


