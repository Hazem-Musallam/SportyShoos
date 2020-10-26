var subscribe = function(course) {
	var voucher = document.querySelector('#voucher-value').value;
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$.ajax({
		type : "POST",
		url : course + '/subscribe',
		beforeSend : function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		data : JSON.stringify({
			voucher : voucher
		}),
		contentType : 'application/json',
		success : function(response) {
			if (response) {
				window.location.reload();
			}
		}
	});
}