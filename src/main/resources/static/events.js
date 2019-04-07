function formatDate(date) {
	var year = date.getFullYear();
	var month= date.getMonth()+1;
	var day  = date.getDate();

	var hour = date.getHours();
	var min  = date.getMinutes();
	var sec  = date.getSeconds();

	return `${hour}:${min}:${sec} ${day}.${month}.${year}`;
}

function href2id(object) {
	const href = object._links.self.href;
	const spl  = href.split('/');
	const ints = spl[spl.length-1];

	return parseInt(ints);
}

function appendEvent(evt) {
	var name = evt.name;
	var start= evt.start;
	var end  = evt.end;

	var startDate = formatDate(new Date(start));
	var endDate   = formatDate(new Date(end));

	var tr = $(`<tr><td>${href2id(evt)}</td><td>${name}</td><td>${startDate}</td><td>${endDate}</td></tr>`);
	$('#tbody').append(tr);
}

$.getJSON("api/events", "", function (data) {
    $.each(data._embedded.events, function (index, evt) {
        appendEvent(evt);
    })
})