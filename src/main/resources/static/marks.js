function href2id(object) {
	const href = object._links.self.href;
	const spl  = href.split('/');
	const ints = spl[spl.length-1];

	return parseInt(ints);
}

function append(mark) {
	const x = mark.coord_x, y = mark.coord_y;
	const name = mark.name;
	$.get(`api/users/${mark.owner_id}`, "", function (owner) {
		const owner_td = `<td>${owner.username}</td>`;

		const tr = `<tr><td>${href2id(mark)}</td><td>${name}</td><td>${x}</td><td>${y}</td>${owner_td}</tr>`;
		$('#tbody').append($(tr));
	});
}

$.getJSON("api/marks", "", function (data) {
    $.each(data._embedded.marks, function (index, user) {
        append(user);
    })
})