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
                <input type="checkbox" name="${ext.name}" flagFixed=${ext.flagFixed} id="${target_id}" oid="${ext.id}" ${ext.flagUse ? "checked":""}>
                <label for="${target_id}">${ext.name}</label>
            </div>`;
		
		$(fixedHtml).appendTo(target);
		$('#' + target_id).click( updateUseStatus);
	});// each
}

let addCustomExts = function () {
    let customExt ='';
    let customExtsTag =
    `<div id="${customExt}" style="margin-right: 10px;padding: 2px;border: 1px solid grey;border-radius: 10px;">
    ${customExt}<span>×</span>
    </div>`;

    $("#customExts").append(addCustomExts);
    $(customExtsTag).click( function(){ deleteCustomExt(); });
}

let updateUseStatus = function (e) {
	console.log(e);
	let t_data = $(e.target);
	let extensionDto = new Object();
	extensionDto.id= parseInt(t_data.attr("oid"));
	extensionDto.name= t_data.attr("name");
	extensionDto.flagFixed= t_data.attr("flagFixed") == 'true' ? true : false;
	extensionDto.flagUse= e.target.checked;
	extensionDto = JSON.stringify(extensionDto);
	httpPost({"type":"POST", "url":"/exts/" + t_data.attr("oid"), "data": extensionDto });
}

let deleteCustomExt = function() {

}

let httpGet = function (params) {
	let responseData;
    $.ajax({
		type: params.type,
		url: params.url,
		data: params.data,
		async: false,
        contentType:'application/json;charset=utf-8',
		dataType:'json',
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
		type: params.type,
		url: params.url,
		data: params.data,
		async: false,
        contentType:'application/json;charset=utf-8',
		dataType:'json',
		beforeSend: function() {
		},
		error: function(e) {
			console.error(e);
		},
		success: function(res) {
			alert(res);
		}
	})
	return responseData;
}



