/**
 * Created by Gavin on 2015/9/5 0005.
 * Mail: GavinChangCN@163.com
 */
function saveStorage(id, name) {
    var data = document.getElementById(id).value ;
    localStorage.setItem(name, data) ;
}

function loadStorage(name) {
    return localStorage.getItem(name);
}

function clearStorage() {
    localStorage.clear() ;
    alert("数据已经删除！") ;
}
