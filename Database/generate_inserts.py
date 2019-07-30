import sys
import random

EN_ALPHABET_LEN = 26
EN_ALPHABET_A_LOWER_POS = 97

def gen_random_number(n):
    return ''.join([random.choice(range(10)) for _ in range(n)])

def gen_random_word(n, cap=True):
    s = ''.join([random.choice(list(map(chr, range(EN_ALPHABET_A_LOWER_POS, EN_ALPHABET_A_LOWER_POS+EN_ALPHABET_LEN)))) for _ in range(n)])
    return s.capitalize() if cap else s

def gen_coord():
    return random.randint(0, 3600) / 10

ALPHABET = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'_', '$', '#', '@']

def random_password():
	return ''.join([random.choice(ALPHABET) for _ in range(random.randint(8, 33))])

ADMINS_COUNT = 10
MODERS_COUNT = 100
CREATOR_COUNT = 150
ACTIVE_COUNT = 200
USER_COUNT = 500

EVENT_COUNT = 10
PLACE_COUNT = 50

def gen_first_name():
	length = random.randint(10, 21)
	return gen_random_word(length)

def gen_last_name():
	length = random.randint(5, 45)
	return gen_random_word(length)

def gen_random_domain():
	return gen_random_word(random.randint(3, 10), cap=False) + '.' + gen_random_word(random.randint(3, 6), cap=False)

def gen_username(fn, ln):
	fn_part = fn[0]
	try:
		ln_part = ln[0:7]
	except IndexError:
		ln_part = ln
	return fn_part + ln_part

def gen_phone_number():
	numbers = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
	return '+' + ''.join([random.choice(numbers) for _ in range(14)])

def gen_birth_date():
	return 'now()'

def gen_email(un):
	return un + '@' + gen_random_domain()

DATABASE = 'PROJECTMAP'

# INSERTS_FILENAME = sys.argv[1] or 'INSERTS.sql'

try:
	INSERTS_FILENAME = sys.argv[1]
except IndexError:
	INSERTS_FILENAME = 'INSERTS.SQL'

def generate_user_sql(id, type, *, first_name=None, last_name=None, email=None, phone_number=None, password=None, birth_date=None):
	sql_first_name = first_name or gen_first_name()
	sql_last_name  = last_name  or gen_last_name()
	sql_phone_number=phone_number or gen_phone_number()
	sql_password   = password   or random_password()
	sql_birth_date = birth_date or gen_birth_date()
	sql_username   = gen_username(sql_first_name, sql_last_name).lower()
	sql_email      = email      or gen_email(sql_username).lower()
	# return f'INSERT INTO USER (id, type, first_name, last_name, email, phone_number, password, birth_date, username) VALUES ({id}, {type}, "{sql_first_name}", "{sql_last_name}", "{sql_email}", "{sql_phone_number}", "{sql_password}", {sql_birth_date}, "{sql_username}")'
	return 'INSERT INTO USER (ID, TYPE, STATE, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, PASSWORD, BIRTH_DATE, USERNAME) VALUES ({}, {}, {}, "{}", "{}", "{}", "{}", "{}", {}, "{}");'.format(
		id,
		type,
		1,
		sql_first_name,
		sql_last_name,
		sql_email,
		sql_phone_number,
		sql_password,
		sql_birth_date,
		sql_username
	)

def generate_place_sql(id, userid_max, *, name=None, coordx=None, coordy=None, owner_id=None):
	sql_name = name or gen_first_name()
	sql_cx   = coordx or gen_coord()
	sql_cy   = coordy or gen_coord()
	sql_oid  = owner_id or random.randint(0, userid_max)
	# return f'INSERT INTO MARK (id, owner_id, name, coordx, coordy) VALUES ({id}, {sql_oid}, "{sql_name}", {sql_cx}, {sql_cy})'
	return 'INSERT INTO MARK (id, owner_id, name, coordx, coordy) VALUES ({}, {}, "{}", {}, {})'.format(
		id,
		sql_oid,
		sql_name,
		sql_cx,
		sql_cy
	)

def generate_event_zaprosheni_sql(eid, muid):
	zapr_len = random.randint(5, 25)
	s = []
	for _ in range(zapr_len):
		# s.append(f'INSERT INTO EVENT_ZAPROSHENI (event_id, zaprosheni_id) VALUES ({eid}, {random.randint(0, muid)});')
		s.append('INSERT INTO EVENT_ZAPROSHENI (event_id, zaprosheni_id) VALUES ({}, {});'.format(
			eid,
			random.randint(0, muid)
		))
	return '\n'.join(s)

def generate_event_sql(id, userid_max, placeid_max, end=None, start=None, name=None):
	sql_name = name or gen_first_name()
	sql_pid  = random.randint(0, placeid_max)
	sql_end  = end or gen_birth_date()
	sql_start= start or gen_birth_date()

	sql_zapr = generate_event_zaprosheni_sql(id, userid_max)

	# return f'INSERT INTO EVENT (id, end_time, name, start_time, `where`) VALUES ({id}, {sql_end}, "{sql_name}", {sql_start}, {sql_pid});\n{sql_zapr}'
	return """INSERT INTO EVENT (id, end_time, name, start_time `where`) VALUES ({}, {}, "{}", {}, {});
	{}""".format(
		id,
		sql_end,
		sql_name,
		sql_start,
		sql_pid,
		sql_zapr
	)

OFFSETS = {
	1000: 0,
	900 : ADMINS_COUNT,
	500 : MODERS_COUNT,
	200 : CREATOR_COUNT,
	100 : ACTIVE_COUNT
}

COUNTS = {
	1000: ADMINS_COUNT,
	900 : MODERS_COUNT,
	500 : CREATOR_COUNT,
	200 : ACTIVE_COUNT,
	100 : USER_COUNT
}

def generate_inserts():
	s = []
	for k in OFFSETS:
		o = sum(tuple(OFFSETS.values())[:tuple(OFFSETS.keys()).index(k)+1])
		c = COUNTS[k]
		for id in range(o, o+c):
			s.append(generate_user_sql(id, k))
	for pid in range(0, PLACE_COUNT):
		s.append(generate_place_sql(pid, sum(COUNTS.values())))
	for eid in range(EVENT_COUNT):
		s.append(generate_event_sql(eid, sum(COUNTS.values()), PLACE_COUNT))
	f = open(INSERTS_FILENAME, 'w') if INSERTS_FILENAME != '-' else sys.stdout
	f.write('USE ' + DATABASE + ';\n')
	f.write('\n'.join(s))
	f.close()

if __name__ == '__main__':
	generate_inserts()
