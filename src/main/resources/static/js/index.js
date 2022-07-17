$(document).ready(function () {
//    httpGet({"type":"GET", "url":"/exts" });
    getAllExtensions();
    $("#customAdd").click( function () {
        console.log( $("#customInput").val());
    });
})

let getAllExtensions = function () {
    let datas = httpGet({"type":"GET", "url":"/exts" });
    let target = $("#form-extension").find("#fixed-area");
    target.empty();
	$.each(datas, function(idx, ext){
		let target_id = "fixed-" + ext.name;
		let fixedHtml =
            `<div class="fixed-div">
                <input type="checkbox" name="exts" id="${target_id}" ${ext.flagUse ? "checked":""}>
                <label for="${target_id}">${ext.name}</label>
            </div>`;
		$(fixedHtml).appendTo(target);
	});// each
}

let addCustomExts = function () {
    let customExt =
    let customExtsTag =
    `<div id="${customExt}" style="margin-right: 10px;padding: 2px;border: 1px solid grey;border-radius: 10px;">
    ${customExt}<span>×</span>
    </div>`;

    $("#customExts").append(addCustomExts);
    $(customExtsTag).click( function(){ deleteCustomExt(); });
}

let deleteCustomExt = function() {

}

let httpGet = function (params) {
	let responseData;
    $.ajax({
        type: params.type,
        url: params.url,
        async: false,
        contentType:'application/json;charset=utf-8',
        dataType:'json',
        data:{},
        beforeSend: function(params) {
        },
        error: function(e) {
            console.error(e);
        },
        success: function(res) {
            responseData = res;
        }
    })
	return responseData;
}

let httpPost = function (params) {
	let responseData;
	$.ajax({
		type: "POST",
		url: "/hi",
		data:{},
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
	return responseData;
}



