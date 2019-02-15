import itertools # needed for combinations
ALPHABET = list(map(chr, range(58,97+26)))
FILENAME = 'INSERTS-29.01.SQL'
LINESEP = __import__('os').linesep
def sql_inserts():
	file = open(FILENAME, 'w')
	starts = [0, 500, 700, 850, 950]
	types = [100, 200, 300, 400, 1000]
	i = 0
	for x in itertools.combinations(ALPHABET, 8):
		if i > 960:
			break
		type = 100 if i < 500 else (200 if i < 700 else (300 if i < 850 else (400 if i < 950 else 1000)))
		str_x = ''.join(x)
		file.write('INSERT INTO user (type, username, password) VALUES ({type}, "{x}", "{y}");{ls}'.format(type=str(type), x=str_x, y=str_y, ls=LINESEP))
		i += 1

	i = 0

	for x in itertools.combinations(ALPHABET, 8):
		if i > 50:
			break
		str_x = ''.join(x)
		file.write('INSERT INTO mark (coordx, coordy, name, ownerid) VALUES (123.456, 456.789, "{x}", {i});{ls}'.format(x=str_x, i=str(i), ls=LINESEP))
		i += 1
	i=0
	for x in itertools.combinations(ALPHABET, 10):
		if i > 10:
			break
		str_x = ''.join(x)
		file.write('INSERT into event (chas_kinec, name, chas_pochatok) VALUES (sysday, "{x}", sysday);{ls}'.format(x=str_x, ls=LINESEP))
		i+=1

	for i in range(10):
		file.write('INSERT into event_zaprosheni (event_id, zaprosheni_id) VALUES ({i}, {j});{ls}'.format(i=str(i), j=str(i+100), ls=LINESEP))
		file.write('INSERT into event_zaprosheni (event_id, zaprosheni_id) VALUES ({i}, {j});{ls}'.format(i=str(i), j=str(i+300), ls=LINESEP))

	file.close()

if __name__ == '__main__':
	sql_inserts()
