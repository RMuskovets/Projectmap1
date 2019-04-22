var conversionTable = {
	"100" : "User",
	"200" : "Privileged User",
	"400" : "Moder",
	"500" : "Moder",
	"1000": "Admin"
};

function appendUser(user) {

	var username = user.username;
	var password = user.password;
	var type	 = conversionTable[user.type.toString()];

	var elementHTML = `<tr><td>${type}</td><td>${username}</td><td>${password}</td></tr>`;
	var jqElem		= $(elementHTML);
	$('#tbody').append(jqElem);
}

$.getJSON("api/users", "", function (data) {
    $.each(data._embedded.users, function (index, user) {
        appendUser(user);
    })
});