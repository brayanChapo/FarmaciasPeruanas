function saveRecord(form, endpoint) {
	var e = Util.getFormJson(form);
	$.ajax({
		type:"POST",
		dataType: "json",
        contentType: "application/json",
		url:endpoint,
		data:e
	}).done(function(data){
		Util.addRecord(data);
	});
}