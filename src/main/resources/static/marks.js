function href2id(object) {
	var href = object._links.self;
	var spl  = href.split('/');
	var ints = spl[spl.length-1];

	return parseInt(ints);
}

function append(mark) {
	var x = mark.coord_x, y = mark.coord_y;
	var name = mark.name;
	$.get(`api/users/${mark.owner_id}`, "", function (owner) {
		var owner_td = `<td>${owner.username}</td>`;

		var tr = `<tr><td>${href2if(mark)}</td><td>${name}</td><td>${x}</td><td>${y}</td>${owner_td}</tr>`;

		$('#tbody').append($(tr));
	});
}

$.getJSON("api/marks", "", function (data) {
    $.each(data._embedded.marks, function (index, user) {
        append(user);
    })
})