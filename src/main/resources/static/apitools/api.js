function apiGet(api, handleFunction=((...)=>{}), data_path='_embedded/', base_uri='api') {
	let url = `http://${window.location.host}/${base_uri}/${api}`;

	function handle(fn, path)  {
		return function (data) {
			var json = JSON.parse(data);
			for (var pathElement of path.split('/')) {
				json = json[pathElement];
			}

			for (var dataElement of json) {
				fn(dataElement);
			}
		};
	}

	$.ajax({
		url: url,
		data: '',
		success: handle(handleFunction, data_path + api),
		dataType: 'application/json'
	});
}