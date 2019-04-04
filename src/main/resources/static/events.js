function appendMark(Mark) {

	var Markname = Mark.name;
	var password = Mark.password;
	var elementHTML = `<tr><td>${Markname}</td><td>${password}</td></tr>`;
	var jqElem		= $(elementHTML);
	$('#tbody').append(jqElem);
}

$.getJSON("api/events", "", function (data) {
    $.each(data._embedded.events, function (index, Mark) {
        appendMark(Mark);
    })
})