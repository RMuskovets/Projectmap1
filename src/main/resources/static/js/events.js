function formatDate(date) {
	const year = date.getFullYear();
	const month= date.getMonth()+1;
	const day  = date.getDate();

	const hour = date.getHours();
	const min  = date.getMinutes();
	const sec  = date.getSeconds();

	return `${hour}:${min}:${sec} ${day}.${month}.${year}`;
}

function href2id(object) {
	const href = object._links.self.href;
	const spl  = href.split('/');
	const ints = spl[spl.length-1];

	return parseInt(ints);
}

function appendEvent(evt) {
	const name = evt.name;
	const start= evt.start;
	const end  = evt.end;

	const startDate = formatDate(new Date(start));
    const endDate = formatDate(new Date(end));

    const tr = $(`<tr><td>${href2id(evt)}</td><td>${name}</td><td>${startDate}</td><td>${endDate}</td></tr>`);
	$('#tbody').append(tr);
}

$.getJSON("api/events", "", function (data) {
    $.each(data._embedded.events, function (index, evt) {
        appendEvent(evt);
    })
});