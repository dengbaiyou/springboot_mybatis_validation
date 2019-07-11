$.validator.setDefaults({
    errorPlacement: function (error, element) {
        $(element).parents("div.form-group").find("div.web-error-tip").append(error);
    }
});

var d_timeout = 6 * 1000;
var layerLoadIndex;

function d_wait() {
    layerLoadIndex = layer.load(2, {time: d_timeout}); //三种样式0,1,2 超过2默认加载0，设置最大加载时间time
}

function d_close() {
    layer.close(layerLoadIndex);
}

function d_ajax(url, data, successFunction) {
    $.ajax({
        beforeSend: function () {
            d_wait();
        },
        complete: function () {
            d_close();
        },
        cache: false,
        data: data,
        dataType: "html",
        error: function (xhr, status, error) {
            if ("timeout" == status) {
                layer.alert("_请求超时_");
            } else if ("error" == status) {
                layer.alert("_请求错误_");
            } else if ("abort" == status) {
                layer.alert("_请求中止_");
            } else if ("parsererror" == status) {
                layer.alert("_解析错误_");
            } else {
                layer.alert("_未知错误_");
            }
        },
        global: false,
        success: successFunction,
        timeout: d_timeout,
        type: "POST",
        url: ctx + url
    });
}