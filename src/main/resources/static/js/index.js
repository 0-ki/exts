
$(document).ready(function () {
httpGet();

})



let httpGet = function (params) {
    $.ajax({
        type: "GET",
        url: "/hi",
        data:{},
        async: true,
        beforeSend: function() {
            alert("ajax before!");
        },
        error: function(e) {
            console.error(e);
        },
        success: function(res) {
            alert("ajax success!");
        }
    })
}

let httpPost = function (params) {
        $.ajax({
        type: "GET",
        url: "/hi",
        data:{},
        async: true,
        beforeSend: function() {
            alert("ajax before!");
        },
        error: function(e) {
            console.error(e);
        },
        success: function(res) {
            alert("ajax success!");
        }
    })
}



