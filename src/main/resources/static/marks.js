function append(user) {

	var username = user.username;
	var password = user.password;
	var type	 = conversionTable[user.type.toString()];

	var elementHTML = `<tr><td>${type}</td><td>${username}</td><td>${password}</td></tr>`;
	var jqElem		= $(elementHTML);
	$('#tbody').append(jqElem);
}

$.getJSON("api/marks", "", function (data) {
    $.each(data._embedded.marks, function (index, user) {
        appendUser(user);
    })
})