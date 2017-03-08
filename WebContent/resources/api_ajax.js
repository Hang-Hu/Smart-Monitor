/**
 * Created by dailybird on 16/12/13.
 */

const API_ROOT_URL = "http://localhost:8080/api/v1";
const API_GET_GROUP_LIST = API_ROOT_URL + "/groups";
const API_GET_DEVICE_LIST = API_ROOT_URL + "/devices";
const API_GET_ERROR_TYPE_LIST = API_ROOT_URL + "/error_types";
const API_GET_ERROR_LIST = API_ROOT_URL + "/errors";
const API_GET_REAL_STATUS = API_ROOT_URL + "/status";
const API_LOGIN = API_ROOT_URL + "/login";
const API_POST_GROUP_LIST = API_ROOT_URL + "/groups";
const API_POST_DEVICE_LIST = API_ROOT_URL + "/devices";
const API_GET_DEVICE_LIST_WITH_PARAMS = API_ROOT_URL + "/devices?group_id=0";
const REFRESH_FREQUENCE = 1500;

$.ajaxSetup({
    headers : {
        "x-requested-with" : "XMLHttpRequest",
    },
    // async : false,
});
// TODO: refresh group list according to data received from java web server
function refreshGroupList(data) {
    var $groupList =  $('#js-group-list');
    $groupList.text('');
    $groupList.append('<option value="">选择设备组</option> <option value="-1" selected>全部</option>');
    for(var index in data){
        var item = '<option value="'+ data[index]['id'] +'">' + data[index]['name'] + '</option>';
        $groupList.append(item);
    }
}

// TODO: refresh type error list according to data received from java web server
function refreshErrorTypeList(data) {
    var $errorTypeList =  $('#js-error-type-list');
    $errorTypeList.text('');
    $errorTypeList.append('<option value="">选择错误类型</option> <option value="-1" selected>全部</option>');
    for(var index in data){
        var item = '<option value="'+ data[index]['id'] +'">' + data[index]['name'] + '</option>';
        $errorTypeList.append(item);
    }
}

// TODO: refresh device list according to data received from java web server
function refreshDeviceList(data) {
    var $deviceList =  $('#js-device-list');
    $deviceList.text('');
    $deviceList.append('<option value="">选择设备名</option> <option value="-1" selected>全部</option>');
    for(var index in data){
        var item = '<option value="'+ data[index]['id'] +'">' + data[index]['name'] + '</option>';
        $deviceList.append(item);
    }
}
